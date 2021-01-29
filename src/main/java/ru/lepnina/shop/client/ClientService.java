package ru.lepnina.shop.client;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    private final ClientRepo clientRepo;

    public ClientService(ClientRepo clientRepo) {
        this.clientRepo = clientRepo;
    }

    public List<Client> getClients(){
        return clientRepo.findAll();
    }

    public void addNewClient(Client client){
        Optional<Client> clientOptional = clientRepo.findByPhoneNumber(client.getPhoneNumber());
        if(clientOptional.isPresent()){
            //TODO add this user to top of the LIST
            //TODO add for this client again ACTIVE
            throw new IllegalStateException("User exists");
        }
        clientRepo.save(client);
    }
}