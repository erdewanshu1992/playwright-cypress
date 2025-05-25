const fs = require('fs');
const { test, expect } = require('@playwright/test');

test('Boutiqaat - List all brands and click a specific brand under MEN > Apparel', async ({ page }) => {
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


  // Hover on Grooming & Personal Care
const apparelLinkGroomingPersonalCare = page.locator('a.noWrap.upperCase', { hasText: 'Grooming & Personal Care' });
await apparelLinkGroomingPersonalCare.waitFor({ state: 'visible', timeout: 10000 });
await apparelLinkGroomingPersonalCare.hover();
console.log('✅ Hovered over Grooming & Personal Care');
await page.waitForTimeout(2000);
await page.screenshot({ path: 'hover-GroomingPersonalCare.png' });
console.log('📸 Screenshot saved: hover-GroomingPersonalCare.png');

// Hover on As Seen On TikTok
const apparelLinkAsSeenOnTikTok = page.locator('a.noWrap.upperCase', { hasText: 'As Seen On TikTok' });
await apparelLinkAsSeenOnTikTok.waitFor({ state: 'visible', timeout: 10000 });
await apparelLinkAsSeenOnTikTok.hover();
console.log('✅ Hovered over As Seen On TikTok');
await page.waitForTimeout(2000);
await page.screenshot({ path: 'hover-AsSeenOnTikTok.png' });
console.log('📸 Screenshot saved: hover-AsSeenOnTikTok.png');

// Hover on Eyewear
const apparelLinkEyewear = page.locator('a.noWrap.upperCase', { hasText: 'Eyewear' });
await apparelLinkEyewear.waitFor({ state: 'visible', timeout: 10000 });
await apparelLinkEyewear.hover();
console.log('✅ Hovered over Eyewear');
await page.waitForTimeout(2000);
await page.screenshot({ path: 'hover-Eyewear.png' });
console.log('📸 Screenshot saved: hover-Eyewear.png');

// Hover on International Fragrances
const internationalFragrances = page.locator('a.noWrap.upperCase', { hasText: /International Fragrances/i });
await internationalFragrances.waitFor({ state: 'visible', timeout: 10000 });
await internationalFragrances.hover();
console.log('✅ Hovered over International Fragrances');
await page.waitForTimeout(2000);
await page.screenshot({ path: 'hover-InternationalFragrances.png' });
console.log('📸 Screenshot saved: hover-InternationalFragrances.png');

// Hover on Arabic Fragrances
const apparelLinkArabicFragrances = page.locator('a.noWrap.upperCase', { hasText: 'Arabic Fragrances' });
await apparelLinkArabicFragrances.waitFor({ state: 'visible', timeout: 10000 });
await apparelLinkArabicFragrances.hover();
console.log('✅ Hovered over Arabic Fragrances');
await page.waitForTimeout(2000);
await page.screenshot({ path: 'hover-ArabicFragrances.png' });
console.log('📸 Screenshot saved: hover-ArabicFragrances.png');

// Hover on Niche Fragrances
const apparelLinkNicheFragrances = page.locator('a.noWrap.upperCase', { hasText: 'Niche Fragrances' });
await apparelLinkNicheFragrances.waitFor({ state: 'visible', timeout: 10000 });
await apparelLinkNicheFragrances.hover();
console.log('✅ Hovered over Niche Fragrances');
await page.waitForTimeout(2000);
await page.screenshot({ path: 'hover-NicheFragrances.png' });
console.log('📸 Screenshot saved: hover-NicheFragrances.png');

// Hover on Sports
const apparelLinkSports = page.locator('a.noWrap.upperCase', { hasText: 'Sports' });
await apparelLinkSports.waitFor({ state: 'visible', timeout: 10000 });
await apparelLinkSports.hover();
console.log('✅ Hovered over Sports');
await page.waitForTimeout(2000);
await page.screenshot({ path: 'hover-Sports.png' });
console.log('📸 Screenshot saved: hover-Sports.png');

// Hover on Footwear
const apparelLinkFootwear = page.locator('a.noWrap.upperCase', { hasText: 'Footwear' });
await apparelLinkFootwear.waitFor({ state: 'visible', timeout: 10000 });
await apparelLinkFootwear.hover();
console.log('✅ Hovered over Footwear');
await page.waitForTimeout(2000);
await page.screenshot({ path: 'hover-Footwear.png' });
console.log('📸 Screenshot saved: hover-Footwear.png');


// Hover on Apparel
const apparelLink = page.locator('a.noWrap.upperCase', { hasText: 'Apparel' });
await apparelLink.waitFor({ state: 'visible', timeout: 10000 });
await apparelLink.hover();
console.log('✅ Hovered over Apparel');
await page.waitForTimeout(2000);
await page.screenshot({ path: 'hover-Apparel.png' });
console.log('📸 Screenshot saved: hover-Apparel.png');


  // Wait for Pajama Sets to ensure submenu is fully loaded
  await page.locator('a', { hasText: 'Pajama Sets' }).waitFor({ state: 'visible', timeout: 10000 });

  // Select all brand links
  const brandLinks = page.locator('a[href*="/men/"][href*="/br/"] strong');

  const count = await brandLinks.count();
  console.log(`🧾 Found ${count} brands:`);

  // Collect all brand names in an array
  const brands = [];
  for (let i = 0; i < count; i++) {
    const brandName = await brandLinks.nth(i).textContent();
    const trimmedName = brandName.trim();
    console.log(`👉 ${trimmedName}`);
    brands.push(trimmedName);
  }

  // Save all brands to CSV file
  const csvContent = brands.join('\n');
  fs.writeFileSync('brands.csv', csvContent);
  console.log('✅ Saved all brands to brands.csv');

  // Now click on a specific brand by exact text (case insensitive)
  const targetBrand = 'adidas';

  // Find the link containing the target brand (case-insensitive match)
  const brandToClick = page.locator(`a[href*="/men/"][href*="/br/"] strong`, {
    hasText: new RegExp(`^${targetBrand}$`, 'i'),
  }).first();

  // Wait for it and click
  await brandToClick.waitFor({ state: 'visible', timeout: 10000 });
  await brandToClick.click();
  console.log(`👉 Clicking on: ${targetBrand}`);

  // Optionally verify navigation URL contains the brand text slug (lowercase, dashes)
  const expectedSlug = targetBrand.toLowerCase().replace(/\s+/g, '-');
  await expect(page).toHaveURL(new RegExp(`${expectedSlug}`, 'i'));
  console.log(`✅ Redirected to ${targetBrand} brand page`);

  // Print the current URL
  const currentURL = page.url();
  console.log(`🌐 Current URL: ${currentURL}`);

// Wait for product images to load
const productImage = page.locator('img[alt*="Duramo Speed Running Shoes - Navy"]');
await productImage.first().waitFor({ state: 'visible', timeout: 20000 });

// Hover over the first adidas product image
// await productImage.first().hover();
// console.log('🖱️ Hovered over first adidas product image');
// await page.screenshot({ path: 'hovers-state.png', fullPage: true });
// console.log('📸 Screenshot of hover state saved as hover-state.png');
// await page.waitForTimeout(2000);
await productImage.first().hover();
console.log('🖱️ Hovered over first adidas product image');

await page.waitForSelector('button.action.tocart.primary', { state: 'visible', timeout: 15000 });
console.log('👁️ "View" button appeared on hover');

await page.screenshot({ path: 'hover-state.png', fullPage: true });
console.log('📸 Screenshot of hover state saved as hover-state.png');


// Optional: Click on the product image to navigate to its detail page
const productTitle = 'Eclyptix 2000 Sneakers - Grey';
// Find the element containing that title
const titleElement = page.locator(`text="${productTitle}"`).first();

// Go to its grandparent (adjust the number of `..` as needed to reach the container)
const container = titleElement.locator('..').locator('..');
await container.hover();
console.log(`🖱️ Hovered over container of: ${productTitle}`);
await page.screenshot({ path: 'hoverImage-state.png', fullPage: true });
console.log('📸 Screenshot of hover state saved as hoverImage-state.png');


  
});













/*
const fs = require('fs');
const { test, expect } = require('@playwright/test');

test('Boutiqaat - List all brands and click a specific brand under MEN > Apparel', async ({ page }) => {
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

  
  // Hover on apparelLinkapparelLinkGroomingPersonalCare
  const apparelLinkapparelLinkGroomingPersonalCare = page.locator('a.noWrap.upperCase', { hasText: 'Grooming & Personal Care' });
  await apparelLinkapparelLinkGroomingPersonalCare.waitFor({ state: 'visible', timeout: 10000 });
  await apparelLinkapparelLinkGroomingPersonalCare.hover();
  console.log('✅ Hovered over apparelLinkapparelLinkGroomingPersonalCare');
  await page.waitForTimeout(2000);

  // Hover on apparelLinkapparelLinkAsSeenOnTikTok
  const apparelLinkapparelLinkAsSeenOnTikTok = page.locator('a.noWrap.upperCase', { hasText: 'As Seen On TikTok' });
  await apparelLinkapparelLinkAsSeenOnTikTok.waitFor({ state: 'visible', timeout: 10000 });
  await apparelLinkapparelLinkAsSeenOnTikTok.hover();
  console.log('✅ Hovered over apparelLinkapparelLinkAsSeenOnTikTok');
  await page.waitForTimeout(2000);

  // Hover on apparelLinkapparelLinkEyewear
  const apparelLinkapparelLinkEyewear = page.locator('a.noWrap.upperCase', { hasText: 'Eyewear' });
  await apparelLinkapparelLinkEyewear.waitFor({ state: 'visible', timeout: 10000 });
  await apparelLinkapparelLinkEyewear.hover();
  console.log('✅ Hovered over apparelLinkapparelLinkEyewear');
  await page.waitForTimeout(2000);

  // Hover on InternationalFragrances
  const internationalFragrances = page.locator('a.noWrap.upperCase', { hasText: /International Fragrances/i });
  await internationalFragrances.waitFor({ state: 'visible', timeout: 10000 });
  await internationalFragrances.hover();
  console.log('✅ Hovered over International Fragrances');
  await page.waitForTimeout(2000);


  // Hover on apparelLinkapparelLinkArabicFragrances
  const apparelLinkapparelLinkArabicFragrances = page.locator('a.noWrap.upperCase', { hasText: 'Arabic Fragrances' });
  await apparelLinkapparelLinkArabicFragrances.waitFor({ state: 'visible', timeout: 10000 });
  await apparelLinkapparelLinkArabicFragrances.hover();
  console.log('✅ Hovered over apparelLinkapparelLinkArabicFragrances');
  await page.waitForTimeout(2000);

  // Hover on apparelLinkapparelLinkNicheFragrances
  const apparelLinkapparelLinkNicheFragrances = page.locator('a.noWrap.upperCase', { hasText: 'Niche Fragrances' });
  await apparelLinkapparelLinkNicheFragrances.waitFor({ state: 'visible', timeout: 10000 });
  await apparelLinkapparelLinkNicheFragrances.hover();
  console.log('✅ Hovered over apparelLinkapparelLinkNicheFragrances');
  await page.waitForTimeout(2000);

  // Hover on apparelLinkSports
  const apparelLinkSports = page.locator('a.noWrap.upperCase', { hasText: 'Sports' });
  await apparelLinkSports.waitFor({ state: 'visible', timeout: 10000 });
  await apparelLinkSports.hover();
  console.log('✅ Hovered over apparelLinkSports');
  await page.waitForTimeout(2000);

  // Hover on apparelLinkFootwear
  const apparelLinkFootwear = page.locator('a.noWrap.upperCase', { hasText: 'Footwear' });
  await apparelLinkFootwear.waitFor({ state: 'visible', timeout: 10000 });
  await apparelLinkFootwear.hover();
  console.log('✅ Hovered over apparelLinkFootwear');
  await page.waitForTimeout(2000);

  // Hover on Apparel
  const apparelLink = page.locator('a.noWrap.upperCase', { hasText: 'Apparel' });
  await apparelLink.waitFor({ state: 'visible', timeout: 10000 });
  await apparelLink.hover();
  console.log('✅ Hovered over Apparel');

  // Wait for Pajama Sets to ensure submenu is fully loaded
  await page.locator('a', { hasText: 'Pajama Sets' }).waitFor({ state: 'visible', timeout: 10000 });

  // Select all brand links
  const brandLinks = page.locator('a[href*="/men/"][href*="/br/"] strong');

  const count = await brandLinks.count();
  console.log(`🧾 Found ${count} brands:`);

  // Collect all brand names in an array
  const brands = [];
  for (let i = 0; i < count; i++) {
    const brandName = await brandLinks.nth(i).textContent();
    const trimmedName = brandName.trim();
    console.log(`👉 ${trimmedName}`);
    brands.push(trimmedName);
  }

  // Save all brands to CSV file
  const csvContent = brands.join('\n');
  fs.writeFileSync('brands.csv', csvContent);
  console.log('✅ Saved all brands to brands.csv');

  // Now click on a specific brand by exact text (case insensitive)
  const targetBrand = 'adidas';

  // Find the link containing the target brand (case-insensitive match)
  const brandToClick = page.locator(`a[href*="/men/"][href*="/br/"] strong`, {
    hasText: new RegExp(`^${targetBrand}$`, 'i'),
  }).first();

  // Wait for it and click
  await brandToClick.waitFor({ state: 'visible', timeout: 10000 });
  await brandToClick.click();
  console.log(`👉 Clicking on: ${targetBrand}`);

  // Optionally verify navigation URL contains the brand text slug (lowercase, dashes)
  const expectedSlug = targetBrand.toLowerCase().replace(/\s+/g, '-');
  await expect(page).toHaveURL(new RegExp(`${expectedSlug}`, 'i'));
  console.log(`✅ Redirected to ${targetBrand} brand page`);

  // Print the current URL
  const currentURL = page.url();
  console.log(`🌐 Current URL: ${currentURL}`);

// Wait for product images to load
const productImage = page.locator('img[alt*="Duramo Speed Running Shoes - Navy"]');
await productImage.first().waitFor({ state: 'visible', timeout: 10000 });

// Hover over the first adidas product image
await productImage.first().hover();
console.log('🖱️ Hovered over first adidas product image');
await page.screenshot({ path: 'hover-state.png', fullPage: true });
console.log('📸 Screenshot of hover state saved as hover-state.png');
await page.waitForTimeout(2000);

// Optional: Click on the product image to navigate to its detail page
const productTitle = 'Eclyptix 2000 Sneakers - Grey';
// Find the element containing that title
const titleElement = page.locator(`text="${productTitle}"`).first();

// Go to its grandparent (adjust the number of `..` as needed to reach the container)
const container = titleElement.locator('..').locator('..');
await container.hover();
console.log(`🖱️ Hovered over container of: ${productTitle}`);
await page.screenshot({ path: 'hoverImage-state.png', fullPage: true });
console.log('📸 Screenshot of hover state saved as hoverImage-state.png');


  
});
*/













// const { test, expect } = require('@playwright/test');

// test('Boutiqaat - List all brands and click "Jack & Jones" under MEN > Apparel', async ({ page }) => {
//   await page.goto('https://boutiqaat.com/', {
//     timeout: 60000,
//     waitUntil: 'domcontentloaded'
//   });
//   console.log('✅ Opened Boutiqaat');

//   // Click MEN menu
//   const menMenu = page.getByText('MEN', { exact: true });
//   await menMenu.waitFor({ state: 'visible', timeout: 10000 });
//   await menMenu.click();
//   console.log('✅ Clicked MEN menu');

//   // Hover on Apparel submenu
//   const apparelLink = page.locator('a.noWrap.upperCase', { hasText: 'Apparel' });
//   await apparelLink.waitFor({ state: 'visible', timeout: 10000 });
//   await apparelLink.hover();
//   console.log('✅ Hovered over Apparel');

//   // Wait for brand list visible
//   const brandLinks = page.locator('a[href*="/men/"][href*="/br/"] strong');
//   await brandLinks.first().waitFor({ state: 'visible', timeout: 10000 });

//   // Step 1: Print all brand names
//   const count = await brandLinks.count();
//   console.log(`🧾 Found ${count} brands:`);

//   for (let i = 0; i < count; i++) {
//     const brandName = await brandLinks.nth(i).textContent();
//     console.log(`👉 ${brandName.trim()}`);
//   }

//  // Step 2: Now click on Jack & Jones separately
// const jackJonesLink = page.locator('a[href*="/men/Jack--Jones/br/"]').first();
// await jackJonesLink.waitFor({ state: 'visible', timeout: 10000 });
// await jackJonesLink.click();
// console.log('👉 Clicking on: Jack & Jones');

// // Confirm navigation
// await expect(page).toHaveURL(/Jack--Jones\/br/i);
// console.log('✅ Redirected to Jack & Jones brand page');

// });













// const { test, expect } = require('@playwright/test');

// test('Boutiqaat - List all brands and click "Jack & Jones" under MEN > Apparel', async ({ page }) => {
//   await page.goto('https://boutiqaat.com/', {
//     timeout: 60000,
//     waitUntil: 'domcontentloaded'
//   });
//   console.log('✅ Opened Boutiqaat');

//   // Click MEN menu
//   const menMenu = page.getByText('MEN', { exact: true });
//   await menMenu.waitFor({ state: 'visible', timeout: 10000 });
//   await menMenu.click();
//   console.log('✅ Clicked MEN menu');

//   // Hover on Apparel submenu
//   const apparelLink = page.locator('a.noWrap.upperCase', { hasText: 'Apparel' });
//   await apparelLink.waitFor({ state: 'visible', timeout: 10000 });
//   await apparelLink.hover();
//   console.log('✅ Hovered over Apparel');

//   // Wait for brand list to be visible
//   await page.locator('a[href*="/men/"][href*="/br/"] strong').first().waitFor({ state: 'visible', timeout: 10000 });

//   // Get all brand names
//   const brandLinks = page.locator('a[href*="/men/"][href*="/br/"] strong');
//   const count = await brandLinks.count();
//   console.log(`🧾 Found ${count} brands:`);

//   let foundJackJones = false;

//   for (let i = 0; i < count; i++) {
//     const brandName = await brandLinks.nth(i).textContent();
//     const trimmedName = brandName.trim();
//     console.log(`👉 ${trimmedName}`);

//     // Click on Jack & Jones when found (only once)
//     if (!foundJackJones && trimmedName === "Jack & Jones") {
//       foundJackJones = true;
//       console.log(`👉 Clicking on: ${trimmedName}`);
//       // Click the parent anchor of this strong element
//       const brandAnchor = brandLinks.nth(i).locator('xpath=ancestor::a[1]');
//       await brandAnchor.click();

//       // Wait for navigation and confirm URL
//       await expect(page).toHaveURL(/Jack--Jones\/br/i);
//       console.log('✅ Redirected to Jack & Jones brand page');
//     }
//   }

//   if (!foundJackJones) {
//     console.log('⚠️ Brand "Jack & Jones" not found!');
//   }
// });












// const { test, expect } = require('@playwright/test');

// test('Boutiqaat - List all brands and click "Jack & Jones" under MEN > Apparel', async ({ page }) => {
//   await page.goto('https://boutiqaat.com/', {
//     timeout: 60000,
//     waitUntil: 'domcontentloaded'
//   });
//   console.log('✅ Opened Boutiqaat');

//   // Click on MEN menu
//   const menMenu = page.getByText('MEN', { exact: true });
//   await menMenu.waitFor({ state: 'visible', timeout: 10000 });
//   await menMenu.click();
//   console.log('✅ Clicked MEN menu');

//   // Hover on Apparel
//   const apparelLink = page.locator('a.noWrap.upperCase', { hasText: 'Apparel' });
//   await apparelLink.waitFor({ state: 'visible', timeout: 10000 });
//   await apparelLink.hover();
//   console.log('✅ Hovered over Apparel');

//   // Wait for submenu to load
//   await page.locator('a', { hasText: 'Pajama Sets' }).waitFor({ state: 'visible', timeout: 10000 });

//   // Select all brand links — assume structure stays consistent
//   const brandLinks = page.locator('a[href*="/men/"][href*="/br/"] strong');

//   const count = await brandLinks.count();
//   console.log(`🧾 Found ${count} brands:`);

//   let clicked = false;

//   for (let i = 0; i < count; i++) {
//     const brandElement = brandLinks.nth(i);
//     const brandName = await brandElement.textContent();

//     if (brandName?.trim() === 'Jack & Jones' && !clicked) {
//       console.log(`👉 Clicking on: ${brandName.trim()}`);
//       await brandElement.click(); // Click the <strong> — it will bubble to <a>
//       clicked = true;
//       break;
//     }
//   }

//   if (!clicked) {
//     console.log('❌ "Jack & Jones" not found in the brand list.');
//   } else {
//     // Optionally verify navigation
//     await expect(page).toHaveURL(/Jack--Jones\/br/i);
//     console.log('✅ Redirected to Jack & Jones brand page');
//   }
// });








// const { test, expect } = require('@playwright/test');

// test('Boutiqaat - List all brands under MEN > Apparel', async ({ page }) => {
//   await page.goto('https://boutiqaat.com/', {
//     timeout: 60000,
//     waitUntil: 'domcontentloaded'
//   });
//   console.log('✅ Opened Boutiqaat');

//   // Click on MEN menu
//   const menMenu = page.getByText('MEN', { exact: true });
//   await menMenu.waitFor({ state: 'visible', timeout: 10000 });
//   await menMenu.click();
//   console.log('✅ Clicked MEN menu');

//   // Hover on Apparel
//   const apparelLink = page.locator('a.noWrap.upperCase', { hasText: 'Apparel' });
//   await apparelLink.waitFor({ state: 'visible', timeout: 10000 });
//   await apparelLink.hover();
//   console.log('✅ Hovered over Apparel');

//   // Wait for Pajama Sets to ensure submenu is fully loaded
//   await page.locator('a', { hasText: 'Pajama Sets' }).waitFor({ state: 'visible', timeout: 10000 });

//   // Select all brand links — assumes structure stays consistent
//   const brandLinks = page.locator('a[href*="/men/"][href*="/br/"] strong');

//   const count = await brandLinks.count();
//   console.log(`🧾 Found ${count} brands:`);

//   for (let i = 0; i < count; i++) {
//     const brandName = await brandLinks.nth(i).textContent();
//     console.log(`👉 ${brandName.trim()}`);
//   }
// });








// const { test, expect } = require('@playwright/test');

// test('Boutiqaat - Navigate to Pajama Sets under MEN > Apparel', async ({ page }) => {
//   // Go to Boutiqaat with extended timeout and minimal load wait
//   await page.goto('https://boutiqaat.com/', {
//     timeout: 60000,
//     waitUntil: 'domcontentloaded'
//   });
//   console.log('✅ Opened Boutiqaat');

//   // Click on MEN menu
//   const menMenu = page.getByText('MEN', { exact: true });
//   await menMenu.waitFor({ state: 'visible', timeout: 10000 });
//   await menMenu.click();
//   console.log('✅ Clicked MEN menu');

//   // Hover on Apparel to reveal its submenu
//   const apparelLink = page.locator('a.noWrap.upperCase', { hasText: 'Apparel' });
//   await apparelLink.waitFor({ state: 'visible', timeout: 10000 });
//   await apparelLink.hover();
//   console.log('✅ Hovered over Apparel');

//   // Now click on Pajama Sets under Apparel
//   const pajamaLink = page.locator('a', { hasText: 'Pajama Sets' });
//   await pajamaLink.waitFor({ state: 'visible', timeout: 10000 });
//   await pajamaLink.click();
//   console.log('✅ Clicked Pajama Sets');

//   // Validate URL contains pajama-sets
//   await expect(page).toHaveURL(/.*pajama-sets/);
//   console.log('✅ Redirected to Pajama Sets page');
  
// });









/*
const { test, expect } = require('@playwright/test');

test('Boutiqaat - Hover over MEN and click submenu', async ({ page }) => {
  // Go to Boutiqaat with extended timeout and minimal load wait
  await page.goto('https://boutiqaat.com/', {
    timeout: 60000,
    waitUntil: 'domcontentloaded'
  });
  console.log('✅ Opened Boutiqaat');

  // Hover over MEN menu
  const menMenu = page.getByText('MEN', { exact: true });
  await menMenu.waitFor({ state: 'visible', timeout: 10000 });
  await menMenu.click();
  console.log('✅ Clicked over MEN menu');

  // Find Apparel submenu and click it
  const apparelLink = page.locator('a.noWrap.upperCase', { hasText: 'Apparel' });
  await apparelLink.waitFor({ state: 'visible', timeout: 10000 });
  await apparelLink.click();
  console.log('✅ Clicked Apparel submenu');

  // Confirm URL contains /men/apparel
  await expect(page).toHaveURL(/.*men\/apparel/);
  console.log('✅ Redirected to Apparel page');


  // Click Pajama Sets link under Apparel
  const pajamaSetsLink = page.locator('a', { hasText: 'Pajama Sets' });
  await pajamaSetsLink.waitFor({ state: 'visible', timeout: 10000 });
  await pajamaSetsLink.click();
  console.log('✅ Clicked Pajama Sets link');

  // Confirm URL contains /men/apparel/pajama-sets
  await expect(page).toHaveURL(/.*men\/apparel\/pajama-sets/);
  console.log('✅ Redirected to Pajama Sets page');

});

*/
























// const { test, expect } = require('@playwright/test');

// test('Boutiqaat - Hover over MEN and click submenu', async ({ page }) => {
//   // Run browser with UI by default — if you run via CLI, add --headed flag:
//   // npx playwright test --headed

//   // Block heavy assets to speed up loading
// //   await page.route('**/*', route => {
// //     const url = route.request().url();
// //     if (url.match(/\.(png|jpg|jpeg|webp|woff|woff2|ttf|gif)/)) {
// //       route.abort();
// //     } else {
// //       route.continue();
// //     }
// //   });

//   // Go to Boutiqaat with extended timeout and minimal load wait
//   await page.goto('https://boutiqaat.com/', {
//     timeout: 60000,
//     waitUntil: 'domcontentloaded'
//   });
//   console.log('✅ Opened Boutiqaat');

//   // Hover over MEN menu
//   const menMenu = page.getByText('MEN', { exact: true });
//   await menMenu.waitFor({ state: 'visible', timeout: 10000 });
//   // await menMenu.hover();
//   await menMenu.click();
//   console.log('✅ Hovered over MEN menu');

//   // Pause here to visually see hover effect
//   // await page.pause();

//   // Find Apparel submenu and click it
//   const apparelLink = page.locator('a.noWrap.upperCase', { hasText: 'Apparel' });
//   await apparelLink.waitFor({ state: 'visible', timeout: 10000 });
//   await apparelLink.click();
//   console.log('✅ Clicked Apparel submenu');

//   // Wait for navigation after click
//   // await page.waitForLoadState('load');

//   // Confirm URL contains /men/apparel
//   await expect(page).toHaveURL(/.*men\/apparel/);
//   console.log('✅ Redirected to Apparel page');
// });
