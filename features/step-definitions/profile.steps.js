import { Given, When, Then } from '@wdio/cucumber-framework';
import { open, login } from '../../test/pageobjects/login.page';
import { goToProfile } from '../../test/pageobjects/dashboard.page';
import { updateProfile, isUpdateSuccessful } from '../../test/pageobjects/profile.page';

Given('I am on the profile page', async () => {
  await open();
  await login('user', 'pass');
  await goToProfile();
});

When('I update my name and email', async () => {
  await updateProfile('Test User', 'test@example.com');
});

Then('I should see a success message', async () => {
  await expect(await isUpdateSuccessful()).toBe(true);
});
