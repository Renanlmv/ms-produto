package com.github.renanlmv.ms.produto.repositories;

import com.github.renanlmv.ms.produto.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
