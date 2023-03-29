package Client;

import java.util.List;

public interface ClientAccessor {

  List<Client> getAllClients();

  Client getClientById(int id);

  void addClient(Client client);

  void updateClient(Client client);

  void deleteClient(int id);
}
