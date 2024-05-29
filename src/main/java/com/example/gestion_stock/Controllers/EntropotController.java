package com.example.gestion_stock.Controllers;

import com.example.gestion_stock.Entities.Entropot;
import com.example.gestion_stock.Services.EntropotService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@NoArgsConstructor
@RequestMapping({"/entropots"})
@CrossOrigin("*")
public class EntropotController {
    @Autowired
    private EntropotService entropotservice;

    @GetMapping
    public List<Entropot> getentropot() {
        return entropotservice.listes_entropots();
    }

    @GetMapping({"/{id}"})
    public Entropot chercherentropot(@PathVariable long id) {
        return entropotservice.trouver_entropot(id);
    }

    @DeleteMapping({"/{id}"})
    public String supprimer_entropot(@PathVariable long id) {
        entropotservice.supprimer_entropot(id);
        return "entropot de numero " + id + "est supprimé";
    }

    @PostMapping
    public Entropot ajouter_entropot(@RequestBody Entropot e) {
        return entropotservice.creer_entropot(e);
    }

    @PutMapping
    public Entropot misajour_entropot(@RequestBody Entropot e) {
        return entropotservice.creer_entropot(e);
    }

    @DeleteMapping
    public String suprime() {
        entropotservice.supprime_tout();
        return "tout est supprimés";
    }
}

