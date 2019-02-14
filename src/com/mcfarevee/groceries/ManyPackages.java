package com.mcfarevee.groceries;

public class ManyPackages implements Item{
  private Package type; 
  private int count;
  
  /**
   * @param - type, the type of package that the packages are made of
   *        - count, how many packages there are
   */
  public ManyPackages(Package type, int count) {
    this.type = type; 
    this.count = count; 
  }

  /**
   * @return  weight, the total Weight of all the packages of the unit that
   *          the individual packages have 
   */
  public Weight getWeight() {
    //Multiply weight for each package by the number of packages there are 
    return new Weight(type.getWeight().getUnit(), type.getWeight().getAmount() * count);
  }

  /**
   * @return  price, the total price of all the packages
   */
  public int getPrice() {
    //Multiply the price of one package by the number of packages
    return count * type.getPrice();
  } 
  
  public Package getType() {
    return this.type;
  }
  
  /**
   * @return  true if the memory location of two ManyPackage objects are the same
   *          false otherwise
   */
  public boolean equals(ManyPackages other) {
    return other == this;
  }
  
  /**
   * @return  a String with the quantity, a times sign, and description of the package
   *
   */
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
  
  /**
   * Adds the specified number of packages to the ManyPackagee object
   * 
   * @param count, the number of packages to add
   *
   */
  public void addCount(int count) {
    this.count += count;
  }
  
  
}
