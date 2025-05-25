export function calculateProductTotal({ category, pricePerUnit, quantity, bulkDiscount, nonPerishableDiscount }) {
  let total = pricePerUnit * quantity;
  if (category === "Perishable" && quantity > 5) {
    total -= total * (bulkDiscount / 100);
  }
  if (category === "Non-Perishable" && total > 2000) {
    total -= total * (nonPerishableDiscount / 100);
  }
  return total;
}

export function calculateOrderSummary(products) {
  let totalAmount = 0;
  let highestCostProduct = null;
  let highestCost = 0;

  for (const product of products) {
    const total = calculateProductTotal(product);
    totalAmount += total;
    if (total > highestCost) {
      highestCost = total;
      highestCostProduct = product.name;
    }
  }

  return {
    totalAmount,
    highestCostProductName: highestCostProduct
  };
}