package com.empresa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.empresa.model.Cliente;
import com.empresa.repositorio.ClienteRepositorio;

// TORNA A CLASSE POSSIVEL DE FAZER DE FORMA AUTOMATICA A COMUNICAÇAO
@Component 
public class ClienteController {
	
	//FAZER DE FORMA AUTOMATICA A COMUNICAÇAO PARA O BANCO
	@Autowired  
	private ClienteRepositorio clienteRepositorio;
	
	public void salvarCliente(String name, String cpf, String telefone, String email, String endereco) {
		Cliente cliente = new Cliente(name, cpf, telefone, email, endereco);
		clienteRepositorio.save(cliente);

	}
	
}
