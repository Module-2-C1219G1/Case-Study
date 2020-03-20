package BookInfo;

import java.io.Serializable;

public class Publisher implements Serializable {
    private String name;
    private String phoneNumber;
    private String address;


    public Publisher() {
    }

    public Publisher(String name, String phoneNumber, String address) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    @Override
    public String toString() {
        return
                "Name: " + this.getName() + '\n' +
                        "Phone Number: " + this.getPhoneNumber() + '\n' +
                        "Name: " + this.getAddress() ;

    }
}
