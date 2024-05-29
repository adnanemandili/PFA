package com.example.gestion_stock.Services;

import com.example.gestion_stock.Entities.Admin;
import com.example.gestion_stock.Repo.Adminrepo;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
@Transactional
public class AdminService {
    private Adminrepo adminrepo;
    public Admin creer_admin(Admin e){
        return adminrepo.save(e);
    }
    public void supprimer_admin(long id){
        Admin e =trouver_admin(id);
        adminrepo.delete(e);
    }
    public Admin trouver_admin(long id){
        Optional<Admin> et = adminrepo.findById(id);
        return et.get();
    }
    public List<Admin> listes_admins(){
        return adminrepo.findAll();
    }
    public void supprime_tout(){
        adminrepo.findAll().forEach(e->adminrepo.delete(e));
    }
}
