package com.mcfarevee.groceries;

public class Weight {
  Unit unit;
  int amount;
  
  public Weight (Unit unit, int amount) {
    this.unit = unit;
    this.amount = amount;
  }
  
  public int getAmount() {
    return this.amount;
  }
  
  public Unit getUnit() {
    return this.unit;
  }
  
  public boolean equals(Weight other) {
    return this.unit.equals(other.unit) && this.amount == other.amount;
  }
}
