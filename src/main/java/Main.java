import java.util.Scanner;

import static Constants.BookActions.addBook;
import static Constants.BookActions.deleteBook;
import static Constants.BookActions.getBookById;
import static Constants.BookActions.showAllBooks;
import static Constants.BookActions.updateBook;
import static Constants.ClientActions.addClient;
import static Constants.ClientActions.deleteClient;
import static Constants.ClientActions.getClientById;
import static Constants.ClientActions.showAllClients;
import static Constants.ClientActions.updateClient;
import static Constants.MenuMessages.booksMenu;
import static Constants.MenuMessages.clientsMenu;
import static Constants.MenuMessages.mainMenu;
import static Constants.MenuMessages.orderMenu;
import static Constants.OrderActions.addOrder;
import static Constants.OrderActions.deleteOrder;
import static Constants.OrderActions.getOrderByBookId;
import static Constants.OrderActions.getOrderByClientId;
import static Constants.OrderActions.getOrderById;
import static Constants.OrderActions.showAllOrders;
import static Constants.OrderActions.updateOrder;

public class Main {

  private static final Scanner SCANNER = new Scanner(System.in);

  public static void main(String[] args) {


    while (true) {
      System.out.println(mainMenu());
      int mainChoice = SCANNER.nextInt();

      if (mainChoice == 4) {
        System.out.println("Quitting...");
        break;
      }

      switch (mainChoice) {
        case 1:
          while (true) {
            System.out.println(booksMenu());
            int booksChoice = SCANNER.nextInt();

            if (booksChoice == 6) {
              break;
            }

            switch (booksChoice) {
              case 1 -> showAllBooks();
              case 2 -> addBook();
              case 3 -> updateBook();
              case 4 -> deleteBook();
              case 5 -> getBookById();
              case 0 -> {
                System.out.println("Quitting...");
                System.exit(0);
              }
              default -> System.out.println("Invalid choice.");
            }
          }
          break;
        case 2:
          while (true) {
            System.out.println(clientsMenu());
            int clientsChoice = SCANNER.nextInt();
            if (clientsChoice == 6) {
              break;
            }
            switch (clientsChoice) {
              case 1 -> showAllClients();
              case 2 -> addClient();
              case 3 -> updateClient();
              case 4 -> deleteClient();
              case 5 -> getClientById();
              case 0 -> {
                System.out.println("Quitting...");
                System.exit(0);
              }
            }
          }

          break;
        case 3:
          while (true) {
            System.out.println(orderMenu());
            int choice = SCANNER.nextInt();
            SCANNER.nextLine();
            if (choice == 8) {
              break;
            }
            switch (choice) {
              case 1 -> showAllOrders();
              case 2 -> addOrder();
              case 3 -> updateOrder();
              case 4 -> deleteOrder();
              case 5 -> getOrderById();
              case 6 -> getOrderByClientId();
              case 7 -> getOrderByBookId();
              case 0 -> {
                System.out.println("Quitting...");
                System.exit(0);
              }
            }
          }
          break;
        default:
          System.out.println("Invalid choice.");
          break;
      }
    }
  }
}
