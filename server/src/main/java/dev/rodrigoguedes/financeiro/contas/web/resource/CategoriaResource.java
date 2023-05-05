package dev.rodrigoguedes.financeiro.contas.web.resource;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.rodrigoguedes.financeiro.contas.domain.Categoria;
import dev.rodrigoguedes.financeiro.contas.service.CategoriaService;
import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/financeiro/categoria")
public class CategoriaResource {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    private ResponseEntity<Page<Categoria>> findAll(
            @RequestParam(value = "search", required = false) Optional<String> search,
            Pageable pageable, HttpServletRequest request) {

        return ResponseEntity.ok(categoriaService.findAll(pageable));
    }
}
