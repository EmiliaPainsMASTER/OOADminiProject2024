package Menu;

import Interface.libraryItem;

public class output {
    public static void printMenu() {
        System.out.printf("[1]\t%s%n", "Loan Items");
        System.out.printf("[2]\t%s%n", "Return Items");
        System.out.printf("[3]\t%s%n", "Exit");
    }

    public static void printVar(libraryItem[] items) {
        for (int i = 0; i < items.length; i++) {
            int count = i + 1;
            System.out.println("[" + count + "] " + items[i].toDisplayString());  // Ensure toDisplayString() is called here
        }
        System.out.println();
    }
}
