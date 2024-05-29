package com.example.gestion_stock.Services;

import com.example.gestion_stock.Entities.Produit;
import com.example.gestion_stock.Repo.Clinetrepo;
import com.example.gestion_stock.Repo.Produitrepo;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
@Transactional
public class ProduitService {
    private Produitrepo produitrepo;
    public Produit creer_produit(Produit e){
        return produitrepo.save(e);
    }
    public void supprimer_produit(long id){
        Produit e =trouver_produit(id);
        produitrepo.delete(e);
    }
    public Produit trouver_produit(long id){
        Optional<Produit> et = produitrepo.findById(id);
        return et.get();
    }
    public List<Produit> listes_produits(){
        return produitrepo.findAll();
    }
    public void supprime_tout(){
        produitrepo.findAll().forEach(e->produitrepo.delete(e));
    }
}
