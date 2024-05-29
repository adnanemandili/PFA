package com.example.gestion_stock.Controllers;

import com.example.gestion_stock.Entities.Commande;
import com.example.gestion_stock.Services.CommandeService;
import com.example.gestion_stock.Services.CommandeService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@NoArgsConstructor
@RequestMapping({"/commandes"})
@CrossOrigin("*")
public class CommandeController {
    @Autowired
    private CommandeService commandeservice;

    @GetMapping
    public List<Commande> getcommande() {
        return commandeservice.listes_commandes();
    }

    @GetMapping({"/{id}"})
    public Commande cherchercommande(@PathVariable long id) {
        return commandeservice.trouver_commande(id);
    }

    @DeleteMapping({"/{id}"})
    public String supprimer_commande(@PathVariable long id) {
        commandeservice.supprimer_commande(id);
        return "commande de numero " + id + "est supprimé";
    }

    @PostMapping
    public Commande ajouter_commande(@RequestBody Commande e) {
        return commandeservice.creer_commande(e);
    }

    @PutMapping
    public Commande misajour_commande(@RequestBody Commande e) {
        return commandeservice.creer_commande(e);
    }

    @DeleteMapping
    public String suprime() {
        commandeservice.supprime_tout();
        return "tout est supprimés";
    }
}

