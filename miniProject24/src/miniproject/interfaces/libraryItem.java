package miniproject.interfaces;

public interface libraryItem {
    void loan();

    void returnItem();

    boolean isLoaned();

    String toDisplayString();
}
