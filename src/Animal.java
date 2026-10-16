import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class Animal {
    private int id;
    private String name;
    private String species;
    private boolean sick;
    private Enclosure enclosure;
    private Date birthday;

    public Animal(String name, String species, Date birthday) {
        this.id = UUID.randomUUID().hashCode();
        this.name = name;
        this.species = species;
        this.birthday = birthday;

    }

    public void feed(Item item) {

    }

    public void cure(Item item) {

    }

    public void move (Enclosure enclosure) {

    }

    public void forget () {
        // methode um ein erstelltes Tier-Objekt wieder aus dem Speicher zu löschen, nachdem es in eine Liste übertragen wurde (für SQL-Resultate)
    }

    public static Animal fromResultSet(ResultSet rs) throws SQLException {
        return new Animal(
                rs.getString("name"),
                rs.getString("species"),
                rs.getDate("birthday")
        );
    }
}
