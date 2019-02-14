package com.mcfarevee.groceries;

public class Weight {
  private Unit unit;
  private int amount;
  
  /**
   * @param - unit, the weight's unit (pounds, grams, kilograms, ounces)
   *        - amount, the amount of weight the object has 
   */
  public Weight (Unit unit, int amount) {
    this.unit = unit;
    this.amount = amount;
  }
  
  /**
   * @param - amount, the amount of weight to add
   */
  public void addAmount(int amount) {
    this.amount += amount;
  }
  
  public int getAmount() {
    return this.amount;
  }
  
  public Unit getUnit() {
    return this.unit;
  }
  
  /**
   * @return - true if all parameters are the same
   */
  public boolean equals(Weight other) {
    return this.unit.equals(other.unit) && this.amount == other.amount;
  }
}
