import java.util.Scanner;

public class Main {
    private Library library1;
    private Library library2;
    private Scanner scanner;

    public Main() {
        library1 = new Library("Центральная библиотека");
        library2 = new Library("Сообщество библиотек");
        scanner = new Scanner(System.in);

        library1.addBook(new Book("1984", "Фёдор Достоевский", 1949));
        library1.addBook(new Book("Преступление и наказание", "Фёдор Достоевский", 1945));
        library1.addBook(new Book("Война и мир", "Лев толстой ", 1960));

        library2.addBook(new Book("Антон Чехов", "Три сестры", 1932));
        library2.addBook(new Book("1984", "Фёдор Достоевский", 1949));
    }

    public void addBookFromUserInput() {
        System.out.print("Введите название библиотеки: ");
        String libraryName = scanner.nextLine();

        System.out.print("Введите название книги: ");
        String title = scanner.nextLine();

        System.out.print("Введите автора книги: ");
        String author = scanner.nextLine();

        System.out.print("Введите год издания книги: ");
        int year = scanner.nextInt();
        scanner.nextLine();

        addBookToLibrary(libraryName, title, author, year);
    }

    public void addBookToLibrary(String libraryName, String title, String author, int year) {
        Book newBook = new Book(title, author, year);
        if (libraryName.equalsIgnoreCase(library1.getName())) {
            library1.addBook(newBook);
            System.out.println("Книга добавлена в " + library1.getName() + ": " + title);
        } else if (libraryName.equalsIgnoreCase(library2.getName())) {
            library2.addBook(newBook);
            System.out.println("Книга добавлена в " + library2.getName() + ": " + title);
        } else {
            System.out.println("Библиотека с таким названием не найдена.");
        }
    }

    public void displayBooksByAuthor(String author) {
        System.out.println("Книги автора " + author + " в " + library1.getName() + ":");
        for (Book book : library1.getBooksByAuthor(author)) {
            book.displayInfo();
        }

        System.out.println("\nКниги автора " + author + " в " + library2.getName() + ":");
        for (Book book : library2.getBooksByAuthor(author)) {
            book.displayInfo();
        }
    }

    public void displaySpecificBookInfo() {
        System.out.println("\nИнформация о конкретной книге:");
        library1.getBooksByAuthor("Фёдор Достоевский").get(0).displayInfo();
    }

    public void displayAllBooks() {
        System.out.println("\nКниги в " + library1.getName() + ":");
        library1.displayAllBooks();
        System.out.println("\nКниги в " + library2.getName() + ":");
        library2.displayAllBooks();
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.displayBooksByAuthor("Фёдор Достоевский");
        main.displaySpecificBookInfo();

        main.addBookFromUserInput();
        main.displayAllBooks();
    }
}
