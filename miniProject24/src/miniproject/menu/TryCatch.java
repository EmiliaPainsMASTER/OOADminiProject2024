package miniproject.menu;

import miniproject.exceptions.InvalidInputException;
import miniproject.interfaces.LibraryItem;

import static miniproject.menu.LibraryUser.userInput;

public class TryCatch {
    public static String mainMenuChoice() {
        String inputChoice;
        while (true) {
            try {
                System.out.print("Please enter any of these words (LOAN)(RETURN)(EXIT) to use the program: ");
                if (!userInput.hasNextLine()) {
                    System.out.println();
                    throw new InvalidInputException("Invalid input! Please enter an String! (Loan/Return/Exit)");
                }
                inputChoice = userInput.nextLine();
                break;
            } catch (InvalidInputException e) {
                System.out.println(e.getMessage());
                userInput.next();
            }
        }
        System.out.println();
        return inputChoice;
    }

    public static int subMenuChoice(LibraryItem[] items) {
        int indexChoice;
        while (true) {
            try {
                System.out.print("Which item would you like to loan out? Alternatively, you can enter 0 to leave the submenu. (Use index 1 to " + items.length + "): ");
                if (!userInput.hasNextInt()) {
                    throw new InvalidInputException("Invalid input! Please enter an integer! (Use index 1 to " + items.length + ")");
                }
                indexChoice = userInput.nextInt();
                break;
            } catch (InvalidInputException e) {
                System.out.println(e.getMessage());
                userInput.next();
            }
        }
        //return the indexChoice as a index that can be used in the Array (where 1 becomes 0)
        return indexChoice - 1;
    }

}
