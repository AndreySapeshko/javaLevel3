import java.io.Serializable;
import java.util.Date;

public class House implements Serializable {
    private String type;
    private String walls;
    private Date birthDay;
    private int flows;

    public House(String type, Date birthDay, String walls, int flows) {
        this.type = type;
        this.birthDay = birthDay;
        this.walls = walls;
        this.flows = flows;
    }

    public String toString() {
        return type + " " + birthDay + " " + walls + " " + flows;
    }
}
