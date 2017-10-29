package farmyard;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * An egg that a farmer collects.
 */
public class Egg extends FarmItem {

  /**
   * How this piece of food appears on the screen.
   */
  public Egg() {
    super("o", Color.ROSYBROWN);
  }
}
