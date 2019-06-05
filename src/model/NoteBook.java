package model;

import java.util.ArrayList;

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
