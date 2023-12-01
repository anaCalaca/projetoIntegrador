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

@Entity
@Table(name="produto_tb")
@NoArgsConstructor //criar construtor
@AllArgsConstructor //construtor com todos os campos
@Getter //gerar get
@Setter //gerar set 
public class Produto {
	
	//definir como chave primaria
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;

		//mudar nome da coluna
		@Column(name="produto_name")
		private String name;
		
		@Column(name="produto_valor")
		private double valor;
		
		@Column(name="produto_desconto")
		private double desconto;

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

		public double getValor() {
			return valor;
		}

		public void setValor(double valor) {
			this.valor = valor;
		}

		public double getDesconto() {
			return desconto;
		}

		public void setDesconto(double desconto) {
			this.desconto = desconto;
		}

		public Produto(String name, double valor, double desconto) {
			super();
			this.name = name;
			this.valor = valor;
			this.desconto = desconto;
		}
}
