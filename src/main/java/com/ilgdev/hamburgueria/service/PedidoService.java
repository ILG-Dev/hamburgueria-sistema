package com.ilgdev.hamburgueria.service;

import com.ilgdev.hamburgueria.model.*;
import com.ilgdev.hamburgueria.repository.ClienteRepository;
import com.ilgdev.hamburgueria.repository.PedidoRepository;
import com.ilgdev.hamburgueria.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    public void criarPedido(Long clienteId, List<Long> produtoIds, List<Integer> quantidades) {
        Cliente cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        Pedido pedido = new Pedido();
        pedido.setCliente(cliente);
        pedido.setDataHora(LocalDateTime.now());
        pedido.setStatus(StatusPedido.RECEBIDO);

        BigDecimal total = BigDecimal.ZERO;
        List<ItemPedido> itens = new ArrayList<>();

        for (int i = 0; i < produtoIds.size(); i++) {
            int quantidade = quantidades.get(i);

            if (quantidade <= 0) {
                continue;
            }

            Produto produto = produtoRepository.findById(produtoIds.get(i))
                    .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

            ItemPedido item = new ItemPedido();
            item.setPedido(pedido);
            item.setProduto(produto);
            item.setQuantidade(quantidade);
            item.setPrecoUnitario(produto.getPreco());
            itens.add(item);

            total = total.add(produto.getPreco().multiply(BigDecimal.valueOf(quantidade)));
        }

        pedido.setItens(itens);
        pedido.setValorTotal(total);

        pedidoRepository.save(pedido);
    }
}