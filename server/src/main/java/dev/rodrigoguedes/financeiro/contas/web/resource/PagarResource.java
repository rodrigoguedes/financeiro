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

import dev.rodrigoguedes.financeiro.contas.domain.Pagar;
import dev.rodrigoguedes.financeiro.contas.service.PagarService;
import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/financeiro/pagar")
public class PagarResource {

    @Autowired
    private PagarService pagarService;

    @GetMapping
    private ResponseEntity<Page<Pagar>> findAll(
            @RequestParam(value = "search", required = false) Optional<String> search,
            Pageable pageable, HttpServletRequest request) {

        return ResponseEntity.ok(pagarService.findAll(pageable));
    }

}
