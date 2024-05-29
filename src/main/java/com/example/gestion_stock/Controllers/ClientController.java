package com.example.gestion_stock.Controllers;

import com.example.gestion_stock.Entities.Client;
import com.example.gestion_stock.Services.ClientService;
import com.example.gestion_stock.Services.ClientService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@NoArgsConstructor
@RequestMapping({"/clients"})
@CrossOrigin("*")
public class ClientController {
    @Autowired
    private ClientService clientservice;

    @GetMapping
    public List<Client> getclient() {
        return clientservice.listes_clients();
    }

    @GetMapping({"/{id}"})
    public Client chercherclient(@PathVariable long id) {
        return clientservice.trouver_client(id);
    }

    @DeleteMapping({"/{id}"})
    public String supprimer_client(@PathVariable long id) {
        clientservice.supprimer_client(id);
        return "client de numero " + id + "est supprimé";
    }

    @PostMapping
    public Client ajouter_client(@RequestBody Client e) {
        return clientservice.creer_client(e);
    }

    @PutMapping
    public Client misajour_client(@RequestBody Client e) {
        return clientservice.creer_client(e);
    }

    @DeleteMapping
    public String suprime() {
        clientservice.supprime_tout();
        return "tout est supprimés";
    }
}

