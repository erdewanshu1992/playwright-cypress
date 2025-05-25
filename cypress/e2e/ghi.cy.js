describe('Test all the UI', () => {
  it('should click Women\'s Salon & Spa and then Salon for Women', () => {
    cy.visit('https://www.urbancompany.com/delhi-ncr');
    cy.wait(3000);

    cy.xpath("//p[contains(text(), \"Women's Salon & Spa\")]")
      .should('be.visible')
      .click({ force: true });

    // Wait for modal and click option
    cy.contains('Salon for Women', { timeout: 10000 })
      .should('be.visible')
      .click({ force: true });


      // Wait for modal and click option
    cy.contains('Packages', { timeout: 10000 })
      .should('be.visible')
      .click({ force: true });

    cy.xpath('(//button[@aria-label="Add"])[1]').click({ force: true });
    cy.xpath("//p[contains(text(), 'View Cart')]").click({ force: true });
    

    // Click "Edit package"
    cy.xpath("//p[contains(text(), 'Edit package')]")
      .should('be.visible')
      .click({ force: true });

      
    cy.xpath("(//p[contains(text(), 'Service time:')])[1]")
        .should('be.visible')
        .invoke('text')
        .then((text) => {
            const match = text.match(/(\d+\s*mins)/i); // matches formats like "60 mins", "45mins", etc.
            if (match) {
            const serviceTime = match[0].trim();
            cy.log('✅ Extracted service time:', serviceTime);
            // Optional assertion
            expect(serviceTime).to.match(/^\d+\s*mins$/);
            } else {
            throw new Error('❌ Could not extract service time from text: ' + text);
            }
        });


    cy.xpath("//p[contains(text(), 'Add to cart')]")
      .should('be.visible')
      .click({ force: true });
      




  });
});
