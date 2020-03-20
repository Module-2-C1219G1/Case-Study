package BookInfo;

import java.io.Serializable;

public class Book implements Serializable {


    private String nameBook;
    private double price;
    private String author;
    private Category category;
    private Publisher publisher;
    private String yearOfPublication;
    private String bookId;

    public Book() {
    }

    public Book(String nameBook, double price, String author, Category category,  Publisher publisher, String yearOfPublication,String bookId) {
        this.nameBook = nameBook;
        this.price = price;
        this.author = author;
        this.category = category;
        this.publisher = publisher;
        this.yearOfPublication = yearOfPublication;
        this.bookId = bookId;
    }

    public String getNameBook() {
        return nameBook;
    }

    public void setNameBook(String nameBook) {
        this.nameBook = nameBook;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public String getYearOfPublication() {
        return yearOfPublication;
    }

    public void setYearOfPublication(String yearOfPublication) {
        this.yearOfPublication = yearOfPublication;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    @Override
    public String toString() {
        return "Name Book: " + getNameBook() + '\n' +
                "Price: " + getPrice() + '\n' +
                "Category: " + category.getName() + '\n' +
                "Author: " + author + '\n' +
                "Publisher: " + publisher.getName() + '\n' +
                "Year Of Publication: " + getYearOfPublication() + '\n' +
                "Book ID: " + getBookId()+ '\n' +
                "------------------------------";

    }
}
