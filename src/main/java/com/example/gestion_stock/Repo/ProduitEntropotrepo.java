package com.example.gestion_stock.Repo;

import com.example.gestion_stock.Entities.Admin;
import com.example.gestion_stock.Entities.ProduitEntopot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProduitEntropotrepo extends JpaRepository<ProduitEntopot,Long> {
}
