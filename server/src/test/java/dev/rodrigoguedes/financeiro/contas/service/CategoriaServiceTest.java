package dev.rodrigoguedes.financeiro.contas.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import dev.rodrigoguedes.core.exception.DuplicateRecordException;
import dev.rodrigoguedes.financeiro.contas.domain.Categoria;
import dev.rodrigoguedes.financeiro.contas.repository.CategoriaRepository;

@ExtendWith(MockitoExtension.class)
public class CategoriaServiceTest {

    private CategoriaService categoriaService;

    @Mock
    private CategoriaRepository categoriaRepositoryMock;

    @BeforeEach
    public void setUp() {
        this.categoriaService = new CategoriaService(this.categoriaRepositoryMock);
    }

    @Test
	public void validaCategoriaComDescricaoJaUtilizada() {
		when(this.categoriaRepositoryMock.findOneByDescricaoIgnoreCase(any())).thenReturn(criaCategoria());

		Categoria categoria = new Categoria();
		categoria.setDescricao("Test");

		Assertions.assertThrows(DuplicateRecordException.class, () -> this.categoriaService.save(categoria));
	}

    private Categoria criaCategoria() {
        final Categoria categoria = new Categoria();
        categoria.setDescricao("test");
        return categoria;
    }
}
