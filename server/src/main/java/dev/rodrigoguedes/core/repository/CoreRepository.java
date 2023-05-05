package dev.rodrigoguedes.core.repository;

import java.io.Serializable;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoreRepository<T, K extends Serializable> extends JpaRepository<T, K> {

    Optional<T> findOneOptionalById(K id);

    Page<T> findAll(Pageable pageable);

}
