package com.github.renanlmv.ms.produto.controller;

import com.github.renanlmv.ms.produto.dto.ProdutoDTO;
import com.github.renanlmv.ms.produto.dto.ProdutoInputDTO;
import com.github.renanlmv.ms.produto.dto.ProdutoResponseDTO;
import com.github.renanlmv.ms.produto.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public ResponseEntity<List<ProdutoDTO>> getAllProdutos() {

        List<ProdutoDTO> list = produtoService.findAllProdutos();

        return ResponseEntity.ok(list); // ok envia o código 200, nesse caso especificando para renderizar a lista no body
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoDTO> getProdutoById(@PathVariable Long id) {

        ProdutoDTO produtoDTO = produtoService.findProdutoById(id);

        return ResponseEntity.ok(produtoDTO);
    }
}
