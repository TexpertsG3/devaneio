package br.com.hotel.devaneio.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "hotel")
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_hotel")
    private Integer idHotel;
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_dados_hotel")
    private DadosHotel dadosHotel;
    @Transient
    private List<Alojamento> listaDeAlojamentos = new ArrayList<>();
    @Transient
    private Set<Funcionario> listaDeFuncionarios = new HashSet<>();
    @Transient
    private List<Reserva> listaDeReservas = new ArrayList<>();
    @Transient
    private List<ServicoAdicional> listaDeServicos;

    public Hotel(Integer idHotel) {
        this.idHotel = idHotel;
    }

    public Hotel(DadosHotel dadosHotel, List<Alojamento> listaDeAlojamentos, List<ServicoAdicional> listaDeServicos,
                 Set<Funcionario> listaDeFuncionarios, List<Reserva> listaDeReservas) {

        this.dadosHotel = dadosHotel;
        this.listaDeAlojamentos = listaDeAlojamentos;
        this.listaDeFuncionarios = listaDeFuncionarios;
        this.listaDeReservas = listaDeReservas;
        this.listaDeServicos = listaDeServicos;
    }

    public Hotel(Integer idHotel, DadosHotel dadosHotel) {
        this.idHotel = idHotel;
        this.dadosHotel = dadosHotel;
    }

    public Hotel(DadosHotel dadosHotel) {
        this.dadosHotel = dadosHotel;
    }

    public Hotel() {

    }

    public Integer getIdHotel() {
        return idHotel;
    }

    public void setIdHotel(Integer idHotel) {
        this.idHotel = idHotel;
    }

    public DadosHotel getDadosHotel() {
        return dadosHotel;
    }

    public void setDadosHotel(DadosHotel dadosHotel) {
        this.dadosHotel = dadosHotel;
    }

    public List<Alojamento> getListaDeAlojamentos() {
        return listaDeAlojamentos;
    }

    public void setListaDeAlojamentos(List<Alojamento> listaDeAlojamentos) {
        this.listaDeAlojamentos = listaDeAlojamentos;
    }

    public Set<Funcionario> getListaDeFuncionarios() {
        return listaDeFuncionarios;
    }

    public void setListaDeFuncionarios(Set<Funcionario> listaDeFuncionarios) {
        this.listaDeFuncionarios = listaDeFuncionarios;
    }

    public List<Reserva> getListaDeReservas() {
        return listaDeReservas;
    }

    public void setListaDeReservas(List<Reserva> listaDeReservas) {
        this.listaDeReservas = listaDeReservas;
    }

    public List<ServicoAdicional> getListaDeServicos() {
        return listaDeServicos;
    }

    public void setListaDeServicos(List<ServicoAdicional> listaDeServicos) {
        this.listaDeServicos = listaDeServicos;
    }

    public static BigDecimal somaServicos(List<ServicoAdicional> servicos) {
        BigDecimal resultado = BigDecimal.ZERO;
        for (ServicoAdicional servico : servicos) {
            resultado = resultado.add(servico.getPreco());
        }
        return resultado;
    }

    @Override
    public String toString() {
        return "\nRegistro: " + idHotel + "\nHotel: " + dadosHotel.getNome() + "\nCNPJ: " + dadosHotel.getCnpj() + "\nEmail: " + dadosHotel.getContato().getEmail()
                + "\nTelefone: " + dadosHotel.getContato().getTelefone() + " / Celular: " + dadosHotel.getContato().getCelular()
                + "\nEndereco: " + dadosHotel.getEndereco().getRua() + ", " + dadosHotel.getEndereco().getNumero() + " - Bairro: " + dadosHotel.getEndereco().getBairro()
                + "\nCidade: " + dadosHotel.getEndereco().getCidade() + " / " + dadosHotel.getEndereco().getUf() + "\nComplemento: " + dadosHotel.getEndereco().getComplemento() + "\n";
    }

}
