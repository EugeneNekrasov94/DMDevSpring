package com.example.database.repos;

import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface CRUDRepository<K,E> {
    Optional<E> findById(K id);
    void delete(E entity);
}
