package com.example.gestion_stock.Repo;

import com.example.gestion_stock.Entities.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Adminrepo extends JpaRepository<Admin,Long> {
}
