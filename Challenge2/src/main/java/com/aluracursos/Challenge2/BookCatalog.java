package Challenge2;
import java.util.ArrayList;
import java.util.List;

public class BookCatalog {
    private List<Book> books;
    private List<Author> authors;

    public BookCatalog() {
        books = new ArrayList<>();
        authors = new ArrayList<>();
    }

    public void addBooks(Book[] books) {
        for (Book book : books) {
            this.books.add(book);
            for (Author author : book.getAuthors()) {
                if (!authors.contains(author)) {
                    authors.add(author);
                }
            }
        }
    }

    public List<Book> getBooks() {
        return books;
    }

    public List<Author> getAuthors() {
        return authors;
    }

}
