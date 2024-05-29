package com.example.gestion_stock.Controllers;

import com.example.gestion_stock.Entities.Admin;
import com.example.gestion_stock.Services.AdminService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@NoArgsConstructor
@RequestMapping({"/admins"})
@CrossOrigin("*")
public class AdminController {
    @Autowired
    private AdminService adminservice;

    @GetMapping
    public List<Admin> getadmin() {
        return adminservice.listes_admins();
    }

    @GetMapping({"/{id}"})
    public Admin chercheradmin(@PathVariable long id) {
        return adminservice.trouver_admin(id);
    }

    @DeleteMapping({"/{id}"})
    public String supprimer_admin(@PathVariable long id) {
        adminservice.supprimer_admin(id);
        return "admin de numero " + id + "est supprimé";
    }

    @PostMapping
    public Admin ajouter_admin(@RequestBody Admin e) {
        return adminservice.creer_admin(e);
    }

    @PutMapping
    public Admin misajour_admin(@RequestBody Admin e) {
        return adminservice.creer_admin(e);
    }

    @DeleteMapping
    public String suprime() {
        adminservice.supprime_tout();
        return "tout est supprimés";
    }
}

