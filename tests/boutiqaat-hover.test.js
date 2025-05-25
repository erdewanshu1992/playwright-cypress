const fs = require('fs');
const path = require('path');
const { test, expect } = require('@playwright/test');

test('Boutiqaat - List all brands and click a specific brand under MEN > Apparel', async ({ page }) => {
  // 📁 Create screenshots folder in root
  const screenshotDir = path.resolve('screenshots');
  if (!fs.existsSync(screenshotDir)) {
    fs.mkdirSync(screenshotDir);
  }

  await page.goto('https://boutiqaat.com/', {
    timeout: 60000,
    waitUntil: 'domcontentloaded'
  });
  console.log('✅ Opened Boutiqaat');

  const menMenu = page.getByText('MEN', { exact: true });
  await menMenu.waitFor({ state: 'visible', timeout: 10000 });
  await menMenu.click();
  console.log('✅ Clicked MEN menu');

  // Helper to hover and take screenshot
  const hoverAndCapture = async (locator, name) => {
    await locator.waitFor({ state: 'visible', timeout: 10000 });
    await locator.hover();
    console.log(`✅ Hovered over ${name}`);
    await page.waitForTimeout(2000);
    const filepath = path.join(screenshotDir, `hover-${name}.png`);
    await page.screenshot({ path: filepath });
    console.log(`📸 Screenshot saved: ${filepath}`);
  };

  await hoverAndCapture(page.locator('a.noWrap.upperCase', { hasText: 'Grooming & Personal Care' }), 'GroomingPersonalCare');
  await hoverAndCapture(page.locator('a.noWrap.upperCase', { hasText: 'As Seen On TikTok' }), 'AsSeenOnTikTok');
  await hoverAndCapture(page.locator('a.noWrap.upperCase', { hasText: 'Eyewear' }), 'Eyewear');
  await hoverAndCapture(page.locator('a.noWrap.upperCase', { hasText: /International Fragrances/i }), 'InternationalFragrances');
  await hoverAndCapture(page.locator('a.noWrap.upperCase', { hasText: 'Arabic Fragrances' }), 'ArabicFragrances');
  await hoverAndCapture(page.locator('a.noWrap.upperCase', { hasText: 'Niche Fragrances' }), 'NicheFragrances');
  await hoverAndCapture(page.locator('a.noWrap.upperCase', { hasText: 'Sports' }), 'Sports');
  await hoverAndCapture(page.locator('a.noWrap.upperCase', { hasText: 'Footwear' }), 'Footwear');
  await hoverAndCapture(page.locator('a.noWrap.upperCase', { hasText: 'Apparel' }), 'Apparel');

  await page.locator('a', { hasText: 'Pajama Sets' }).waitFor({ state: 'visible', timeout: 10000 });

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

  const targetBrand = 'adidas';
  const brandToClick = page.locator(`a[href*="/men/"][href*="/br/"] strong`, {
    hasText: new RegExp(`^${targetBrand}$`, 'i'),
  }).first();

  await brandToClick.waitFor({ state: 'visible', timeout: 10000 });
  await brandToClick.click();
  console.log(`👉 Clicking on: ${targetBrand}`);

  const expectedSlug = targetBrand.toLowerCase().replace(/\s+/g, '-');
  await expect(page).toHaveURL(new RegExp(`${expectedSlug}`, 'i'));
  console.log(`✅ Redirected to ${targetBrand} brand page`);

  const currentURL = page.url();
  console.log(`🌐 Current URL: ${currentURL}`);

  const productImage = page.locator('img[alt*="Duramo Speed Running Shoes - Navy"]');
  await productImage.first().waitFor({ state: 'visible', timeout: 20000 });

  await productImage.first().hover();
  console.log('🖱️ Hovered over first adidas product image');

  await page.waitForSelector('button.action.tocart.primary', { state: 'visible', timeout: 15000 });
  console.log('👁️ "View" button appeared on hover');

  await page.screenshot({ path: path.join(screenshotDir, 'hover-state.png'), fullPage: true });
  console.log('📸 Screenshot of hover state saved as hover-state.png');

  const productTitle = 'Eclyptix 2000 Sneakers - Grey';
  const titleElement = page.locator(`text="${productTitle}"`).first();
  const container = titleElement.locator('..').locator('..');

  await container.hover();
  console.log(`🖱️ Hovered over container of: ${productTitle}`);
  await page.screenshot({ path: path.join(screenshotDir, 'hoverImage-state.png'), fullPage: true });
  console.log('📸 Screenshot of hover state saved as hoverImage-state.png');
});












/*
const fs = require('fs');
const path = require('path');
const { test, expect } = require('@playwright/test');

test('Boutiqaat - List all brands and click a specific brand under MEN > Apparel', async ({ page }) => {
  // Create screenshots folder if not exists
  const screenshotDir = path.join(__dirname, 'screenshots');
  if (!fs.existsSync(screenshotDir)) {
    fs.mkdirSync(screenshotDir);
  }

  await page.goto('https://boutiqaat.com/', {
    timeout: 60000,
    waitUntil: 'domcontentloaded'
  });
  console.log('✅ Opened Boutiqaat');

  const menMenu = page.getByText('MEN', { exact: true });
  await menMenu.waitFor({ state: 'visible', timeout: 10000 });
  await menMenu.click();
  console.log('✅ Clicked MEN menu');

  // Helper function to hover and take screenshot
  const hoverAndCapture = async (locator, name) => {
    await locator.waitFor({ state: 'visible', timeout: 10000 });
    await locator.hover();
    console.log(`✅ Hovered over ${name}`);
    await page.waitForTimeout(2000);
    const filepath = path.join(screenshotDir, `hover-${name}.png`);
    await page.screenshot({ path: filepath });
    console.log(`📸 Screenshot saved: ${filepath}`);
  };

  await hoverAndCapture(page.locator('a.noWrap.upperCase', { hasText: 'Grooming & Personal Care' }), 'GroomingPersonalCare');
  await hoverAndCapture(page.locator('a.noWrap.upperCase', { hasText: 'As Seen On TikTok' }), 'AsSeenOnTikTok');
  await hoverAndCapture(page.locator('a.noWrap.upperCase', { hasText: 'Eyewear' }), 'Eyewear');
  await hoverAndCapture(page.locator('a.noWrap.upperCase', { hasText: /International Fragrances/i }), 'InternationalFragrances');
  await hoverAndCapture(page.locator('a.noWrap.upperCase', { hasText: 'Arabic Fragrances' }), 'ArabicFragrances');
  await hoverAndCapture(page.locator('a.noWrap.upperCase', { hasText: 'Niche Fragrances' }), 'NicheFragrances');
  await hoverAndCapture(page.locator('a.noWrap.upperCase', { hasText: 'Sports' }), 'Sports');
  await hoverAndCapture(page.locator('a.noWrap.upperCase', { hasText: 'Footwear' }), 'Footwear');
  await hoverAndCapture(page.locator('a.noWrap.upperCase', { hasText: 'Apparel' }), 'Apparel');

  await page.locator('a', { hasText: 'Pajama Sets' }).waitFor({ state: 'visible', timeout: 10000 });

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

  const targetBrand = 'adidas';
  const brandToClick = page.locator(`a[href*="/men/"][href*="/br/"] strong`, {
    hasText: new RegExp(`^${targetBrand}$`, 'i'),
  }).first();

  await brandToClick.waitFor({ state: 'visible', timeout: 10000 });
  await brandToClick.click();
  console.log(`👉 Clicking on: ${targetBrand}`);

  const expectedSlug = targetBrand.toLowerCase().replace(/\s+/g, '-');
  await expect(page).toHaveURL(new RegExp(`${expectedSlug}`, 'i'));
  console.log(`✅ Redirected to ${targetBrand} brand page`);

  const currentURL = page.url();
  console.log(`🌐 Current URL: ${currentURL}`);

  const productImage = page.locator('img[alt*="Duramo Speed Running Shoes - Navy"]');
  await productImage.first().waitFor({ state: 'visible', timeout: 20000 });

  await productImage.first().hover();
  console.log('🖱️ Hovered over first adidas product image');

  await page.waitForSelector('button.action.tocart.primary', { state: 'visible', timeout: 15000 });
  console.log('👁️ "View" button appeared on hover');

  await page.screenshot({ path: path.join(screenshotDir, 'hover-state.png'), fullPage: true });
  console.log('📸 Screenshot of hover state saved as hover-state.png');

  const productTitle = 'Eclyptix 2000 Sneakers - Grey';
  const titleElement = page.locator(`text="${productTitle}"`).first();
  const container = titleElement.locator('..').locator('..');

  await container.hover();
  console.log(`🖱️ Hovered over container of: ${productTitle}`);
  await page.screenshot({ path: path.join(screenshotDir, 'hoverImage-state.png'), fullPage: true });
  console.log('📸 Screenshot of hover state saved as hoverImage-state.png');
});
*/