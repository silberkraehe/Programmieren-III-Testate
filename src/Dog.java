import java.util.ArrayList;

public class Dog extends Animal{
    private ArrayList<Item> requiredItems;

    public Dog(int id, String name, String species, Enclosure enclosure) {
        super(id, name, species, enclosure);
    }
}
