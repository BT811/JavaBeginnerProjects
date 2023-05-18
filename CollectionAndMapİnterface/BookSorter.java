package CollectionAndMapİnterface;
import java.util.TreeSet;

public class BookSorter {
    public static void main(String[] args) {
        // Book a1 = new Book(1,"George R. R. Martin","Game Of Thrones",500);
        //Book a2 = new Book(2,"Patric","Chronicles",1100);
        //Book a3 = new Book(3,"Tolkien","Lord Of The Rings",450);

        TreeSet<Book> book = new TreeSet<>();
        book.add(new Book(1,"George R. R. Martin","Game Of Thrones",500));
        book.add(new Book(2,"Patric","Chronicles",1100));
        book.add(new Book(3,"Tolkien","Lord Of The Rings",450));
        book.add(new Book(4,"Robert","Nature of People",600));
        book.add(new Book(5,"Frank","Dune",704));

        for(Book b : book) {
            System.out.println(b.getBookName() + ", " + b.getPage());
        }
        System.out.println("*******************");
        for (Book a : book) {
            System.out.println(a.getBookName());
        }
        System.out.println("*******************");
        for (Book a : book) {
            System.out.println(a.getPage());
        }

    }
}
