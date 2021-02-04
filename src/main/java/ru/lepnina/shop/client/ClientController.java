package ru.lepnina.shop.client;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
@CrossOrigin
public class ClientController {
    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/allClients")
    public List<Client> allClients(){
        return clientService.getClients();
    }

    @PostMapping("/addNewClient")
    public void addNewClient(@RequestBody Client client){
        //clientService.addNewClient(client);
    }

    @GetMapping("/activeClients")
    public List<Client> activeClients(){
        return clientService.getActiveClients();
    }
}
