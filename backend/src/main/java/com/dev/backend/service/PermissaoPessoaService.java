package com.dev.backend.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.backend.entity.Pessoa;
import com.dev.backend.repository.PermissaoPessoaRepository;
import com.dev.backend.repository.Permissaorepository;
import com.dev.backend.entity.Permissao;
import com.dev.backend.entity.PermissaoPessoa;

@Service
public class PermissaoPessoaService {
    
    @Autowired
    private PermissaoPessoaRepository permissaoPessoaRepository;

    @Autowired
    private Permissaorepository permissaoRepository;

    public void vincularPessoaPermissaoCliente(Pessoa pessoa){
        List<Permissao> listaPermissao = permissaoRepository.findByNome("cliente");
        if(listaPermissao.size()>0){
            PermissaoPessoa permissaoPessoa = new PermissaoPessoa();
            permissaoPessoa.setPessoa(pessoa);
            permissaoPessoa.setPermissao(listaPermissao.get(0));
            permissaoPessoa.setDataCriacao(new Date());
            permissaoPessoaRepository.saveAndFlush(permissaoPessoa);
        }
    }

}

