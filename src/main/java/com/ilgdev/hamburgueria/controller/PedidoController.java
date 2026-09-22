package com.ilgdev.hamburgueria.controller;

import com.ilgdev.hamburgueria.repository.ClienteRepository;
import com.ilgdev.hamburgueria.repository.PedidoRepository;
import com.ilgdev.hamburgueria.repository.ProdutoRepository;
import com.ilgdev.hamburgueria.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private PedidoService pedidoService;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("pedidos", pedidoRepository.findAll());
        return "pedidos/lista";
    }

    @GetMapping("/novo")
    public String formNovo(Model model) {
        model.addAttribute("clientes", clienteRepository.findAll());
        model.addAttribute("produtos", produtoRepository.findAll());
        return "pedidos/form";
    }

    @PostMapping("/salvar")
    public String salvar(@RequestParam Long clienteId,
                         @RequestParam List<Long> produtoId,
                         @RequestParam List<Integer> quantidade) {
        pedidoService.criarPedido(clienteId, produtoId, quantidade);
        return "redirect:/pedidos";
    }

    @GetMapping("/deletar/{id}")
    public String deletar(@PathVariable Long id) {
        pedidoRepository.deleteById(id);
        return "redirect:/pedidos";
    }
}