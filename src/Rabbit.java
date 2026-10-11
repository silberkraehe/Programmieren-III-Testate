import java.util.ArrayList;

public class Rabbit extends Animal{
    private ArrayList<Item> requiredItems;

    public Rabbit(int id, String name, String species, Enclosure enclosure) {
        super(id, name, species, enclosure);
    }
}
