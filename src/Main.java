/*
 * Copyright (c)
 */

import manager.*;
import model.*;
import view.*;

/**
 * Class created for a training
 * @version v.1.1 05 Jun 2019
 * @author Aleksey Muratov
 */
public class Main {
    public static void main(String[] args) {
        Manager m = new Manager(new View(), new Model());
        m.runManager();
    }
}
