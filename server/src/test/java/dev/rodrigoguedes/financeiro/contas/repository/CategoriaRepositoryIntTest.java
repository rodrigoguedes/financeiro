package dev.rodrigoguedes.financeiro.contas.repository;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

import java.util.Optional;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.springtestdbunit.annotation.DatabaseOperation;
import com.github.springtestdbunit.annotation.DatabaseSetup;

import dev.rodrigoguedes.financeiro.FinanceiroIntegrationTests;
import dev.rodrigoguedes.financeiro.contas.domain.Categoria;

@DatabaseSetup(type = DatabaseOperation.INSERT, value = "classpath:/db/dbunit/financeiro/contas/Categorias.xml")
public class CategoriaRepositoryIntTest extends FinanceiroIntegrationTests {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Test
    public void findOneByDescricaoIgnoreCase() {
        Categoria categoria = this.categoriaRepository.findOneByDescricaoIgnoreCase("casa");
        assertThat(categoria, notNullValue());
        assertThat(categoria.getId(), is(UUID.fromString("299873c7-c006-4b64-985b-98ac91a6b165")));
    }

    @Test
    public void save() {
        Categoria categoria = new Categoria();
        categoria.setDescricao("Carro");

        Categoria categoriaSalva = this.categoriaRepository.save(categoria);

        assertThat(categoriaSalva, notNullValue());
        assertThat(categoriaSalva.getDescricao(), is(categoria.getDescricao()));
    }

    @Test
    public void update() {
        Categoria categoria = new Categoria();
        categoria.setDescricao("Despesas de Carro");

        Categoria categoriaSalva = this.categoriaRepository.save(categoria);

        categoriaSalva.setDescricao("Carro");

        Categoria categoriaAtual = this.categoriaRepository.save(categoriaSalva);

        assertThat(categoriaAtual, notNullValue());
        assertThat(categoriaAtual.getId(), is(categoriaSalva.getId()));
        assertThat(categoriaAtual.getDescricao(), is(categoriaSalva.getDescricao()));
    }

    @Test
    public void delete() {
        Categoria categoria = this.categoriaRepository.findOneByDescricaoIgnoreCase("Casa");
        assertThat(categoria, notNullValue());

        Categoria categoriaSalva = this.categoriaRepository.save(categoria);

        this.categoriaRepository.delete(categoriaSalva);

        Optional<Categoria> categoriaRemovida = this.categoriaRepository.findById(categoria.getId());

        assertThat(categoriaRemovida.isPresent(), is(false));
    }
}
