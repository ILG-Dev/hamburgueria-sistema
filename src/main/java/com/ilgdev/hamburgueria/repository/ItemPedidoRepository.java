package com.ilgdev.hamburgueria.repository;

import com.ilgdev.hamburgueria.model.ItemPedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Long> {
}