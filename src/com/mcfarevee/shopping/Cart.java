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

  public void addItem(Item item) {
    cart.add(item);
  }

  public int numThings() {
    int count = 0;
    for (int i = 0; i < cart.size(); i++) {
      Item item = cart.get(i);
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

  public void printContents(PrintWriter pen) {
    for (int i = 0; i < cart.size(); i++) {
      pen.println(cart.get(i).toString());
    }
  }

  public int getPrice() {
    int cents = 0;
    for (int i = 0; i < cart.size(); i++) {
      cents += cart.get(i).getPrice();
    }
    return cents;
  }

  public Weight[] getWeight() {
    Weight[] weights = new Weight[4];
    weights[0] = new Weight(Unit.POUND, 0);
    weights[1] = new Weight(Unit.OUNCE, 0);
    weights[2] = new Weight(Unit.KILOGRAM, 0);
    weights[3] = new Weight(Unit.GRAM, 0);

    for (int i = 0; i < cart.size(); i++) {
      Item item = cart.get(i);

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

  public void remove(String name) {
    for (int i = 0; i < cart.size(); i++) {
      if (cart.get(i).getName().equals(name)) {
        cart.remove(i);

      }
    }
  }

  public void merge() {
    for (int i = 0; i < cart.size(); i++) {
      for (int j = i + 1; j < cart.size(); j++) {
        Item keyItem = cart.get(i);
        Item otherItem = cart.get(j);
        if (keyItem instanceof BulkItem && otherItem instanceof BulkItem) {
          BulkItem other = (BulkItem) otherItem;
          BulkItem key = (BulkItem) keyItem;
          if (key.equals(other)) {
            key.addAmount(other.getWeight().getAmount());
            cart.remove(j);
            j--;
          }
        } else if (keyItem instanceof ManyPackages && otherItem instanceof ManyPackages) {
          ManyPackages other = (ManyPackages) otherItem;
          ManyPackages key = (ManyPackages) keyItem;
          if (key.getType().equals(other.getType())) {
            key.addCount(other.getCount());
            cart.remove(j);
            j--;
          }
        } else if (keyItem instanceof Package && otherItem instanceof ManyPackages) {
          Package key = (Package) keyItem;
          ManyPackages other = (ManyPackages) otherItem;

          if (key.equals(other.getType())) {
            other.addCount(1);
            cart.add(i, cart.get(j));
            cart.remove(j+1);
            cart.remove(i+1);
            j--;
          }
        } else if (keyItem instanceof ManyPackages && otherItem instanceof Package) {
          Package other = (Package) otherItem;
          ManyPackages key = (ManyPackages) keyItem;

          if (key.getType().equals(other)) {
            key.addCount(1);
            cart.remove(j);
            j--;
          }
        }
        else if (keyItem instanceof Package && otherItem instanceof Package) {
          Package other = (Package) otherItem;
          Package key = (Package) keyItem;
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
  

// Cite https://study.com/academy/lesson/how-to-use-instanceof-operator-in-java.html
