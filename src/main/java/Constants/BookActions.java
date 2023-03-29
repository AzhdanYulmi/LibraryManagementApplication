package Constants;

import Book.Book;
import Book.BookRepository;
import Order.OrderRepository;

import java.util.List;
import java.util.Scanner;

public class BookActions {

  private static final Scanner SCANNER = new Scanner(System.in);
  private static final BookRepository BOOK_REPOSITORY = new BookRepository();
  private static final OrderRepository ORDER_REPOSITORY = new OrderRepository();

  public static void showAllBooks() {
    List<Book> books = BOOK_REPOSITORY.getAllBooks();
    for (Book book : books) {
      System.out.println(book);
    }
  }

  public static void addBook() {
    System.out.println("Enter book ID: ");
    int bookId = SCANNER.nextInt();
    SCANNER.nextLine();
    System.out.println("Enter book title: ");
    String bookTitle = SCANNER.nextLine();
    System.out.println("Enter book author: ");
    String bookAuthor = SCANNER.nextLine();
    System.out.println("Enter book release date: ");
    String bookReleaseDate = SCANNER.nextLine();
    Book newBook = new Book(bookId, bookTitle, bookAuthor, bookReleaseDate);
    BOOK_REPOSITORY.addBook(newBook);
    System.out.println("Book added successfully!");
  }

  public static void updateBook() {
    System.out.println("Enter Book ID:");
    int id = SCANNER.nextInt();
    SCANNER.nextLine();
    System.out.println("Enter new title:");
    String title = SCANNER.nextLine();
    System.out.println("Enter new author:");
    String author = SCANNER.nextLine();
    System.out.println("Enter new release date:");
    String releaseDate = SCANNER.nextLine();
    Book book = new Book(id, title, author, releaseDate);
    BOOK_REPOSITORY.updateBook(book);
    System.out.println("Book has successfully been updated.");
  }

  public static void deleteBook() {
    System.out.println("Enter the ID of the book to be deleted:");
    int choice = SCANNER.nextInt();
    BOOK_REPOSITORY.deleteBook(choice);
    System.out.println("Book has successfully been deleted.");
  }

  public static void getBookById() {
    System.out.println("Enter book ID to search: ");
    int searchId = SCANNER.nextInt();
    Book searchedBook = BOOK_REPOSITORY.getBookById(searchId);
    if (searchedBook != null) {
      System.out.println(searchedBook);
    } else {
      System.out.println("Book not found.");
    }
  }
}
