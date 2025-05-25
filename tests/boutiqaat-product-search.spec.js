const fs = require('fs');
const { test, expect } = require('@playwright/test');

test('Boutiqaat - List brands and test hover under MEN > Apparel', async ({ page }) => {

  // Helper function for hover + screenshot
  async function hoverAndSnap(locator, label) {
    await locator.waitFor({ state: 'visible', timeout: 30000 });
    await locator.hover();
    console.log(`✅ Hovered over ${label}`);
    await expect(locator).toBeVisible();
    const fileName = `hover-${label.replace(/\s+/g, '')}.png`;
    await page.screenshot({ path: fileName });
    console.log(`📸 Screenshot saved: ${fileName}`);
  }

  // Navigate to site
  await page.goto('https://boutiqaat.com/', {
    timeout: 60000,
    waitUntil: 'domcontentloaded'
  });
  console.log('✅ Opened Boutiqaat');

  // Click on MEN menu
  const menMenu = page.getByText('MEN', { exact: true });
  await menMenu.waitFor({ state: 'visible', timeout: 10000 });
  await menMenu.click();
  console.log('✅ Clicked MEN menu');

  // Define all menu hover locators
  const menuItems = [
    ['Grooming & Personal Care', 'a.noWrap.upperCase'],
    ['As Seen On TikTok', 'a.noWrap.upperCase'],
    ['Eyewear', 'a.noWrap.upperCase'],
    ['International Fragrances', 'a.noWrap.upperCase'],
    ['Arabic Fragrances', 'a.noWrap.upperCase'],
    ['Niche Fragrances', 'a.noWrap.upperCase'],
    ['Sports', 'a.noWrap.upperCase'],
    ['Footwear', 'a.noWrap.upperCase'],
    ['Apparel', 'a.noWrap.upperCase'],
  ];

  // Hover and screenshot each menu
  for (const [label, selector] of menuItems) {
    const locator = page.locator(selector, { hasText: new RegExp(`^${label}$`, 'i') });
    await hoverAndSnap(locator, label);
  }

  // Wait for Apparel submenu item
  await page.locator('a', { hasText: 'Pajama Sets' }).waitFor({ state: 'visible', timeout: 10000 });

  // Collect all brand links
  const brandLinks = page.locator('a[href*="/men/"][href*="/br/"] strong');
  const count = await brandLinks.count();
  console.log(`🧾 Found ${count} brands:`);

  const brands = [];
  for (let i = 0; i < count; i++) {
    const brandName = await brandLinks.nth(i).textContent();
    const trimmedName = brandName.trim();
    console.log(`👉 ${trimmedName}`);
    brands.push(trimmedName);
  }

  fs.writeFileSync('brands.csv', brands.join('\n'));
  console.log('✅ Saved all brands to brands.csv');

  // Click a specific brand (case-insensitive)
  const targetBrand = 'adidas';
  const brandToClick = page.locator('a[href*="/men/"][href*="/br/"] strong', {
    hasText: new RegExp(`^${targetBrand}$`, 'i'),
  }).first();

  await brandToClick.waitFor({ state: 'visible', timeout: 10000 });
  await brandToClick.click();
  console.log(`👉 Clicking on: ${targetBrand}`);

  const expectedSlug = targetBrand.toLowerCase().replace(/\s+/g, '-');
  await expect(page).toHaveURL(new RegExp(`${expectedSlug}`, 'i'));
  console.log(`✅ Redirected to ${targetBrand} brand page`);
  console.log(`🌐 Current URL: ${page.url()}`);

  // Hover over first product image
  const productImage = page.locator('img[alt*="Duramo Speed Running Shoes - Navy"]').first();
  await productImage.waitFor({ state: 'visible', timeout: 20000 });
  await productImage.hover();
  console.log('🖱️ Hovered over first adidas product image');

  // Wait for hover UI element (like View button)
  await page.waitForSelector('button.action.tocart.primary', { state: 'visible', timeout: 15000 });
  console.log('👁️ "View" button appeared on hover');

  await page.screenshot({ path: 'hover-state.png', fullPage: true });
  console.log('📸 Screenshot of hover state saved as hover-state.png');

  // Hover over container for specific product
  const productTitle = 'Eclyptix 2000 Sneakers - Grey';
  const titleElement = page.locator(`text="${productTitle}"`).first();
  const container = titleElement.locator('..').locator('..');
  await container.hover();
  console.log(`🖱️ Hovered over container of: ${productTitle}`);
  await page.screenshot({ path: 'hoverImage-state.png', fullPage: true });
  console.log('📸 Screenshot of hover state saved as hoverImage-state.png');

});
