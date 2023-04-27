package dev.rodrigoguedes.financeiro.contas.repository;

import java.util.UUID;

import org.springframework.stereotype.Component;

import dev.rodrigoguedes.core.repository.CoreRepository;
import dev.rodrigoguedes.financeiro.contas.domain.Pagar;

@Component
public interface PagarRepository extends CoreRepository<Pagar, UUID> {

}
