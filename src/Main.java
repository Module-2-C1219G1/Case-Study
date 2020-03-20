
import BookInfo.Category;
import BookInfo.Publisher;
import Manager.LibraryManager;
import Manager.User;

import java.util.Scanner;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        LibraryManager libraryManager = new LibraryManager();
        String choose = null;
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
        int searchBook = 0;
        int searchUser = 0;
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
        int searchBook = 0;
        int searchUser = 0;
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
        String choose = null;
        boolean exit = false;
        System.out.println("-----------search Menu------------");
        System.out.println("1. change name book");
        System.out.println("2. change price");
        System.out.println("3. change author");
        System.out.println("5. change publisher name");
        System.out.println("6 .change category name ");
        System.out.println("8 .change name user");
        System.out.println("9 .change phone user");
        System.out.println("0 .exit.");
        System.out.println("---------------------------");
        System.out.println("Enter Choose: ");
        String nameBook, userName, bookId, userId, newUser,newName, newAuthor, newPublisher, namePublisher,nameCategory,newCategory;
        int searchBook = -1, searchUser = -1, searchPublisher = -1,searchCategory = -1;
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
                        searchUser = libraryManager.searchUser(userName,userId);
                        libraryManager.changeUser(userName,userId,newUser);
                        if (searchPublisher == -1) {
                            System.out.println("Please create new or enter another !");
                        }
                    }
                case "7":
                    // change phone number
                    do {
                        System.out.println("Enter code of book want change: ");
                        codeBook = scanner.nextInt();
                        System.out.println("Enter new phone number : ");
                        newName = scanner.nextLine();
                        searchBook = libraryManager.searchBook(codeBook, libraryManager.library);
                        libraryManager.userList.get(searchBook).setPhoneNumber(newName);
                        if (searchBook == -1) {
                            System.out.println("Please create new or enter another !");
                        }
                    } while (searchBook == -1);
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

    private static void showDeleteMenu(LibraryManager libraryManager) {
        Scanner scanner = new Scanner(System.in);
        String choose = null;
        boolean exit = false;
        System.out.println("-----------delete menu------------");
        System.out.println("1. delete category with name");
        System.out.println("2. delete category with code");
        System.out.println("3. delete user with code");
        System.out.println("4. delete book with name");
        System.out.println("5. delete book with code");
        System.out.println("6. delete Publisher with name");
        System.out.println("7. delete publisher with code");
        System.out.println("8. Clear screen");
        System.out.println("0. exit.");
        System.out.println("---------------------------");
        System.out.println("Enter Choose: ");
        int codeUser, codeCategory, codePublisher, searchCategory, bookCode, searchUser, searchBook, searchPublisher;
        String nameBook, nameCategory, namePublisher;

        while (true) {
            choose = scanner.nextLine();
            switch (choose) {
                case "1":
                    //delete category with name - done
                    //----------------------------------------------------
                    do {
                        System.out.println("Enter name category");
                        nameCategory = scanner.nextLine();
                        searchCategory = libraryManager.searchCategory(nameCategory, libraryManager.categoryList);
                        if (searchCategory == -1) {
                            System.out.println("Category doesn't Exist ! please create new or enter another !");
                        }
                        libraryManager.categoryList.remove(searchCategory);
                    } while (searchCategory == -1);
                    break;
                case "2":
                    // delete with category with code -- done
                    do {
                        System.out.println("Enter code category");
                        codeCategory = scanner.nextInt();
                        searchCategory = libraryManager.searchCategory(codeCategory, libraryManager.categoryList);
                        if (searchCategory == -1) {
                            System.out.println("Category doesn't Exist ! please create new or enter another !");
                        }
                        libraryManager.categoryList.remove(searchCategory);
                    } while (searchCategory == -1);
                    break;
                case "3":
                    //delete user with code -- done
                    do {
                        System.out.println("Enter code user");
                        codeUser = scanner.nextInt();
                        searchUser = libraryManager.searchUser(codeUser, libraryManager.userList);
                        if (searchUser == -1) {
                            System.out.println("user doesn't Exist ! please create new or enter another !");
                        }
                        libraryManager.userList.remove(searchUser);
                    } while (searchUser == -1);
                    break;
                case "4":
                    // delete book with name -- done
                    do {
                        System.out.println("Enter name book: ");
                        nameBook = scanner.nextLine();
                        searchBook = libraryManager.searchBook(nameBook, libraryManager.library);
                        if (searchBook == -1) {
                            System.out.println("Book doesn't Exist ! please create new or enter another !");
                        }
                        libraryManager.library.remove(searchBook);
                    } while (searchBook == -1);
                    break;
                case "5":
                    // delete book with code-- done
                    do {
                        System.out.println("Enter code book: ");
                        bookCode = scanner.nextInt();
                        searchBook = libraryManager.searchBook(bookCode, libraryManager.library);
                        if (searchBook == -1) {
                            System.out.println("book doesn't Exist ! please create new or enter another !");
                        }
                        libraryManager.library.remove(searchBook);
                    } while (searchBook == -1);
                    break;
                case "6":
                    // delete publisher with name -- done
                    do {
                        System.out.println("Enter name Publisher: ");
                        namePublisher = scanner.nextLine();
                        searchPublisher = libraryManager.searchPublisher(namePublisher, libraryManager.publisherList);
                        if (searchPublisher == -1) {
                            System.out.println("Publisher doesn't Exist ! please create new or enter another !");
                        }
                        libraryManager.publisherList.remove(searchPublisher);
                    } while (searchPublisher == -1);
                    break;
                case "7":
                    // delete publisher with code-- done
                    do {
                        System.out.println("Enter code Publisher: ");
                        codePublisher = scanner.nextInt();
                        searchPublisher = libraryManager.searchPublisher(codePublisher, libraryManager.publisherList);
                        if (searchPublisher == -1) {
                            System.out.println("publisher doesn't Exist ! please create new or enter another !");
                        }
                        libraryManager.library.remove(searchPublisher);
                    } while (searchPublisher == -1);
                    break;
                case "8":
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
            showDeleteMenu(libraryManager);
        }
    }

    private static void showAddMenu(LibraryManager libraryManager) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String choose = null;
        boolean exit = false;
        System.out.println("-----------Add Menu------------");
        System.out.println("1. new book ");
        System.out.println("2. new user");
        System.out.println("3. new category");
        System.out.println("4. new publisher");
        System.out.println("5. Clear screen");
        System.out.println("0. exit.");
        System.out.println("---------------------------");
        System.out.println("Enter Choose: ");
        int bookCode, codeUser, codeCategory, codePublisher, searchCategory, searchPublisher, yearOfPublication;
        double price;

        Publisher publisher;
        Category category;
        String nameBook, nameAuthor, nameUser, nameCategory, namePublisher,
                phoneNumber, categoryName, publisherName;
        while (true) {
            choose = scanner.nextLine();
            switch (choose) {
                case "1":
                    //add book
                    //----------------------------------------------------
                    do {
                        System.out.println("Enter name category");
                        nameCategory = scanner.nextLine();
                        searchCategory = libraryManager.searchCategory(nameCategory, libraryManager.categoryList);
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
                    bookCode = scanner.nextInt();
                    //------------------------------------------------------------------------
                    do {
                        System.out.println("Enter name publisher");
                        namePublisher = scanner.nextLine();
                        searchPublisher = libraryManager.searchPublisher(namePublisher, libraryManager.publisherList);
                        if (searchPublisher == -1) {
                            System.out.println("Publisher doesn't tExist ! please create new or enter another!");
                        }

                    } while (searchPublisher == -1);
                    publisher = libraryManager.publisherList.get(searchPublisher);
                    //----------------------------
                    System.out.println("Enter year of publication: ");
                    yearOfPublication = scanner.nextInt();
                    libraryManager.addBook(category, nameBook, nameAuthor, price, bookCode, publisher, yearOfPublication);
                    break;
                case "2":
                    // add user
                    System.out.println("Enter the code user: ");
                    codeUser = scanner.nextInt();
                    System.out.println("Enter the name user: ");
                    nameUser = scanner.nextLine();
                    nameUser = scanner.nextLine();

                    System.out.println("Enter the phone number: ");
                    phoneNumber = scanner.nextLine();
                    libraryManager.addUser(codeUser, nameUser, phoneNumber);
                    break;
                case "3":
                    // add category
                    System.out.println("Enter the category name: ");
                    categoryName = scanner.nextLine();
                    System.out.println("Enter the category code: ");
                    codeCategory = scanner.nextInt();
                    libraryManager.addCategory(categoryName, codeCategory);
                    break;
                case "4":
                    // add publisher
                    System.out.println("Enter the publisher name: ");
                    publisherName = scanner.nextLine();
                    System.out.println("Enter the publisher code: ");
                    codePublisher = scanner.nextInt();
                    libraryManager.addCategory(publisherName, codePublisher);
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
        String choose = null;
        boolean exit = false;
        System.out.println("-----------search Menu------------");
        System.out.println("1. Display library");
        System.out.println("2. Display user list");
        System.out.println("3. Display category list");
        System.out.println("4. Display publisher");
        System.out.println("5. Display active log");
        System.out.println("6. Clear screen");
        System.out.println("0. exit.");
        System.out.println("---------------------------");
        System.out.println("Enter Choose: ");

        while (true) {
            choose = scanner.nextLine();
            switch (choose) {
                case "1":
                    System.out.println("---------- library list---------------");
                    System.out.println(libraryManager.displayLibraries());
                    break;
                case "2":
                    System.out.println("-----------User list-------------------");
                    System.out.println(libraryManager.displayUserList());
                    break;
                case "3":
                    System.out.println("-----------Category list----------------");
                    System.out.println(libraryManager.displayCategoryList());
                    break;
                case "4":
                    System.out.println("------------Publisher list --------------");
                    System.out.println(libraryManager.displayPublisherList());
                    break;
                case "5":
                    System.out.println("------------Active Log------------------- ");
                    libraryManager.displayActiveLog();
                case "6":
                    System.out.flush();
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
        String choose = null;
        boolean exit = false;
        System.out.println("-----------search Menu------------");
        System.out.println("1. Search book with name");
        System.out.println("2. search book with code");
        System.out.println("3. Search user with name");
        System.out.println("4. Search user with code");
        System.out.println("5. Search category with name");
        System.out.println("6. search category with code");
        System.out.println("7. search Publisher with name");
        System.out.println("8. Search publisher with code");
        System.out.println("9. Clear screen");
        System.out.println("0. exit.");
        System.out.println("---------------------------");
        System.out.println("Enter Choose: ");
        int codeBook, codeUser, codeCategory, codePublisher;
        String nameBook, nameUser, nameCategory, namePublisher;

        while (true) {
            choose = scanner.nextLine();
            switch (choose) {
                case "1":
                    System.out.println("Enter name Book: ");
                    nameBook = scanner.nextLine();
                    libraryManager.searchBook(nameBook, libraryManager.library);
                    break;
                case "2":
                    System.out.println("Enter code Book: ");
                    codeBook = scanner.nextInt();
                    libraryManager.searchBook(codeBook, libraryManager.library);
                    break;
                case "3":
                    System.out.println("Enter name User: ");
                    nameUser = scanner.nextLine();
                    libraryManager.searchUser(nameUser, libraryManager.userList);
                    break;
                case "4":
                    System.out.println("Enter code User: ");
                    codeUser = scanner.nextInt();
                    libraryManager.searchUser(codeUser, libraryManager.userList);
                    break;
                case "5":
                    System.out.println("Enter name Category: ");
                    nameCategory = scanner.nextLine();
                    libraryManager.searchCategory(nameCategory, libraryManager.categoryList);
                    break;
                case "6":
                    System.out.println("Enter code Category: ");
                    codeCategory = scanner.nextInt();
                    libraryManager.searchCategory(codeCategory, libraryManager.categoryList);
                    break;
                case "7":
                    System.out.println("Enter name publisher: ");
                    namePublisher = scanner.nextLine();
                    libraryManager.searchPublisher(namePublisher, libraryManager.publisherList);
                    break;
                case "8":
                    System.out.println("Enter code publisher: ");
                    codePublisher = scanner.nextInt();
                    libraryManager.searchPublisher(codePublisher, libraryManager.publisherList);
                    break;
                case "9":
                    System.out.flush();
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


