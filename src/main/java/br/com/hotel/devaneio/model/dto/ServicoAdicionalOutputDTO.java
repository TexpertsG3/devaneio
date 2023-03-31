package br.com.hotel.devaneio.model.dto;

import java.math.BigDecimal;

public class ServicoAdicionalOutputDTO {

    private Integer id;
    private String nome;
    private BigDecimal preco;
    private Integer hotel;

    public ServicoAdicionalOutputDTO() {

    }

    public ServicoAdicionalOutputDTO(Integer id, String nome, BigDecimal preco, Integer hotel) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.hotel = hotel;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public void setHotel(Integer hotel) {
        this.hotel = hotel;
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public Integer getHotel() {
        return hotel;
    }

}
