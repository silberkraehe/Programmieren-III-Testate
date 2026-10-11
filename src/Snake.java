import java.util.ArrayList;

public class Snake extends Animal{
    private ArrayList<Item> requiredItems;

    public Snake(int id, String name, String species, Enclosure enclosure) {
        super(id, name, species, enclosure);
    }
}
