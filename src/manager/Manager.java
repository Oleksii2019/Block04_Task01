package manager;

import view.*;
import java.util.Scanner;
import java.util.regex.*;

public class Manager {
    View view;
    Scanner scanner;

    public Manager(View view) {
        scanner = new Scanner(System.in);
        this.view = view;
    }

    private void stopScanner() {
        scanner.close();
    }

    public void getName() {
        view.printMessage(view.INPUT_DATA);
        String regex = "^[0-9]+[^5]+$";
        String Name = scanner.nextLine();
        if (Name.matches(regex)) {
            view.printMessage(view.OK_MESSAGE);
        }
        else
            view.printMessage(view.NOT_OK_MESSAGE);
        stopScanner();
    }



}
