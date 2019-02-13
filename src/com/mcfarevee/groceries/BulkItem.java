package com.mcfarevee.groceries;

public class BulkItem implements Item{
  Unit unit;
  int amount;
  BulkFood food;
  
  public BulkItem(BulkFood food, Unit unit, int amount) {
    this.unit = unit;
    this.amount = amount;
    this.food = food;
  }
  
  public String toString() {
    if (amount == 1) {
      return amount + " " + unit.name + " of " + food.name; 
    } else {
      return amount + " " + unit.plural + " of " + food.name; 
    }
  }
  
  //Are we supposed to return a weight object (and how do we do that)
  //or just the amount?
  public Weight getWeight() {
    return new Weight(unit, amount);
  }

  public int getPrice() {
    return this.amount * food.pricePerUnit;
  }
  
  public  boolean equals(BulkItem item) {
    return (this.unit.equals(item.unit) && this.amount == item.amount 
        && this.food.equals(item.food));
        
  }

}
