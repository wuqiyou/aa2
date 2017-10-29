package farmyard;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class FarmItem {
  /**
   * How FarmItem appears on the screen.
   */
  protected String appearance;
  /**
   * The colour of this FarmItem.
   */
  private Color colour;
  /**
   * This FarmItem's first coordinate.
   */
  protected int row;
  /**
   * This FarmItem's second coordinate.
   */
  protected int column;

  public FarmItem(String appearance, Color colour){
    this.appearance = appearance;
    this.colour = colour;
  }

  /**
   * set the FarmItem's location
   * @param row the row number of the location
   * @param col the column number of the location
   */
  public void setLocation(int row, int col){
    this.row = row;
    column = col;
  }

  /**
   * Draw the FarmItem.
   * @param g the graphics context in which to draw this item.
   */
  public void draw(GraphicsContext g) {
    g.setFill(colour);
    g.fillText(appearance, column * 10, row * 6);
  }
}
