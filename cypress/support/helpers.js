// cypress/support/helpers.js

// Function to set the viewport to simulate a mobile device
Cypress.Commands.add("setMobileView", () => {
  // You can change the device model as needed
  cy.viewport('iphone-6'); // This simulates an iPhone 6 screen size
});

// Function to click a mobile button after setting the mobile view
export const setMobileViewAndClick = (buttonSelector) => {
  cy.setMobileView(); // Set mobile view first
  cy.get(buttonSelector).click(); // Then click on the button
};


