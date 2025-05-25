
import { expect } from 'chai';
import { calculateOrderSummary } from '../../app/demo/groceryUtilsWithUi.js';

describe('UI + Logic (Function-based)', () => {
  it('should validate total amount and highest cost product from UI', async () => {
    // Put your actual absolute path here, adjust for your OS
    const pathToHTML = 'file:///Users/yesmadamtesting/Desktop/wdio-function-tests/products.html';
    console.log('🧭 Loading:', pathToHTML);
    await browser.url(pathToHTML);


    const productEls = await $$('.product');
    console.log(`Found ${productEls.length} product elements`);

    if (productEls.length === 0) {
      throw new Error("No product elements found. Check page URL and selectors!");
    }

    const products = [];

    for (const el of productEls) {
      const name = await el.getAttribute('data-name');
      const category = await el.getAttribute('data-category');
      const pricePerUnit = parseFloat(await el.getAttribute('data-price'));
      const quantity = parseInt(await el.getAttribute('data-qty'), 10);
      const bulkDiscount = parseFloat(await el.getAttribute('data-bulk-discount'));
      const nonPerishableDiscount = parseFloat(await el.getAttribute('data-np-discount'));

      products.push({ name, category, pricePerUnit, quantity, bulkDiscount, nonPerishableDiscount });
    }

    console.log('Starting order summary calculation...');

    const result = calculateOrderSummary(products);

    console.log(`Product with the highest total cost after discounts: ${result.highestCostProductName}`);
    console.log(`Total amount to be paid by the customer: Rs. ${result.totalAmount}`);

    expect(result.highestCostProductName).to.equal('Rice (5kg bag)');
    expect(result.totalAmount).to.equal(3015);


    console.log(`\nSummary:`);
    console.log(`Product with the highest total cost after discounts: ${result.highestCostProductName}`);
    console.log(`Total amount to be paid by the customer: Rs. ${result.totalAmount}`);

  });
});