package co.com.concesionariodemotos.service;

import java.util.List;

import co.com.concesionariodemotos.model.Client;

public interface ClientService {
    
    List<Client> getAll();
    Client getByClientId(Long clientId);
    Client addClient(Client client);
    Client updateClient(Long clientId, Client newclient);
    void deleteClient(Long clientId);

}