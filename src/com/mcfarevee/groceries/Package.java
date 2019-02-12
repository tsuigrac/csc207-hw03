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

  @Override
  public Weight getWeight() {
    // TODO Auto-generated method stub
    return weight;
  }

  @Override
  public int getPrice() {
    // TODO Auto-generated method stub
    return price;
  }

  public boolean equals(Package other) {

    return (this.name == other.name && this.weight == other.weight && this.price == other.price);
  }

  public String toString() {
    return weight.amount + " "+ weight.unit.name + " " + "package of " + name + ".";
  }
}
