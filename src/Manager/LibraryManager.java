package Manager;

import BookInfo.*;
import Log.ActivityLog;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class LibraryManager {
    public ActivityLog activityLog = new ActivityLog();
    public static int countBook = 0;
    public static int countUser = 0;
    public HashMap<Integer, Book> library;
    public HashMap<Integer, Publisher> publisherList;
    public HashMap<Integer, User> userList;
    public HashMap<Integer, Author> authorList;

    public LibraryManager() throws IOException {
        library = new HashMap<>();
        publisherList = new HashMap<>();
        userList = new HashMap<>();
        authorList = new HashMap<>();
    }
//-------------------------------------------------------------------------------------------------
    // search Book
    public int searchBook(String bookName, HashMap<Integer, Book> library) {
        Integer flag = -1;
        Set<Map.Entry<Integer, Book>> setOfEntries = library.entrySet();
        for (Map.Entry<Integer, Book> entry : setOfEntries) {
            Book value = entry.getValue();
            if (value.getNameBook().equals(bookName)) {
                flag = entry.getKey();
                break;
            }
        }
        return flag;
    }

    public int searchBook(int bookCode, HashMap<Integer, Book> library) {
        Integer flag = -1;
        Set<Map.Entry<Integer, Book>> setOfEntries = library.entrySet();
        for (Map.Entry<Integer, Book> entry : setOfEntries) {
            Book value = entry.getValue();
            if (value.getBookCode() == bookCode) {
                flag = entry.getKey();
                break;
            }
        }
        return flag;
    }

    //search publisher
    public int searchPublisher(String publisherName, HashMap<Integer, Publisher> publisherList) {
        Integer flag = -1;
        Set<Map.Entry<Integer, Publisher>> setOfEntries = publisherList.entrySet();
        for (Map.Entry<Integer, Publisher> entry : setOfEntries) {
            Publisher value = entry.getValue();
            if (value.getName().equals(publisherName)) {
                flag = entry.getKey();
                break;
            }
        }
        return flag;
    }

    public int searchPublisher(int publisherCode, HashMap<Integer, Publisher> publisherList) {
        Integer flag = -1;
        Set<Map.Entry<Integer, Publisher>> setOfEntries = publisherList.entrySet();
        for (Map.Entry<Integer, Publisher> entry : setOfEntries) {
            Publisher value = entry.getValue();
            if (value.getPublisherCode() == publisherCode) {
                flag = entry.getKey();
                break;
            }
        }
        return flag;
    }

    // search user
    public int searchUser(String userName, HashMap<Integer, User> userList) {
        Integer flag = -1;
        Set<Map.Entry<Integer, User>> setOfEntries = userList.entrySet();
        for (Map.Entry<Integer, User> entry : setOfEntries) {
            User value = entry.getValue();
            if (value.getName().equals(userName)) {
                flag = entry.getKey();
                break;
            }
        }
        return flag;
    }

    public int searchUser(int userCode, HashMap<Integer, User> userList) {
        Integer flag = -1;
        Set<Map.Entry<Integer, User>> setOfEntries = userList.entrySet();
        for (Map.Entry<Integer, User> entry : setOfEntries) {
            User value = entry.getValue();
            if (value.getUserCode() == userCode) {
                flag = entry.getKey();
                break;
            }
        }
        return flag;
    }

    // search author
    public int searchAuthor(String authorName, HashMap<Integer, Author> userList) {
        Integer flag = -1;
        Set<Map.Entry<Integer, Author>> setOfEntries = authorList.entrySet();
        for (Map.Entry<Integer, Author> entry : setOfEntries) {
            Author value = entry.getValue();
            if (value.getName().equals(authorName)) {
                flag = entry.getKey();
                break;
            }
        }
        return flag;
    }

    public int searchAuthor(int authorCode, HashMap<Integer, Author> userList) {
        Integer flag = -1;
        Set<Map.Entry<Integer, Author>> setOfEntries = authorList.entrySet();
        for (Map.Entry<Integer, Author> entry : setOfEntries) {
            Author value = entry.getValue();
            if (value.getAuthorCode() == authorCode) {
                flag = entry.getKey();
                break;
            }
        }
        return flag;
    }
    //------------------------------------------------------------------------------------------------

    // add book
    public void addBook(Book book) throws IOException {
        if (!book.isBook()) {
            System.out.println("Book doesn't exist");
        }
        library.put(book.getBookCode(), book);
        countBook++;
        activityLog.WriteActivityLog(book,"add");
    }
    //------------------------------------------------------------------------------------------------

    //delete with name
    public void deleteBookWithName(String book) throws IOException {
        int findBook = searchBook(book, library);

        if (findBook == -1) {
            System.out.println("Book doesn't exist");
        }
        activityLog.WriteActivityLog(library.get(findBook),"remove");
        library.remove(findBook);
        countBook--;

    }

    //delete book with book code
    public void deleteBookWithCode(int bookCode) throws IOException {
        int findBook = searchBook(bookCode, library);
        if (findBook == -1) {
            System.out.println("Book doesn't exist");
        }
        activityLog.WriteActivityLog(library.get(findBook),"remove");
        library.remove(findBook);
        countBook--;
    }
    //------------------------------------------------------------------------------------------------------

    // change name Book
    //with name
    public void changeNameBook(String nameBook,String nameChange) throws IOException {
        int findBook = searchBook(nameBook, library);

        if (findBook == -1) {
            System.out.println("Book doesn't exist");
        }
        activityLog.WriteActivityLog(library.get(findBook),"Change");
        library.get(findBook).setNameBook(nameBook);
    }
    //with codeBook
    public void changeNameBook(int codeBook,String nameChange) throws IOException {
        int findBook = searchBook(codeBook, library);

        if (findBook == -1) {
            System.out.println("Book doesn't exist");
            activityLog.WriteActivityLog(library.get(findBook),"Change");
        }
        library.get(findBook).setNameBook(nameChange);
    }
    //-------------------------------------------------------------------------------------------------------------
    // change codeBook
    //with name
    public void changeBookCode(String nameBook,int codeChange) throws IOException {
        int findBook = searchBook(nameBook, library);

        if (findBook == -1) {
            System.out.println("Book doesn't exist");
            activityLog.WriteActivityLog(library.get(findBook),"Change");
        }
        library.get(findBook).setBookCode(codeChange);
    }
    //with codeBook
    public void changeBookCode(int codeBook,int codeChange) throws IOException {
        int findBook = searchBook(codeBook, library);

        if (findBook == -1) {
            System.out.println("Book doesn't exist");
            activityLog.WriteActivityLog(library.get(findBook),"Change");
        }
        library.get(findBook).setBookCode(codeChange);
    }
    //----------------------------------------------------------------------------------------------------------------
    //change category
    //with name
    public void changeCategory(String nameBook,String categoryChange) throws IOException {
        int findBook = searchBook(nameBook, library);

        if (findBook == -1) {
            System.out.println("Book doesn't exist");
            activityLog.WriteActivityLog(library.get(findBook),"Change");
        }
        library.get(findBook).setCategory(categoryChange);
    }
    //with codeBook
    public void changeBookCode(int codeBook,String categoryChange) throws IOException {
        int findBook = searchBook(codeBook, library);

        if (findBook == -1) {
            System.out.println("Book doesn't exist");
            activityLog.WriteActivityLog(library.get(findBook),"Change");
        }
        library.get(findBook).setCategory(categoryChange);
    }
    //----------------------------------------------------------------------------------------------------------------
    //change Author
    //with name
    public void changeAuthor(String nameBook,Author authorChange) throws IOException {

        int findBook = searchBook(nameBook, library);
        int findAuthor = searchAuthor(authorChange.getName(),authorList);
        if (findBook == -1) {
            System.out.println("Book doesn't exist");
            activityLog.WriteActivityLog(library.get(findBook),"Change");
        }
        if (findAuthor == -1){
            System.out.println("Author doesn't exist");
        }
        library.get(findBook).setAuthor(authorChange);
    }
    //with codeBook
    public void changeAuthor(int codeBook,Author authorChange) throws IOException {

        int findBook = searchBook(codeBook, library);
        int findAuthor = searchAuthor(authorChange.getName(),authorList);
        if (findBook == -1) {
            System.out.println("Book doesn't exist");
            activityLog.WriteActivityLog(library.get(findBook),"Change");
        }
        if (findAuthor == -1){
            System.out.println("Author doesn't exist");
        }
        library.get(findBook).setAuthor(authorChange);
    }
    //----------------------------------------------------------------------------------------------------------------
    //change category
    //with name
    public void changePrice(String nameBook,double priceChange) throws IOException {
        int findBook = searchBook(nameBook, library);

        if (findBook == -1) {
            System.out.println("Book doesn't exist");
            activityLog.WriteActivityLog(library.get(findBook),"Change");
        }
        library.get(findBook).setPrice(priceChange);
    }
    //with codeBook
    public void changePrice(int codeBook,double priceChange) throws IOException {
        int findBook = searchBook(codeBook, library);

        if (findBook == -1) {
            System.out.println("Book doesn't exist");
            activityLog.WriteActivityLog(library.get(findBook),"Change");
        }
        library.get(findBook).setPrice(priceChange);
    }
    //----------------------------------------------------------------------------------------------------------------
    //change Publisher
    //with name
    public void changePublisher(String nameBook,Publisher publisherChange) throws IOException {

        int findBook = searchBook(nameBook, library);
        int findPublisher = searchPublisher(publisherChange.getName(),publisherList);
        if (findBook == -1) {
            System.out.println("Book doesn't exist");
            activityLog.WriteActivityLog(library.get(findBook),"Change");
        }
        if (findPublisher== -1){
            System.out.println("Publisher doesn't exist");
        }
        library.get(findBook).setPublisher(publisherChange);
    }
    //with codeBook
    public void changePublisher(int codeBook,Publisher publisherChange) throws IOException {

        int findBook = searchBook(codeBook, library);
        int findPublisher = searchPublisher(publisherChange.getName(),publisherList);
        if (findBook == -1) {
            System.out.println("Book doesn't exist");
            activityLog.WriteActivityLog(library.get(findBook),"Change");
        }
        if (findPublisher== -1){
            System.out.println("Publisher doesn't exist");
        }
        library.get(findBook).setPublisher(publisherChange);
    }
    //----------------------------------------------------------------------------------------------------------------
    //change year of publication
    //with name
    public void changeYearOfPublication(String nameBook,int yearChange) throws IOException {
        int findBook = searchBook(nameBook, library);
        if (findBook == -1) {
            System.out.println("Book doesn't exist");
            activityLog.WriteActivityLog(library.get(findBook),"Change");
        }
        library.get(findBook).setYearOfPublication(yearChange);
    }
    //with codeBook
    public void changeYearOfPublication(int codeBook,int yearChange) throws IOException {
        int findBook = searchBook(codeBook, library);

        if (findBook == -1) {
            System.out.println("Book doesn't exist");
            activityLog.WriteActivityLog(library.get(findBook),"Change");
        }
        library.get(findBook).setYearOfPublication(yearChange);
    }





}
