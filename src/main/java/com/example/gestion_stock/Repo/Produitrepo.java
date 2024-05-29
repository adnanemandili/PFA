package com.example.gestion_stock.Repo;

import com.example.gestion_stock.Entities.Admin;
import com.example.gestion_stock.Entities.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Produitrepo extends JpaRepository<Produit,Long> {
}
