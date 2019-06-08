package manager;

import view.View;
import java.util.Scanner;

public class ScanтerController {
    private Scanner scanner;
    private View view;
    private StringBuffer prompt, wrongMessage, regex, result;
    private int bound;


    public ScanтerController(Scanner scanner, View view) {
        this.scanner = scanner;
        this.view = view;
        prompt = new StringBuffer();
        wrongMessage = new StringBuffer();
        regex = new StringBuffer();
        result = new StringBuffer();
    }

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

    private String getScannerLine() {
        view.printMessage(prompt.toString());
        return scanner.nextLine();
    }

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
