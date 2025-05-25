const mobileUserAgent = 'Mozilla/5.0 (Linux; Android 9; SM-G973F) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/90.0.4430.91 Mobile Safari/537.36';

describe('Mobile view test', () => {
  it('should show mobile UI correctly on home page', () => {
    // Visit the page with the mobile User-Agent header and set the viewport size
    cy.visit('https://www.urbancompany.com/delhi-ncr', {
      headers: {
        'User-Agent': mobileUserAgent
      }
    });

    // Set the viewport size for Galaxy S10 dimensions (412x869)
    cy.viewport(414, 896);

    Cypress.on('uncaught:exception', (err, runnable) => {
      return false; // Prevents Cypress from failing the test
    });
    
  });
  
});








