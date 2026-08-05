package com.github.renanlmv.ms.produto.dto;

import com.github.renanlmv.ms.produto.entities.Produto;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProdutoRequestDTO {

    @NotBlank(message = "Campo nome é requerido")
    @Size(min = 3, max = 100, message = "O nome deve ter entre 3 e 100 caracteres")
    @Schema(example = "Produto exemplo")
    private String nome;

    @NotBlank(message = "Campo descrição é requerido")
    @Size(min = 10, message = "A descrição deve ter no mínimo 10 caracteres")
    private String descricao;

    @NotNull(message = "Campo valor é requerido")
    @Positive(message = "Campo valor deve ser um número positivo maior que zero")
    private Double valor;

    @NotNull(message = "Campo categoria é requerido")
    private Long categoriaId;

    public ProdutoRequestDTO(Produto produto) {
        nome = produto.getNome();
        descricao = produto.getDescricao();
        valor = produto.getValor();
        categoriaId = produto.getCategoria().getId();
    }
}
