package com.ilgdev.hamburgueria.repository;

import com.ilgdev.hamburgueria.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}