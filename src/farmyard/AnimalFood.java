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
   * Search for food
   */
  public static AnimalFood foodIsHere() {
    for (int index = 0; index < Farm.myFarmItems.size(); index++) {
      FarmItem item = (FarmItem)Farm.myFarmItems.get(index);
      if (item instanceof AnimalFood){
        return (AnimalFood)item;
      }
    }
    return null;
  }

  /**
   * Causes this item to take its turn in the farm-pen simulation, blown due to strong winds. Up in
   * this case
   */
  public void blownUp() {
    row--;
    if (row == -1) {
      row = Farm.MaxRow - 1;
    }
  }

  /**
   * Causes this item to take its turn in the farm-pen simulation, blown due to strong winds. Down
   * in this case
   */
  public void blownDown() {
    row++;
    if (row == Farm.MaxRow)
    {
      row = 0;
    }
  }

  /**
   * Causes this item to take its turn in the farm-pen simulation, blown due to strong winds. Up and
   * Left in this case
   */
  public void blownLeft() {
    column--;
    if (column == -1) {
      column = Farm.MaxCol - 1;
    }
  }

  /**
   * Causes this item to take its turn in the farm-pen simulation, blown due to strong winds. Up and
   * Right in this case
   */
  public void blownRight() {
    column++;
    if (column == Farm.MaxCol)
    {
      column = 0;
    }
  }
}
