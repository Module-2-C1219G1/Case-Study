import BookInfo.Book;
import BookInfo.Category;
import BookInfo.Publisher;
import Manager.LibraryManager;
import Manager.User;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        LibraryManager libraryManager = new LibraryManager();
        Category kinh_di = new Category("kinh di",1);
        Publisher kim_dong = new Publisher("kim dong",1);
        User user = new User(1,"theanh","18001508");
        Book book = new Book(kinh_di,"conan","chiu",10000,1,kim_dong,1998);
        Category haihuoc = new Category("kinh di",2);
        Publisher tuoitre = new Publisher("kim dong",2);
        User user1 = new User(2,"theanh","18001508");
        Book book1 = new Book(haihuoc,"shin","chiu",10000,2 ,kim_dong,1998);
        libraryManager.addBook(book);
        libraryManager.addBook(book1);
        System.out.println(libraryManager.searchBook(1, libraryManager.library));
        System.out.println( libraryManager.displayCategoryList());
        System.out.println(libraryManager.displayLibraries());
        libraryManager.displayActiveLog();
    }
}
