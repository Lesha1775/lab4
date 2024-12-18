import java.util.ArrayList;
import java.util.List;

public class Library {
    private String name;
    private List<Book> books;

    public Library(String name) {
        this.name = name;
        this.books = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public List<Book> getBooksByAuthor(String author) {
        List<Book> filteredBooks = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                filteredBooks.add(book);
            }
        }
        return filteredBooks;
    }

    public void displayAllBooks() {
        for (Book book : books) {
            book.displayInfo();
        }
    }
}