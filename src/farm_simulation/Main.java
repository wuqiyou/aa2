package farm_simulation;

import farmyard.*;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * Our take on the "classical" game Farm Ville
 */
public class Main extends Application {
    /**
     * The width of a character.
     */
    public final static int charWidth = 6;
    /**
     * The height of a character.
     */
    public final static int charHeight = 10;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("FarmVille");

        Group root = new Group();
        Scene theScene = new Scene(root);
        primaryStage.setScene(theScene);
        Canvas canvas = new Canvas(1024, 720);
        root.getChildren().add(canvas);

        GraphicsContext gc = canvas.getGraphicsContext2D();

        // Call Farm.init() to initialize the farm items list
        Farm.init();
        drawShapes(gc);

        Timeline gameLoop = new Timeline();
        gameLoop.setCycleCount(Timeline.INDEFINITE);
        final long timeStart = System.currentTimeMillis();

        KeyFrame kf = new KeyFrame(
                Duration.seconds(0.5),
                new EventHandler<ActionEvent>() {
                    public void handle(ActionEvent ae) {
                        double t = (System.currentTimeMillis() - timeStart) / 1000.0;

                        for (int index = 0; index < Farm.myFarmItems.size(); index++) {
                            FarmItem item = (FarmItem)Farm.myFarmItems.get(index);
                            if (item instanceof MovableFarmItem) {
                                ((MovableFarmItem) item).move();
                            }
                            if (item instanceof AnimalFood) {
                                // Figure out whether to float left or right, if at all.
                                AnimalFood lolfood = (AnimalFood) item;

                                lolfood.d = Wind.windBlowingUp();
                                if (lolfood.d == -1) {
                                    lolfood.blownUp();
                                }
                                if (lolfood.d == 1) {
                                    lolfood.blownDown();
                                }
                                lolfood.d = Wind.windBlowingLeft();
                                if (lolfood.d == -1) {
                                    lolfood.blownLeft();
                                }
                                if (lolfood.d == 1) {
                                    lolfood.blownRight();
                                }
                            }
                        }

                        // Clear the canvas
                        gc.clearRect(0, 0, 1024, 720);
                        drawShapes(gc);
                    }
                });

        gameLoop.getKeyFrames().add(kf);
        gameLoop.play();
        primaryStage.show();
    }

    private void drawShapes(GraphicsContext gc) {
        // Tell all the farmyard items to draw themselves.
        for (int index = 0; index < Farm.myFarmItems.size(); index++) {
            FarmItem item = (FarmItem)Farm.myFarmItems.get(index);
            item.draw(gc);
        }
    }
}
