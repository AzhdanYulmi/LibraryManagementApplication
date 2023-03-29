package Constants;

public class MenuMessages {

  public static String mainMenu() {
    return """
           -----------------------------------
           Library Management
           Choose an option from the menu:
           1.Books
           2.Clients
           3.Orders
           4.Quit
           -----------------------------------
           """;
  }

  public static String booksMenu() {
    return """
           -----------------------------------
           Library Management
           Choose an action on Books:
           1.Show all books
           2.Add a new book
           3.Update a book
           4.Delete a book
           5.Search a book by it's ID.
           6.Back
           0.Quit
           -----------------------------------                                          
           """;
  }

  public static String clientsMenu() {
    return """
           -----------------------------------
           Library Management
           Choose an action on Clients:
           1.Show all clients
           2.Add a new client
           3.Update client's information
           4.Delete a client
           5.Search a client by his ID
           6.Back
           0.Quit
           -----------------------------------
           """;
  }

  public static String orderMenu() {
    return """
           -----------------------------------
           Library Management
           Choose an action on Orders:
           1.Show all orders
           2.Add a new order
           3.Update an order
           4.Delete an order
           5.Get an order by ID
           6.Get an order by Client ID
           7.Get an order by Book ID
           8.Back
           0.Quit
           -----------------------------------
           """;
  }
}
