import java.util.ArrayList;

public class Bird extends Animal{
    private ArrayList<Item> requiredItems;

    public Bird(int id, String name, String species, Enclosure enclosure) {
        super(id, name, species, enclosure);
    }
}
