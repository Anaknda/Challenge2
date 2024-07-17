package Challenge2.LiteraluraApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication

public class LiteraluraApplication implements CommandLineRunner {
    private JsonMapper jsonMapper;
    private HttpRequest httpRequest;
    private BookCatalog bookCatalog;

    public LiteraluraApplication(JsonMapper jsonMapper, HttpRequest httpRequest, BookCatalog bookCatalog) {
        this.jsonMapper = jsonMapper;
        this.httpRequest = httpRequest;
        this.bookCatalog = bookCatalog;
    }

    public static void main(String[] args) {
        SpringApplication.run(LiteraluraApplication.class, args);
    }

    @Override
    public void run(String... args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Buscar libro por título");
            System.out.println("2. Mostrar lista de libros");
            System.out.println("3. Mostrar lista de autores");
            System.out.println("4. Salir");
            System.out.print("Opción: ");
            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    searchBookByTitle(scanner);
                    break;
                case 2:
                    showBookList();
                    break;
                case 3:
                    showAuthorList();
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        }
    }

    private void searchBookByTitle(Scanner scanner) {
        System.out.print("Ingrese título del libro: ");
        String title = scanner.next();
        String url = "https://gutendex.com/books/?search=" + title;
        HttpResponse response = httpRequest.sendRequest(url);
        Book[] books = jsonMapper.mapJson(response.getBody(), Book[].class);
        bookCatalog.addBooks(books);
        System.out.println("Libros encontrados:");
        for (Book book : books) {
            System.out.println(book.toString());
        }
    }

    private void showBookList() {
        System.out.println("Lista de libros:");
        for (Book book : bookCatalog.getBooks()) {
            System.out.println(book.toString());
        }
    }

    private void showAuthorList() {
        System.out.println("Lista de autores:");
        for (Author author : bookCatalog.getAuthors()) {
            System.out.println(author.toString());
        }
    }

}
