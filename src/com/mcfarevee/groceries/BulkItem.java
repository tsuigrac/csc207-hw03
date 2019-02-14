package com.mcfarevee.groceries;

public class BulkItem implements Item{
  private Unit unit;
  private int amount;
  private BulkFood food;

  /**
   * @param - food, the BulkFood of which the BulkItem is made of
   *        - unit, the unit of the weight 
   *        - amount, the weight (in units of the parameter 'unit') of the BulkItem
   */
  public BulkItem(BulkFood food, Unit unit, int amount) {
    this.unit = unit;
    this.amount = amount;
    this.food = food;
  }
  
  /**
   * @return A string of the form " 'amount' 'unit' of 'BulkFood name'"
   * 
   */
  public String toString() {
    if (amount == 1) {
      return amount + " " + unit.name + " of " + food.getName(); 
    } else {
      return amount + " " + unit.plural + " of " + food.getName(); 
    }
  }
  
  /**
   * @return An object of type Weight, which consists of a unit and amount
   * 
   */
  public Weight getWeight() {
    return new Weight(unit, amount);
  }
  
  /**
   * @return The price of the BulkItem, computed by multiplying the pricePerUnit
   *         by the amount of food 
   */
  public int getPrice() {
    return this.amount * food.getPricePerUnit();
  }
  
  /**
   * @return A boolean, which is true if the BulkItem we are comparing it with has
   *         the same parameters
   */
  public  boolean equals(BulkItem item) {
    return (this.unit.equals(item.unit) && this.amount == item.amount 
        && this.food.equals(item.food));
  }
  
  /**
   * @return name, a String of the name of the food
   */
  public String getName() {
    return this.food.getName();
  }
  
  /**
   * Adds 'amount' weight to the current weight
   * 
   * @preconditions 'amount' must be of the unit that this.unit is 
   */
  public void addAmount(int amount) {
    this.amount += amount;
  }
}
