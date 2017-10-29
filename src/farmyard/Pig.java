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

   super.move();

    // Move one spot to the right or left.
    if (goingRight) {
      column += 1;
    } else {
      column -= 1;
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
