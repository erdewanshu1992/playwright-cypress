import { Given, When, Then } from '@wdio/cucumber-framework';
import { open, login } from '../../test/pageobjects/login.page';
import { isLoaded, goToProfile } from '../../test/pageobjects/dashboard.page';

Given('I am logged in', async () => {
  await open();
  await login('user', 'pass');
  await expect(await isLoaded()).toBe(true);
});

When('I click the profile link', async () => {
  await goToProfile();
});

Then('I should see my profile page', async () => {
  await expect($('#profileHeader')).toBeDisplayed();
});
