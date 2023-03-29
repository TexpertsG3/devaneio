package br.com.hotel.devaneio.model;

import jakarta.persistence.*;

@Entity
@Table(name = "dados_hotel")
public class DadosHotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_dados_hotel")
    private Integer idDadosHotel;
    @Column(name = "nome")
    private String nome;
    @Column(name = "cnpj")
    private String cnpj;
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_contato")
    private Contato contato;
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_endereco")
    private Endereco endereco;

    public DadosHotel(String nome, String cnpj, Contato contato, Endereco endereco) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.contato = contato;
        this.endereco = endereco;
    }

    public DadosHotel(Integer idDadosHotel) {
        this.idDadosHotel = idDadosHotel;
    }

    public DadosHotel(String nome, String cnpj) {
        this.nome = nome;
        this.cnpj = cnpj;
    }

    public DadosHotel() {

    }

    public Integer getIdDadosHotel() {
        return idDadosHotel;
    }

    public void setIdDadosHotel(Integer idDadosHotel) {
        this.idDadosHotel = idDadosHotel;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public Contato getContato() {
        return contato;
    }

    public void setContato(Contato contato) {
        this.contato = contato;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
