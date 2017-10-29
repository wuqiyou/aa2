package farmyard;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class AnimalManure extends FarmItem {
  

  public AnimalManure(String appearance) {
    super(appearance, Color.BLACK.darker().darker().darker());
  }
}
