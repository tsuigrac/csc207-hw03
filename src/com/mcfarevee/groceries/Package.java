package com.mcfarevee.groceries;

public class Package implements Item {
  private String name;
  private Weight weight;
  private int price;

  public Package(String name, Weight weight, int price) {
    this.name = name;
    this.weight = weight;
    this.price = price;
  }

  public Weight getWeight() {
    return this.weight;
  }


  public int getPrice() {
    return this.price;
  }
  
  public String getName() {
    return this.name;
  }

  public boolean equals(Package other) {
    return (this.name.equals(other.name) && 
        this.weight.equals(other.weight) && this.price == other.price);
  }

  public String toString() {
    return weight.getAmount() + " "+ weight.getUnit().abbrev + " " + "package of " + name;
  }
  
  public void addPrice(int price) {
    this.price += price;
  }
}
