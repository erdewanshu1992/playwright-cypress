// const { join } = require('path');

// exports.config = {
//   runner: 'local',
//   specs: ['./features/**/*.feature'],
//   maxInstances: 1,
//   capabilities: [{
//     maxInstances: 1,
//     browserName: 'chrome'
//   }],
//   logLevel: 'info',
//   framework: 'cucumber',
//   reporters: [
//     ['allure', {
//       outputDir: 'allure-results',
//       disableWebdriverStepsReporting: true,
//       disableWebdriverScreenshotsReporting: false,
//     }]
//   ],
//   cucumberOpts: {
//     require: ['./features/step-definitions/*.js'],
//     timeout: 60000
//   },
//   before: function () {
//     browser.addCommand("waitAndClick", async function (selector) {
//       await $(selector).waitForDisplayed();
//       await $(selector).click();
//     });
//   }
// };




export const config = {
    runner: 'local',

    specs: ['./features/**/*.feature'],

    exclude: [],

    maxInstances: 1,

    capabilities: [{
        maxInstances: 1,
        browserName: 'chrome',
        acceptInsecureCerts: true,
    }],

    logLevel: 'info',

    bail: 0,

    baseUrl: 'http://localhost:8080/mock-webapp/',

    waitforTimeout: 10000,

    connectionRetryTimeout: 120000,
    connectionRetryCount: 3,

    services: ['chromedriver'],

    framework: 'cucumber',

    reporters: ['spec', ['allure', {
        outputDir: 'allure-results',
        disableWebdriverStepsReporting: false,
        disableWebdriverScreenshotsReporting: false,
    }]],

    cucumberOpts: {
        require: ['./test/step-definitions/**/*.js'],
        backtrace: false,
        requireModule: [],
        dryRun: false,
        failFast: false,
        format: ['pretty'],
        snippets: true,
        source: true,
        profile: [],
        strict: false,
        tagExpression: '',
        timeout: 60000,
        ignoreUndefinedDefinitions: false,
    },

    onPrepare: function (config, capabilities) {
        console.log('<<< Test Execution Started >>>');
    },

    beforeSession: function () {
        require('@babel/register');
    },

    afterTest: async function (test, context, { error, result, duration, passed, retries }) {
        if (error) {
            await browser.takeScreenshot();
        }
    },

    onComplete: function () {
        console.log('<<< Test Execution Finished >>>');
    },
};
