package com.mcfarevee.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import com.mcfarevee.groceries.*;
import com.mcfarevee.groceries.Package;

class PackageTests {

  
  void testString() {
    Package first = new Package("oreos", new Weight(Unit.OUNCE, 12), 399);
    System.out.println(first.toString());
  }
  
  
  void testWeight() {
    Package first = new Package("oreos", new Weight(Unit.OUNCE, 12), 399);
    System.out.println(first.getWeight().getAmount());
    System.out.println(first.getWeight().getUnit().abbrev());
  }
  
  
  void testPrice() {
    Package first = new Package("oreos", new Weight(Unit.OUNCE, 12), 399);
    System.out.println(first.getPrice());
  }

  
  @Test
  void testEquals() {
    Package first = new Package("oreos", new Weight(Unit.OUNCE, 12), 399);
    Package second = new Package("oreos", new Weight(Unit.OUNCE, 12), 39);
    System.out.println(first.equals(second));
  }
}
