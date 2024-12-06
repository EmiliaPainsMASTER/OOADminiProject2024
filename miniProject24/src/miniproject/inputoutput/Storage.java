package miniproject.inputoutput;

import miniproject.books.Book;
import miniproject.books.BookLoaned;
import miniproject.exceptions.InvalidFileException;

import java.io.*;

public class Storage {
    public static String filename = "books.txt";

    // loading from file and splitting the line into parts, bookName, author, dateReleased etc.
    public static Book[] loadBooks() throws InvalidFileException {
        Book[] booksArray;
        int lines = countLines();
        try(FileReader fileReader = new FileReader(filename); BufferedReader bookReader = new BufferedReader(fileReader)){
        // Initialize the array with the correct size
            booksArray = new Book[lines];
            for (int count = 0; count < lines; count++) {
                String line = bookReader.readLine();
                String[] parts = line.split(", ");
                String bookName = parts[0];
                String author = parts[1];
                int dateReleased = Integer.parseInt(parts[2].trim());
                String isbn = parts[3];
                BookLoaned loaned = BookLoaned.valueOf(parts[4].trim());
                booksArray[count] = new Book(bookName, author, dateReleased, isbn, loaned);
            }
        } catch (IOException e) {
            throw new InvalidFileException("Error reading the book file: " + filename, e);
        }
        return booksArray;
    }
    // save bookArray to file
    public static void saveBooks(Book[] bookArray, int userIndex, boolean isReturningBook) throws InvalidFileException {
        // Check if the index is within bounds
        if (isReturningBook) {
            bookArray[userIndex].setLoaned(BookLoaned.AVAILABLE);
        } else {
            bookArray[userIndex].setLoaned(BookLoaned.LOANED);
        }

        try(FileWriter bookFWriter = new FileWriter(filename); PrintWriter bookPWriter = new PrintWriter(bookFWriter)) {

            // saves each object of the bookArray to a line by line document in it's original format
            for (int count = 0 ; count < bookArray.length; count++) {
                bookPWriter.println(bookArray[count].toFileString());
            }
        } catch (IOException e) {
            throw new InvalidFileException("Error reading the book file: " + filename, e);
        }
    }
    // method to count the amount of lines, as we possibly couldn't know how many books there are
    public static int countLines() throws InvalidFileException {
        int lines = 0;
        try(FileReader fileReader = new FileReader(filename); BufferedReader bookReader = new BufferedReader(fileReader)) {
            // Counting lines in the file
            while (bookReader.readLine() != null) {
                lines++;
            }
        } catch (IOException e) {
            throw new InvalidFileException("Error reading the book file: " + filename, e);
        }
        return lines;
    }
}
