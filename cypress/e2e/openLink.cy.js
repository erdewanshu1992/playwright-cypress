describe('Click UC Reviews link in same tab', () => {
  beforeEach(() => {
    cy.visit('https://www.urbancompany.com/delhi-ncr');
  });

  it('should open UC Reviews in the same tab', () => {
    // Remove target="_blank" and click the link
    // cy.contains('UC reviews')
    //   .should('be.visible')
    //   .invoke('removeAttr', 'target') // removes new tab behavior
    //   .click();

    // // Now assert we are on the /reviews page
    // cy.url().should('include', '/reviews');

    // // Optionally take screenshot and check page content
    // cy.screenshot('uc-reviews-page');

    // cy.contains('Recently Added Reviews').should('exist');

    cy.clickLinkInSameTab('UC reviews');
    

  });
});

/**
 * | Step                              | Purpose                                    |
| --------------------------------- | ------------------------------------------ |
| `cy.visit(...)`                   | Load the target homepage                   |
| `cy.contains('UC reviews')`       | Locate the UC reviews link                 |
| `.invoke('removeAttr', 'target')` | Prevent new tab opening                    |
| `.click()`                        | Click the link — now opens in the same tab |
| `cy.url().should(...)`            | Assert successful navigation               |
| `cy.screenshot(...)`              | Capture the new page                       |
| `cy.contains(...)`                | Validate expected content                  |

 */
