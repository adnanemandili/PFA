package com.example.gestion_stock.Controllers;

import com.example.gestion_stock.Entities.Fournisseur;
import com.example.gestion_stock.Services.Fournisseurservice;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@NoArgsConstructor
@RequestMapping({"/fournisseurs"})
@CrossOrigin("*")
public class FournisseurController {
    @Autowired
    private Fournisseurservice fournisseurservice;

    @GetMapping
    public List<Fournisseur> getfournisseur() {
        return fournisseurservice.listes_fournisseurs();
    }

    @GetMapping({"/{id}"})
    public Fournisseur chercherfournisseur(@PathVariable long id) {
        return fournisseurservice.trouver_fournisseur(id);
    }

    @DeleteMapping({"/{id}"})
    public String supprimer_fournisseur(@PathVariable long id) {
        fournisseurservice.supprimer_fournisseur(id);
        return "fournisseur de numero " + id + "est supprimé";
    }

    @PostMapping
    public Fournisseur ajouter_fournisseur(@RequestBody Fournisseur e) {
        return fournisseurservice.creer_fournisseur(e);
    }

    @PutMapping
    public Fournisseur misajour_fournisseur(@RequestBody Fournisseur e) {
        return fournisseurservice.creer_fournisseur(e);
    }

    @DeleteMapping
    public String suprime() {
        fournisseurservice.supprime_tout();
        return "tout est supprimés";
    }
}
