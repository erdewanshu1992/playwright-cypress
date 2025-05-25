// describe('Visit Privacy Policy page on YesMadam', () => {
//   it('should extract href and visit privacy policy page in same tab', () => {
//     cy.visit('https://www.yesmadam.com/delhi-at-home-services');

//     cy.get('a[href="/privacy-policy"]')
//       .should('have.attr', 'href')
//       .then((href) => {
//         // Prepend domain to href to form the full URL
//         const fullUrl = `https://www.yesmadam.com${href}`;
//         cy.visit(fullUrl);
//       });

//     // Assertion to confirm navigation
//     cy.url().should('include', 'privacypolicy');
//     cy.contains('Privacy Policy').should('be.visible');

//     // 📸 Take a screenshot
//     cy.screenshot('privacy-policy-page-yesmadam');

//     cy.scrollTo('bottom');

   

//   });
// });

// describe('test', () => {
//     it('test', () => {
//         cy.visit('https://docs.cypress.io/api/cypress-api/custom-commands');
//         cy.wait(5000);
//         cy.xpath('//*[@id="__docusaurus_skipToContent_fallback"]/div/div[2]/aside/div/div/nav/div/div/ul/li[2]/button').click({ force: true });

//         // cy.get('h1').scrollIntoView();
//        // cy.scrollTo('bottomRight', { duration: 1000 }); // Scroll over 1 second
//        // Scroll to top
//         cy.get('nav[aria-label="Docs sidebar"]').scrollIntoView();
//     });
// });

describe('test', () => {
    it('left side bar scroll', () => {
        cy.visit('https://docs.cypress.io/api/cypress-api/custom-commands');
        cy.wait(5000);

        // Click the expandable "Commands" button
        cy.xpath('//*[@id="__docusaurus_skipToContent_fallback"]/div/div[2]/aside/div/div/nav/div/div/ul/li[2]/button')
          .click({ force: true });

        // Scroll the sidebar itself to the bottom (or top/middle/custom position)
        cy.get('nav[aria-label="Docs sidebar"]')
          .scrollTo('bottom'); // or 'top', 'center', or { top: 100 }
    });

    it('scroll right table of contents', () => {
        cy.visit('https://docs.cypress.io/api/cypress-api/custom-commands');
        
        cy.get('div.tableOfContents_bqdL.thin-scrollbar.theme-doc-toc-desktop.table-of-contents__left-border.pt-\\[\\.1rem\\].table-of-contents')
            .scrollTo('bottom', { duration: 2000 }); // Adjust duration as needed
        });

});



/**
 * | Step                                  | What It Does                               |
| ------------------------------------- | ------------------------------------------ |
| `cy.visit(...)`                       | Open the initial service page              |
| `cy.get('a[href="/privacy-policy"]')` | Locate the anchor                          |
| `.then((href) => cy.visit(...))`      | Dynamically visit the link in the same tab |
| `cy.url().should(...)`                | Confirm navigation succeeded               |
| `cy.contains(...)`                    | Confirm expected content loaded            |

 */