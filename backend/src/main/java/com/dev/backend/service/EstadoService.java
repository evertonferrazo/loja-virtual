package com.dev.backend.service;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dev.backend.entity.Estado;
import com.dev.backend.repository.Estadorepository;
import java.util.List;

@Service
public class EstadoService {
    
    @Autowired
    private Estadorepository estadoRepository;

    public List<Estado> buscarTodos(){
        return estadoRepository.findAll();
    }
    
    
    public Estado inserir(Estado estado){
        estado.setDataAtualizacao(new java.sql.Date(new Date().getTime()));
        Estado estadoNovo = estadoRepository.saveAndFlush(estado);
        return estadoNovo;
    }

    public Estado alterar(Estado estado){
        estado.setDataAtualizacao(new java.sql.Date(new Date().getTime()));
        return estadoRepository.saveAndFlush(estado);
        
    }

    public void excluir(Long id){
        estadoRepository.findById(id).ifPresent(estado -> estadoRepository.delete(estado));
    }
}

