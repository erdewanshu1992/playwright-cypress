import { Given, When, Then } from '@wdio/cucumber-framework';
import { open, login } from '../../test/pageobjects/login.page';
import { isLoaded } from '../../test/pageobjects/dashboard.page';

Given('I am on the login page', async () => {
  await open();
});

When(/^I login with username "(.*)" and password "(.*)"$/, async (user, pass) => {
  await login(user, pass);
});

Then('I should see the dashboard', async () => {
  await expect(await isLoaded()).toBe(true);
});
