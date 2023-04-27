package dev.rodrigoguedes.financeiro.contas.domain;

import java.util.UUID;

import dev.rodrigoguedes.core.domain.CoreEntity;

public class Pagar extends CoreEntity<UUID> {

    private UUID id;

    @Override
    public UUID getId() {
        return id;
    }

}
