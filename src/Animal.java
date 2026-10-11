public abstract class Animal {
    private int id;
    private String name;
    private String species;
    private boolean sick;
    private Enclosure enclosure;

    public Animal(int id, String name, String species, Enclosure enclosure) {
        this.id = id;
        this.name = name;
        this.species = species;
        this.enclosure = enclosure;
    }

    public void feet(Item item) {

    }

    public void cure(Item item) {

    }

    public void move (Enclosure enclosure) {

    }
}
