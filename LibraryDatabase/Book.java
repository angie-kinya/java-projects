package LibraryDatabase;

public class Book {
    private int serialNumber;
    private String title;
    private String author;
    private boolean available;

    //constructor
    public Book(int serialNumber, String title, String author) {
        this.serialNumber = serialNumber;
        this.title = title;
        this.author = author;
        this.available = false;
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(int serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean available() {
        return available;
    }

    public void setAvailable(boolean isAvailable) {
        this.available = isAvailable;
    }

    @Override
    public String toString() {
        return "Serial Number: " + serialNumber + ", Title: " + title + ", Author: " + author + ", Available: " + !available;
    }
}
