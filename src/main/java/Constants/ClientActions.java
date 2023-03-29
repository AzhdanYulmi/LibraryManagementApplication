package Constants;

import Client.Client;
import Client.ClientRepository;

import java.util.List;
import java.util.Scanner;

public class ClientActions {

  private static final Scanner SCANNER = new Scanner(System.in);
  private static final ClientRepository CLIENT_REPOSITORY = new ClientRepository();

  public static void showAllClients() {
    List<Client> clients = CLIENT_REPOSITORY.getAllClients();
    for (Client client : clients) {
      System.out.println(client);
    }
  }

  public static void addClient() {
    System.out.println("Input client's ID:");
    int clientId = SCANNER.nextInt();
    SCANNER.nextLine();
    System.out.println("Input client's first name:");
    String firstName = SCANNER.nextLine();
    System.out.println("Input client's second name");
    String secondName = SCANNER.nextLine();
    Client client = new Client(clientId, firstName, secondName);
    CLIENT_REPOSITORY.addClient(client);
    System.out.println("Client added successfully");
  }

  public static void updateClient() {
    System.out.println("Input the ID of the client you wish to update:");
    int idToBeUpdated = SCANNER.nextInt();
    SCANNER.nextLine();
    System.out.println("Input new first name:");
    String newFirstName = SCANNER.nextLine();
    System.out.println("Input new second name:");
    String newSecondName = SCANNER.nextLine();
    Client newClient = new Client(idToBeUpdated, newFirstName, newSecondName);
    CLIENT_REPOSITORY.updateClient(newClient);
    System.out.println("Client's information updated successfully");
  }

  public static void deleteClient() {
    System.out.println("Input the ID of the client to be deleted:");
    int idToBeDeleted = SCANNER.nextInt();
    SCANNER.nextLine();
    CLIENT_REPOSITORY.deleteClient(idToBeDeleted);
    System.out.println("Client has been deleted.");
  }

  public static void getClientById() {
    System.out.println("Input client's ID:");
    int clientId = SCANNER.nextInt();
    SCANNER.nextLine();
    Client client = CLIENT_REPOSITORY.getClientById(clientId);
    if (client != null) {
      System.out.println(client);
    } else {
      System.out.println("Client not found.");
    }
  }
}
