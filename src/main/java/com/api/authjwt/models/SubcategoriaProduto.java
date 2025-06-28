package com.api.authjwt.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.util.Objects;

@Entity
public class SubcategoriaProduto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeSubcategoria;

    @ManyToOne
    @JoinColumn(name = "id_categoria")
    @JsonIgnore
    private CategoriaProduto categoriaProduto;

    // Construtor sem argumentos
    public SubcategoriaProduto() {
    }

    // Construtor com argumentos
    public SubcategoriaProduto(Long id, String nomeSubcategoria, CategoriaProduto categoriaProduto) {
        this.id = id;
        this.nomeSubcategoria = nomeSubcategoria;
        this.categoriaProduto = categoriaProduto;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeSubcategoria() {
        return nomeSubcategoria;
    }

    public void setNomeSubcategoria(String nomeSubcategoria) {
        this.nomeSubcategoria = nomeSubcategoria;
    }

    public CategoriaProduto getCategoriaProduto() {
        return categoriaProduto;
    }

    public void setCategoriaProduto(CategoriaProduto categoriaProduto) {
        this.categoriaProduto = categoriaProduto;
    }

    // equals e hashCode excluindo categoriaProduto

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SubcategoriaProduto)) return false;
        SubcategoriaProduto that = (SubcategoriaProduto) o;
        return Objects.equals(id, that.id) &&
               Objects.equals(nomeSubcategoria, that.nomeSubcategoria);
               // categoriaProduto excluído conforme lombok @EqualsAndHashCode(exclude)
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nomeSubcategoria);
        // categoriaProduto excluído conforme lombok @EqualsAndHashCode(exclude)
    }

    // toString excluindo categoriaProduto
    @Override
    public String toString() {
        return "SubcategoriaProduto{" +
                "id=" + id +
                ", nomeSubcategoria='" + nomeSubcategoria + '\'' +
                '}';
    }
}
