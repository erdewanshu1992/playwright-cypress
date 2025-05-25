describe('Product Search with Mock Backend', () => {
    beforeEach(() => {
      cy.visit('index.html'); // Replace with your actual HTML page if needed
    });
  
    it('intercepts and mocks the product list API', () => {
      // Intercept the GET request to /products and return mocked data
      cy.intercept('GET', 'http://localhost:5000/products', {
        statusCode: 200,
        body: [
          { "id": 1, "name": "Mocked HP Laptop", "price": 45000 },
          { "id": 2, "name": "Mocked Dell Inspiron", "price": 55000 }
        ]
      }).as('mockedProductRequest');
  
      // Trigger search (simulated by clicking a button, assuming it's wired to call the API)
      cy.get('#searchBox').type('Laptop');
      cy.get('#searchBtn').click();
  
      // Wait for the intercepted request to complete
      cy.wait('@mockedProductRequest');
  
      // Verify that the mocked product list is shown
      cy.get('li').should('have.length', 2)
                  .and('contain.text', 'Mocked HP Laptop')
                  .and('contain.text', 'Mocked Dell Inspiron');
    });
  
    it('simulates error on search', () => {
      // Simulate an error response (500 status)
      cy.intercept('GET', 'http://localhost:5000/products', {
        statusCode: 500
      }).as('errorRequest');
  
      cy.get('#searchBox').type('Laptop');
      cy.get('#searchBtn').click();
  
      cy.wait('@errorRequest');
      
      // Expect an error message in the UI
      cy.get('li').should('contain.text', 'Error fetching results');
    });
  });
  