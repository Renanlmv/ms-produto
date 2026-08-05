package com.github.renanlmv.ms.produto.dto;

import com.github.renanlmv.ms.produto.entities.Categoria;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CategoriaRequestDTO {

    @NotBlank(message = "Campo não pode estar vazio, nulo ou em branco")
    @Size(min = 3, max = 100, message = "O nome deve ter entre 3 e 100 caracteres")
    @Schema(example = "Ferramentas")
    private String nome;

    public CategoriaRequestDTO(Categoria categoria) {
        nome = categoria.getNome();
    }
}
