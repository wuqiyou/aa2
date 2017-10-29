package farmyard;

import javafx.scene.paint.Color;

public class Chicken extends MovableFarmItem {

  /**
   * Constructs a new Chicken.
   */
  public Chicken() {
    super("/'/>", Color.RED);
  }

  /**
   * Set this item's location.
   */
  public static Egg aneggishere() {
    for (int index = 0; index < Farm.myFarmItems.size(); index++) {
      FarmItem item = (FarmItem)Farm.myFarmItems.get(index);
      if (item instanceof Egg){
        return (Egg)item;
      }
    }
    return null;
  }

  /**
   * Causes this item to take its turn in the farm-pen simulation.
   */
  public void move() {

    // Sometimes food doesn't sit well in the stomach, so I have to clear my stomach
    double d1 = Math.random();
    if (d1 < 0.2) {
      digest();
    }

    // Move one spot to the right or left.
    if (goingRight) {
      column += 1;
    } else {
      column -= 1;
    }

    // Every now and then lay an egg.
    double d2 = Math.random();
    if (d1 < 0.1) {
      layEgg();
    }

    super.move();
  }

  /**
   * Lay an egg.
   */
  private void layEgg() {
    System.out.println("Breakfast! " + "Egg loc: " + row + " " + column);
    Egg egg = new Egg();
    egg.setLocation(row, column);
    Farm.AddItem(egg);
  }

  /**
   * Finish digesting
   */
  private final boolean digest() {
    System.out.println("New stuff to make things grow.");

    AnimalManure getTheScoop = new AnimalManure(".");
    getTheScoop.setLocation(row, column);
    Farm.AddItem(getTheScoop);

    return true;
  }
}
