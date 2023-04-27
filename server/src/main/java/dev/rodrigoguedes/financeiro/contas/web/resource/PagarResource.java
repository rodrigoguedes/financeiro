package dev.rodrigoguedes.financeiro.contas.web.resource;

import org.springframework.beans.factory.annotation.Autowired;

import dev.rodrigoguedes.financeiro.contas.service.PagarService;
import jakarta.annotation.Resource;

@Resource
public class PagarResource {

    @Autowired
    private PagarService pagarService;
}
