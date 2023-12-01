package com.empresa.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity //ser reconhecido no banco
@Table(name = "cliente_tb")
@NoArgsConstructor // criar construtor
@AllArgsConstructor // construtor com todos os campos
@Getter // gerar get
@Setter // gerar set
public class Cliente {

	// definir como chave primaria
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	// mudar nome da coluna
	@Column(name = "cliente_name")
	private String name;

	@Column(name = "cliente_cpf")
	private String cpf;

	@Column(name = "cliente_telefone")
	private String telefone;

	@Column(name = "cliente_email")
	private String email;

	@Column(name = "cliente_endereco")
	private String endereco;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEndereço() {
		return endereco;
	}

	public void setEndereço(String endereco) {
		this.endereco = endereco;
	}

	public Cliente(String name, String cpf, String telefone, String email, String endereco) {
		super();
//		this.id = id;
		this.name = name;
		this.cpf = cpf;
		this.telefone = telefone;
		this.email = email;
		this.endereco = endereco;
	}
}
