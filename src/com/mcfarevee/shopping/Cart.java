package com.mcfarevee.shopping;

import com.mcfarevee.groceries.Item;
import com.mcfarevee.groceries.ManyPackages;
import com.mcfarevee.groceries.Unit;
import com.mcfarevee.groceries.Weight;
import com.mcfarevee.groceries.BulkFood;
import com.mcfarevee.groceries.BulkItem;
import java.util.ArrayList;
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
}
  

// Cite https://study.com/academy/lesson/how-to-use-instanceof-operator-in-java.html
