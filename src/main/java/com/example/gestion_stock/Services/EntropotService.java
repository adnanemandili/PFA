package com.example.gestion_stock.Services;

import com.example.gestion_stock.Entities.Client;
import com.example.gestion_stock.Entities.Entropot;
import com.example.gestion_stock.Repo.Clinetrepo;
import com.example.gestion_stock.Repo.Entropotrepo;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
@Transactional
public class EntropotService {
    private Entropotrepo entropotservice;
    public Entropot creer_entropot(Entropot e){
        return entropotservice.save(e);
    }
    public void supprimer_entropot(long id){
        Entropot e =trouver_entropot(id);
        entropotservice.delete(e);
    }
    public Entropot trouver_entropot(long id){
        Optional<Entropot> et = entropotservice.findById(id);
        return et.get();
    }
    public List<Entropot> listes_entropots(){
        return entropotservice.findAll();
    }
    public void supprime_tout(){
        entropotservice.findAll().forEach(e->entropotservice.delete(e));
    }
}
