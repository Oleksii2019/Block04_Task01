/*
 * Copyright (c)
 */

package model;

/**
 * Class created for a training
 * Определяет отдельную запись для Записной книги
 * @version v.1.1 05 Jun 2019
 * @author Aleksey Muratov
 */
public class Subscriber {

    // Количество используемых записей (полей)
    public static final int MAX_ENTRY_NAME_AMOUNT = 3;

    // Названия записей (полей)
    public static String[] FIELD_NAME = {"family_name",
                                         "name",
                                         "patronymic"};

    // Записи (полей)
    private StringBuffer familyName;
    private StringBuffer name;
    private StringBuffer patronymic;

    public Subscriber() {
        familyName = new StringBuffer(Model.MAX_ENTRY_NAME_LENGTH);
        name = new StringBuffer(Model.MAX_ENTRY_NAME_LENGTH);
        patronymic = new StringBuffer(Model.MAX_ENTRY_NAME_LENGTH);
    }

    public Subscriber(String[] str) {
        familyName = new StringBuffer(Model.MAX_ENTRY_NAME_LENGTH);
        name = new StringBuffer(Model.MAX_ENTRY_NAME_LENGTH);
        patronymic = new StringBuffer(Model.MAX_ENTRY_NAME_LENGTH);
        setFamilyName(str[0]);
        setName(str[1]);
        setPatronymic(str[2]);
    }

    public void setFamilyName(String familyName) {
        this.familyName.replace(0, Model.MAX_ENTRY_NAME_LENGTH,
                                familyName);
    }

    public void setName(String name) {
        this.name.replace(0, Model.MAX_ENTRY_NAME_LENGTH, name);
    }

    public void setPatronymic(String patronymic) {
        this.patronymic.replace(0, Model.MAX_ENTRY_NAME_LENGTH,
                                patronymic);
    }

    public String getFamilyName() {
        return familyName.toString();
    }

    public String getName() {
        return name.toString();
    }

    public String getPatronymic() {
        return patronymic.toString();
    }

}
