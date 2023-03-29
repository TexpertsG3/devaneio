package br.com.hotel.devaneio.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "quarto")
public class Alojamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_quarto")
    private Integer idAlojamento;
    @Column(name = "nome")
    private String nomeAlojamento;
    @Column(name = "descricao")
    private String descricao;
    @Column(name = "preco")
    private BigDecimal valor;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_hotel")
    private Hotel hotel;

    public Alojamento(Integer idAlojamento) {
        this.idAlojamento = idAlojamento;
    }

    public Alojamento(Integer idAlojamento, String nomeAlojamento) {
        this.idAlojamento = idAlojamento;
        this.nomeAlojamento = nomeAlojamento;
    }

    public Alojamento(String nomeAlojamento, String descricao, BigDecimal valor, Hotel hotel) {
        this.hotel = hotel;
        this.nomeAlojamento = nomeAlojamento;
        this.descricao = descricao;
        this.valor = valor;
    }

    public Alojamento(Integer idAlojamento, String nomeAlojamento, String descricao, BigDecimal valor, Hotel hotel) {
        this.idAlojamento = idAlojamento;
        this.hotel = hotel;
        this.nomeAlojamento = nomeAlojamento;
        this.descricao = descricao;
        this.valor = valor;
    }

    public Alojamento() {

    }

    public Integer getIdAlojamento() {
        return idAlojamento;
    }

    public void setIdAlojamento(Integer idAlojamento) {
        this.idAlojamento = idAlojamento;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public String getNomeAlojamento() {
        return nomeAlojamento;
    }

    public void setNomeAlojamento(String nomeAlojamento) {
        this.nomeAlojamento = nomeAlojamento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {

        return "\nRegistro do Hotel: " + hotel.getIdHotel() + "    " + "Nome: " + hotel.getDadosHotel().getNome()
                + "\nAlojamento - " + this.nomeAlojamento + "\n" + "Valor da diária - R$" + this.valor;
    }

}
