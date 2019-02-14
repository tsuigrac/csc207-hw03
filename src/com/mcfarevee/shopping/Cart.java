package com.mcfarevee.shopping;

import com.mcfarevee.groceries.Item;
import com.mcfarevee.groceries.ManyPackages;
import com.mcfarevee.groceries.Package;
import com.mcfarevee.groceries.Unit;
import com.mcfarevee.groceries.Weight;
import com.mcfarevee.groceries.BulkFood;
import com.mcfarevee.groceries.BulkItem;
import java.util.ArrayList;
import java.awt.RenderingHints.Key;
import java.io.PrintWriter;

public class Cart {
  ArrayList<Item> cart;


  public Cart() {
    cart = new ArrayList<Item>();
  }
  
  /**
   * Adds the specified item to the end of the ArrayList
   */
  public void addItem(Item item) {
    cart.add(item);
  }

  /**
   * @return the number of things in the cart
   *         - most items are counted as one thing, except for ManyPackages
   *           for which the count was used
   */
  public int numThings() {
    int count = 0;
    for (int i = 0; i < cart.size(); i++) {
      Item item = cart.get(i);
      //If the item is ManyPackages, add the count of that object
      if (item instanceof ManyPackages) {
        ManyPackages packages = (ManyPackages) item;
        count += packages.getCount();
      } else {
        count++;
      }
    }
    return count;
  }

  public int numEntries() {
    return cart.size();
  }

  /**
   * Prints the items in the cart as strings
   */
  public void printContents(PrintWriter pen) {
    for (int i = 0; i < cart.size(); i++) {
      pen.println(cart.get(i).toString());
    }
  }

  /**
   * @return the sum of the prices of all items in the cart
   */
  public int getPrice() {
    int cents = 0;
    for (int i = 0; i < cart.size(); i++) {
      cents += cart.get(i).getPrice();
    }
    return cents;
  }

  /**
   * @return Weights, an array of weights of length 4
   *         - index 0 represents the total number of pounds of the cart
   *         - index 1 represents the total number of ounces in the cart
   *         - index 2 represents the total number of kilograms in the cart
   *         - index 3 represents the total number of grams in the cart
   */
  public Weight[] getWeight() {
    Weight[] weights = new Weight[4];
    weights[0] = new Weight(Unit.POUND, 0);
    weights[1] = new Weight(Unit.OUNCE, 0);
    weights[2] = new Weight(Unit.KILOGRAM, 0);
    weights[3] = new Weight(Unit.GRAM, 0);

    for (int i = 0; i < cart.size(); i++) {
      Item item = cart.get(i);

      //Add the weight of each item to the correct index, based on the unit
      if (item.getWeight().getUnit().equals(Unit.POUND)) {
        weights[0].addAmount(item.getWeight().getAmount());
      } else if (item.getWeight().getUnit().equals(Unit.OUNCE)) {
        weights[1].addAmount(item.getWeight().getAmount());
      } else if (item.getWeight().getUnit().equals(Unit.KILOGRAM)) {
        weights[2].addAmount(item.getWeight().getAmount());
      } else
        weights[3].addAmount(item.getWeight().getAmount());
    }
    return weights;
  }

  /**
   * Removes all items whose name exactly matches 'name'
   */
  public void remove(String name) {
    for (int i = 0; i < cart.size(); i++) {
      if (cart.get(i).getName().equals(name)) {
        cart.remove(i);

      }
    }
  }

  /**
   * Finds two identical items and merges them into a single item
   * - BulkItems: if two BulkItem objects with the same food and units are
   *              encountered, the weights are added together. Subsequent 
   *              BulkItem objects with the same original weight are ignored,
   *              and the next BulkItem object with the same weight as the updated
   *              weight get merged.
   * - ManyPackages objects and Package objects of the same kind are combined
   * - Two Package items with identical parameters are combined into a single ManyPackage
   * - Two ManyPackages objects with the same kind of package are combined
   *   into a single ManyPackage object
   */
  public void merge() {
    //Compare item at index 0 with all other elements in ArrayList, then compare
    //item at index 1 with all other subsequent elements, etc.
    for (int i = 0; i < cart.size(); i++) {
      for (int j = i + 1; j < cart.size(); j++) {
        Item keyItem = cart.get(i);
        Item otherItem = cart.get(j);
        
        //If both items are BulkItems:
        if (keyItem instanceof BulkItem && otherItem instanceof BulkItem) {
          BulkItem other = (BulkItem) otherItem;
          BulkItem key = (BulkItem) keyItem;
          
          //If they have the same parameters
          if (key.equals(other)) {
            //Add weight and remove the object further down in the array
            key.addAmount(other.getWeight().getAmount());
            cart.remove(j);
            //Update search index
            j--;
          }
          //If both items are ManyPackage items
        } else if (keyItem instanceof ManyPackages && otherItem instanceof ManyPackages) {
          ManyPackages other = (ManyPackages) otherItem;
          ManyPackages key = (ManyPackages) keyItem;
          //If they are of the same package type
          if (key.getType().equals(other.getType())) {
            //increment the count of one ManyPackage object and remove
            //the object further down in the ArrayList
            key.addCount(other.getCount());
            cart.remove(j);
            //Update search index
            j--;
          }
          //If the key object is a Package and the comparison object is a ManyPackage
        } else if (keyItem instanceof Package && otherItem instanceof ManyPackages) {
          Package key = (Package) keyItem;
          ManyPackages other = (ManyPackages) otherItem;
          
          //If they are composed of the same type of package,
          //copy the ManyPackage into the front of the ArrayList, increment
          //count and delete the old ManyPackage and Package
          if (key.equals(other.getType())) {
            other.addCount(1);
            cart.add(i, cart.get(j));
            cart.remove(j+1);
            cart.remove(i+1);
            j--;
          }
          //If key is ManyPackages and other is Package
        } else if (keyItem instanceof ManyPackages && otherItem instanceof Package) {
          Package other = (Package) otherItem;
          ManyPackages key = (ManyPackages) keyItem;
          
          //Increment count for ManyPackage and delete Package
          if (key.getType().equals(other)) {
            key.addCount(1);
            cart.remove(j);
            j--;
          }
          //If both are Packages
        } else if (keyItem instanceof Package && otherItem instanceof Package) {
          Package other = (Package) otherItem;
          Package key = (Package) keyItem;
          //Create a new ManyPackage object, merge Packages, insert, and delete Packages
          if (key.equals(other)) {
            ManyPackages newPackages = new ManyPackages(key, 2);
            cart.remove(j);
            cart.remove(i);
            j--;
            cart.add(i, newPackages);
          }
        }
      }
    }
  }

}
  

