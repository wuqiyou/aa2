package farmyard;

import javafx.scene.paint.Color;

public class Pig extends MovableFarmItem {
  /**
   * Constructs a new Pig.
   */
  public Pig() {
    super(":(8)", Color.PINK.darker().darker().darker());
  }

  /**
   * Causes this item to take its turn in the farm-pen simulation.
   */
  public void move() {
    // Figure out whether I turn around.
    tryTurnAround();

      // Get to food ?
      if (target == null) {
          target = AnimalFood.foodIsHere();
      }
      if (target != null) {
          System.out.println("Target acquired: " + target.row + " " + target.column + "| Me: " + row + " " + column);
          if (row == target.row && column == target.column) {
              // Meet with food
              System.out.println("Food!");
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

    // Sometimes we digest.
    double d = Math.random();
    if (d < 0.2) {
      clearStomach();
    }
  }

  /**
   * Helps animal clear stomach
   */
  private final boolean clearStomach() {
    System.out.println("Pig stink");

    AnimalManure newManure = new AnimalManure("*");
    newManure.setLocation(row, column);
    Farm.AddItem(newManure);

    return true;
  }
}
