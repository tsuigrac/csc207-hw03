package com.mcfarevee.tests;
import com.mcfarevee.groceries.BulkItem;
import com.mcfarevee.groceries.Unit;
import com.mcfarevee.groceries.BulkFood;
import com.mcfarevee.groceries.*;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class BulkItemTests {

  
  void testToString() {
    BulkFood bananas = new BulkFood("bananas", Unit.POUND, 50, 20);
    BulkFood saffron = new BulkFood("saffron", Unit.POUND, 20, 20);
    
    BulkItem item1 = new BulkItem(bananas, Unit.POUND, 3);
    
    System.out.println(item1.toString());
  }
  

  void testWeight() {
    BulkFood bananas = new BulkFood("bananas", Unit.POUND, 50, 20);
    BulkFood saffron = new BulkFood("saffron", Unit.POUND, 20, 20);
    
    BulkItem item1 = new BulkItem(bananas, Unit.POUND, 3);
    BulkItem item2 = new BulkItem(saffron, Unit.GRAM, 3);
    
    Weight weight = item1.getWeight();
    Weight weight2 = item2.getWeight();
    System.out.println(weight.getAmount());   
    System.out.println(weight.getUnit().abbrev());
    System.out.println(weight.equals(weight2));
    
    weight.addAmount(5);
    
    System.out.println(weight.getAmount());
    
  }
  

  void testPrice() {
    BulkFood bananas = new BulkFood("bananas", Unit.POUND, 50, 20);
    BulkFood saffron = new BulkFood("saffron", Unit.POUND, 20, 20);
    
    BulkItem item1 = new BulkItem(bananas, Unit.POUND, 3);
    BulkItem item2 = new BulkItem(saffron, Unit.POUND, 5);
    
    
    System.out.println(item1.getPrice());
    System.out.println(item2.getPrice());
  }
  
  void testEquals() {
    BulkFood bananas1 = new BulkFood("bananas", Unit.POUND, 50, 20);
    BulkFood bananas2 = new BulkFood("bananas", Unit.POUND, 50, 20);
    BulkFood bananas3 = new BulkFood("bananas", Unit.POUND, 150, 20);
    BulkFood bananas4 = new BulkFood("bananas", Unit.GRAM, 50, 20);
    BulkFood saffron = new BulkFood("saffron", Unit.POUND, 20, 20);
    
    BulkItem item1 = new BulkItem(bananas1, Unit.POUND, 3);
    BulkItem item2 = new BulkItem(saffron, Unit.GRAM, 3);
    
    System.out.println(item1.equals(item2));
    
  }

}
