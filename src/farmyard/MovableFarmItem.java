package farmyard;

import javafx.scene.paint.Color;

public class MovableFarmItem extends FarmItem {

  protected boolean goingRight;

  public MovableFarmItem(String appearance, Color colour) {
    super(appearance, colour);
    goingRight = true;
  }

  public void move(){
    double d = Math.random();
    if (d < 0.1) {
      turnAround();
    }
  }

  protected void MoveRight(int maxCol) {

    if (goingRight)
    {
      column++;
      if (column == maxCol)
      {
        column = 0;
      }
    }
    else {
      column--;
      if (column == -1)
      {
        column = maxCol - 1;
      }
    }

  }

  protected void turnAround() {
    goingRight = !goingRight;
    appearance = reverseAppearance();
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
