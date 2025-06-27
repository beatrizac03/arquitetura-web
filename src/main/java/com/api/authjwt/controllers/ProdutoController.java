package com.api.authjwt.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.authjwt.DTOs.ProdutoRequestDto;
import com.api.authjwt.DTOs.ProdutoResponseDto;
import com.api.authjwt.models.Produto;
import com.api.authjwt.services.ProdutoService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;  


@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public ResponseEntity<Page<Produto>> buscarProdutos(@PageableDefault(page = 0, size = 10) Pageable pageable) {
        Page<Produto> pagina = produtoService.buscarProdutos(pageable);
        return ResponseEntity.ok(pagina);
    }

    // @PostMapping("/produtos")
    // @PreAuthorize("hasRole('ADMIN')")
    // public ResponseEntity<ProdutoResponseDto> cadastrarProduto(@RequestBody ProdutoRequestDto dto) {
        
    //     return entity;
    // }
    
    
}
