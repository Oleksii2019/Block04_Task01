/*
 * Copyright (c)
 */

package manager;

import model.*;
import view.*;
import java.util.Scanner;

/**
 * Class created for a training
 * @version v.1.2 08 Jun 2019
 * @author Aleksey Muratov
 */
public class Manager {

    // Для временного хранения и передачи строковых данных между методами
    private StringBuffer currentRegex;

    private View view;
    private Model model;
    private Scanner scanner;
    private ScannerController sc;

    /**
     * Class constructor.
     */
    public Manager(View view, Model model) {
        scanner = new Scanner(System.in);
        this.view = view;
        this.model = model;
        currentRegex = new StringBuffer(View.NAME_REGEX_UA.length());
        sc = new ScannerController(scanner, view);
    }

    private void stopScanner() {
        scanner.close();
    }

    /**
     * Основной метод контроллера (менеджера).
     * Управляет получением, проверкой данных, их записью в записную книгу
     * и печатью соответствующей записи из записной книги
     */
    public void runManager() {
        choiceLanguage();
        addRecord(model.noteBook);
        view.printNoteBookFields(model.noteBook,
                                 model.noteBook.subscriberList.size() - 1);
        stopScanner();
    }

    /**
     * Метод реализует выбор языка мнтерфейса программы
     */
    private void choiceLanguage() {
        if (sc.getFromScanner(View.PROMPT_MESSAGE
                + View.CHOICE_EN  + " - english, "
                + View.CHOICE_UA + " - ukrainian)"
                + View.COLON_SIGN,
                View.NOT_OK_MESSAGE + View.NEW_LINE_SIGN,
                View.CHOICE_LOCAL_REGEX,
                View.NAME_REGEX_EN.length())
                .equals(View.CHOICE_EN)) {
            view.setRegion(View.ENGLAND);
            currentRegex.replace(0, View.NAME_REGEX_UA.length(),
                                 View.NAME_REGEX_EN);
        } else {
            view.setRegion(View.UKRAINE);
            currentRegex.replace(0, View.NAME_REGEX_UA.length(),
                                 View.NAME_REGEX_UA);
        }
    }

    /**
     * Метод вызывает метод для ввод данных из командной строки и
     * реализует передачу результатов в соответствующую сущность.
     * @param noteBook  сущность, в которую передаются результаты
     */
    private void addRecord(NoteBook noteBook) {
        String[] str = new String[NoteBook.MAX_ENTRY_NAME_AMOUNT];
        for (int i = 0; i < NoteBook.MAX_ENTRY_NAME_AMOUNT; i++) {
            str[i] = getValue(i);
        }
        noteBook.addSubscriber(new Subscriber(str));
    }

    /**
     * Метод реализует ввод данных из командной строки для
     * поля класса NoteBook передачу результатов в соответствующую сущность noteBook.
     * @param number номер поля записи класса NoteBook
     * @return String строка з новим значением поля
     */
    private String getValue(int number) {
        return sc.getFromScanner(
                view.localMessenger.getString(View.PROMPT_KEY)
                + view.localMessenger.getString(NoteBook
                                                .FIELD_NAME[number])
                + view.localMessenger.getString(View.COLON_SIGN_KEY),
                view.localMessenger.getString(View.NOT_OK_MESSAGE_KEY)
                + String.valueOf(View.NEW_LINE_SIGN),
                currentRegex.toString(),
                Model.MAX_ENTRY_NAME_LENGTH);
    }

}
