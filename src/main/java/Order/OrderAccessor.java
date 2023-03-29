package Order;

import java.util.List;

public interface OrderAccessor {

  List<Order> getAllOrders();

  Order getOrderById(int id);

  List<Order> getOrdersByClientId(int clientId);

  List<Order> getOrdersByBookId(int bookId);

  void addOrder(Order order);

  void updateOrder(Order order);

  void deleteOrder(int id);
}
