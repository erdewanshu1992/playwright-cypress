class HomePage {
  visitHomePage() {
    cy.visit('https://www.urbancompany.com/delhi-ncr');
  }

  clickWomensSalonAndSpa() {
    cy.clickVisible("//p[contains(text(), \"Women's Salon & Spa\")]", true);
  }

  clickSalonForWomen() {
    cy.clickVisible('Salon for Women');
  }

  clickPackages() {
    cy.clickVisible('Packages');
  }

  addFirstService() {
    cy.clickVisible('(//button[@aria-label="Add"])[1]', true);
  }

  viewCart() {
    cy.clickVisible("//p[contains(text(), 'View Cart')]", true);
  }

  clickEditPackage() {
    cy.clickVisible("//p[contains(text(), 'Edit package')]", true);
  }

  validateServiceTime() {
    cy.extractServiceTime("(//p[contains(text(), 'Service time:')])[1]");
  }

  clickAddToCart() {
    cy.clickVisible("//p[contains(text(), 'Add to cart')]", true);
  }
}

export default HomePage;
