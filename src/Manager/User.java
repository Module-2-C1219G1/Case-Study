package Manager;

import BookInfo.Book;

import java.io.Serializable;
import java.util.ArrayList;

public class User implements Serializable {
    private String name;
    private String phoneNumber;
    private String userID;
    private ArrayList<Book> cart;

    public User() {
    }

    public User(String name, String phoneNumber, String userID) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.userID = userID;
        this.cart = new ArrayList<>();
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public void giveBookBack(Book book) {
        cart.remove(book);
    }

    public void takeBook(Book book) {
        cart.add(book);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public ArrayList<Book> getCart() {
        return cart;
    }

    public void setCart(ArrayList<Book> cart) {
        this.cart = cart;
    }

    public String getCartList() {
        int count = 1;
        StringBuilder myCart = new StringBuilder(" ---------------------\nlist book use take: ");
        for (Book book : cart) {
            myCart = new StringBuilder(count + ". " + myCart + book.toString() + "\n");
        }

        return myCart.toString();
    }

    @Override
    public String toString() {
        return
                "Name " + getName() + '\n' +
                        "Phone Number: " + phoneNumber + '\n' + getCartList()+'\n'+
                "ID user: "+getUserID();
    }
}
