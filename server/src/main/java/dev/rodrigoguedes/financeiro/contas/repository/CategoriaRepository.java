package dev.rodrigoguedes.financeiro.contas.repository;

import java.util.UUID;

import org.springframework.stereotype.Repository;

import dev.rodrigoguedes.core.repository.CoreRepository;
import dev.rodrigoguedes.financeiro.contas.domain.Categoria;

@Repository
public interface CategoriaRepository extends CoreRepository<Categoria, UUID> {

    public Categoria findOneByDescricaoIgnoreCase(String descricao);

}
