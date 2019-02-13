package com.mcfarevee.groceries;

public class Package implements Item {
  String name;
  Weight weight;
  int price;

  public Package(String name, Weight weight, int price) {
    this.name = name;
    this.weight = weight;
    this.price = price;
  }

  public Weight getWeight() {
    return weight;
  }


  public int getPrice() {
    return price;
  }

  public boolean equals(Package other) {
    return (this.name.equals(other.name) && 
        this.weight.equals(other.weight) && this.price == other.price);
  }

  public String toString() {
    return weight.amount + " "+ weight.unit.abbrev + " " + "package of " + name + ".";
  }
}
