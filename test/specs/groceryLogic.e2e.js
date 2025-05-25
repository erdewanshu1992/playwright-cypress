import { expect } from 'chai';
import { calculateOrderSummary } from '../../app/demo/groceryUtils.js';

describe('Pure function test (no UI)', () => {
  it('should calculate correct total and highest product', () => {
    const products = [
      { name: 'Apples', category: 'Perishable', pricePerUnit: 100, quantity: 6, bulkDiscount: 10, nonPerishableDiscount: 0 },
      { name: 'Rice (5kg bag)', category: 'Non-Perishable', pricePerUnit: 500, quantity: 4, bulkDiscount: 0, nonPerishableDiscount: 5 },
      { name: 'Milk (1 liter)', category: 'Perishable', pricePerUnit: 50, quantity: 10, bulkDiscount: 5, nonPerishableDiscount: 0 }
    ];

    const result = calculateOrderSummary(products);

    expect(result.totalAmount).to.equal(3015);
    expect(result.highestCostProductName).to.equal("Rice (5kg bag)");

     console.log(`\nSummary:`);
    console.log(`Product with the highest total cost after discounts: ${result.highestCostProductName}`);
    console.log(`Total amount to be paid by the customer: Rs. ${result.totalAmount}`);
    
  });
});
