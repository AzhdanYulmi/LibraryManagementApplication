package Order;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class OrderRepository implements OrderAccessor {

  private static final String FILE_PATH = "src/main/resources/orders.txt";

  @Override
  public List<Order> getAllOrders() {
    List<Order> orders = new ArrayList<>();
    try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
      String line;
      while ((line = br.readLine()) != null) {
        String[] parts = line.split("_");
        int id = Integer.parseInt(parts[0]);
        int clientId = Integer.parseInt(parts[1]);
        int bookId = Integer.parseInt(parts[2]);
        String dateOfOrder = parts[3];
        String dueDate = parts[4];
        Order order = new Order(id, clientId, bookId, dateOfOrder, dueDate);
        orders.add(order);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    return orders;
  }

  @Override
  public Order getOrderById(int id) {
    List<Order> orders = getAllOrders();
    for (Order order : orders) {
      if (order.getId() == id) {
        return order;
      }
    }
    return null;
  }

  @Override
  public List<Order> getOrdersByClientId(int clientId) {
    List<Order> orders = getAllOrders();
    return orders.stream().
                 filter(order -> order.getClientId() == clientId).
                 collect(Collectors.toList());
  }

  @Override
  public List<Order> getOrdersByBookId(int bookId) {
    List<Order> orders = getAllOrders();
    return orders.stream().
                 filter(order -> order.getBookId() == bookId).
                 collect(Collectors.toList());
  }

  @Override
  public void deleteOrder(int id) {
    List<Order> orders = getAllOrders();
    orders.removeIf(order -> order.getId() == id);
    writeOrdersToFile(orders);
  }

  @Override
  public void updateOrder(Order order) {
    List<Order> orders = getAllOrders();
    for (int i = 0; i < orders.size(); i++) {
      Order o = orders.get(i);
      if (o.getId() == order.getId()) {
        orders.set(i, order);
        break;
      }
    }
    writeOrdersToFile(orders);
  }

  @Override
  public void addOrder(Order order) {
    List<Order> orders = getAllOrders();
    boolean idExists = false;
    for (Order o : orders) {
      if (o.getId() == order.getId()) {
        idExists = true;
        break;
      }
    }
    if (idExists) {
      System.out.println("ID already exists. Try again.");
      return;
    }
    try (FileWriter fw = new FileWriter(FILE_PATH, true)) {
      fw.write(order.toString() + "\n");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private void writeOrdersToFile(List<Order> orders) {
    try (FileWriter fw = new FileWriter(FILE_PATH)) {
      for (Order order : orders) {
        fw.write(order.toString() + "\n");
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
