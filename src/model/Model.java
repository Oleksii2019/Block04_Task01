/*
 * Copyright (c)
 */

package model;

/**
 * Class created for a training
 * @version v.1.1 05 Jun 2019
 * @author Aleksey Muratov
 */
public class Model {

    // Максимальная длинна в записях
    public static final int MAX_ENTRY_NAME_LENGTH = 20;

    public NoteBook noteBook;

    /**
     * Class constructor.
     */
    public Model() {
        noteBook = new NoteBook();
    }

}
