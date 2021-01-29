package ru.lepnina.shop.client;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClientController {
    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/api/clients/allClients")
    public List<Client> allClients(){
        return clientService.getClients();
    }

    @PostMapping("/api/clients/addNewClient")
    public void addNewClient(@RequestBody Client client){
        clientService.addNewClient(client);
    }

   @GetMapping("/api/clients/activeClients")
    public List<Client> activeClients(){
        return clientService.getActiveClients();
    }
}
