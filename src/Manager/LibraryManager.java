package Manager;

import BookInfo.*;
import Log.ActivityLog;
import StorageIO.LibraryIO;

import java.io.*;
import java.util.*;

public class LibraryManager implements Serializable {
    public ActivityLog activityLog = new ActivityLog();
    public LibraryIO libraryIO = new LibraryIO();
    public static int countBook = 0;
    public static int countUser = 0;
    public static int countPublisher = 0;
    public static int countCategory = 0;

    public ArrayList<Book> library;
    public ArrayList<Publisher> publisherList;
    public ArrayList<User> userList;
    public ArrayList<Category> categoryList;

    public LibraryManager() throws IOException, NotSerializableException {
        library = new ArrayList<>();
        publisherList = new ArrayList<>();
        userList = new ArrayList<>();
        categoryList = new ArrayList<>();
    }

    public int searchBook(String bookName, String bookId) {
        if (library.isEmpty()) {
            System.out.println("Library is empty!");
            return -1;
        }
        for (Book book : library) {
            boolean sameName = book.getNameBook().equals(bookName);
            boolean sameID = book.getNameBook().equals(bookId);
            if (sameName && sameID) {
                return library.indexOf(book);
            }
        }
        return -1;
    }

    //-----------------------------------------------------------------------------------------------
    // search user - done
    public int searchUser(String userName, String userID) {
        if (userList.isEmpty()) {
            System.out.println("User List is empty!");
            return -1;
        }
        for (User user : userList) {
            boolean sameID = user.getUserID().equals(userID);
            boolean sameName = user.getName().equals(userName);
            if (sameID && sameName) {
                return userList.indexOf(user);
            }
        }
        return -1;
    }

    //--------------------------------------------------------------------------------------------------------
    public int searchPublisher(String publisherName) {
        if (publisherList.isEmpty()) {
            System.out.println("Publisher List is empty!");
            return -1;
        }
        for (Publisher publisher : publisherList) {
            boolean hasBeenFind = publisher.getName().equals(publisherName);
            if (hasBeenFind) {
                return publisherList.indexOf(publisher);
            }
        }
        return -1;
    }

    //---------------------------------------------------------------------------------------------------
    //search Category - done
    public int searchCategory(String categoryName) {
        if (publisherList.isEmpty()) {
            System.out.println("Publisher List is empty!");
            return -1;
        }
        for (Category category : categoryList) {
            boolean hasBeenFind = category.getName().equals(categoryName);
            if (hasBeenFind) {
                return categoryList.indexOf(category);
            }
        }
        return -1;
    }

    //------------------------------------------------------------------------------------------------

    // add book - done

    public void addBook(String nameBook, double price, String author, Category category, Publisher publisher, String yearOfPublication, String bookId) throws IOException {

        Book book = new Book(nameBook, price, author, category, publisher, yearOfPublication, bookId);
        library.add(book);
        countBook++;
        activityLog.WriteActivityLog(book, "Add new book");
        System.out.println("add complete !");
    }

    //add user - done
    public void addUser(String name, String phoneNumber, String userID) throws IOException {
        User user = new User(name, phoneNumber, userID);
        userList.add(user);
        countUser++;
        activityLog.WriteActivityLog(user, "Add new user");
        System.out.println("add complete !");
    }

    // add publisher - done
    public void addPublisher(String name, String phoneNumber, String address) throws IOException {
        Publisher publisher = new Publisher(name, phoneNumber, address);
        publisherList.add(publisher);
        countPublisher++;
        activityLog.WriteActivityLog(publisher, "Add new Publisher");
        System.out.println("add complete !");
    }

    //add Category - done
    public void addCategory(String name) throws IOException {
        Category category = new Category(name);
        categoryList.add(category);
        countCategory++;
        activityLog.WriteActivityLog(category, "Add new Category");
        System.out.println("add complete !");
    }

    //----------------------------------------------------------------------------------------------------
    //delete book - done
    public void deleteBook(String nameBook, String bookId) throws IOException {

        if (searchBook(nameBook, bookId) == -1) {
            System.out.println("doesn't exist !");
            return;
        }
        int index = searchBook(nameBook, bookId);
        activityLog.WriteActivityLog(library.get(index), "remove book");
        countBook--;
        System.out.println("delete complete !");
    }

    //------------------------------------------------------------------------------------------------------
    //delete User - done
    public void deleteUser(String nameUser, String userId) throws IOException {

        if (searchUser(nameUser, userId) == -1) {
            System.out.println("doesn't exist !");
            return;
        }
        int index = searchUser(nameUser, userId);
        activityLog.WriteActivityLog(userList.get(index), "remove user");
        countUser--;
        System.out.println("delete complete !");
    }

    //delete publisher - done
    public void deleteBook(String namePublisher) throws IOException {

        if (searchPublisher(namePublisher) == -1) {
            System.out.println("doesn't exist !");
            return;
        }
        int index = searchPublisher(namePublisher);
        activityLog.WriteActivityLog(publisherList.get(index), "remove publisher");
        countPublisher--;
        System.out.println("delete complete !");
    }

    //delete Category - done
    public void deleteCategory(String nameCategory) throws IOException {

        if (searchCategory(nameCategory) == -1) {
            System.out.println("doesn't exist !");
            return;
        }
        int index = searchPublisher(nameCategory);
        activityLog.WriteActivityLog(categoryList.get(index), "remove publisher");
        countPublisher--;
        System.out.println("delete complete !");
    }

    //------------------------------------------------------------------------------------------------------------
    // change name Book - done

    public void changeNameBook(String name, String id, String nameChange) throws IOException {

        if (searchBook(name, id) == -1) {
            System.out.println("doesn't exist !");
            return;
        }
        int index = searchBook(name, id);
        activityLog.WriteActivityLog(library.get(index), "Change name book: " + nameChange);
        library.get(index).setNameBook(nameChange);
        System.out.println("change complete !");
    }
    //-------------------------------------------------------------------------------------------------------------
    // change idBook - done

    public void changeIdBook(String name, String id, String codeChange) throws IOException {

        if (searchBook(name, id) == -1) {
            System.out.println("doesn't exist !");
            return;
        }
        int index = searchBook(name, id);
        activityLog.WriteActivityLog(library.get(index), "Change ID book: " + codeChange);
        library.get(index).setBookId(codeChange);
        System.out.println("change complete !");
    }

    //----------------------------------------------------------------------------------------------------------------
    //change name category - done

    public void changeCategoryName(String name, String nameChange) throws IOException {
        if (searchCategory(name) == -1) {
            System.out.println("doesn't exist !");
            return;
        }
        int index = searchCategory(name);
        activityLog.WriteActivityLog(categoryList.get(index), "Change name book: " + nameChange);
        categoryList.get(index).setName(nameChange);
        System.out.println("change complete !");
    }

    //----------------------------------------------------------------------------------------------------------------
    //change price book - done
    //with name
    public void changePrice(String name, String id, double priceChange) throws IOException {

        if (searchBook(name, id) == -1) {
            System.out.println("doesn't exist !");
            return;
        }
        int index = searchBook(name, id);
        activityLog.WriteActivityLog(library.get(index), "Change name book: " + priceChange);
        library.get(index).setPrice(priceChange);
        System.out.println("change complete !");
    }
    //----------------------------------------------------------------------------------------------------------------
    //change Publisher name - done

    public void changePublisher(String name, String nameChange) throws IOException {

        if (searchPublisher(name) == -1) {
            System.out.println("doesn't exist !");
            return;
        }
        int index = searchPublisher(name);
        activityLog.WriteActivityLog(publisherList.get(index), "Change name Publisher: " + nameChange);
        publisherList.get(index).setName(name);
        System.out.println("change complete !");
    }

    //----------------------------------------------------------------------------------------------------------------
    //change author
    public void changeAuthor(String name, String id, String nameChange) throws IOException {

        if (searchBook(name, id) == -1) {
            System.out.println("doesn't exist !");
            return;
        }
        int index = searchBook(name, id);
        activityLog.WriteActivityLog(library.get(index), "Change name Author: " + nameChange);
        library.get(index).setAuthor(nameChange);
        System.out.println("change complete !");
    }

    //---------------------------------------------------------------------------------------------------------------------
    //change year of publication
    //with name
    public void changeYearOfPublication(String name, String id, String yearChange) throws IOException {

        if (searchBook(name, id) == -1) {
            System.out.println("doesn't exist !");
            return;
        }
        int index = searchBook(name, id);
        activityLog.WriteActivityLog(library.get(index), "Change year of Publication: " + yearChange);
        library.get(index).setYearOfPublication(yearChange);
        System.out.println("change complete !");
    }

    //------------------------------------------------------------------------------------------
    //display libraries
    public void displayLibraries() {
        int count = 1;
        StringBuilder myString = new StringBuilder();
        for (Book book : library) {
            myString.append("\n").append(count).append(book.toString());
        }
        System.out.println("----------Libraries-------------");
        System.out.println("Amount: " + countBook);
        System.out.println(myString.toString());
    }

    //display user -- done
    public void displayUserList() {

        int count = 1;
        StringBuilder myString = new StringBuilder();
        for (User user : userList) {
            myString.append("\n").append(count).append(user.toString());
        }
        System.out.println("----------User list-------------");
        System.out.println("Amount: " + countBook);
        System.out.println(myString.toString());
    }

    //display category -- done
    public void displayCategoryList() {
        int count = 1;
        StringBuilder myString = new StringBuilder();
        for (Category category : categoryList) {
            myString.append("\n").append(count).append(categoryList.toString());
        }
        System.out.println("----------Categories list-------------");
        System.out.println("Amount: " + countUser);
        System.out.println(myString.toString());
    }

    //display publisher -- done
    public void displayPublisherList() {
        int count = 1;
        StringBuilder myString = new StringBuilder();
        for (Publisher publisher : publisherList) {
            myString.append("\n").append(count).append(publisherList.toString());
        }
        System.out.println("----------Publisher list-------------");
        System.out.println("Amount: " + countPublisher);
        System.out.println(myString.toString());
    }

    //display File log -- done
    public void displayActiveLog() throws IOException {
        System.out.println("-----------Active Log:--------------");
        int count = 1;
        BufferedReader bufferedReader = new BufferedReader(new FileReader(activityLog.fileActiveLog));
        String contentLine = bufferedReader.readLine();
        while ((contentLine = bufferedReader.readLine()) != null) {
            System.out.println(count + ". " + contentLine + "\n");
            contentLine = bufferedReader.readLine();
            count++;
        }
    }

    //------------------------------------------------------------------------------------------------
    //write file - done
    public void writeToFile() throws IOException {
        libraryIO.writeBook(library);
        libraryIO.writeUser(userList);
        System.out.println("Has been write !");
    }

    //read file - done
    public void readFromStorage() throws IOException, ClassNotFoundException {

        library = libraryIO.readBook();
        userList = libraryIO.readUser();
        System.out.println("Has been read !");
    }

    //--------------------------------------------------------------------------------------------------
    //lendBook
    public void lendBookUser(String nameBook, String bookId, String userName, String userId) throws IOException {
        int searchBook = searchBook(nameBook, bookId);
        int searchUser = searchUser(userName, userId);
        if (searchBook == -1 || searchUser == -1) {
            System.out.println("Wrong name Book or User try again");
            return;
        }
        User user = userList.get(searchUser);
        Book book = library.get(searchBook);
        user.takeBook(book);
        library.remove(book);
        countBook--;
        activityLog.WriteActivityLog(book, "Lend book from user: " + user.getName() + ",code: " + user.getUserID());
    }

    //-----------------------------------------------------------------------------------------------------
    //givePack
    //with name
    public void giveBookBack(String nameBook, String bookId, String userName, String userId) throws IOException {
        int searchBook = searchBook(nameBook, bookId);
        int searchUser = searchUser(userName, userId);
        if (searchBook == -1 || searchUser == -1) {
            System.out.println("Wrong name Book or User try again");
            return;
        }
        User user = userList.get(searchUser);
        Book book = library.get(searchBook);
        user.giveBookBack(book);
        library.add(book);
        countBook++;
        activityLog.WriteActivityLog(book, "Lend book from user: " + user.getName() + ",code: " + user.getUserID());
    }

    public void changeUser(String userName, String userId, String newUser) {

    }
}
