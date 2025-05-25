// ***********************************************
// This example commands.js shows you how to
// create various custom commands and overwrite
// existing commands.
//
// For more comprehensive examples of custom
// commands please read more here:
// https://on.cypress.io/custom-commands
// ***********************************************
//
//
// -- This is a parent command --
// Cypress.Commands.add('login', (email, password) => { ... })
//
//
// -- This is a child command --
// Cypress.Commands.add('drag', { prevSubject: 'element'}, (subject, options) => { ... })
//
//
// -- This is a dual command --
// Cypress.Commands.add('dismiss', { prevSubject: 'optional'}, (subject, options) => { ... })
//
//
// -- This will overwrite an existing command --
// Cypress.Commands.overwrite('visit', (originalFn, url, options) => { ... })


// Example of other helper methods you can add:

// Function to perform login action
export const login = (username, password) => {
  cy.get('#username').type(username);
  cy.get('#password').type(password);
  cy.get('#loginButton').click();
};

// Function to verify URL after navigation
export const verifyUrl = (expectedUrl) => {
  cy.url().should('include', expectedUrl);
};


/** 
// Click element with visible check
Cypress.Commands.add('clickVisible', (selector, isXpath = false) => {
  const el = isXpath ? cy.xpath(selector) : cy.contains(selector);
  el.should('be.visible').click({ force: true });
});
*/


// Extract service time from text
Cypress.Commands.add('extractServiceTime', (xpath) => {
  cy.xpath(xpath)
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
});


/**
 * Alternative (if you want to use both cy.get() and cy.contains() based on context):

You can make the function smarter by checking if the selector starts with . or # to decide:
 */

Cypress.Commands.add('clickVisible', (selector, isXpath = false, timeout = 10000) => {
  let el;
  if (isXpath) {
    el = cy.xpath(selector);
  } else if (selector.startsWith('.') || selector.startsWith('#')) {
    el = cy.get(selector); // For CSS selectors
  } else {
    el = cy.contains(selector); // For visible text
  }

  el.should('be.visible').click({ force: true });
});


Cypress.Commands.add('clickVisible', (selector, isXpath = false, timeout = 10000) => {
  const el = isXpath ? cy.xpath(selector, { timeout }) : cy.contains(selector, { timeout });
  el.should('be.visible').click({ force: true });
});


Cypress.Commands.add('waitForHomePageToLoad', () => {
  // Replace this selector with one that you know is always present when homepage is loaded
  cy.contains("Women's Salon & Spa", { timeout: 10000 }).should('be.visible');
});

Cypress.Commands.add('clickLinkInSameTab', (text) => {
  cy.contains(text)
    .should('be.visible')
    .invoke('removeAttr', 'target')
    .click();
});


