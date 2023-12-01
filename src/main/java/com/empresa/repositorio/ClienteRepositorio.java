package com.empresa.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.empresa.model.Cliente;

public interface ClienteRepositorio extends JpaRepository<Cliente, Long> {

}
