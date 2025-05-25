const { test, expect } = require('@playwright/test');
const fs = require('fs');

test(
  'Amazon.in - Search iPhone, filter with price, click, and save to JSON',
  async ({ page }) => {
    // Step 1: Go to Amazon.in
    await page.goto('https://www.amazon.in');
    console.log('✅ Opened Amazon.in');

    // Step 2: Accept cookies if shown
    const cookiesButton = page.locator('#sp-cc-accept');
    if (await cookiesButton.isVisible()) {
      await cookiesButton.click();
      console.log('✅ Accepted cookies');
    }

    // Step 3: Search for "iPhone"
    await page.fill('input#twotabsearchtextbox', 'iPhone');
    await page.keyboard.press('Enter');
    console.log('✅ Searched for iPhone');

    // Step 4: Wait for results to load
    await page.waitForSelector('[data-component-type="s-search-result"]', { timeout: 60000 });
    console.log('✅ Search results loaded');

    // Step 5: Scroll to bottom
    await page.evaluate(async () => {
      await new Promise((resolve) => {
        let totalHeight = 0;
        const distance = 1000;
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

    // Step 6: Extract product info
    const productCards = page.locator('[data-component-type="s-search-result"]');
    const count = await productCards.count();
    let productList = [];

    for (let i = 0; i < count; i++) {
      try {
        const card = productCards.nth(i);

        // Get title
        const titleLocator = card.locator('h2');
        const title = (await titleLocator.textContent())?.trim();
        if (!title) continue;

        // Get price (safely)
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

        if (priceWhole) {
          productList.push({
            title,
            price: `₹${priceWhole.trim()}${priceFraction ? '.' + priceFraction.trim() : ''}`,
          });
        }
      } catch (err) {
        console.warn(`⚠️ Skipping product ${i} due to error: ${err.message}`);
        continue;
      }
    }

    console.log(`🧾 Found ${productList.length} products with price.`);

    // Step 7: Save to JSON
    fs.writeFileSync('amazon_products.json', JSON.stringify(productList, null, 2));
    console.log('💾 Saved product data to amazon_products.json');

    // Step 8: Click first product and validate detail page
    if (productList.length > 0) {
      const firstProductLink = productCards.nth(0).locator('h2 a');
      if (await firstProductLink.isVisible()) {
        await firstProductLink.click();
        await page.waitForLoadState('domcontentloaded');

        const detailTitle = await page.locator('#productTitle').textContent();
        console.log(`✅ Opened product detail page: ${detailTitle?.trim()}`);

        await expect(page.locator('#productTitle')).toContainText('iPhone');
      } else {
        console.warn('⚠️ First product link not clickable.');
      }
    } else {
      console.warn('⚠️ No products with price found.');
    }
  },
  { timeout: 90_000 } // Increase test timeout
);














/*
const { test, expect } = require('@playwright/test');

test('Amazon.in - Search iPhone, scroll to bottom, and capture screenshot', async ({ page }) => {
  // Go to Amazon India
  await page.goto('https://www.amazon.in');
  console.log('✅ Opened Amazon.in');

  // Accept cookies if prompted (Amazon sometimes shows a popup)
  const cookiesButton = page.locator('#sp-cc-accept');
  if (await cookiesButton.isVisible()) {
    await cookiesButton.click();
    console.log('✅ Accepted cookies');
  }

  // Search for iPhone
  await page.fill('input#twotabsearchtextbox', 'iPhone');
  await page.keyboard.press('Enter');
  console.log('✅ Searched for iPhone');

  // Wait for results to load
  await page.waitForSelector('[data-component-type="s-search-result"]', { timeout: 60000 });
  console.log('✅ Search results loaded');

  // Scroll to bottom of the page
  console.log('📜 Scrolling to bottom...');
  await page.evaluate(async () => {
    await new Promise((resolve) => {
      let totalHeight = 0;
      const distance = 1000;
      const timer = setInterval(() => {
        const scrollHeight = document.body.scrollHeight;
        window.scrollBy(0, distance);
        totalHeight += distance;
        if (totalHeight >= scrollHeight) {
          clearInterval(timer);
          resolve();
        }
      }, 300);
    });
  });
  console.log('✅ Reached bottom of the page');

  // Screenshot the full page
  await page.screenshot({ path: 'amazon_search.png', fullPage: true });
  console.log('📸 Screenshot saved as amazon_search.png');

  // Grab all visible product titles
  const productTitles = page.locator('[data-component-type="s-search-result"] h2');
  const count = await productTitles.count();
  console.log(`🧾 Found ${count} product titles:`);

  for (let i = 0; i < Math.min(count, 10); i++) { // Print only first 10 for brevity
    const text = await productTitles.nth(i).textContent();
    console.log(`  - ${text?.trim()}`);
  }

  // Assertion: At least one product title contains "iPhone"
  await expect(productTitles.first()).toContainText('iPhone');
});
*/