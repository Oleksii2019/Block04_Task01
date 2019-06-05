/*
 * Copyright (c)
 */

package manager;

import model.*;
import view.*;
import java.util.Scanner;

/**
 * Class created for a training
 * @version v.1.1 05 Jun 2019
 * @author Aleksey Muratov
 */
public class Manager {

    // Регулярное выражение, применяемое для контроля введенных имен,
    // фамилмй, отчеств на английском языке
    private String NAME_REGEX_EN;

    // Для временного хранения и передачи строковых данных между методами
    private StringBuffer resultAfterCheck;

    private View view;
    private Model model;
    private Scanner scanner;

    public Manager(View view, Model model) {
        scanner = new Scanner(System.in);
        this.view = view;
        this.model = model;
        resultAfterCheck = new StringBuffer(Model.MAX_ENTRY_NAME_LENGTH);

        // Значения регулярных выражений
        NAME_REGEX_EN = "^[A-Z]{1}[a-z]+[-]?[A-Z]?{1}[a-z]+?$";
//        NAME_REGEX_RU = "^([А-ЯЁ&&[^ЪЬ]]{1}[а-яё]+)|([А-ЯЁ&&[^ЪЬ]]"
//                        + "{1}[а-яё]+-[А-ЯЁ&&[^ЪЬ]]{1}[а-яё]+)$";
//        NAME_REGEX_UA = "^[А-ЯЇІЄҐ&&[^ъЫЭ]]{1}[а-яїієґ'&&[^ъыэ]]+"
//                        + "-?[А-ЯЇІЄҐ&&[^ъЫЭ]]?[а-яїієґ'&&[^ъыэ]]+?$";

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
        String[] str = new String[Subscriber.MAX_ENTRY_NAME_AMOUNT];
        for (int i = 0; i < Subscriber.MAX_ENTRY_NAME_AMOUNT; i++) {
            getName(i);
            str[i] = resultAfterCheck.toString();
        }
        model.moteBook.addSubscriber(new Subscriber(str));
        printNoteBookFields(model.moteBook.subscriberList.size() - 1);
        stopScanner();
    }

    private void getName(int counter) {
        while (!checkScannerLine(getScannerLine(counter)));
    }

    public String getScannerLine(int counter) {
        view.printMessage(view.PROMPT_MRSSAGE
                          + Subscriber.FIELD_NAME[counter]
                          + view.COLON_SIGN);
        return scanner.nextLine();
    }

    public boolean checkScannerLine(String str) {
        boolean res = str.matches(NAME_REGEX_EN) && (str.length()
                                  < Model.MAX_ENTRY_NAME_LENGTH);
        resultAfterCheck.replace(0, Model.MAX_ENTRY_NAME_LENGTH, str);
        if (!res) {
            view.printMessage(view.NOT_OK_MESSAGE + view.NEW_LINE_SIGN);
        }
        return res;
    }

    public void printNoteBookFields(int number) {
        view.printMessage(view.NEW_LINE_SIGN + view.RESULT_NESSAGE
                          + view.NEW_LINE_SIGN);
        view.printMessage(model.moteBook.getFamilyName(number)
                          + view.NEW_LINE_SIGN);
        view.printMessage(model.moteBook.getName(number)
                          + view.NEW_LINE_SIGN);
        view.printMessage(model.moteBook.getPatronymic(number)
                          + view.NEW_LINE_SIGN);
    }

}
