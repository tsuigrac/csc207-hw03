package com.mcfarevee.groceries;

public class ManyPackages implements Item{
  Package type; 
  int count;
  
  public ManyPackages(Package type, int count) {
    this.type = type; 
    this.count = count; 
  }
  @Override
  public Weight getWeight() {
    return new Weight(type.weight.unit, type.weight.amount * count);
  }
  @Override
  public int getPrice() {
    return count * type.price;
  } 
  
  public boolean equals(ManyPackages other) {
    return other == this;
  }
  public String toString() {
    return this.count + "x" + this.type.weight.amount + " " + this.type.weight.unit.abbrev + " " + "package of " +
  this.type.name;
  }
}
