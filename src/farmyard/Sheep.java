package farmyard;

import javafx.scene.paint.Color;

public class Sheep extends MovableFarmItem {
    private boolean allowDefecate = false;
    /**
     * Constructs a new Chicken.
     */
    public Sheep() {
        super("^_^", Color.BLUE);
    }

    public void move() {
        // Get to food ?
        if (target == null) {
            target = AnimalFood.foodIsHere();
        }
        if (target != null) {
            System.out.println("Target acquired: " + target.row + " " + target.column + "| Me: " + row + " " + column);
            if (row == target.row && column == target.column) {
                // Meet with food
                allowDefecate = true;
                // clear egg in the array
                Farm.RemoveItem(target);
                // reset target
                target = null;
            } else {
                MoveTowardTarget(target);
            }
        } else {
            // no egg to pick up
            MoveRandomly();
        }

        // Sometimes we digest.
        double d = Math.random();
        if (d < 0.1 && allowDefecate) {
            clearStomach();
        }

        // Figure out whether I turn around.
        tryTurnAround();
    }

    /**
     * Helps animal clear stomach
     */
    private void clearStomach() {
        AnimalManure newManure = new AnimalManure("@");
        newManure.setLocation(row, column);
        Farm.AddItem(newManure);

        allowDefecate = false;
    }
}
