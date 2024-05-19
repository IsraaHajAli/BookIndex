public class LibraryCatalog {
    public BookIndex[] books = new BookIndex[500];
    public LibraryCatalog() {
        // Empty constructor to create an empty object of LibraryCatalog
    }
    ////////////////////////////////////////////////////////////////////////
    boolean add_copies(String title, int quantity) { //adds a quantity number of copies to the book already in the LibraryCatalog object with the title

        for (int i = 0; i <= BookIndex.numOfBooks; i++) {
            if (books[i] != null && books[i].getTitle().compareToIgnoreCase(title) == 0) {
                books[i].setCopies(books[i].getCopies() + quantity);
                return true;
            }
        }
        return false;
    }
    ////////////////////////////////////////////////////////////////////////
    public int findInCatalog(String title) { //  returns the number of copies the LibraryCatalog object has from the book
        for (int i = 0; i <= BookIndex.numOfBooks; i++) {
            if (books[i] != null && books[i] != null && books[i].getTitle().compareToIgnoreCase(title) == 0) {
                return books[i].getCopies();
            }
        }
        return 0;
    }
    ////////////////////////////////////////////////////////////////////////
    public int searchBook(String title) {
        for (int i = 0; i <= BookIndex.numOfBooks; i++) {
            if (books[i] != null && books[i].getTitle().compareToIgnoreCase(title) == 0) {
                return i;
            }
        }
        return -1;
    }
    ////////////////////////////////////////////////////////////////////////
    void list_titles() {
        for (int i = 0; i <= BookIndex.numOfBooks; i++) {
            if (books[i] != null) {
                System.out.println(books[i].toString());
            }
        }
    }
    ////////////////////////////////////////////////////////////////////////
    boolean borrowBook(String title) {
        for (int i = 0; i <= BookIndex.numOfBooks; i++) {
            if (books[i] != null && books[i].getTitle().compareToIgnoreCase(title) == 0 ) {
                if (findInCatalog(title) > 0) {
                    System.out.println(books[i].toString());
                    books[i].setCopies(books[i].getCopies() - 1);
                    return true;
                }
                else{
                    System.out.println("There is no available copies from this book ");
                }
            }
        }
        return false;
    }
    ////////////////////////////////////////////////////////////////////////
    boolean returnBook(String title) {
        for (int i = 0; i <= BookIndex.numOfBooks; i++) {
            if (books[i] != null && books[i].getTitle().compareToIgnoreCase(title) == 0) {
                //if (books[i].getCopies() > 0) {
                books[i].setCopies(books[i].getCopies() + 1);
                return true;
                // }
            }
        }
        return false;
    }
    public void addNewBook(BookIndex b){
        b.setCopies(0);
        books[BookIndex.numOfBooks] = b;
    }
    ////////////////////////////////////////////////////////////////////////
    public void addNewBook(BookIndex b, int ncopies){

        b.setCopies(ncopies);
        books[BookIndex.numOfBooks] = b;

    }
}