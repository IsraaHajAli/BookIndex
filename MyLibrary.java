import java.util.*;
public class MyLibrary {
    public static void main(String[] args) {
        LibraryCatalog libraryCatalog = new LibraryCatalog();
        Scanner input = new Scanner(System.in);
        int choice,copies,copyright, searchIndex, index;
        String title, author, search;
        System.out.println("Choose one from the menu below:");
        System.out.println("1) Add a book to the Library Catalog.");
        System.out.println("2) Search a Book.");
        System.out.println("3) Borrow a Book.");
        System.out.println("4) Return a Book.");
        System.out.println("5) List all the book titles in Library Catalog.");
        System.out.println("6) Quit.");
        choice = input.nextInt();
        input.nextLine(); // Consume the newline character
        while (true){
            switch (choice){
                //////////////////////////////////////////////////////////////////////////////////////////////
                case 1:
                    System.out.print("What is the title of the book you would like to add? ");
                    title = input.nextLine();
                    index = libraryCatalog.searchBook(title);
                    if (index != -1) {
                        System.out.print("The book already exists in the stock. How many extra copies would you like to add? ");
                        copies = input.nextInt();
                        input.nextLine(); // Consume the newline character
                        libraryCatalog.add_copies(title, copies);
                    } else {
                        System.out.println("Enter the book information: author, number of copies, and copyright");
                        author = input.nextLine();
                        copies = input.nextInt();
                        copyright = input.nextInt();
                        while (copyRightForm(copyright) != 4){
                            System.out.println(" Enter the copyrigt in the correct form");
                            copyright = input.nextInt();
                        }
                        input.nextLine(); // Consume the newline character
                        if (copies == 0) {
                            libraryCatalog.addNewBook(new BookIndex(title, author, 0, copyright));
                        } else if (copies > 0) {
                            libraryCatalog.addNewBook(new BookIndex(title, author, copies, copyright), copies);
                        }
                    }
                    break;
                //////////////////////////////////////////////////////////////////////////////////////////////
                case 2:
                    System.out.print("Enter the title of the book you would like to search: ");
                    search = input.nextLine();
                    searchIndex = libraryCatalog.searchBook(search);
                    if (libraryCatalog.searchBook(search) == -1) {
                        System.out.println("The book is not in the library.");
                    } else {
                        System.out.println(libraryCatalog.books[searchIndex].toString());
                    }
                    break;
                //////////////////////////////////////////////////////////////////////////////////////////////
                case 3:
                    System.out.print("What is the title of the book you would like to borrow? ");
                    title = input.nextLine();
                    index = libraryCatalog.searchBook(title);
                    if (libraryCatalog.borrowBook(title)) {
                        System.out.print("The book has been successfully loaned to the user and must be returned in 10 days");
                    } else {
                        System.out.print("The book is not available in the library");
                    }
                    input.nextLine(); // Consume the newline character
                    break;
                //////////////////////////////////////////////////////////////////////////////////////////////
                case 4:
                    System.out.print("What is the title of the book you would like to return? ");
                    title = input.nextLine();
                    index = libraryCatalog.searchBook(title);
                    if (libraryCatalog.returnBook(title)) {
                        System.out.print("The book has been successfully returned to, thank you for returning it on time ♥♥♥");
                    } else {
                        System.out.print("The book is not available in the library");
                    }
                    input.nextLine(); // Consume the newline character
                    break;
                //////////////////////////////////////////////////////////////////////////////////////////////
                case 5:
                    libraryCatalog.list_titles();
                    break;
                //////////////////////////////////////////////////////////////////////////////////////////////
                case 6:
                    System.exit(0);
                    break;
                default: System.out.println("Invalid choice !!");
            }
            System.out.println("Choose one from the menu below:");
            System.out.println("1) Add a book to the Library Catalog.");
            System.out.println("2) Search a Book.");
            System.out.println("3) Borrow a Book.");
            System.out.println("4) Return a Book.");
            System.out.println("5) List all the book titles in Library Catalog.");
            System.out.println("6) Quit.");
            choice = input.nextInt();
            input.nextLine(); // Consume the newline character
        }
    }
    public static int copyRightForm(int copyright){
        int count = 0;
        while (copyright != 0) {
            copyright /= 10; // Divide the number by 10 to remove the last digit
            count++; // Increment the count of digits
        }
        return count;
    }
}