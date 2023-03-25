package br.com.hotel.devaneio.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
@Entity
@Table(name = "servico_adicional")
public class ServicoAdicional {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_servico_adicional")
	private Integer idServico;
	@Column(name = "nome")
	private String nomeServico;
	@Column(name = "preco")
	private BigDecimal valorServico;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_hotel")
	private Hotel idHotel;

	public ServicoAdicional(String nomeServico, BigDecimal valorServico, Hotel idHotel) {
		this.idHotel = idHotel;
		this.nomeServico = nomeServico;
		this.valorServico = valorServico;
	}

	public ServicoAdicional() {

	}

	public Hotel getIdHotel() {
		return idHotel;
	}

	public void setIdHotel(Hotel hotel) {
		this.idHotel = hotel;
	}

	public Integer getIdServico() {
		return idServico;
	}

	public void setIdServico(Integer idServico) {
		this.idServico = idServico;
	}

	public String getNomeServico() {
		return nomeServico;
	}

	public BigDecimal getValorServico() {
		return valorServico;
	}

	public void setNomeServico(String nomeServico) {
		this.nomeServico = nomeServico;
	}

	public void setValorServico(BigDecimal valorServico) {
		this.valorServico = valorServico;
	}

	@Override
	public String toString() {
		return "\nNome: " + this.nomeServico + "\n" + "Valor - R$" + this.valorServico + "\n";
	}

}
