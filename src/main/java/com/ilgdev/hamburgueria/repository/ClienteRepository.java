package com.ilgdev.hamburgueria.repository;

import com.ilgdev.hamburgueria.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}