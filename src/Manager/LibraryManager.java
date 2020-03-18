package Manager;

import BookInfo.*;
import Log.ActivityLog;

import java.io.*;
import java.util.*;

public class LibraryManager {
    public ActivityLog activityLog = new ActivityLog();
    public static int countBook = 0;
    public static int countUser = 0;
    public static int countPublisher = 0;
    public static int countCategory = 0;

    public HashMap<Integer, Book> library;
    public HashMap<Integer, Publisher> publisherList;
    public HashMap<Integer, User> userList;
    public HashMap<Integer, Category> categoryList;

    public LibraryManager() throws IOException {
        library = new HashMap<>();
        publisherList = new HashMap<>();
        userList = new HashMap<>();
        categoryList = new HashMap<>();
    }

    //-------------------------------------------------------------------------------------------------
    // search Book - done
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

    //-----------------------------------------------------------------------------------------------
    // search user - done
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

    //--------------------------------------------------------------------------------------------------------
    //search publisher - done
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

    //---------------------------------------------------------------------------------------------------
    //search Category - done
    //with name
    public int searchCategory(String categoryName, HashMap<Integer, Category> categoryList) {
        Integer flag = -1;
        Set<Map.Entry<Integer, Category>> setOfEntries = categoryList.entrySet();
        for (Map.Entry<Integer, Category> entry : setOfEntries) {
            Category value = entry.getValue();
            if (value.getName().equals(categoryName)) {
                flag = entry.getKey();
                break;
            }
        }
        return flag;
    }

    //with categoryCode
    public int searchCategory(int categoryCode, HashMap<Integer, Category> categoryList) {
        Integer flag = -1;
        Set<Map.Entry<Integer, Category>> setOfEntries = categoryList.entrySet();
        for (Map.Entry<Integer, Category> entry : setOfEntries) {
            Category value = entry.getValue();
            if (value.getCategoryCode() == categoryCode) {
                flag = entry.getKey();
                break;
            }
        }
        return flag;
    }
    //------------------------------------------------------------------------------------------------

    // add book - done
    public void addBook(Book book) throws IOException {
        if (!book.isBook()) {
            System.out.println("Book doesn't exist");
            return;
        }
        library.put(book.getBookCode(), book);
        countBook++;
        activityLog.WriteActivityLog(book, "add");
        System.out.println("add complete !");
    }

    //add user - done
    public void addUser(User user) throws IOException {
        if (!user.isHasUser()) {
            System.out.println("User doesn't exist");
            return;
        }
        userList.put(user.getUserCode(), user);
        countUser++;
        activityLog.WriteActivityLog(user, "add");
        System.out.println("add complete !");
    }

    // add publisher - done
    public void addPublisher(Publisher publisher) throws IOException {
        if (!publisher.isHasPublisher()) {
            System.out.println("Publisher doesn't exist");
            return;
        }
        publisherList.put(publisher.getPublisherCode(), publisher);
        countPublisher++;
        activityLog.WriteActivityLog(publisher, "add");
        System.out.println("add complete !");
    }

    //add Category - done
    public void addCategory(Category category) throws IOException {
        if (!category.isHasCategory()) {
            System.out.println("Category doesn't exist");
            return;
        }
        categoryList.put(category.getCategoryCode(), category);
        countCategory++;
        activityLog.WriteActivityLog(category, "add");
        System.out.println("add complete !");
    }

    //------------------------------------------------------------------------------------------------
    // delete category - done
    //with name
    public void deleteCategory(String categoryName) throws IOException {
        int findCategory = searchCategory(categoryName, categoryList);
        if (findCategory == -1) {
            System.out.println("Category doesn't exist");
            return;
        }
        activityLog.WriteActivityLog(categoryList.get(findCategory), "remove");
        categoryList.remove(findCategory);
        countCategory--;
        System.out.println("delete complete !");
    }

    //with code
    public void deleteCategory(int categoryCode) throws IOException {
        int findCategory = searchCategory(categoryCode, categoryList);

        if (findCategory == -1) {
            System.out.println("Category doesn't exist");
            return;
        }
        activityLog.WriteActivityLog(categoryList.get(findCategory), "remove");
        categoryList.remove(findCategory);
        countCategory--;
        System.out.println("delete complete !");
    }

    //----------------------------------------------------------------------------------------------------
    //delete book - done
    // with book name
    public void deleteBook(String book) throws IOException {
        int findBook = searchBook(book, library);

        if (findBook == -1) {
            System.out.println("Book doesn't exist");
            return;
        }
        activityLog.WriteActivityLog(library.get(findBook), "remove");
        library.remove(findBook);
        countBook--;
        System.out.println("delete complete !");
    }

    // with book code
    public void deleteBook(int bookCode) throws IOException {
        int findBook = searchBook(bookCode, library);
        if (findBook == -1) {
            System.out.println("Book doesn't exist");
            return;
        }
        activityLog.WriteActivityLog(library.get(findBook), "remove");
        library.remove(findBook);
        countBook--;
        System.out.println("delete complete !");
    }

    //------------------------------------------------------------------------------------------------------
    //delete User - done
    public void deleteUser(int userCode) throws IOException {
        int findUser = searchUser(userCode, userList);
        if (findUser == -1) {
            System.out.println("user doesn't exist");
            return;
        }
        activityLog.WriteActivityLog(userList.get(findUser), "remove");
        userList.remove(findUser);
        countUser--;
        System.out.println("delete complete !");
    }
    //------------------------------------------------------------------------------------------------------
    //delete publisher - done
    public void deletePublisher(int publisherCode) throws IOException {
        int findPublisher = searchPublisher(publisherCode, publisherList);
        if (findPublisher == -1) {
            System.out.println("user doesn't exist");
            return;
        }
        activityLog.WriteActivityLog(userList.get(findPublisher), "remove");
        userList.remove(findPublisher);
        countUser--;
        System.out.println("delete complete !");
    }

    //------------------------------------------------------------------------------------------------------------
    // change name Book - done
    //with name
    public void changeNameBook(String nameBook, String nameChange) throws IOException {
        int findBook = searchBook(nameBook, library);
        if (findBook == -1) {
            System.out.println("Book doesn't exist");
            return;
        }
        activityLog.WriteActivityLog(library.get(findBook), "Change");
        library.get(findBook).setNameBook(nameBook);
        System.out.println("change complete !");
    }
    //with codeBook
    public void changeNameBook(int codeBook, String nameChange) throws IOException {
        int findBook = searchBook(codeBook, library);

        if (findBook == -1) {
            System.out.println("Book doesn't exist");
            return;
        }
        activityLog.WriteActivityLog(library.get(findBook), "Change");
        library.get(findBook).setNameBook(nameChange);
        System.out.println("change complete !");
    }
    //-------------------------------------------------------------------------------------------------------------
    // change codeBook - done
    //with name
    public void changeBookCode(String nameBook, int codeChange) throws IOException {
        int findBook = searchBook(nameBook, library);
        if (findBook == -1) {
            System.out.println("Book doesn't exist");
            return;
        }
        activityLog.WriteActivityLog(library.get(findBook), "Change");
        library.get(findBook).setBookCode(codeChange);
        System.out.println("change complete !");
    }
    //with codeBook
    public void changeBookCode(int codeBook, int codeChange) throws IOException {
        int findBook = searchBook(codeBook, library);

        if (findBook == -1) {
            System.out.println("Book doesn't exist");
            return;
        }
        activityLog.WriteActivityLog(library.get(findBook), "Change");
        library.get(findBook).setBookCode(codeChange);
        System.out.println("change complete !");
    }

    //----------------------------------------------------------------------------------------------------------------
    //change name category - done
    //with name
    public void changeCategory(String nameCategory, String categoryChange) throws IOException {
        int findCategory = searchCategory(nameCategory, categoryList);

        if (findCategory == -1) {
            System.out.println("Book doesn't exist");
            return;

        }
        activityLog.WriteActivityLog(categoryList.get(findCategory), "Change");
        categoryList.get(findCategory).setName(categoryChange);
        System.out.println("change complete !");
    }

    //with codeBook
    public void changeCategory(int codeCategory, String categoryChange) throws IOException {
        int findCategory = searchCategory(codeCategory, categoryList);

        if (findCategory == -1) {
            System.out.println("Book doesn't exist");
            return;
        }
        activityLog.WriteActivityLog(categoryList.get(findCategory), "Change");
        categoryList.get(findCategory).setName(categoryChange);
        System.out.println("change complete");
    }
    //----------------------------------------------------------------------------------------------------------------
    //change price book - done
    //with name
    public void changePrice(String nameBook, double priceChange) throws IOException {
        int findBook = searchBook(nameBook, library);

        if (findBook == -1) {
            System.out.println("Book doesn't exist");
            return;

        }
        activityLog.WriteActivityLog(library.get(findBook), "Change");
        library.get(findBook).setPrice(priceChange);
        System.out.println("change complete !");
    }
    //with codeBook
    public void changePrice(int codeBook, double priceChange) throws IOException {
        int findBook = searchBook(codeBook, library);

        if (findBook == -1) {
            System.out.println("Book doesn't exist");

        }
        activityLog.WriteActivityLog(library.get(findBook), "Change");
        library.get(findBook).setPrice(priceChange);
        System.out.println("change complete");
    }

    //----------------------------------------------------------------------------------------------------------------
    //change Publisher - done
    //with name
    public void changePublisher(String namePublisher, String publisherChange) throws IOException {

        int findPublisher = searchPublisher(namePublisher, publisherList);
        if (findPublisher == -1) {
            System.out.println("Publisher doesn't exist");
            return;
        }
        publisherList.get(findPublisher).setName(publisherChange);
        activityLog.WriteActivityLog(publisherList.get(findPublisher), "Change");
        System.out.println("change complete !");
    }

    //with codeBook
    public void changePublisher(int codePublisher, String publisherChange) throws IOException {

        int findPublisher = searchPublisher(codePublisher, publisherList);
        if (findPublisher == -1) {
            System.out.println("Publisher doesn't exist");
            return;
        }
        publisherList.get(findPublisher).setName(publisherChange);
        activityLog.WriteActivityLog(publisherList.get(findPublisher), "Change");
        System.out.println("change complete !");
    }

    //----------------------------------------------------------------------------------------------------------------
    //change year of publication
    //with name
    public void changeYearOfPublication(String nameBook, int yearChange) throws IOException {
        int findBook = searchBook(nameBook, library);
        if (findBook == -1) {
            System.out.println("Book doesn't exist");
            return;

        }
        activityLog.WriteActivityLog(library.get(findBook), "Change");
        library.get(findBook).setYearOfPublication(yearChange);
        System.out.println("change complete !");
    }

    //with codeBook
    public void changeYearOfPublication(int codeBook, int yearChange) throws IOException {
        int findBook = searchBook(codeBook, library);

        if (findBook == -1) {
            System.out.println("Book doesn't exist");
            return;
        }
        activityLog.WriteActivityLog(library.get(findBook), "Change");
        library.get(findBook).setYearOfPublication(yearChange);
        System.out.println("change complete !");
    }
    //------------------------------------------------------------------------------------------
    //display libraries -- done
    public void displayLibraries() {
        int count = 1;
        Set<Map.Entry<Integer, Book>> setOfEntries = library.entrySet();
        for (Map.Entry<Integer, Book> entry : setOfEntries) {
               Book book = entry.getValue();
            System.out.println(count+". "+book.toString());
            count++;
        }
    }
    //display user -- done
    public void displayUserList() {
        int count = 1;
        Set<Map.Entry<Integer, User>> setOfEntries = userList.entrySet();
        for (Map.Entry<Integer, User> entry : setOfEntries) {
            User user = entry.getValue();
            System.out.println(count+". "+ user.toString());
            count++;
        }
    }
    //display category -- done
    public String displayCategoryList() {
        int count = 1;
        String myString = null;
        Set<Map.Entry<Integer, Category>> setOfEntries = categoryList.entrySet();
        for (Map.Entry<Integer, Category> entry : setOfEntries) {
            Category category = entry.getValue();
            myString = myString+"\n"+count+". "+ category.toString();
            count++;
        }
        return myString;
    }
    //display publisher -- done
    public void displayPublisherList() {
        int count = 1;
        Set<Map.Entry<Integer, Publisher>> setOfEntries = publisherList.entrySet();
        for (Map.Entry<Integer, Publisher> entry : setOfEntries) {
            Publisher publisher = entry.getValue();
            System.out.println(count+". "+ publisher.toString());
            count++;
        }
    }
    //-----------------------------------------------------------
    //display File log
    public void displayActiveLog() throws IOException {
        File file;
        BufferedReader bufferedReader = new BufferedReader(new FileReader(activityLog.fileActiveLog));
        String contentLine = bufferedReader.readLine();
        while ((contentLine = bufferedReader.readLine()) != null) {
            System.out.println(contentLine + "\n");
            contentLine = bufferedReader.readLine();
        }
    }

}
