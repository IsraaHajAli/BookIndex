public class BookIndex {
    private String title ; // without setter
    private String author ; // without setter
    private int copies; // with setter
    private int copyright;//(in the form of yyyy) // with setter
    public static int numOfBooks = 0;

    public BookIndex(String title, String author, int copies, int copyright) {
        this.title = title;
        this.author = author;
        this.copies = copies;
        this.copyright = copyright;
        numOfBooks++;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getCopies() {
        return copies;
    }

    public void setCopies(int newCopies) {
        this.copies = newCopies;
    }

    public int getCopyright() {
        return copyright;
    }

    public void setCopyright(int newCopyright) {
        this.copyright = newCopyright;
    }

    @Override
    public String toString() {
        return
                "Title='" + title + '\'' +
                        ", Author='" + author + '\'' +
                        ", Copies=" + copies +
                        ", Copyright=" + copyright
                ;
    }
}
