package farmyard;

import javafx.scene.paint.Color;

public class Chicken extends MovableFarmItem {

  private boolean allowDefecate = false;
  /**
   * Constructs a new Chicken.
   */
  public Chicken() {
    super("/'/>", Color.RED);
  }

  /**
   * Search for an Egg
   */
  public static Egg anEggIsHere() {
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
    if (d1 < 0.2 && allowDefecate) {
      digest();
    }

    // Get to food ?
    if (target == null) {
      target = AnimalFood.foodIsHere();
    }
    if (target != null) {
      System.out.println("Target acquired: " + target.row + " " + target.column + "| Me: " + row + " " + column);
      if (row == target.row && column == target.column) {
        // Meet with food
        System.out.println("Food!");
        // set the flag to allow defecate
        allowDefecate = true;
        // clear egg in the array
        Farm.RemoveItem(target);
        // reset target
        target = null;
      } else {
        MoveTowardTarget(target);
      }
    } else {
      // no egg to pick up
      MoveRandomly();
    }

    // Every now and then lay an egg.
    if (d1 < 0.1) {
      layEgg();
    }

    // Figure out whether I turn around.
    tryTurnAround();
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
  private final void digest() {
    System.out.println("New stuff to make things grow.");

    AnimalManure getTheScoop = new AnimalManure(".");
    getTheScoop.setLocation(row, column);
    Farm.AddItem(getTheScoop);

    // set the flag to false
    allowDefecate = false;
  }
}
