package ru.lepnina.shop.client;

import org.springframework.stereotype.Service;
import ru.lepnina.shop.cart.CartRepo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    private final ClientRepo clientRepo;
    private final CartRepo cartRepo;

    public ClientService(ClientRepo clientRepo, CartRepo cartRepo) {
        this.clientRepo = clientRepo;
        this.cartRepo = cartRepo;
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

    public void saveClient(Client client){
        clientRepo.save(client);
    }

    public void addNewClient(Client client){
        if(clientRepo.findByPhoneNumber(client.getPhoneNumber()).isPresent()){
            Client clientFromDB = clientRepo.findByPhoneNumber(client.getPhoneNumber()).get();
            clientFromDB.setActive(true);
            clientRepo.save(clientFromDB);
        }else {
            clientRepo.save(client);
        }
    }

    public Client findClientByNumber(String phoneNumber){
        Optional<Client> clientOptional = clientRepo.findByPhoneNumber(phoneNumber);
        return clientOptional.orElseGet(Client::new);
    }

    public void offClient(Long id){
        Client client = clientRepo.findById(id).get();
        client.setActive(!cartRepo.findCartByClientIdAndActiveEquals(client.getId(),true).isEmpty());
        clientRepo.save(client);
    }
}
