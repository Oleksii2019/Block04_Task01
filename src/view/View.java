/*
 * Copyright (c)
 */

package view;

import model.*;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Class created for a training
 * @version v.1.1 05 Jun 2019
 * @author Aleksey Muratov
 */
public class View {

    // Варианты локализации
    public static String CHOICE_EN = "1";
    public static String CHOICE_UA = "2";

    // Регулярное выражение, применяемое для контроля введенных имен,
    // фамилмй, отчеств на английском языке
    public static String CHOICE_LOCAL_REGEX = "[" + CHOICE_EN + CHOICE_UA
            + "]{1}";
    public static String NAME_REGEX_EN = "^[A-Z]{1}[a-z]+[-]?[A-Z]?"
            + "{1}[a-z]+?$";
    public static String NAME_REGEX_UA = "^[А-ЯЇІЄҐ&&[^ъЫЭ]]{1}[а-яїі"
            + "єґ'&&[^ъыэ]]+-?[А-ЯЇІЄҐ&&[^ъЫЭ]]?[а-яїієґ'&&[^ъыэ]]+?$";
//        NAME_REGEX_RU = "^([А-ЯЁ&&[^ЪЬ]]{1}[а-яё]+)|([А-ЯЁ&&[^ЪЬ]]"
//                        + "{1}[а-яё]+-[А-ЯЁ&&[^ЪЬ]]{1}[а-яё]+)$";

    public static String MESSAGES_FILE_NAME = "messages";
    public static String PROMPT_KEY = "first.prompt";
    public static String COLON_SIGN_KEY = "second.prompt";
    public static String RESULT_KEY = "result.message";
    public static String NOT_OK_MESSAGE_KEY = "wrong.message";
    public static String ENGLAND = "en";
    public static String UKRAINE = "ua";
    public static String PROMPT_MESSAGE = "Select language (";
    public static String COLON_SIGN = ":";
    public static String NOT_OK_MESSAGE = "It is wrong. Try again...";
    public static final char NEW_LINE_SIGN = '\n';
    public ResourceBundle localMessenger;

    /**
     * Метод выводит сообщение в устройство вывода
     * @param mess сообщение
     */
    public void printMessage(String mess) {
        System.out.print(mess);
    }

    /**
     * Метод установки заданной локализации
     * @param language определяет локализацию
     */
    public void setRegion(String language) {
        localMessenger = ResourceBundle.getBundle(
                MESSAGES_FILE_NAME, new Locale(language));
    }

    /**
     * Метод выводит содержание сущности с введенными в программе
     * данними в устройство вывода
     * @param noteBook имя сущности с данными для вывода
     * @param number номер сущности в списке
     */
    public void printNoteBookFields(NoteBook noteBook, int number) {
        printMessage(String.valueOf(NEW_LINE_SIGN));
        printMessage(localMessenger.getString(RESULT_KEY));
        printMessage(String.valueOf(NEW_LINE_SIGN));
        printMessage(noteBook.getFamilyName(number)
                     + NEW_LINE_SIGN);
        printMessage(noteBook.getName(number)
                     + NEW_LINE_SIGN);
        printMessage(noteBook.getPatronymic(number)
                     + NEW_LINE_SIGN);
    }

}
