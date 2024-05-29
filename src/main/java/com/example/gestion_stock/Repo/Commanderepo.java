package com.example.gestion_stock.Repo;

import com.example.gestion_stock.Entities.Admin;
import com.example.gestion_stock.Entities.Commande;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Commanderepo extends JpaRepository<Commande,Long> {
}
