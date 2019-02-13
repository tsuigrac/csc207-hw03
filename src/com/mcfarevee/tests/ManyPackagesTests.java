package com.mcfarevee.tests;

import com.mcfarevee.groceries.*;
import com.mcfarevee.groceries.Package;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class ManyPackagesTests {

  void testString() {
    Package first = new Package("oreos", new Weight(Unit.OUNCE, 12), 399);
    ManyPackages package1 = new ManyPackages(first, 13);
    System.out.println(package1.toString());
  }
  
  
  void testWeight() {
    Package first = new Package("oreos", new Weight(Unit.OUNCE, 12), 399);
    ManyPackages package1 = new ManyPackages(first, 13);
    System.out.println(package1.getWeight().getAmount());
    System.out.println(package1.getWeight().getUnit().abbrev());
  }
  
  
  void testPrice() {
    Package first = new Package("oreos", new Weight(Unit.OUNCE, 12), 399);
    ManyPackages package1 = new ManyPackages(first, 10);
    System.out.println(package1.getPrice());
  }

  @Test
  void testEquals() {
    Package first = new Package("oreos", new Weight(Unit.OUNCE, 12), 399);
    ManyPackages package1 = new ManyPackages(first, 10);
    Package second = new Package("oreos", new Weight(Unit.OUNCE, 12), 399);
    ManyPackages package2 = package1;
    System.out.println(package1.equals(package2));
  }
}



