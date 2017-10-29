package farmyard;

import javafx.scene.paint.Color;

public class MovableFarmItem extends FarmItem {

  protected boolean goingRight;
  protected FarmItem target;

  public MovableFarmItem(String appearance, Color colour) {
    super(appearance, colour);
    goingRight = true;
  }

  public void move(){
  }

  /**
   * Move towards a target item
   * @param target: the target item to move towards
   */
  protected void MoveTowardTarget(FarmItem target) {
    if (row < target.row) {
      MoveDown();
    } else if (row > target.row) {
      MoveUp();
    }
    if (column < target.column) {
      MoveRight();
    } else if (column > target.column){
      MoveLeft();
    }
  }

  protected void MoveRandomly() {
    // Move one spot to the right or left.
    if (goingRight) {
      // Figure out whether to move up or down, or neither.
      double d = Math.random();
      if (d < 0.1) {
        MoveDown();
      } else if (d < 0.2) {
        MoveUp();
      }
      MoveRight();
    } else {
      // Figure out whether to move up or down, or neither.
      double d = Math.random();
      if (d < 0.1) {
        MoveDown();
      } else if (d < 0.2) {
        MoveUp();
      }
      MoveLeft();
    }
  }
  protected void tryTurnAround() {
    double d = Math.random();
    if (d < 0.1) {
      goingRight = !goingRight;
      appearance = reverseAppearance();
    }
  }

  protected  void MoveLeft() {
    column--;
    if (column == -1) {
      column = Farm.MaxCol - 1;
    }
  }

  protected void MoveRight() {
    column++;
    if (column == Farm.MaxCol)
    {
      column = 0;
    }
  }

  protected void MoveUp() {
    row--;
    if (row == -1) {
      row = Farm.MaxRow - 1;
    }
  }

  protected void MoveDown() {
    row++;
    if (row == Farm.MaxRow)
    {
      row = 0;
    }
  }

  /**
   * Build and initialize this Chicken's forward and backward appearances.
   */
  private String reverseAppearance() {
    StringBuilder reverseBuilder = new StringBuilder();
    for (int i = appearance.length() - 1; i >= 0; i--) {
      char current = appearance.charAt(i);
      switch (current) {
        case '\\':
          current = '/';
          break;
        case '/':
          current = '\\';
          break;
        case ')':
          current = '(';
          break;
        case '(':
          current = ')';
          break;
        case '>':
          current = '<';
          break;
        case '<':
          current = '>';
          break;
        case '}':
          current = '{';
          break;
        case '{':
          current = '}';
          break;
        case '[':
          current = ']';
          break;
        case ']':
          current = '[';
          break;
        default:
          break;
      }
      reverseBuilder.append(current);
    }

    return reverseBuilder.toString();
  }
}
