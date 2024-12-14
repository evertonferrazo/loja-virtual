package com.dev.backend.service;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dev.backend.entity.Produto;
import com.dev.backend.repository.Produtorepository;
import java.util.List;

@Service
public class ProdutoService {
    
    @Autowired
    private Produtorepository produtoRepository;

    public List<Produto> buscarTodos(){
        return produtoRepository.findAll();
    }
    
    
    public Produto inserir(Produto produto){
        produto.setDataCriacao(new Date());
        Produto produtoNovo = produtoRepository.saveAndFlush(produto);
        return produtoNovo;
    }

    public Produto alterar(Produto produto){
        produto.setDataAtualizacao(new Date());
        return produtoRepository.saveAndFlush(produto);
        
    }

    public void excluir(Long id){
        Produto produto = produtoRepository.findById(id).get();
        produtoRepository.delete(produto);
    }
}

