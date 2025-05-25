const mobileUserAgent = 'Mozilla/5.0 (Linux; Android 9; SM-G973F) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/90.0.4430.91 Mobile Safari/537.36';

describe('Mobile view test', () => {
  it('should show mobile UI correctly on home page', () => {
    // Visit the page with the mobile User-Agent header and set the viewport size
    cy.visit('https://www.yesmadam.com/delhi-at-home-services', {
      headers: {
        'User-Agent': mobileUserAgent
      }
    });

    // Set the viewport size for Galaxy S10 dimensions (412x869)
    cy.viewport(412, 869);

    // Your test here (e.g., validate UI elements, interactions, etc.)
    cy.xpath('//img[@alt="Salon At Home"]').click();
    
  });

  it('should show mobile UI correctly on service page', () => {
     cy.visit('https://www.yesmadam.com/delhi/weekday-offers', {
      headers: {
        'User-Agent': mobileUserAgent
      }
    });

    // Set the viewport size for Galaxy S10 dimensions (412x869)
    cy.viewport(412, 869);

    // Your test here (e.g., validate UI elements, interactions, etc.)
    cy.xpath('//img[@alt="Weekday Offers"]').click();
    
    cy.xpath("(//button[contains(text(), 'Add')])[1]").click();

    cy.xpath("//div[contains(text(), 'View Cart')]").click();
    cy.wait(2000);

  });
  
});


















/*
const mobileUserAgent = 'Mozilla/5.0 (Linux; Android 9; SM-G973F) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/90.0.4430.91 Mobile Safari/537.36';

describe('Mobile view test', () => {
  beforeEach(() => {
    cy.visit('https://www.yesmadam.com/delhi-at-home-services', {
      headers: {
        'User-Agent': mobileUserAgent
      }
    });
    cy.viewport(412, 869); // Galaxy S10 dimensions
  });

  it('should show mobile UI correctly', () => {
    // Your test here
  });
});
*/


