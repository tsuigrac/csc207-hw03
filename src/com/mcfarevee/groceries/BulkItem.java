package com.mcfarevee.groceries;

public class BulkItem implements Item{
  private Unit unit;
  private int amount;
  private BulkFood food;
  
  public BulkItem(BulkFood food, Unit unit, int amount) {
    this.unit = unit;
    this.amount = amount;
    this.food = food;
  }
  
  public String toString() {
    if (amount == 1) {
      return amount + " " + unit.name + " of " + food.getName(); 
    } else {
      return amount + " " + unit.plural + " of " + food.getName(); 
    }
  }
  
  public Weight getWeight() {
    return new Weight(unit, amount);
  }

  public int getPrice() {
    return this.amount * food.getPricePerUnit();
  }
  
  public  boolean equals(BulkItem item) {
    return (this.unit.equals(item.unit) && this.amount == item.amount 
        && this.food.equals(item.food));
  }
  
  public String getName() {
    return this.food.getName();
  }
  
  public void addAmount(int amount) {
    this.amount += amount;
  }
}
