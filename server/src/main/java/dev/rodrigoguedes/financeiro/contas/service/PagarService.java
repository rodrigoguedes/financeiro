package dev.rodrigoguedes.financeiro.contas.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import dev.rodrigoguedes.core.service.CoreService;
import dev.rodrigoguedes.financeiro.contas.domain.Pagar;

@Service
public class PagarService extends CoreService<Pagar, UUID> {

}
