package com.api.authjwt.models;

import java.util.List;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class CategoriaProduto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeCategoria;

    @OneToMany(mappedBy = "categoriaProduto", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SubcategoriaProduto> subcategoriasProduto;

    // Construtor sem argumentos
    public CategoriaProduto() {
    }

    // Construtor com argumentos
    public CategoriaProduto(Long id, String nomeCategoria, List<SubcategoriaProduto> subcategoriasProduto) {
        this.id = id;
        this.nomeCategoria = nomeCategoria;
        this.subcategoriasProduto = subcategoriasProduto;
    }

    // Getters e setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeCategoria() {
        return nomeCategoria;
    }

    public void setNomeCategoria(String nomeCategoria) {
        this.nomeCategoria = nomeCategoria;
    }

    public List<SubcategoriaProduto> getSubcategoriasProduto() {
        return subcategoriasProduto;
    }

    public void setSubcategoriasProduto(List<SubcategoriaProduto> subcategoriasProduto) {
        this.subcategoriasProduto = subcategoriasProduto;
    }

    // equals e hashCode sem considerar subcategoriasProduto
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CategoriaProduto)) return false;
        CategoriaProduto that = (CategoriaProduto) o;
        return Objects.equals(id, that.id) &&
               Objects.equals(nomeCategoria, that.nomeCategoria);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nomeCategoria);
    }

    // toString excluindo subcategoriasProduto para evitar recursão
    @Override
    public String toString() {
        return "CategoriaProduto{" +
                "id=" + id +
                ", nomeCategoria='" + nomeCategoria + '\'' +
                '}';
    }
}
