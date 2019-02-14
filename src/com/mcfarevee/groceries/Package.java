package com.mcfarevee.groceries;

public class Package implements Item {
  private String name;
  private Weight weight;
  private int price;

  /**
   * @param - name, the name of the object
   *        - weight, the weight of the object, with unit and amount
   *        - price, the price of the object in cents
   */
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
  
  /**
   * @return true if all parameters are equal 
   */
  public boolean equals(Package other) {
    return (this.name.equals(other.name) && 
        this.weight.equals(other.weight) && this.price == other.price);
  }

  /**
   * @return a String giving the weight, the word "package", and the name
   */
  public String toString() {
    return weight.getAmount() + " "+ weight.getUnit().abbrev + " " + "package of " + name;
  }
  
  /**
   * Adds specified price to the existing package
   * @param price, the price you want to add to the package
   */
  public void addPrice(int price) {
    this.price += price;
  }
}
