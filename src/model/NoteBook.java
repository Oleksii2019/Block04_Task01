/*
 * Copyright (c)
 */

package model;

import java.util.ArrayList;

/**
 * Class created for a training
 * Определяет Записную книгу
 * @version v.1.1 05 Jun 2019
 * @author Aleksey Muratov
 */
public class NoteBook extends Subscriber {
    public ArrayList<Subscriber> subscriberList;

    public NoteBook() {
        subscriberList = new ArrayList<>();
    }

    public void addSubscriber(Subscriber s) {
        subscriberList.add(s);
    }

    public String getFamilyName(int number) {
        return subscriberList.get(number).getFamilyName();
    }

    public String getName(int number) {
        return subscriberList.get(number).getName();
    }

    public String getPatronymic(int number) {
        return subscriberList.get(number).getPatronymic();
    }

}
