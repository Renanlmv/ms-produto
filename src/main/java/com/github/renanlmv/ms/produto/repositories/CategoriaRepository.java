package com.github.renanlmv.ms.produto.repositories;

import com.github.renanlmv.ms.produto.entities.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
