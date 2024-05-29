package com.example.gestion_stock.Services;

import com.example.gestion_stock.Entities.Admin;
import com.example.gestion_stock.Entities.Client;
import com.example.gestion_stock.Repo.Adminrepo;
import com.example.gestion_stock.Repo.Clinetrepo;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
@Transactional
public class ClientService {
    private Clinetrepo clientrepo;
    public Client creer_client(Client e){
        return clientrepo.save(e);
    }
    public void supprimer_client(long id){
        Client e =trouver_client(id);
        clientrepo.delete(e);
    }
    public Client trouver_client(long id){
        Optional<Client> et = clientrepo.findById(id);
        return et.get();
    }
    public List<Client> listes_clients(){
        return clientrepo.findAll();
    }
    public void supprime_tout(){
        clientrepo.findAll().forEach(e->clientrepo.delete(e));
    }
}
