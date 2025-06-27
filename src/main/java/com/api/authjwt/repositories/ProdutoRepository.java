package com.api.authjwt.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.authjwt.models.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    
}
