package com.mcfarevee.groceries;

public class NonFood implements Item{

  private String name; 
  private Weight weight; 
  private int price; 
  
  
  /**
   * @param - name, the name of the object
   *        - weight, the weight of the object, with unit and amount
   *        - price, the price of the object in cents
   */
  public NonFood(String name, Weight weight, int price) {
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
  
  /**
   * @param other, another NonFood
   * @returns true if the parameters are all the same 
   * 
   */
  public boolean equals(NonFood other) {
    return this.name.equals(other.name) && this.weight.equals(other.weight)
        && this.price == other.price;  
  }
  
  /**
   * @returns the name of the object
   * 
   */
  public String toString() {
    return this.name; 
  }
  
  /**
   * @returns the name of the object
   * 
   */

  public String getName() {
    return this.name;
  }
}
