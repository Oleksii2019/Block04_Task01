import manager.*;
import model.*;
import view.*;

public class Main {
    public static void main(String[] args) {
        Manager m = new Manager(new View(), new Model());
        m.runManager();

    }
}
