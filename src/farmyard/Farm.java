package farmyard;

import java.util.ArrayList;

/**
 * Farm class to manage farm items and max rows/columns
 */
public class Farm {

    public static final int MaxRow = 48;
    public static final int MaxCol = 106;

    /**
     * An array list to hold all the farm items
     */
    public static ArrayList myFarmItems = new ArrayList();

    /**
     * Set the farm items at the beginning
     */
    public static void init(){
        Chicken chicken1 = new Chicken();
        chicken1.setLocation(23, 18);
        myFarmItems.add(chicken1);

        Chicken chicken2 = new Chicken();
        chicken2.setLocation(6, 12);
        myFarmItems.add(chicken2);

        Chicken chicken3 = new Chicken();
        chicken3.setLocation(17, 4);
        myFarmItems.add(chicken3);

        Chicken chicken4 = new Chicken();
        chicken4.setLocation(15, 28);
        myFarmItems.add(chicken4);

        Chicken chicken5 = new Chicken();
        chicken5.setLocation(15, 36);
        myFarmItems.add(chicken5);

        Chicken chicken6 = new Chicken();
        chicken6.setLocation(16, 35);
        myFarmItems.add(chicken6);

        Pig pig1 = new Pig();
        pig1.setLocation(10, 20);
        myFarmItems.add(pig1);

        Pig pig2 = new Pig();
        pig2.setLocation(20, 10);
        myFarmItems.add(pig2);

        Human human1 = new Human();
        human1.setLocation(30, 30);
        myFarmItems.add(human1);
    }

    /**
     * Add one item to the list
     * @param item: the item to add
     */
    public static void AddItem(FarmItem item)
    {
        Farm.myFarmItems.add(item);
    }

    /**
     * Remove one item from the list
     * @param item: the item to remove
     */
    public static void RemoveItem(FarmItem item)
    {
        Farm.myFarmItems.remove(item);
    }
}
