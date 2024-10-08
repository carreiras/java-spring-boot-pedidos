package com.carreiras.java_spring_boot_pedidos.rest.controller;

import com.carreiras.java_spring_boot_pedidos.domain.entity.Produto;
import com.carreiras.java_spring_boot_pedidos.rest.controller.utils.URL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.carreiras.java_spring_boot_pedidos.rest.dto.ProdutoDto;
import com.carreiras.java_spring_boot_pedidos.service.ProdutoService;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Produto> find(@PathVariable Integer id) {
        Produto produto = produtoService.find(id);
        return ResponseEntity.ok().body(produto);
    }

    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public ResponseEntity<Page<ProdutoDto>> findPage(
            @RequestParam(value = "nome", defaultValue = "") String nome,
            @RequestParam(value = "categorias", defaultValue = "") String categorias,
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
            @RequestParam(value = "orderBy", defaultValue = "nome") String orderBy,
            @RequestParam(value = "direction", defaultValue = "ASC") String direction) {
        String nomeDecoded = URL.decodeParam(nome);
        List<Integer> ids = URL.decodeIntList(categorias);
        Page<Produto> produtoPage = produtoService.search(nomeDecoded, ids, page, linesPerPage, orderBy, direction);
        Page<ProdutoDto> produtoPageDto = produtoPage.map(produto -> new ProdutoDto(produto));
        return ResponseEntity.ok().body(produtoPageDto);
    }
}
