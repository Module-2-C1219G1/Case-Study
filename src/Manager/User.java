package Manager;

import BookInfo.Book;

import java.util.HashMap;

public class User {
    private int userCode;
    private String name;
    private String phoneNumber;
    private HashMap<Integer, Book> cart;

    public User() {
    }

    public User(int userCode, String name, String phoneNumber) {
        this.userCode = userCode;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.cart = new HashMap<>();
    }

    public int getUserCode() {
        return userCode;
    }

    public void setUserCode(int id) {
        this.userCode = id;
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

    public HashMap<Integer, Book> getCart() {
        return cart;
    }

    public void setCart(HashMap<Integer, Book> cart) {
        this.cart = cart;
    }
}
