package com.example.gestion_stock.Controllers;

import com.example.gestion_stock.Entities.Stock;
import com.example.gestion_stock.Services.StockService;
import com.example.gestion_stock.Services.StockService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@NoArgsConstructor
@RequestMapping({"/stocks"})
@CrossOrigin("*")
public class StockController {
    @Autowired
    private StockService stockservice;

    @GetMapping
    public List<Stock> getstock() {
        return stockservice.listes_stocks();
    }

    @GetMapping({"/{id}"})
    public Stock chercherstock(@PathVariable long id) {
        return stockservice.trouver_stock(id);
    }

    @DeleteMapping({"/{id}"})
    public String supprimer_stock(@PathVariable long id) {
        stockservice.supprimer_stock(id);
        return "stock de numero " + id + "est supprimé";
    }

    @PostMapping
    public Stock ajouter_stock(@RequestBody Stock e) {
        return stockservice.creer_stock(e);
    }

    @PutMapping
    public Stock misajour_stock(@RequestBody Stock e) {
        return stockservice.creer_stock(e);
    }

    @DeleteMapping
    public String suprime() {
        stockservice.supprime_tout();
        return "tout est supprimés";
    }
}

