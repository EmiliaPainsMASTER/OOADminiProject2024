package Vars;

import Books.Book;
import Books.bookLoaned;

import java.io.*;

public class Storage {
    static String filename = "src/Vars/books.txt";

    public static Book[] loadBooks() {
        Book[] booksArray = null;
        try {
            // Variable declarations
            FileReader fileReader = new FileReader(filename);
            BufferedReader bookReader = new BufferedReader(fileReader);
            int lines = 0;

            // Counting lines in the file
            while (bookReader.readLine() != null) {
                lines++;
            }

            // Filling the array
            booksArray = new Book[lines];

            // Resetting file readers
            fileReader.close();
            fileReader = new FileReader(filename);
            bookReader = new BufferedReader(fileReader);

            // Reading lines and populating books array
            for (int count = 0; count < lines; count++) {
                String line = bookReader.readLine();
                String[] parts = line.split(", ");
                String bookName = parts[0];
                String author = parts[1];
                int dateReleased = Integer.parseInt(parts[2].trim());
                String isbn = parts[3];
                bookLoaned loaned = bookLoaned.valueOf(parts[4].trim());

                booksArray[count] = new Book(bookName, author, dateReleased, isbn, loaned);
            }

            // Closing file readers
            bookReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return booksArray;
    }

    public static void saveBooks(Book[] bookArray, int userIndex, boolean isReturningBook) {
        // Check if the index is within bounds
        if (userIndex >= 0 && userIndex < bookArray.length) {
            if (isReturningBook) {
                bookArray[userIndex].setLoaned(bookLoaned.Available);
            } else {
                bookArray[userIndex].setLoaned(bookLoaned.Loaned);
            }

            try {
                FileWriter bookFWriter = new FileWriter(filename);
                PrintWriter bookPWriter = new PrintWriter(bookFWriter);

                for (Book book : bookArray) {
                    bookPWriter.println(book.toDisplayString());
                }

                // Closing the writer
                bookPWriter.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            System.out.println("Invalid index. Please select a valid book index.");
        }
    }
}
