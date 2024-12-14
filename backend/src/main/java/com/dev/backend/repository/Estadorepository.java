package com.dev.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.dev.backend.entity.Estado;

public interface Estadorepository extends JpaRepository<Estado, Long>{

    
}