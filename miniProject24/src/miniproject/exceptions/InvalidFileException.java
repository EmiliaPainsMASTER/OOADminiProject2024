package miniproject.exceptions;

import java.io.IOException;

public class InvalidFileException extends Exception {
    public InvalidFileException(String message, IOException e) {
        super(message, e);
    }
}
