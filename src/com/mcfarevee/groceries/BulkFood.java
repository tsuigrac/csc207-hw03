package com.mcfarevee.groceries;


public class BulkFood{
  private String name;
  private Unit unit;
  private int pricePerUnit;
  private int supply;
  
  /**
   * @param - name, a String of the food name
   *        - unit, the unit of weight of the food
   *        - pricePerUnit, the price in cents per unit of the food the list of arguments from the terminal, in the order filepath, width, height 
   *        - supply, the amount that the store has 
   */
  public BulkFood(String name, Unit unit, int pricePerUnit, int supply) {
    this.name = name;
    this.unit = unit;
    this.pricePerUnit = pricePerUnit;
    this.supply = supply;
  }
  
  /**
   * @return  name, the name of the food
   */
  public String getName() {
    return this.name;
  }
  
  /**
   * @return  unit, the unit of weight of the food
   */
  public Unit getUnit() {
    return this.unit;
  }
  
  /**
   * @return  pricePerUnit, the price per unit of the food
   */
  public int getPricePerUnit() {
    return this.pricePerUnit;
  }
  
  /**
   * @return  supply, the amount the store has left of the food in weight
   */
  public int getSupply() {
    return this.supply;
  }
  
  /**
   * @param - other, another BulkFood
   * @return  equals, which is true if the BulkFood in the parameter has
   *          the same parameters
   */
  public boolean equals(BulkFood other) {
    return this.name.equals(other.name) && this.unit.equals(other.unit) 
        && this.pricePerUnit == other.pricePerUnit && this.supply == other.supply;
  }
  
  }
  

