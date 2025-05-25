// Prevent test from failing due to uncaught app errors
Cypress.on('uncaught:exception', (err, runnable) => {
  return false;
});

describe('Test all the UI', () => {
  before(() => {
    // Clear cookies and storage before starting
    cy.clearCookies();
    cy.clearLocalStorage();
  });

  it("should click Women's Salon & Spa and then Salon for Women", () => {
    cy.visit('https://www.urbancompany.com/delhi-ncr');
    cy.wait(3000); // Consider replacing with a better wait condition if possible

    // Click "Women's Salon & Spa"
    cy.xpath("//p[contains(text(), \"Women's Salon & Spa\")]")
      .should('be.visible')
      .click({ force: true });

    // Click "Salon for Women"
    cy.contains('Salon for Women', { timeout: 10000 })
      .should('be.visible')
      .click({ force: true });

    // Click "Packages"
    cy.contains('Packages', { timeout: 10000 })
      .should('be.visible')
      .click({ force: true });

    // Add first service
    cy.xpath('(//button[@aria-label="Add"])[1]')
      .should('be.visible')
      .click({ force: true });

    // View Cart
    cy.xpath("//p[contains(text(), 'View Cart')]")
      .should('be.visible')
      .click({ force: true });

    // Click "Edit package"
    cy.xpath("//p[contains(text(), 'Edit package')]")
      .should('be.visible')
      .click({ force: true });

    // Extract and validate service time
    cy.xpath("(//p[contains(text(), 'Service time:')])[1]")
      .should('be.visible')
      .invoke('text')
      .then((text) => {
        const match = text.match(/(\d+\s*mins)/i);
        if (match) {
          const serviceTime = match[0].trim();
          cy.log('✅ Extracted service time:', serviceTime);
          expect(serviceTime).to.match(/^\d+\s*mins$/);
        } else {
          throw new Error('❌ Could not extract service time from text: ' + text);
        }
      });

      // cy.get('.contain-scroll').scrollTo('bottom', { duration: 2000 }); // scrolls to bottom inside the container

      // cy.get('.contain-scroll')
      //   .find('p:contains("Neck")')
      //   .scrollIntoView()
      //   .should('be.visible');
      //   cy.wait(2000); // Wait for the scroll to complete

      const scrollContainer = '.contain-scroll';

      cy.get(scrollContainer).then(($container) => {
        // Scroll down in increments to load lazy content
        const height = $container[0].scrollHeight;
        let current = 0;

        function scrollStep() {
          current += 100;
          if (current > height) {
            return;
          }
          cy.get(scrollContainer).scrollTo(0, current);
          cy.wait(500); // wait for lazy load
          scrollStep();
        }

        scrollStep();

        // After scrolling all, print services
        cy.get(`${scrollContainer} p.css-146c3p1`).each(($el, i) => {
          cy.log(`Service ${i + 1}: ${$el.text().trim()}`);
        });
      });



    // Click "Add to cart"
    cy.xpath("//p[contains(text(), 'Add to cart')]")
      .should('be.visible')
      .click({ force: true });

    // Take screenshot at end of flow
    cy.screenshot('final-state');
  });
});
