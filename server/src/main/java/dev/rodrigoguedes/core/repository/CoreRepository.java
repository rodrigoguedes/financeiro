package dev.rodrigoguedes.core.repository;

import java.io.Serializable;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CoreRepository<T, K extends Serializable>
        extends org.springframework.data.repository.Repository<T, K>, JpaSpecificationExecutor<T> {

    Optional<T> findOneOptionalById(K id);

    T findOneById(K id);

    Iterable<T> findAll(Sort sort);

    Page<T> findAll(Pageable pageable);

}
