package dev.rodrigoguedes.financeiro.contas.domain;

import java.util.UUID;

import dev.rodrigoguedes.core.domain.CoreEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import lombok.ToString;

@Entity
@Table(name = "con_categorias")
@ToString
public class Categoria extends CoreEntity<UUID> {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @Version
    @Column(name = "version")
    Integer version;

    @Column(name = "descricao", length = 100)
    private String descricao;

    @Override
    public UUID getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}
