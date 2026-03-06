package com.github.renanlmv.ms.produto.service;

import com.github.renanlmv.ms.produto.dto.CategoriaDTO;
import com.github.renanlmv.ms.produto.entities.Categoria;
import com.github.renanlmv.ms.produto.exceptions.ResourceNotFoundException;
import com.github.renanlmv.ms.produto.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Transactional(readOnly = true)
    public List<CategoriaDTO> findAllCategories () {
        return categoriaRepository.findAll().stream().map(CategoriaDTO::new).toList();
    }

    @Transactional(readOnly = true)
    public CategoriaDTO findCategoriaById(Long id) {

        Categoria categoria = categoriaRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Recurso não encontrado. ID: " + id)
        );

        return new CategoriaDTO(categoria);
    }
}
