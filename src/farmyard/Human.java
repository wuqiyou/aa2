package farmyard;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.ArrayList;

/**
 * A Human
 */
public class Human extends MovableFarmItem {

  private ArrayList<Egg> myBasket = new ArrayList<Egg>();
  /**
   * The animal food the human is feeding his/her beloved animals.
   */
  static final String thing = ".";
  /**
   * Constructs a new Human.
   */
  public Human() {
    super("human",Color.SANDYBROWN.darker());
  }

  /**
   * Causes human to drop down 4 piece s of food all around.
   */
  protected void dropFood() {
    AnimalFood food = new AnimalFood();
    food.setLocation(row - 1, column - 1);
    Farm.AddItem(food);

    food = new AnimalFood();
    food.setLocation(row - 1, column + 1);
    Farm.AddItem(food);

    food = new AnimalFood();
    food.setLocation(row + 1, column - 1);
    Farm.AddItem(food);

    food = new AnimalFood();
    food.setLocation(row + 1, column + 1);
    Farm.AddItem(food);
  }
  /**
   * Draws this farm pen item.
   *
   * @param g the graphics context in which to draw this item.
   */
  public void draw(GraphicsContext g) {
    super.draw(g);
    g.fillText("Eggs: " + myBasket.size(), 2 * 10, 2 * 6);
  }

  /**
   * Causes this item to take its turn in the farm-pen-simulation.
   */
  public void move() {

    if (target == null) {
      target = Chicken.anEggIsHere();
    }

    if (target != null) {
      System.out.println("Target acquired: " + target.row + " " + target.column + "| Me: " + row + " " + column);
      if (row == target.row && column == target.column) {
        // Meet with an Egg
        System.out.println("Egg!");
        this.myBasket.add((Egg)target);
        // clear egg in the array
        Farm.RemoveItem(target);
        // reset target
        target = null;
        if (myBasket.size() % 12 == 0) {
          System.out.println("Dozen!");
        }
      } else {
        MoveTowardTarget(target);
      }
    } else {
      // no egg to pick up
      MoveRandomly();
    }
    // Figure out whether I should drop food.
    double d = Math.random();
    if (d < 0.05) {
      dropFood();
    }

    // Figure out whether I turn around.
    tryTurnAround();
  }
}
