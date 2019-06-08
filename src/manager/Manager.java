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

    // Для временного хранения и передачи строковых данных между методами
    private StringBuffer resultAfterCheck, currentRegex;

    private View view;
    private Model model;
    private Scanner scanner;

    // Признак этапа выбора языка.
    // Введено для использования одних методоа на разных этапах выполнения
    private boolean choiceLanguageStage;

    public Manager(View view, Model model) {
        scanner = new Scanner(System.in);
        this.view = view;
        this.model = model;
        resultAfterCheck = new StringBuffer(Model.MAX_ENTRY_NAME_LENGTH);
        currentRegex = new StringBuffer(View.NAME_REGEX_UA.length());
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
        fillingFields(model.noteBook);
        view.printNoteBookFields(model.noteBook,
                                 model.noteBook.subscriberList.size() - 1);
        stopScanner();
    }

    private void fillingFields(NoteBook noteBook) {
        String[] str = new String[Subscriber.MAX_ENTRY_NAME_AMOUNT];
        for (int i = 0; i < Subscriber.MAX_ENTRY_NAME_AMOUNT; i++) {
            getName(i);
            str[i] = resultAfterCheck.toString();
        }
        noteBook.addSubscriber(new Subscriber(str));
    }

    private void choiceLanguage() {
        choiceLanguageStage = true;
        while (!checkScannerLine(getScannerLine(0)));
        if (resultAfterCheck.toString().equals(View.CHOICE_EN)) {
            view.setRegion(View.ENGLAND);
            currentRegex.replace(0, View.NAME_REGEX_UA.length(),
                                 View.NAME_REGEX_EN);
        } else {
            view.setRegion(View.UKRAINE);
            currentRegex.replace(0, View.NAME_REGEX_UA.length(),
                                 View.NAME_REGEX_UA);
        }
        choiceLanguageStage = false;
    }

    private void getName(int counter) {
        while (!checkScannerLine(getScannerLine(counter)));
    }

    private String getScannerLine(int counter) {
        if (choiceLanguageStage) {
            view.printMessage(View.PROMPT_MESSAGE
                    + View.CHOICE_EN  + " - english, "
                    + View.CHOICE_UA + " - ukrainian)"
                    + View.COLON_SIGN);
        } else {
            view.printBundleMessage(View.PROMPT_KEY);
            view.printBundleMessage(Subscriber.FIELD_NAME[counter]);
            view.printBundleMessage(View.COLON_SIGN_KEY);
        }
        return scanner.nextLine();
    }

    private boolean checkScannerLine(String str) {
        boolean res;
        if (choiceLanguageStage) {
            res = str.matches(View.CHOICE_LOCAL_REGEX);
            resultAfterCheck.replace(0, Model.MAX_ENTRY_NAME_LENGTH, str);
            if (!res) {
                view.printMessage(View.NOT_OK_MESSAGE + View.NEW_LINE_SIGN);
            }
        } else {
            res = str.matches(currentRegex.toString()) && (str.length()
                              < Model.MAX_ENTRY_NAME_LENGTH);
            resultAfterCheck.replace(0, Model.MAX_ENTRY_NAME_LENGTH, str);
            if (!res) {
                view.printBundleMessage(View.NOT_OK_MESSAGE_KEY);
                view.printMessage(String.valueOf(View.NEW_LINE_SIGN));
            }
        }
        return res;
    }

}
