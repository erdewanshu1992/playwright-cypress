describe('Test all the UI with Custom Commands', () => {
  before(() => {
    cy.clearCookies();
    cy.clearLocalStorage();
    // cy.viewport(1280, 720);
  });

  it("should navigate and validate service time using custom commands", () => {
    cy.visit('https://www.urbancompany.com/delhi-ncr');
    cy.wait(3000); // Ideally replace this with a proper wait condition


    cy.clickVisible("//p[contains(text(), \"Women's Salon & Spa\")]", true);
    // cy.clickVisible('Salon for Women');
    cy.contains('Salon for Women', { timeout: 10000 }).should('be.visible').click({ force: true });

    cy.clickVisible('Packages');

    cy.clickVisible('(//button[@aria-label="Add"])[1]', true);
    cy.clickVisible("//p[contains(text(), 'View Cart')]", true);
    cy.clickVisible("//p[contains(text(), 'Edit package')]", true);

    cy.extractServiceTime("(//p[contains(text(), 'Service time:')])[1]");

    cy.clickVisible("//p[contains(text(), 'Add to cart')]", true);

    cy.screenshot('final-state');
  });
});
