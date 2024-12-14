package com.dev.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.dev.backend.entity.Categoria;
import com.dev.backend.service.CategoriaService;
import java.util.List;

@RestController
@RequestMapping("/api/categoria")
public class CategoriaController {
    
    @Autowired
    private CategoriaService categoriaService;
    
    @GetMapping("/")
    public List<Categoria> buscarTodos(){
       return categoriaService.buscarTodos();
    }

    @PostMapping("/")
    public Categoria inserir(@RequestBody Categoria categoria){
        return categoriaService.inserir(categoria);
    }

    @PutMapping("/{id}")
    public Categoria alterar(@PathVariable Long id, @RequestBody Categoria categoria){
        return categoriaService.alterar(categoria);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") Long id){
        categoriaService.excluir(id);
        return ResponseEntity.ok().build();
    }
}
