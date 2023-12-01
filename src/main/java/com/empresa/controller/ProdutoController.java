package com.empresa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.empresa.model.Produto;
import com.empresa.repositorio.ProdutoRepositorio;

@Component
public class ProdutoController {

	@Autowired
	private ProdutoRepositorio produtoRepositorio;

	public void salvarProduto(String name, double valor, double desconto) {
		Produto produto = new Produto(name, valor, desconto);
		produtoRepositorio.save(produto);

	}

}
