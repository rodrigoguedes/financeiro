package dev.rodrigoguedes.financeiro.contas.domain;

import java.util.UUID;

import javax.money.MonetaryAmount;

import org.hibernate.annotations.CompositeType;

import dev.rodrigoguedes.core.domain.CoreEntity;
import io.hypersistence.utils.hibernate.type.money.MonetaryAmountType;
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import lombok.ToString;

@Entity
@Table(name = "fin_pagar")
@ToString
public class Pagar extends CoreEntity<UUID> {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @Version
    @Column(name = "version")
    Integer version;

    @Column(name = "descricao", length = 100)
    private String descricao;

    @AttributeOverride(name = "amount", column = @Column(name = "valor"))
    @AttributeOverride(name = "currency", column = @Column(name = "moeda"))
    @CompositeType(MonetaryAmountType.class)
    private MonetaryAmount valor;

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

    public MonetaryAmount getValor() {
        return valor;
    }

    public void setValor(MonetaryAmount valor) {
        this.valor = valor;
    }

}
