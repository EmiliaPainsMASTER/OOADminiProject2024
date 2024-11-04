package Vars;

import Books.Book;
import Books.bookLoaned;

import java.io.*;

public class Storage {
    static String filename = "src/Vars/books.txt";

    public static Book[] loadBooks() {
        Book[] booksArray = null;
        try {
            //variable declares
            FileReader fileReader = new FileReader(filename);
            BufferedReader bookReader = new BufferedReader(fileReader);
            int lines = 0;
            //counting the lines in file
            while (bookReader.readLine() != null) {
                lines++;
            }
            //filling the array
            booksArray = new Book[lines];
            // resetting variables
            fileReader.close();
            fileReader = new FileReader(filename);
            bookReader = new BufferedReader(fileReader);
            //for loop that goes line by line and splits the line by ,
            for (int count = 0; count < lines; count++) {
                String line = bookReader.readLine();
                String[] parts = line.split(", ");
                String bookName = parts[0];
                String author = parts[1];
                int dateReleased = Integer.parseInt(parts[2]);
                String isbn = parts[3];
                bookLoaned loaned = bookLoaned.valueOf(parts[4]);
                //
                booksArray[count] = new Book(bookName, author, dateReleased, isbn, loaned);

            }
            //closes fire reading
            fileReader.close();
            bookReader.close();
            //error catching
        } catch (IOException e) {
            e.printStackTrace();
        }
        return booksArray;
    }

    public static void saveBooks(Book[] bookArray, int index, boolean isReturningBook) {
        //overwrites by index using lines to Loaned/Available
        if (isReturningBook) {
            bookArray[index].setLoaned(bookLoaned.Available);
        } else {
            bookArray[index].setLoaned(bookLoaned.Loaned);
        }

        try {
            FileWriter bookFWriter = new FileWriter(filename);
            PrintWriter bookPWriter = new PrintWriter(bookFWriter);
            for (Book book : bookArray) {// start for loop
                bookPWriter.println(book.toFileString());
            } // end for loop
            // closes the file
            bookPWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

