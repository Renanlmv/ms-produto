package com.github.renanlmv.ms.produto.dto;

import com.github.renanlmv.ms.produto.entities.Categoria;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CategoriaResponseDTO {

    private Long id;
    private String nome;

    public CategoriaResponseDTO(Categoria categoria) {
        id = categoria.getId();
        nome = categoria.getNome();
    }
}
