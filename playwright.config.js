// Desktop Website in Google Chrome
const { defineConfig } = require('@playwright/test');

module.exports = defineConfig({
  testDir: './tests',
  timeout: 30 * 1000,
use: {
  headless: false,
  browserName: 'chromium',
  channel: 'chrome',
  viewport: null, // disables viewport emulation
  launchOptions: {
    args: ['--start-maximized'],  // Chrome starts maximized
  },
},
  reporter: [['html', { outputFolder: 'playwright-report' }]],
});













/*
// Desktop Website in Google Chrome
const { defineConfig } = require('@playwright/test');

module.exports = defineConfig({
  testDir: './tests',
  timeout: 30 * 1000,
  use: {
    headless: false, // 👀 Show Chrome browser window
    browserName: 'chromium',
    channel: 'chrome', // ✅ Use installed Google Chrome
    // viewport: { width: 1280, height: 800 },
    viewport: { width: 1920, height: 1080 },
    screenshot: 'only-on-failure',
    video: 'retain-on-failure',
  },
  reporter: [['html', { outputFolder: 'playwright-report' }]],
});
*/











/*
// Emulate mobile device (e.g., iPhone 13) in Chrome
const { defineConfig, devices } = require('@playwright/test');

module.exports = defineConfig({
  testDir: './tests',
  timeout: 30 * 1000,
  use: {
    headless: false, // 👀 Show browser (not headless)
    browserName: 'chromium',
    channel: 'chrome', // Use real Google Chrome
    screenshot: 'only-on-failure',
    video: 'retain-on-failure',

    // 👇 Emulate iPhone 13
    viewport: devices['iPhone 13'].viewport,
    userAgent: devices['iPhone 13'].userAgent,
    deviceScaleFactor: devices['iPhone 13'].deviceScaleFactor,
    isMobile: devices['iPhone 13'].isMobile,
    hasTouch: devices['iPhone 13'].hasTouch,
  },
  reporter: [['html', { outputFolder: 'playwright-report' }]],
});

*/

















/*
const { defineConfig, devices } = require('@playwright/test');

module.exports = defineConfig({
  testDir: './tests',
  timeout: 30 * 1000,
  use: {
    headless: true,
    browserName: 'chromium',
    channel: 'chrome', // 👈 Use Google Chrome
    screenshot: 'only-on-failure',
    video: 'retain-on-failure',
    viewport: { width: 1280, height: 720 },
  },
  retries: 0,
  reporter: [['html', { outputFolder: 'playwright-report' }]],
});
*/

