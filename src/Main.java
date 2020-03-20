
import BookInfo.Category;
import BookInfo.Publisher;
import Manager.LibraryManager;

import java.util.Scanner;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        LibraryManager libraryManager = new LibraryManager();
        String choose;
        boolean exit = false;
        Scanner scanner = new Scanner(System.in);
        // show menu
        showMainMenu();
        while (true) {
            choose = scanner.nextLine();
            switch (choose) {
                case "1":
                    showSearchMenu(libraryManager);
                    break;
                case "2":
                    showDisplayMenu(libraryManager);
                    break;
                case "3":
                    showAddMenu(libraryManager);
                    break;
                case "4":
                    showDeleteMenu(libraryManager);
                    break;
                case "5":
                    changeInfoMenu(libraryManager);
                    break;
                case "6":
                    lenBook(libraryManager);
                    break;
                case "7":
                    giveBookBack(libraryManager);
                case "8":
                    readfromStogare(libraryManager);
                case "0":
                    System.out.println("exited!");
                    exit = true;
                    break;
                default:
                    System.out.println("invalid! please choose action in below menu:");
                    break;
            }
            if (exit) {
                libraryManager.writeToFile();
                break;
            }
            // show menu
            showMainMenu();
        }
    }

    private static void readfromStogare(LibraryManager libraryManager) throws IOException, ClassNotFoundException {
        libraryManager.readFromStorage();

    }

    private static void giveBookBack(LibraryManager libraryManager) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String nameBook, bookId, userName, userId;
        int searchBook;
        int searchUser;
        do {
            System.out.println("Enter the name of book: ");
            nameBook = scanner.nextLine();
            System.out.println("Enter the name of user: ");
            userName = scanner.nextLine();
            System.out.println("Enter the ID of book: ");
            bookId = scanner.nextLine();
            System.out.println("Enter the iD of user: ");
            userId = scanner.nextLine();

            libraryManager.giveBookBack(nameBook, bookId, userName, userId);

            searchBook = libraryManager.searchBook(nameBook, bookId);
            searchUser = libraryManager.searchUser(userName, userId);
            if (searchBook == -1 || searchUser == -1) {
                System.out.println("Please create new or enter another !");
            }
        } while (searchBook == -1 || searchUser == -1);
    }

    private static void lenBook(LibraryManager libraryManager) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String nameBook, bookId, userName, userId;
        int searchBook;
        int searchUser;
        do {
            System.out.println("Enter the name of book: ");
            nameBook = scanner.nextLine();
            System.out.println("Enter the name of user: ");
            userName = scanner.nextLine();
            System.out.println("Enter the ID of book: ");
            bookId = scanner.nextLine();
            System.out.println("Enter the iD of user: ");
            userId = scanner.nextLine();

            libraryManager.lendBookUser(nameBook, bookId, userName, userId);

            searchBook = libraryManager.searchBook(nameBook, bookId);
            searchUser = libraryManager.searchUser(userName, userId);
            if (searchBook == -1 || searchUser == -1) {
                System.out.println("Please create new or enter another !");
            }
        } while (searchBook == -1 || searchUser == -1);
    }

    private static void changeInfoMenu(LibraryManager libraryManager) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String choose;
        boolean exit = false;
        System.out.println("-----------search Menu------------");
        System.out.println("1. change name book");
        System.out.println("2. change price");
        System.out.println("3. change author");
        System.out.println("4. change publisher name");
        System.out.println("5 .change category name ");
        System.out.println("6 .change name user");
        System.out.println("7 .change phone user");
        System.out.println("0 .exit.");
        System.out.println("---------------------------");
        System.out.println("Enter Choose: ");
        String nameBook, userName, bookId, userId, newUser, newName, newAuthor, newPublisher, namePublisher, nameCategory, newCategory, newPhoneNumber;
        int searchBook = -1, searchUser = -1, searchPublisher = -1, searchCategory = -1;
        double newPrice;

        while (true) {
            choose = scanner.nextLine();
            switch (choose) {
                case "1":
                    //change name book
                    while (searchBook == -1) {
                        System.out.println("Enter the name of book: ");
                        nameBook = scanner.nextLine();
                        System.out.println("Enter the Id of book: ");
                        bookId = scanner.nextLine();
                        System.out.println("Enter new name: ");
                        newName = scanner.nextLine();
                        libraryManager.changeNameBook(nameBook, bookId, newName);
                        searchBook = libraryManager.searchBook(nameBook, bookId);
                        if (searchBook == -1) {
                            System.out.println("Please create new or enter another !");
                        }
                    }
                    break;
                case "2":
                    //change price  Book
                    while (searchBook == -1) {
                        System.out.println("Enter the name of book: ");
                        nameBook = scanner.nextLine();
                        System.out.println("Enter the Id of book: ");
                        bookId = scanner.nextLine();
                        System.out.println("Enter new price: ");
                        newPrice = scanner.nextDouble();
                        searchBook = libraryManager.searchBook(nameBook, bookId);
                        libraryManager.changePrice(nameBook, bookId, newPrice);
                        if (searchBook == -1) {
                            System.out.println("Please create new or enter another !");
                        }
                    }
                    break;
                case "3":
                    //change author
                    while (searchBook == -1) {
                        System.out.println("Enter the name of book: ");
                        nameBook = scanner.nextLine();
                        System.out.println("Enter the Id of book: ");
                        bookId = scanner.nextLine();
                        System.out.println("Enter new name of Author: ");
                        newAuthor = scanner.nextLine();
                        searchBook = libraryManager.searchBook(nameBook, bookId);
                        libraryManager.changeAuthor(nameBook, bookId, newAuthor);
                        if (searchBook == -1) {
                            System.out.println("Please create new or enter another !");
                        }
                    }
                    break;
                case "4":
                    // change name publisher
                    while (searchPublisher == -1) {
                        System.out.println("Enter the name of publisher: ");
                        namePublisher = scanner.nextLine();
                        System.out.println("Enter new name of publisher: ");
                        newPublisher = scanner.nextLine();
                        searchPublisher = libraryManager.searchPublisher(namePublisher);
                        libraryManager.changePublisher(namePublisher, newPublisher);
                        if (searchPublisher == -1) {
                            System.out.println("Please create new or enter another !");
                        }
                    }
                    break;
                case "5":
                    // change category name
                    while (searchCategory == -1) {
                        System.out.println("Enter the name of category: ");
                        nameCategory = scanner.nextLine();
                        System.out.println("Enter new name of publisher: ");
                        newCategory = scanner.nextLine();
                        searchCategory = libraryManager.searchPublisher(nameCategory);
                        libraryManager.changeCategoryName(nameCategory, newCategory);
                        if (searchCategory == -1) {
                            System.out.println("Please create new or enter another !");
                        }
                    }
                    break;
                case "6":
                    // change name user
                    while (searchUser == -1) {
                        System.out.println("Enter the name of user: ");
                        userName = scanner.nextLine();
                        System.out.println("Enter the Id of user: ");
                        userId = scanner.nextLine();
                        System.out.println("Enter new name of publisher: ");
                        newUser = scanner.nextLine();
                        searchUser = libraryManager.searchUser(userName, userId);
                        libraryManager.changeUser(userName, userId, newUser);
                        if (searchPublisher == -1) {
                            System.out.println("Please create new or enter another !");
                        }
                    }
                case "7":
                    // change phone number of User
                    do {
                        System.out.println("Enter Name of user: ");
                        userName = scanner.nextLine();
                        System.out.println("Enter code of User: ");
                        userId = scanner.nextLine();
                        System.out.println("Enter new phone number : ");
                        newPhoneNumber = scanner.nextLine();
                        searchUser = libraryManager.searchUser(userName, userId);
                        libraryManager.userList.get(searchBook).setPhoneNumber(newPhoneNumber);
                        if (searchUser == -1) {
                            System.out.println("Please create new or enter another !");
                        }
                    } while (searchUser == -1);
                    break;
                case "0":
                    System.out.println("exited!");
                    exit = true;
                    break;
                default:
                    System.out.println("invalid! please choose action in below menu:");
                    break;
            }
            if (exit) {
                return;
            }
            showDeleteMenu(libraryManager);
        }

    }

    private static void showDeleteMenu(LibraryManager libraryManager) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String choose;
        boolean exit = false;
        System.out.println("-----------delete Menu------------");
        System.out.println("1. delete book");
        System.out.println("2. delete user");
        System.out.println("0 .exit.");
        System.out.println("---------------------------");
        System.out.println("Enter Choose: ");
        String nameBook, userName, bookId, userId;
        int searchBook = -1, searchUser = -1;

        while (true) {
            choose = scanner.nextLine();
            switch (choose) {
                case "1":
                    //delete book
                    while (searchBook == -1) {
                        System.out.println("Enter the name of book: ");
                        nameBook = scanner.nextLine();
                        System.out.println("Enter the Id of book: ");
                        bookId = scanner.nextLine();
                        libraryManager.deleteBook(nameBook, bookId);
                        searchBook = libraryManager.searchBook(nameBook, bookId);
                        if (searchBook == -1) {
                            System.out.println("Please create new or enter another !");
                        }

                    }
                    break;
                case "2":
                    //delete user
                    while (searchUser == -1) {
                        System.out.println("Enter the name of User: ");
                        userName = scanner.nextLine();
                        System.out.println("Enter the Id of User: ");
                        userId = scanner.nextLine();
                        libraryManager.deleteUser(userName, userId);
                        searchUser = libraryManager.searchUser(userName, userId);
                        if (searchBook == -1) {
                            System.out.println("Please create new or enter another !");
                        }
                    }
                case "0":
                    System.out.println("exited!");
                    exit = true;
                    break;
                default:
                    System.out.println("invalid! please choose action in below menu:");
                    break;
            }
            if (exit) {
                return;
            }
            showDeleteMenu(libraryManager);
        }

    }

    private static void showAddMenu(LibraryManager libraryManager) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String choose;
        boolean exit = false;
        System.out.println("-----------Add Menu------------");
        System.out.println("1. new book ");
        System.out.println("2. new user");
        System.out.println("3. new category");
        System.out.println("4. new publisher");
        System.out.println("0. exit.");
        System.out.println("---------------------------");
        System.out.println("Enter Choose: ");
        String userId;
        int searchCategory;
        int searchPublisher;
        String yearOfPublication;
        double price;

        Publisher publisher;
        Category category;
        String nameBook, nameAuthor, nameUser, nameCategory, namePublisher, bookId,
                phoneNumber, categoryName, publisherName, address;
        while (true) {
            choose = scanner.nextLine();
            switch (choose) {
                case "1":
                    //add book
                    //----------------------------------------------------
                    do {
                        System.out.println("Enter name category: ");
                        nameCategory = scanner.nextLine();
                        searchCategory = libraryManager.searchCategory(nameCategory);
                        if (searchCategory == -1) {
                            System.out.println("Category doesn't Exist ! please create new or enter another !");
                        }
                    } while (searchCategory == -1);
                    category = libraryManager.categoryList.get(searchCategory);
                    //---------------------------------------------------------
                    System.out.println("Enter name Book: ");
                    nameBook = scanner.nextLine();
                    System.out.println("Enter name author: ");
                    nameAuthor = scanner.nextLine();
                    System.out.println("Enter price");
                    price = scanner.nextDouble();
                    System.out.println("Enter Book code: ");
                    bookId = scanner.nextLine();
                    //------------------------------------------------------------------------
                    do {
                        System.out.println("Enter name publisher");
                        namePublisher = scanner.nextLine();
                        searchPublisher = libraryManager.searchPublisher(namePublisher);
                        if (searchPublisher == -1) {
                            System.out.println("Publisher doesn't Exist ! please create new or enter another!");
                        }
                    } while (searchPublisher == -1);
                    publisher = libraryManager.publisherList.get(searchPublisher);
                    //----------------------------
                    System.out.println("Enter year of publication: ");
                    yearOfPublication = scanner.nextLine();
                    libraryManager.addBook(nameBook, price, nameAuthor, category, publisher, yearOfPublication, bookId);
                    break;
                case "2":
                    // add new user
                    System.out.println("Enter the name user: ");
                    nameUser = scanner.nextLine();
                    System.out.println("Enter the phone number: ");
                    phoneNumber = scanner.nextLine();

                    System.out.println("Enter the user Id: ");
                    userId = scanner.nextLine();
                    libraryManager.addUser(nameUser, phoneNumber, userId);
                    break;
                case "3":
                    // add new category
                    System.out.println("Enter the category name: ");
                    categoryName = scanner.nextLine();
                    libraryManager.addCategory(categoryName);
                    break;
                case "4":
                    // add new publisher
                    System.out.println("Enter the publisher name: ");
                    publisherName = scanner.nextLine();
                    System.out.println("Enter the publisher phoneNumber: ");
                    phoneNumber = scanner.nextLine();
                    System.out.println("Enter publisher address: ");
                    address = scanner.nextLine();
                    libraryManager.addPublisher(publisherName, phoneNumber, address);
                    break;
                case "5":
                    System.out.flush();
                    break;
                case "0":
                    System.out.println("exited!");
                    exit = true;
                    break;
                default:
                    System.out.println("invalid! please choose action in below menu:");
                    break;
            }
            if (exit) {
                return;
            }
            showAddMenu(libraryManager);
        }
    }

    private static void showDisplayMenu(LibraryManager libraryManager) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String choose;
        boolean exit = false;
        System.out.println("-----------search Menu------------");
        System.out.println("1. Display library");
        System.out.println("2. Display user list");
        System.out.println("3. Display category list");
        System.out.println("4. Display publisher");
        System.out.println("5. Display active log");
        System.out.println("0. exit.");
        System.out.println("---------------------------");
        System.out.println("Enter Choose: ");
        while (true) {
            choose = scanner.nextLine();
            switch (choose) {
                case "1":
                    libraryManager.displayLibraries();
                    break;
                case "2":
                    libraryManager.displayUserList();
                    break;
                case "3":
                    libraryManager.displayCategoryList();
                    break;
                case "4":
                    libraryManager.displayPublisherList();
                    break;
                case "5":
                    libraryManager.displayActiveLog();
                case "0":
                    System.out.println("exited!");
                    exit = true;
                    break;
                default:
                    System.out.println("invalid! please choose action in below menu:");
                    break;
            }
            if (exit) {
                return;
            }
            showDisplayMenu(libraryManager);
        }
    }

    public static void showSearchMenu(LibraryManager libraryManager) {
        Scanner scanner = new Scanner(System.in);
        String choose;
        boolean exit = false;
        System.out.println("-----------search Menu------------");
        System.out.println("1. Search book ");
        System.out.println("3. Search user ");
        System.out.println("4. Search category ");
        System.out.println("7. search Publisher");
        System.out.println("0. exit.");
        System.out.println("---------------------------");
        System.out.println("Enter Choose: ");
        String bookId;
        String userId;
        int searchBook, searchUser, searchPublisher, searchCategory;
        String nameBook, nameUser, nameCategory, namePublisher;
        while (true) {
            choose = scanner.nextLine();
            switch (choose) {
                case "1":
                    System.out.println("Enter name Book: ");
                    nameBook = scanner.nextLine();
                    System.out.println("Enter ID Book: ");
                    bookId = scanner.nextLine();
                    searchBook = libraryManager.searchBook(nameBook, bookId);
                    if (searchBook == -1) {
                        break;
                    }
                    System.out.println(libraryManager.library.get(searchBook).toString());
                    break;
                case "2":
                    // search User
                    System.out.println("Enter name User: ");
                    nameUser = scanner.nextLine();
                    System.out.println("Enter ID Book: ");
                    userId = scanner.nextLine();
                    searchUser = libraryManager.searchUser(nameUser, userId);
                    if (searchUser == -1) {
                        break;
                    }
                    System.out.println(libraryManager.userList.get(searchUser).toString());
                    break;
                case "3":
                    System.out.println("Enter name category: ");
                    nameCategory = scanner.nextLine();
                    searchCategory = libraryManager.searchCategory(nameCategory);
                    if (searchCategory == -1) {
                        break;
                    }
                    System.out.println(libraryManager.categoryList.get(searchCategory).toString());
                    break;
                case "5":
                    System.out.println("Enter name publisher: ");
                    namePublisher = scanner.nextLine();
                    searchPublisher = libraryManager.searchPublisher(namePublisher);
                    if (searchPublisher == -1) {
                        break;
                    }
                    System.out.println(libraryManager.publisherList.get(searchPublisher).toString());
                    break;
                case "0":
                    System.out.println("exited!");
                    exit = true;
                    break;
                default:
                    System.out.println("invalid! please choose action in below menu:");
                    break;

            }
            if (exit) {
                return;
            }
            showSearchMenu(libraryManager);
        }

    }
    public static void showMainMenu() {
        System.out.println("-----------Library Manager------------");
        System.out.println("1. Search.");
        System.out.println("2. Display.");
        System.out.println("3. Add.");
        System.out.println("4. delete.");
        System.out.println("5. change info.");
        System.out.println("6. lend book.");
        System.out.println("7. give book back");
        System.out.println("8. write to file");
        System.out.println("9. read to file");
        System.out.println("0. exit.");
        System.out.println("---------------------------");
    }
}