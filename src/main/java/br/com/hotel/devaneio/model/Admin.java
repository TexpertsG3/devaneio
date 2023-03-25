//package br.com.hotel.devaneio.model;
//
//import jakarta.persistence.*;
//
//@Entity
//@Table(name = "administrador")
//public class Admin {
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(name = "id_administrador")
//	private Integer idAdmin;
//	@Column(name = "nome_admin")
//	private String nome;
//	@Column(name = "senha_admin")
//	private String senha;
//	@OneToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "id_contato")
//	private Contato contato;
//	@OneToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "id_endereco")
//	private Endereco endereco;
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "id_hotel")
//	private Hotel hotel;
//
//	public Admin(String nome, String senha, Contato contato, Endereco endereco, Hotel hotel) {
//		this.nome = nome;
//		this.senha = senha;
//		this.contato = contato;
//		this.endereco = endereco;
//		this.hotel = hotel;
//	}
//
//	public Admin() {
//
//	}
//
//	public Integer getIdAdmin() {
//		return idAdmin;
//	}
//
//	public void setIdAdmin(Integer idAdmin) {
//		this.idAdmin = idAdmin;
//	}
//
//	public String getNome() {
//		return nome;
//	}
//
//	public void setNome(String nome) {
//		this.nome = nome;
//	}
//
//	public String getSenha() {
//		return senha;
//	}
//
//	public void setSenha(String senha) {
//		this.senha = senha;
//	}
//
//	public Contato getContato() {
//		return contato;
//	}
//
//	public void setContato(Contato contato) {
//		this.contato = contato;
//	}
//
//	public Endereco getEndereco() {
//		return endereco;
//	}
//
//	public void setEndereco(Endereco endereco) {
//		this.endereco = endereco;
//	}
//
//	public Hotel getHotel() {
//		return hotel;
//	}
//
//	public void setHotel(Hotel hotel) {
//		this.hotel = hotel;
//	}
//
//	@Override
//	public String toString() {
//		return "Admin{" +
//				"idAdmin=" + idAdmin +
//				", nome='" + nome + '\'' +
//				", senha='" + senha + '\'' +
//				", contato=" + contato +
//				", endereco=" + endereco +
//				", hotel=" + hotel +
//				'}';
//	}
//}
