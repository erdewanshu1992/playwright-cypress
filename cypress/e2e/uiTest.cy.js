import HomePage from '../pages/HomePage';

const homePage = new HomePage();

describe('Test all the UI using POM and custom commands', () => {
  before(() => {
    cy.clearCookies();
    cy.clearLocalStorage();
  });

  it('should complete flow with proper validations', () => {
    homePage.visitHomePage();
    cy.wait(3000); // Ideally replace this with a proper wait condition

    homePage.clickWomensSalonAndSpa();
    homePage.clickSalonForWomen();
    homePage.clickPackages();
    homePage.addFirstService();
    homePage.viewCart();
    homePage.clickEditPackage();
    homePage.validateServiceTime();
    homePage.clickAddToCart();

    cy.screenshot('final-state');
  });
});
