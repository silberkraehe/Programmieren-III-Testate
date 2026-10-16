import java.util.Date;
import java.util.UUID;

public class Caretaker {
    private int id;
    private String name;

    private enum Roles {
        doctor,
        manager,
        apprentice,
        intern,
        worker
    }

    public Caretaker(int id) {
    }

    public void registerAnimal(String pName, String species, Date birthday) {
        UUID animalID = UUID.randomUUID();
        Enclosure enclosure = null;
        Animal name = new Animal(pName, species, birthday);
    }

    public void adoption(Animal animal) {

    }

    public void shopping() {

    }

    public int checkRole() {
        return 0;
    }

    public void changeRole() {

    }
}
