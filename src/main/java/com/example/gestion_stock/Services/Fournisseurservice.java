package com.example.gestion_stock.Services;

import com.example.gestion_stock.Entities.Fournisseur;
import com.example.gestion_stock.Repo.Fournisseurrepo;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
@Transactional
public class Fournisseurservice {
    private Fournisseurrepo fournisseurservice;
    public Fournisseur creer_fournisseur(Fournisseur e){
        return fournisseurservice.save(e);
    }
    public void supprimer_fournisseur(long id){
        Fournisseur e =trouver_fournisseur(id);
        fournisseurservice.delete(e);
    }
    public Fournisseur trouver_fournisseur(long id){
        Optional<Fournisseur> et = fournisseurservice.findById(id);
        return et.get();
    }
    public List<Fournisseur> listes_fournisseurs(){
        return fournisseurservice.findAll();
    }
    public void supprime_tout(){
        fournisseurservice.findAll().forEach(e->fournisseurservice.delete(e));
    }
}
