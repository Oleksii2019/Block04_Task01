/*
 * Copyright (c)
 */

package manager;

import view.View;
import java.util.Scanner;

/**
 * Class created for a training
 * @version v.1.1 08 Jun 2019
 * @author Aleksey Muratov
 */
public class ScannerController {
    private Scanner scanner;
    private View view;
    private StringBuffer prompt, wrongMessage, regex, result;
    private int bound;


    /**
     * Class constructor.
     */
    public ScannerController(Scanner scanner, View view) {
        this.scanner = scanner;
        this.view = view;
        prompt = new StringBuffer();
        wrongMessage = new StringBuffer();
        regex = new StringBuffer();
        result = new StringBuffer();
    }

    /**
     * Метод инициализирует данные для интерфейся ввода-вывода и
     * вызывает метод получения строки с устройства ввода
     * @param prompt строка приглашения интерфейса
     * @param wrongMessage сообщение для случая ошибочного ввода данных
     * @param regex регулярное выражение с условиями для вводимых данных
     * @param bound ограничение числа вводимых символов
     * @return String введенная строка, удовлетворяющая заданым условиям
     */
    public String getFromScanner(String prompt, String wrongMessage,
                                 String regex, int bound) {
        this.prompt.delete(0, this.prompt.length());
        this.prompt.append(prompt);
        this.wrongMessage.delete(0, this.wrongMessage.length());
        this.wrongMessage.append(wrongMessage);
        this.regex.delete(0, this.regex.length());
        this.regex.append(regex);
        this.bound = bound;
        while (!checkScannerLine(getScannerLine()));
        return result.toString();
    }

    /**
     * Метод выводит пригласительное сообщение и принимает
     * строку с устройства ввода
     * @return String введенная строка
     */
    private String getScannerLine() {
        view.printMessage(prompt.toString());
        return scanner.nextLine();
    }

    /**
     * Метод осуществляет проверку выполнения заданных условий для
     * строки
     * @param str строка для проверки
     * @return boolean результат проверки
     */
    private boolean checkScannerLine(String str) {
        boolean check = str.matches(regex.toString())
                                    && (str.length() <= bound);
        result.replace(0, result.length(), str);
        if (!check) {
            view.printMessage(wrongMessage.toString());
        }
        return check;
    }

}
