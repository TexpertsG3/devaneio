package br.com.hotel.devaneio.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "servico_adicional")
public class ServicoAdicional {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_servico_adicional")
    private Integer id;
    @Column(name = "nome")
    private String nome;
    @Column(name = "preco")
    private BigDecimal preco;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_hotel")
    private Hotel hotel;

    public ServicoAdicional(String nome, BigDecimal preco, Hotel hotel) {
        this.hotel = hotel;
        this.nome = nome;
        this.preco = preco;
    }

    public ServicoAdicional() {

    }

    public ServicoAdicional(Integer id, String nome, BigDecimal preco, Hotel hotel) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.hotel = hotel;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "\nNome: " + this.nome + "\n" + "Valor - R$" + this.preco + "\n";
    }

}
