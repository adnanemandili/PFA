package com.example.gestion_stock.Controllers;

import com.example.gestion_stock.Entities.Produit;
import com.example.gestion_stock.Services.ProduitService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@NoArgsConstructor
@RequestMapping({"/produits"})
@CrossOrigin("*")
public class ProduitController {
    @Autowired
    private ProduitService produitservice;

    @GetMapping
    public List<Produit> getproduit() {
        return produitservice.listes_produits();
    }

    @GetMapping({"/{id}"})
    public Produit chercherproduit(@PathVariable long id) {
        return produitservice.trouver_produit(id);
    }

    @DeleteMapping({"/{id}"})
    public String supprimer_produit(@PathVariable long id) {
        produitservice.supprimer_produit(id);
        return "produit de numero " + id + "est supprimé";
    }

    @PostMapping
    public Produit ajouter_produit(@RequestBody Produit e) {
        return produitservice.creer_produit(e);
    }

    @PutMapping
    public Produit misajour_produit(@RequestBody Produit e) {
        return produitservice.creer_produit(e);
    }

    @DeleteMapping
    public String suprime() {
        produitservice.supprime_tout();
        return "tout est supprimés";
    }
}

