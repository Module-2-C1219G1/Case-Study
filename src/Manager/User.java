package Manager;

import BookInfo.Book;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class User {
    private int userCode;
    private String name;
    private String phoneNumber;
    private HashMap<Integer, Book> cart;
    private boolean isUser = false;

    public User() {
        this.isUser = true;
    }

    public User(int userCode, String name, String phoneNumber) {
        this.userCode = userCode;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.isUser = true;
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

    public boolean isHasUser() {
        return isUser;
    }

    public String getCartList() {

        int count = 1;
        String myCart = " ---------------------\nlist book use take: ";
        Set<Map.Entry<Integer, Book>> setOfEntries = cart.entrySet();
        for (Map.Entry<Integer, Book> entry : setOfEntries) {
            Book value = entry.getValue();
            myCart = count + ". " + value.getNameBook() + "\n";
        }
        return myCart;
    }

    @Override
    public String toString() {
        return
                "User Code : " + userCode + '\n' +
                        "Name " + name + '\n' +
                        "Phone Number: " + phoneNumber + '\n' + getCartList();
    }
}
