package edu.campus.numerique.demo;

import edu.campus.numerique.demo.Client;
import java.util.ArrayList;
import java.util.List;

public class ClientDAO {
    private List<Client> clients = new ArrayList<>();

    public ClientDAO() {
        clients.add(new Client(1, "Alice", "alice@mail.com", "0612345678"));
        clients.add(new Client(2, "Bob", "bob@mail.com", "0698765432"));
        clients.add(new Client(3, "Charlie", "charlie@mail.com", "0678901234"));
    }

    public List<Client> findAll() {
        return clients;
    }

    public Client findById(int id) {
        return clients.stream()
                .filter(c -> c.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public void save(Client client) {
        if (findById(client.getId()) != null) {
            clients.removeIf(c -> c.getId() == client.getId());
        }
        clients.add(client);
    }

    public void delete(int id) {
        clients.removeIf(c -> c.getId() == id);
    }

}
