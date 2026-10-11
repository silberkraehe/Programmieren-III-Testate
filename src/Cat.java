import java.util.ArrayList;

public class Cat extends Animal{
    private ArrayList<Item> requiredItems;

    public Cat(int id, String name, String species, Enclosure enclosure) {
        super(id, name, species, enclosure);
    }
}
