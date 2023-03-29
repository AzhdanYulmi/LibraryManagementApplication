package Book;

public class Book {

  private int id;
  private String title;
  private String author;
  private String releaseDate;

  public Book(int id, String title, String author, String releaseDate) {
    this.id = id;
    this.title = title;
    this.author = author;
    this.releaseDate = releaseDate;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public String getReleaseDate() {
    return releaseDate;
  }

  public void setReleaseDate(String releaseDate) {
    this.releaseDate = releaseDate;
  }

  @Override
  public String toString() {
    return id + "_" + title + "_" + author + "_" + releaseDate;
  }
}
