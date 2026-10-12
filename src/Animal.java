import java.util.UUID;

public class Animal {
    private UUID id;
    private String name;
    private String species;
    private boolean sick;
    private Enclosure enclosure;

    public Animal(UUID id, String name, String species, Enclosure enclosure) {
        this.id = id;
        this.name = name;
        this.species = species;
        this.enclosure = enclosure;
    }

    public void feed(Item item) {

    }

    public void cure(Item item) {

    }

    public void move (Enclosure enclosure) {

    }
}
