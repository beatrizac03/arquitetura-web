package com.api.authjwt.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.util.Objects;

@Entity
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String descricao;

    private Double preco;

    @ManyToOne
    @JoinColumn(name = "id_categoria")
    private CategoriaProduto categoria;

    private String marca;

    private String codigoSKU;

    private Integer qtdeEstoque;

    // Construtor sem argumentos
    public Produto() {
    }

    // Construtor com argumentos
    public Produto(Long id, String nome, String descricao, Double preco, CategoriaProduto categoria, String marca, String codigoSKU, Integer qtdeEstoque) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.categoria = categoria;
        this.marca = marca;
        this.codigoSKU = codigoSKU;
        this.qtdeEstoque = qtdeEstoque;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public CategoriaProduto getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaProduto categoria) {
        this.categoria = categoria;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getCodigoSKU() {
        return codigoSKU;
    }

    public void setCodigoSKU(String codigoSKU) {
        this.codigoSKU = codigoSKU;
    }

    public Integer getQtdeEstoque() {
        return qtdeEstoque;
    }

    public void setQtdeEstoque(Integer qtdeEstoque) {
        this.qtdeEstoque = qtdeEstoque;
    }

    // equals e hashCode baseados em todos os campos (pode ajustar conforme necessidade)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Produto)) return false;
        Produto produto = (Produto) o;
        return Objects.equals(id, produto.id) &&
               Objects.equals(nome, produto.nome) &&
               Objects.equals(descricao, produto.descricao) &&
               Objects.equals(preco, produto.preco) &&
               Objects.equals(categoria, produto.categoria) &&
               Objects.equals(marca, produto.marca) &&
               Objects.equals(codigoSKU, produto.codigoSKU) &&
               Objects.equals(qtdeEstoque, produto.qtdeEstoque);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, descricao, preco, categoria, marca, codigoSKU, qtdeEstoque);
    }

    // toString para exibir os campos da classe
    @Override
    public String toString() {
        return "Produto{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", preco=" + preco +
                ", categoria=" + categoria +
                ", marca='" + marca + '\'' +
                ", codigoSKU='" + codigoSKU + '\'' +
                ", qtdeEstoque=" + qtdeEstoque +
                '}';
    }
}
