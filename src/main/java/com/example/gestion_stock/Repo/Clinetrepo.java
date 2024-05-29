package com.example.gestion_stock.Repo;

import com.example.gestion_stock.Entities.Admin;
import com.example.gestion_stock.Entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Clinetrepo extends JpaRepository<Client,Long> {
}
