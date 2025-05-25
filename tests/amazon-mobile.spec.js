const { test, expect, devices } = require('@playwright/test');
const fs = require('fs');

// Emulate iPhone 12
const iPhone = devices['iPhone 12'];

test.use({
  ...iPhone,
});

test(
  'Amazon.in (Mobile) - Search iPhone, filter with price, click, and save to JSON',
  async ({ page }) => {
    // Step 1: Go to Amazon.in
    await page.goto('https://www.amazon.in');
    console.log('✅ Opened Amazon.in in iPhone 12 view');

    // Step 2: Accept cookies if shown
    const cookiesButton = page.locator('#sp-cc-accept');
    if (await cookiesButton.isVisible()) {
      await cookiesButton.click();
    }

    // Step 3: Wait for mobile search bar or reveal it if hidden
    //const searchBox = page.locator('input#twotabsearchtextbox');
    const searchBox = page.locator('xpath=//*[@type="text"]');
    if (!(await searchBox.isVisible())) {
      const mobileSearchIcon = page.locator('span.nav-search-submit-text, .nav-search-icon');
      if (await mobileSearchIcon.isVisible()) {
        await mobileSearchIcon.click();
        await page.waitForSelector('input#twotabsearchtextbox', { timeout: 10000 });
      }
    }

    // Step 4: Fill search and press Enter
    await page.fill('input#twotabsearchtextbox', 'iPhone');
    await page.keyboard.press('Enter');
    console.log('✅ Searched for iPhone');

    // Step 5: Wait for results
    await page.waitForSelector('[data-component-type="s-search-result"]', { timeout: 60000 });
    console.log('✅ Search results loaded');

    // Step 6: Scroll to bottom
    await page.evaluate(async () => {
      await new Promise((resolve) => {
        let totalHeight = 0;
        const distance = 500;
        const timer = setInterval(() => {
          window.scrollBy(0, distance);
          totalHeight += distance;
          if (totalHeight >= document.body.scrollHeight) {
            clearInterval(timer);
            resolve();
          }
        }, 300);
      });
    });
    console.log('✅ Scrolled to bottom');

    // Step 7: Extract data
    const productCards = page.locator('[data-component-type="s-search-result"]');
    const count = await productCards.count();
    let productList = [];

    for (let i = 0; i < count; i++) {
      try {
        const card = productCards.nth(i);
        const title = (await card.locator('h2').textContent())?.trim();

        let priceWhole = '';
        let priceFraction = '';

        const wholeLocator = card.locator('.a-price .a-price-whole').first();
        const fractionLocator = card.locator('.a-price .a-price-fraction').first();

        if (await wholeLocator.isVisible()) {
          priceWhole = (await wholeLocator.textContent()) || '';
        }
        if (await fractionLocator.isVisible()) {
          priceFraction = (await fractionLocator.textContent()) || '';
        }

        if (title && priceWhole) {
          productList.push({
            title,
            price: `₹${priceWhole.trim()}${priceFraction ? '.' + priceFraction.trim() : ''}`,
          });
        }
      } catch (err) {
        console.warn(`⚠️ Skipped product ${i} (mobile view) due to error: ${err.message}`);
        continue;
      }
    }

    // Step 8: Save to JSON
    fs.writeFileSync('amazon_mobile_products.json', JSON.stringify(productList, null, 2));
    console.log('💾 Saved mobile product data to amazon_mobile_products.json');

    // Step 9: Click and validate first product (optional)
    if (productList.length > 0) {
      const firstProductLink = productCards.nth(0).locator('h2 a');
      if (await firstProductLink.isVisible()) {
        await firstProductLink.click();
        await page.waitForLoadState('domcontentloaded');

        const detailTitle = await page.locator('#productTitle').textContent();
        console.log(`✅ Mobile product detail opened: ${detailTitle?.trim()}`);

        await expect(page.locator('#productTitle')).toContainText('iPhone');
      }
    }
  },
  { timeout: 90_000 } // Increased timeout to 90 seconds
);
