package miniproject.interfaces;

public interface LibraryItem {
    void loan();

    void returnItem();

    boolean isLoaned();

    String toDisplayString();
}
