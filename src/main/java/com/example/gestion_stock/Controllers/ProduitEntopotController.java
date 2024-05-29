package com.example.gestion_stock.Controllers;

import com.example.gestion_stock.Entities.ProduitEntopot;
import com.example.gestion_stock.Services.ProduitEntopotService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@NoArgsConstructor
@RequestMapping({"/Produitentropots"})
@CrossOrigin("*")
public class ProduitEntopotController {
    @Autowired
    private ProduitEntopotService produitentropot;

    @GetMapping
    public List<ProduitEntopot> getProduitentropot() {
        return produitentropot.listes_Produitentropots();
    }

    @GetMapping({"/{id}"})
    public ProduitEntopot chercherProduitentropot(@PathVariable long id) {
        return produitentropot.trouver_Produitentropot(id);
    }

    @DeleteMapping({"/{id}"})
    public String supprimer_Produitentropot(@PathVariable long id) {
        produitentropot.supprimer_Produitentropot(id);
        return "Produitentropot de numero " + id + "est supprimé";
    }

    @PostMapping
    public ProduitEntopot ajouter_Produitentropot(@RequestBody ProduitEntopot e) {
        return produitentropot.creer_Produitentropot(e);
    }

    @PutMapping
    public ProduitEntopot misajour_Produitentropot(@RequestBody ProduitEntopot e) {
        return produitentropot.creer_Produitentropot(e);
    }

    @DeleteMapping
    public String suprime() {
        produitentropot.supprime_tout();
        return "tout est supprimés";
    }
}
