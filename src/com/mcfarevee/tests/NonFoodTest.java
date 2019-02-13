package com.mcfarevee.tests;

import com.mcfarevee.groceries.*;
import com.mcfarevee.groceries.Package;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class NonFoodTest {

  
  void testString() {
    NonFood food = new NonFood("can opener", new Weight(Unit.OUNCE, 2), 349);
    System.out.println(food.toString());
    
  }

  void testWeight() {
    NonFood food = new NonFood("can opener", new Weight(Unit.OUNCE, 2), 349);
    System.out.println(food.getWeight().getAmount());
    System.out.println(food.getWeight().getUnit().abbrev());
  }
  
  
  void testPrice() {
    NonFood food = new NonFood("can opener", new Weight(Unit.OUNCE, 2), 349);
    System.out.println(food.getPrice());
  }

  @Test
  void testEquals() {
    NonFood food1 = new NonFood("can opener", new Weight(Unit.OUNCE, 2), 3149);
    NonFood food2 = new NonFood("can opener", new Weight(Unit.OUNCE, 2), 349);
    System.out.println(food1.equals(food2));
  }
}



