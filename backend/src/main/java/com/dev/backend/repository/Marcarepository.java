package com.dev.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.dev.backend.entity.Marca;

public interface Marcarepository extends JpaRepository<Marca, Long>{

    
}