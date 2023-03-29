package Client;

import Order.Order;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ClientRepository implements ClientAccessor {

  private static final String FILE_PATH = "src/main/resources/Clients.txt";

  @Override
  public List<Client> getAllClients() {
    List<Client> clients = new ArrayList<>();
    try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
      String line;
      while ((line = br.readLine()) != null) {
        String[] parts = line.split("_");
        int id = Integer.parseInt(parts[0]);
        String firstName = parts[1];
        String secondName = parts[2];
        Client client = new Client(id, firstName, secondName);
        clients.add(client);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    return clients;
  }

  @Override
  public Client getClientById(int id) {
    List<Client> clients = getAllClients();
    for (Client client : clients) {
      if (client.getId() == id) {
        return client;
      }
    }
    return null;
  }

  @Override
  public void deleteClient(int id) {
    List<Client> clients = getAllClients();
    clients.removeIf(client -> client.getId() == id);
    writeClientsToFile(clients);
  }

  @Override
  public void updateClient(Client client) {
    List<Client> clients = getAllClients();
    for (int i = 0; i < clients.size(); i++) {
      Client c = clients.get(i);
      if (c.getId() == client.getId()) {
        clients.set(i, client);
        break;
      }
    }
    writeClientsToFile(clients);
  }

  @Override
  public void addClient(Client client) {
    List<Client> clients = getAllClients();
    boolean idExists = false;
    for (Client c : clients) {
      if (c.getId() == client.getId()) {
        idExists = true;
        break;
      }
    }
    if (idExists) {
      System.out.println("ID already exists. Try again.");
      return;
    }
    try (FileWriter fw = new FileWriter(FILE_PATH, true)) {
      fw.write(client.toString() + "\n");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private void writeClientsToFile(List<Client> clients) {
    try (FileWriter fw = new FileWriter(FILE_PATH)) {
      for (Client client : clients) {
        fw.write(client.toString() + "\n");
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
