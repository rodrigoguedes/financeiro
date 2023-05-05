package dev.rodrigoguedes.financeiro.contas.service;

import java.util.Objects;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.rodrigoguedes.core.exception.DuplicateRecordException;
import dev.rodrigoguedes.core.service.CoreService;
import dev.rodrigoguedes.financeiro.contas.domain.Categoria;
import dev.rodrigoguedes.financeiro.contas.repository.CategoriaRepository;

@Service
public class CategoriaService extends CoreService<Categoria, UUID> {

    private static final String DESCRICAO_CATEGORIA_JA_UTILIZADA_MESSAGE = "Descrição da Categoria %s já esta sendo utilizado. Escolha outra descrição";

    private CategoriaRepository categoriaRepository;

    @Autowired
    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    @Override
    protected void beforeInsert(Categoria entity) {
        Categoria categoria = this.categoriaRepository.findOneByDescricaoIgnoreCase(entity.getDescricao());
        if (Objects.nonNull(categoria)) {
            throw new DuplicateRecordException(String.format(
                    DESCRICAO_CATEGORIA_JA_UTILIZADA_MESSAGE, entity.getDescricao()));
        }
    }

    @Override
    protected void beforeUpdate(Categoria entity) {
        Categoria categoria = this.categoriaRepository.findOneByDescricaoIgnoreCase(entity.getDescricao());
        if (Objects.nonNull(categoria) && !Objects.equals(categoria.getId(), entity.getId())) {
            throw new DuplicateRecordException(String.format(
                    DESCRICAO_CATEGORIA_JA_UTILIZADA_MESSAGE, entity.getDescricao()));
        }
    }

}
