package com.example.gestion_stock.Repo;

import com.example.gestion_stock.Entities.Admin;
import com.example.gestion_stock.Entities.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Stockrepo extends JpaRepository<Stock,Long> {
}
