package com.example.gestion_stock.Repo;

import com.example.gestion_stock.Entities.Admin;
import com.example.gestion_stock.Entities.Entropot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Entropotrepo extends JpaRepository<Entropot,Long> {
}