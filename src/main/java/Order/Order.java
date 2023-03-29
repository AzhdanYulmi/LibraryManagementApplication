package Order;

public class Order {

  private int id;
  private int clientId;
  private int bookId;
  private String orderDate;
  private String dueDate;

  public Order(int id, int clientId, int bookId, String orderDate, String dueDate) {
    this.id = id;
    this.clientId = clientId;
    this.bookId = bookId;
    this.orderDate = orderDate;
    this.dueDate = dueDate;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getClientId() {
    return clientId;
  }

  public void setClientId(int clientId) {
    this.clientId = clientId;
  }

  public int getBookId() {
    return bookId;
  }

  public void setBookId(int bookId) {
    this.bookId = bookId;
  }

  public String getOrderDate() {
    return orderDate;
  }

  public void setOrderDate(String orderDate) {
    this.orderDate = orderDate;
  }

  public String getDueDate() {
    return dueDate;
  }

  public void setDueDate(String dueDate) {
    this.dueDate = dueDate;
  }

  @Override
  public String toString() {
    return id + "_" + clientId + "_" + bookId + "_" + orderDate + "_" + dueDate;
  }
}
