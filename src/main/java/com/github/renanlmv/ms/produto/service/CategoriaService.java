package com.github.renanlmv.ms.produto.service;

import com.github.renanlmv.ms.produto.dto.CategoriaDTO;
import com.github.renanlmv.ms.produto.entities.Categoria;
import com.github.renanlmv.ms.produto.exceptions.DatabaseException;
import com.github.renanlmv.ms.produto.exceptions.ResourceNotFoundException;
import com.github.renanlmv.ms.produto.repositories.CategoriaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
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

    @Transactional
    public CategoriaDTO saveCategoria(CategoriaDTO categoriaDTO) {
        Categoria categoria = new Categoria();
        copyDtoToCategoria(categoriaDTO, categoria);

        // salva a entidade no banco e retorna a versão atualizada com id gerado pelo banco
        categoria = categoriaRepository.save(categoria);
        return new CategoriaDTO(categoria);
    }

    public void copyDtoToCategoria(CategoriaDTO categoriaDTO, Categoria categoria) {

        categoria.setNome(categoriaDTO.getNome());
        categoria.setProdutos(categoria.getProdutos());
    }

    @Transactional
    public CategoriaDTO updateCategoria(Long id, CategoriaDTO categoriaDTO) {

        try {
            Categoria categoria = categoriaRepository.getReferenceById(id);
            copyDtoToCategoria(categoriaDTO, categoria);
            categoria = categoriaRepository.save(categoria);
            return new CategoriaDTO(categoria);
        } catch (EntityNotFoundException ex) {
            throw new ResourceNotFoundException("Recurso não encontrado. ID: " + id);
        }
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void deleteCategoriaById(Long id) {

        if (!categoriaRepository.existsById(id)) {
            throw new ResourceNotFoundException("Recurso não encontrado. ID " + id);
        }

        try {
            categoriaRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Não foi possível excluir a categoria. " +
                    "Existem produtos associados a ela");
        }
    }

}
