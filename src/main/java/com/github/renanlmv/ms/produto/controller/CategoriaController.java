package com.github.renanlmv.ms.produto.controller;

import com.github.renanlmv.ms.produto.dto.CategoriaDTO;
import com.github.renanlmv.ms.produto.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public ResponseEntity<List<CategoriaDTO>> getAllCategorias() {
        List<CategoriaDTO> categorias = categoriaService.findAllCategories();
        return ResponseEntity.ok(categorias);
    }
}
