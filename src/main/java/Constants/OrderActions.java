package Constants;

import Order.Order;
import Order.OrderRepository;

import java.util.List;
import java.util.Scanner;

public class OrderActions {

  private static final Scanner SCANNER = new Scanner(System.in);
  private static final OrderRepository ORDER_REPOSITORY = new OrderRepository();

  public static void showAllOrders() {
    List<Order> orders = ORDER_REPOSITORY.getAllOrders();
    for (Order o : orders) {
      System.out.println(o);
    }
  }

  public static void addOrder() {
    System.out.println("Input order ID:");
    int orderId = SCANNER.nextInt();
    SCANNER.nextLine();
    System.out.println("Input Client's ID:");
    int clientId = SCANNER.nextInt();
    SCANNER.nextLine();
    System.out.println("Input Book's ID:");
    int bookId = SCANNER.nextInt();
    SCANNER.nextLine();
    System.out.println("Input the Order Date:");
    String orderDate = SCANNER.nextLine();
    System.out.println("Input the Due Date:");
    String dueDate = SCANNER.nextLine();
    Order order = new Order(orderId, clientId, bookId, orderDate, dueDate);
    ORDER_REPOSITORY.addOrder(order);
    System.out.println("Order has been added successfully.");
  }

  public static void updateOrder() {
    System.out.println("Input the ID of the order to be updated:");
    int orderId = SCANNER.nextInt();
    SCANNER.nextLine();
    System.out.println("Input Client's ID:");
    int clientId = SCANNER.nextInt();
    SCANNER.nextLine();
    System.out.println("Input Book's ID:");
    int bookId = SCANNER.nextInt();
    SCANNER.nextLine();
    System.out.println("Input the Order Date:");
    String orderDate = SCANNER.nextLine();
    System.out.println("Input the Due Date:");
    String dueDate = SCANNER.nextLine();
    Order newOrder = new Order(orderId, clientId, bookId, orderDate, dueDate);
    ORDER_REPOSITORY.updateOrder(newOrder);
    System.out.println("Order has been updated successfully.");
  }

  public static void deleteOrder() {
    System.out.println("Input the ID of the order to be deleted:");
    int idToBeDeleted = SCANNER.nextInt();
    SCANNER.nextLine();
    ORDER_REPOSITORY.deleteOrder(idToBeDeleted);
    System.out.println("Order deleted successfully.");
  }

  public static void getOrderById() {
    System.out.println("Input the ID of the order you're looking for:");
    int orderId = SCANNER.nextInt();
    SCANNER.nextLine();
    Order order = ORDER_REPOSITORY.getOrderById(orderId);
    if (order != null) {
      System.out.println(order);
    } else {
      System.out.println("Order not found.");
    }
  }

  public static void getOrderByClientId() {
    System.out.println("Input the ID of the Client who's orders you want to see:");
    int clientId = SCANNER.nextInt();
    SCANNER.nextLine();
    List<Order> clientOrders = ORDER_REPOSITORY.getOrdersByClientId(clientId);
    for (Order order : clientOrders) {
      System.out.println(order);
    }
  }

  public static void getOrderByBookId() {
    System.out.println("Input the ID of the book to see which orders it's present at:");
    int bookId = SCANNER.nextInt();
    SCANNER.nextLine();
    List<Order> bookOrders = ORDER_REPOSITORY.getOrdersByBookId(bookId);
    for (Order order : bookOrders) {
      System.out.println(order);
    }
  }
}
