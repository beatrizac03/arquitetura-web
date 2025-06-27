package com.api.authjwt.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.api.authjwt.models.Produto;
import com.api.authjwt.repositories.ProdutoRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;

    public Page<Produto> buscarProdutos(Pageable pageable) {
        return produtoRepository.findAll(pageable);
    }
}
