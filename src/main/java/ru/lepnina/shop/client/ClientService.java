package ru.lepnina.shop.client;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    public Client getOneClient(Long id){
        return clientRepo.findById(id).orElse(new Client());
    }

    public List<Client> getActiveClients(){
        return clientRepo.findByActiveEquals(true);
    }

    public void saveOffClient(Client client){
        clientRepo.save(client);
    }

    public void addNewClient(Client client){
        Optional<Client> clientOptional = clientRepo.findByPhoneNumber(client.getPhoneNumber());
        if(clientOptional.isPresent()){
            ArrayList<Client> c = new ArrayList<>();
            clientOptional.ifPresent(c::add);
            Client client1 = c.get(c.size()-1);
            client1.setActive(true);
            clientRepo.save(client1);
        }else {
            clientRepo.save(client);
        }
    }
}
