package br.com.hotel.devaneio.model;

import jakarta.persistence.*;

@Entity
@Table(name = "cargo")
public class Cargo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cargo")
	private Integer idCargo;
	@Column(name = "nome_cargo")
	private String nome;
	@Column(name = "descricao_cargo")
	private String descricao;

	public Cargo(String nome) {
		this.nome = nome;

	}

	public Cargo() {

	}

	public Integer getIdCargo() {
		return idCargo;
	}

	public void setIdCargo(Integer idCargo) {
		this.idCargo = idCargo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return this.nome;
	}
}
