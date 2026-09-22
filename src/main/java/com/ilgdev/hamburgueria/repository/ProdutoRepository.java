package com.ilgdev.hamburgueria.repository;

import com.ilgdev.hamburgueria.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}