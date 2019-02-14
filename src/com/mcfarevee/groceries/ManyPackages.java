package com.mcfarevee.groceries;

public class ManyPackages implements Item{
  private Package type; 
  private int count;
  
  public ManyPackages(Package type, int count) {
    this.type = type; 
    this.count = count; 
  }
  @Override
  public Weight getWeight() {
    return new Weight(type.getWeight().getUnit(), type.getWeight().getAmount() * count);
  }
  @Override
  public int getPrice() {
    return count * type.getPrice();
  } 
  
  public Package getType() {
    return this.type;
  }
  
  public boolean equals(ManyPackages other) {
    return other == this;
  }
  public String toString() {
    return this.count + " x " + this.type.getWeight().getAmount() + " " + 
        this.type.getWeight().getUnit().abbrev + " " + "package of " +
        this.type.getName();
  }
  
  public int getCount() {
    return this.count;
  }
  
  public String getName() {
    return this.type.getName();
  }
  
  public void addCount(int count) {
    this.count += count;
  }
  
  
}
