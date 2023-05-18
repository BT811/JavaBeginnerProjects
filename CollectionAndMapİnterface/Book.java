
package CollectionAndMapİnterface;
public class Book implements Comparable<Book> {
    @Override
    public int compareTo(Book other) {
        return this.bookName.compareTo(other.bookName);
    }


    private int id;
    private String authorName;
    private String bookName;
    private int page;
    Book (int id,String authorName,String bookName,int page){
        this.id = id;
        this.authorName = authorName;
        this.bookName = bookName;
        this.page = page;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }


}
