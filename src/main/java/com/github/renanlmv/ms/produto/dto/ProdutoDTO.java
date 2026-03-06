package com.github.renanlmv.ms.produto.dto;

import com.github.renanlmv.ms.produto.entities.Produto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ProdutoDTO {

    private Long id;

    @NotBlank(message = "Campo nome é requerido")
    @Size(min = 3, max = 100, message = "O nome deve ter entre 3 e 100 caracteres")
    private String nome;

    @NotBlank(message = "Campo descrição é requerido")
    @Size(min = 10, message = "A descrição deve ter no mínimo 10 caracteres")
    private String descricao;

    @NotNull(message = "Campo valor é requerido")
    @Positive(message = "Campo valor deve ser um número positivo maior que zero")
    private Double valor;

    @NotNull(message = "Campo categoria é requerido")
    private CategoriaDTO categoria;

    public ProdutoDTO(Produto produto) {
        id = produto.getId();
        nome = produto.getNome();
        descricao = produto.getDescricao();
        valor = produto.getValor();
        categoria = new CategoriaDTO(produto.getCategoria());
    }
}
