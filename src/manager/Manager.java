package manager;

import java.util.Scanner;

public class Manager {
    Scanner scanner;

    Manager() {
        scanner = new Scanner();

    }

    private void stopScanner() {
        scanner.close();
    }


}
