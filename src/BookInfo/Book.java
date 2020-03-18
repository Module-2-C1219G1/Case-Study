package BookInfo;

public class Book {

    private String category;
    private String nameBook;
    private Author author;
    private double price;
    private int bookCode;
    private Publisher publisher;
    private int yearOfPublication;
    private boolean bookStatus = false;

    public Book() {
    }

    public Book(String category, String nameBook, Author author, double price, int bookCode, Publisher publisher, int yearOfPublication, boolean bookStatus) {
        this.category = category;
        this.nameBook = nameBook;
        this.author = author;
        this.price = price;
        this.bookCode = bookCode;
        this.publisher = publisher;
        this.yearOfPublication = yearOfPublication;
        this.bookStatus = true;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getNameBook() {
        return nameBook;
    }

    public void setNameBook(String nameBook) {
        this.nameBook = nameBook;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getBookCode() {
        return bookCode;
    }

    public void setBookCode(int bookCode) {
        this.bookCode = bookCode;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public int getYearOfPublication() {
        return yearOfPublication;
    }

    public void setYearOfPublication(int yearOfPublication) {
        this.yearOfPublication = yearOfPublication;
    }

    public boolean isBook() {
        return bookStatus;
    }

    public void setBookStatus(boolean bookStatus) {
        this.bookStatus = bookStatus;
    }
}
