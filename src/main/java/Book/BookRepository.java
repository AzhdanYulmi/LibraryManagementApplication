package Book;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BookRepository implements BookAccessor {

  private static final String FILE_PATH = "src/main/resources/books.txt";

  @Override
  public List<Book> getAllBooks() {
    List<Book> books = new ArrayList<>();
    try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
      String line;
      while ((line = br.readLine()) != null) {
        String[] parts = line.split("_");
        int id = Integer.parseInt(parts[0]);
        String title = parts[1];
        String author = parts[2];
        String releaseDate = parts[3];
        Book book = new Book(id, title, author, releaseDate);
        books.add(book);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    return books;
  }

  @Override
  public Book getBookById(int id) {
    List<Book> books = getAllBooks();
    for (Book book : books) {
      if (book.getId() == id) {
        return book;
      }
    }
    return null;
  }

  @Override
  public void deleteBook(int id) {
    List<Book> books = getAllBooks();
    books.removeIf(book -> book.getId() == id);
    writeBooksToFile(books);
  }

  @Override
  public void updateBook(Book book) {
    List<Book> books = getAllBooks();
    for (int i = 0; i < books.size(); i++) {
      Book b = books.get(i);
      if (b.getId() == book.getId()) {
        books.set(i, book);
        break;
      }
    }
    writeBooksToFile(books);
  }

  @Override
  public void addBook(Book book) {
    List<Book> books = getAllBooks();
    boolean idExists = false;
    for (Book b : books) {
      if (b.getId() == book.getId()) {
        idExists = true;
        break;
      }
    }
    if (idExists) {
      System.out.println("ID already exists. Try again.");
      return;
    }
    try (FileWriter fw = new FileWriter(FILE_PATH, true)) {
      fw.write(book.toString() + "\n");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private void writeBooksToFile(List<Book> books) {
    try (FileWriter fw = new FileWriter(FILE_PATH)) {
      for (Book book : books) {
        fw.write(book.toString() + "\n");
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
