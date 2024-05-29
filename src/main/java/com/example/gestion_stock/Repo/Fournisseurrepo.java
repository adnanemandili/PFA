package com.example.gestion_stock.Repo;

import com.example.gestion_stock.Entities.Fournisseur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Fournisseurrepo extends JpaRepository<Fournisseur,Long> {
}
