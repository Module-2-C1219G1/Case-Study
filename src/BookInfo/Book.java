package BookInfo;

public class Book {

    private Category category;
    private String nameBook;
    private String author;
    private double price;
    private int bookCode;
    private Publisher publisher;
    private int yearOfPublication;
    private boolean bookStatus = false;

    public Book() {
    }

    public Book(Category category, String nameBook, String author, double price, int bookCode, Publisher publisher, int yearOfPublication) {
        this.category = category;
        this.nameBook = nameBook;
        this.author = author;
        this.price = price;
        this.bookCode = bookCode;
        this.publisher = publisher;
        this.yearOfPublication = yearOfPublication;
        this.bookStatus = true;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getNameBook() {
        return nameBook;
    }

    public void setNameBook(String nameBook) {
        this.nameBook = nameBook;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
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

    @Override
    public String toString() {
        return "Name Book: " + nameBook + '\n' +
                "Price: " + price + '\n' +
                "Category: " + category.getName() + '\n' +
                "Author: " + author + '\n' +
                "Publisher: " + publisher.getName() + '\n' +
                "Year Of Publication: " + yearOfPublication + '\n' +
                "Book Code:" + bookCode+'\n'+
                "------------------------------";

    }
}
