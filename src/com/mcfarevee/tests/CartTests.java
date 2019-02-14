package com.mcfarevee.tests;
import com.mcfarevee.groceries.*;
import com.mcfarevee.groceries.Package;
import com.mcfarevee.shopping.*;
import java.io.PrintWriter;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class CartTests {

  void testAdd() {
    PrintWriter pen = new PrintWriter(System.out, true);
    Cart cart = new Cart();
 // The store has 20 pounds of bananas, priced at 50 cents per pound
    BulkFood bananas = new BulkFood("bananas", Unit.POUND, 50, 20);
    // The store has 200 grams of saffron, priced at 1000 cents per gram
    BulkFood saffron = new BulkFood("saffron", Unit.GRAM, 1000, 200);
    
    // The customer adds three pounds of bananas to the cart
    cart.addItem(new BulkItem(bananas, Unit.POUND, 3));
    
    // The customer adds a bag of 1 gram of saffron to the cart
    cart.addItem(new BulkItem(saffron, Unit.GRAM, 1));
    
    // The customer adds a can opener to the cart, priced $3.489.
    cart.addItem(new NonFood("can opener", new Weight(Unit.OUNCE, 2), 349));
    
    // The customer adds a box of oreos to the cart
    
    cart.addItem(new Package("oreos", new Weight(Unit.OUNCE, 12), 399));
    cart.addItem(new ManyPackages(new Package("macncheez", 
        new Weight(Unit.OUNCE, 6), 77), 5));
    pen.println("Before:");
    cart.printContents(pen);
    pen.println("Number of entries Before:");
    pen.println(cart.numEntries());
    pen.println("Number of things Before");
    pen.println(cart.numThings());
    pen.println();
    cart.remove("oreos");
    //cart.remove("macncheez");
    pen.println("After:");
    cart.printContents(pen);
    pen.println("Number of entries after");
    pen.println(cart.numEntries());
    pen.println("Number of things after");
    pen.println(cart.numThings());
    // The customer adds five 6oz packages of macncheez to the cart, each 
    // priced at 77 cents.
    cart.addItem(new ManyPackages(new Package("macncheez", 
        new Weight(Unit.OUNCE, 6), 77), 5));
  }

  
  void testPrice() {
    PrintWriter pen = new PrintWriter(System.out, true);
    Cart cart = new Cart();
 // The store has 20 pounds of bananas, priced at 50 cents per pound
    BulkFood bananas = new BulkFood("bananas", Unit.POUND, 50, 20);
    // The store has 200 grams of saffron, priced at 1000 cents per gram
    BulkFood saffron = new BulkFood("saffron", Unit.GRAM, 1000, 200);
    
    // The customer adds three pounds of bananas to the cart
    cart.addItem(new BulkItem(bananas, Unit.POUND, 3));
    cart.printContents(pen);
    pen.println("Total price: " + cart.getPrice());
    // The customer adds a bag of 1 gram of saffron to the cart
    cart.addItem(new BulkItem(saffron, Unit.GRAM, 1));
    cart.printContents(pen);
    pen.println("Total price: " + cart.getPrice());
    // The customer adds a can opener to the cart, priced $3.489.
    cart.addItem(new NonFood("can opener", new Weight(Unit.OUNCE, 2), 349));
    cart.printContents(pen);
    pen.println("Total price: " + cart.getPrice());
    // The customer adds a box of oreos to the cart
    
    cart.addItem(new Package("oreos", new Weight(Unit.OUNCE, 12), 400));
    cart.addItem(new ManyPackages(new Package("macncheez", 
        new Weight(Unit.OUNCE, 6), 100), 5));
    cart.printContents(pen);
    pen.println("Total price: " + cart.getPrice());
    cart.remove("oreos");
    cart.remove("macncheez");
    cart.printContents(pen);
    pen.println("Total price: " + cart.getPrice());
    // The customer adds five 6oz packages of macncheez to the cart, each 
    // priced at 77 cents.
    cart.addItem(new ManyPackages(new Package("macncheez", 
        new Weight(Unit.OUNCE, 6), 77), 5));
  }


  void testWeight() {
    PrintWriter pen = new PrintWriter(System.out, true);
    Cart cart = new Cart();

    BulkFood bananas = new BulkFood("bananas", Unit.POUND, 50, 20);
   
    BulkFood saffron = new BulkFood("saffron", Unit.GRAM, 1000, 200);
    
    
    cart.addItem(new BulkItem(bananas, Unit.POUND, 10));
    //cart.printContents(pen);
    /*
    pen.println("Pounds: " + cart.getWeight()[0].getAmount());
    pen.println("Ounces: " + cart.getWeight()[1].getAmount());
    pen.println("Kilograms: " + cart.getWeight()[2].getAmount());
    pen.println("Grams: " + cart.getWeight()[3].getAmount());
    */
    // The customer adds a bag of 1 gram of saffron to the cart
    cart.addItem(new BulkItem(saffron, Unit.GRAM, 1));
    /*
    pen.println("Pounds: " + cart.getWeight()[0].getAmount());
    pen.println("Ounces: " + cart.getWeight()[1].getAmount());
    pen.println("Kilograms: " + cart.getWeight()[2].getAmount());
    pen.println("Grams: " + cart.getWeight()[3].getAmount());
    */
    // The customer adds a can opener to the cart, priced $3.489.
    cart.addItem(new NonFood("can opener", new Weight(Unit.POUND, 2), 349));
    /*
    pen.println("Pounds: " + cart.getWeight()[0].getAmount());
    pen.println("Ounces: " + cart.getWeight()[1].getAmount());
    pen.println("Kilograms: " + cart.getWeight()[2].getAmount());
    pen.println("Grams: " + cart.getWeight()[3].getAmount());
    // The customer adds a box of oreos to the cart
    */
    cart.addItem(new Package("oreos", new Weight(Unit.OUNCE, 12), 400));
    cart.addItem(new ManyPackages(new Package("macncheez", 
        new Weight(Unit.OUNCE, 6), 100), 5));
    // The customer adds five 6oz packages of macncheez to the cart, each 
    // priced at 77 cents.
    cart.addItem(new ManyPackages(new Package("macncheez", 
        new Weight(Unit.KILOGRAM, 6), 77), 5));
    pen.println("Pounds: " + cart.getWeight()[0].getAmount());
    pen.println("Ounces: " + cart.getWeight()[1].getAmount());
    pen.println("Kilograms: " + cart.getWeight()[2].getAmount());
    pen.println("Grams: " + cart.getWeight()[3].getAmount());
  }
  
  @Test
  void testMerge() {
    PrintWriter pen = new PrintWriter(System.out, true);
    Cart cart = new Cart();

    BulkFood bananas = new BulkFood("bananas", Unit.POUND, 50, 20);
   
    BulkFood saffron = new BulkFood("saffron", Unit.GRAM, 1000, 200);
    
    /*
    cart.addItem(new BulkItem(bananas, Unit.POUND, 2));
    cart.addItem(new Package("oreos", new Weight(Unit.OUNCE, 12), 399));
    cart.addItem(new BulkItem(saffron, Unit.POUND, 2));
    cart.addItem(new Package("oreos", new Weight(Unit.OUNCE, 12), 399));
    cart.addItem(new BulkItem(bananas, Unit.POUND, 2));
    cart.addItem(new Package("oreos", new Weight(Unit.OUNCE, 12), 399));
    cart.addItem(new BulkItem(bananas, Unit.POUND, 2));
    cart.addItem(new BulkItem(saffron, Unit.POUND, 2));
    cart.addItem(new Package("oreos", new Weight(Unit.OUNCE, 10), 399));
    cart.addItem(new BulkItem(bananas, Unit.POUND, 4));
    cart.addItem(new ManyPackages(new Package("oreos", new Weight(Unit.OUNCE, 12), 399), 5));
    */
    
/*
    Package oreos = new Package("oreos", new Weight(Unit.OUNCE, 12), 399);
    Package oreos2 = new Package("oreos", new Weight(Unit.OUNCE, 12), 399);
    ManyPackages oreoPack4 = new ManyPackages(oreos, 10);
    ManyPackages oreoPack1 = new ManyPackages(oreos, 5);
    ManyPackages oreoPack2 = new ManyPackages(oreos, 5);
    ManyPackages oreoPack3 = new ManyPackages(oreos, 10);
    cart.addItem(oreoPack1);
    cart.addItem(oreos);
    cart.addItem(oreoPack2);
    cart.addItem(oreos2);
    cart.addItem(oreoPack3);
    cart.addItem(oreoPack4);
  */
    Package oreos = new Package("oreos", new Weight(Unit.OUNCE, 12), 399);
    Package oreos2 = new Package("oreos", new Weight(Unit.OUNCE, 12), 399);
    Package oreos3 = new Package("oreos", new Weight(Unit.OUNCE, 12), 399);
    Package oreos4 = new Package("oreos", new Weight(Unit.OUNCE, 12), 399);
    Package oreos1 = new Package("oreos", new Weight(Unit.OUNCE, 12), 399);
    Package bananas1 = new Package("bananas", new Weight(Unit.OUNCE, 12), 399);
    Package bananas2 = new Package("bananas", new Weight(Unit.OUNCE, 12), 399);
    Package bananas3 = new Package("bananas", new Weight(Unit.OUNCE, 13), 399);
    
    cart.addItem(oreos);
    cart.addItem(oreos1);
    cart.addItem(bananas1);
    cart.addItem(oreos2);
    cart.addItem(bananas2);
    cart.addItem(oreos3);
    cart.addItem(oreos4);
    cart.addItem(bananas3);
    
    pen.println("Original: ");
    cart.printContents(pen);
    
    pen.println();
    pen.println("Merged:");
    cart.merge();
    cart.printContents(pen);
   
  }
  
}
