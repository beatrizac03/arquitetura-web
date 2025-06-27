package com.api.authjwt.models;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "subcategoriasProduto")
@EqualsAndHashCode(exclude = "subcategoriasProduto")
public class CategoriaProduto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeCategoria;

    @OneToMany(mappedBy = "categoriaProduto", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SubcategoriaProduto> subcategoriasProduto;
}
