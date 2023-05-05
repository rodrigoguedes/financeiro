package dev.rodrigoguedes.financeiro.contas.repository;

import java.util.UUID;

import org.springframework.stereotype.Repository;

import dev.rodrigoguedes.core.repository.CoreRepository;
import dev.rodrigoguedes.financeiro.contas.domain.Pagar;

@Repository
public interface PagarRepository extends CoreRepository<Pagar, UUID> {

}
