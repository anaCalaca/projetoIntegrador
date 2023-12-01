package com.empresa;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.model.Cliente;

@RestController
public class MeuControler {
	
	@GetMapping("/cadastrar/cliente")
	public void cliente() {
		Cliente cliente = new Cliente("ana", "4569582", "569836457", "ana@gmail.com", "bairro pipipi");
	}
//	Cliente cliente = new Cliente(null, null, null, null, null)
	
	
//	public String cliente() {
//		return "teste";
//	}

}
