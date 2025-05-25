export function calculateProductTotal({ name, category, pricePerUnit, quantity, bulkDiscount, nonPerishableDiscount }) {
  let total = pricePerUnit * quantity;
  console.log(`Calculating total for ${name}: pricePerUnit(${pricePerUnit}) * quantity(${quantity}) = ${total}`);

  if (category === "Perishable" && quantity > 5) {
    const discountAmount = total * (bulkDiscount / 100);
    total -= discountAmount;
    console.log(`  Perishable bulk discount applied (${bulkDiscount}%): -${discountAmount} => ${total}`);
  }
  if (category === "Non-Perishable" && total > 2000) {
    const discountAmount = total * (nonPerishableDiscount / 100);
    total -= discountAmount;
    console.log(`  Non-Perishable discount applied (${nonPerishableDiscount}%): -${discountAmount} => ${total}`);
  }
  
  console.log(`  Final total for ${name}: ${total}\n`);
  return total;
}

export function calculateOrderSummary(products) {
  let totalAmount = 0;
  let highestCostProduct = null;
  let highestCost = 0;

  console.log("Starting order summary calculation...\n");

  for (const product of products) {
    const total = calculateProductTotal(product);
    totalAmount += total;

    if (total > highestCost) {
      highestCost = total;
      highestCostProduct = product.name;
    }
  }

  console.log(`Total amount for all products: Rs. ${totalAmount}`);
  console.log(`Product with highest cost: ${highestCostProduct} (${highestCost})`);

  return {
    totalAmount,
    highestCostProductName: highestCostProduct
  };
}
