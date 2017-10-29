package farmyard;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * Animal Food
 */

public class AnimalFood extends FarmItem {

  public double d;

  /**
   * The appearance of the food.
   */
  private static final String test = "%";

  public AnimalFood() {
    super(AnimalFood.test, Color.GRAY.darker().darker().darker());
  }

  /**
   * Causes this item to take its turn in the farm-pen simulation, blown due to strong winds. Up in
   * this case
   */
  public void blownUp() {

    // Move upwards
    row--;
  }

  /**
   * Causes this item to take its turn in the farm-pen simulation, blown due to strong winds. Down
   * in this case
   */
  public void blownDown() {

    // Move downwards
    row++;
  }

  /**
   * Causes this item to take its turn in the farm-pen simulation, blown due to strong winds. Up and
   * Left in this case
   */
  public void blownLeft() {

    column--;//move left
  }

  /**
   * Causes this item to take its turn in the farm-pen simulation, blown due to strong winds. Up and
   * Right in this case
   */
  public void blownRight() {

    column++;//move right
  }

}
