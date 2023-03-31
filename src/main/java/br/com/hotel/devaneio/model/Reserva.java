package br.com.hotel.devaneio.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "reserva")
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reserva")
    private Integer idReserva;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_hotel")
    private Hotel hotel;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_quarto")
    private Alojamento quarto;
    @Column(name = "check_in")
    private LocalDate checkIn;
    @Column(name = "check_out")
    private LocalDate checkOut;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_hospede")
    private Hospede hospede;
    @Column(name = "qtd_adultos")
    private Integer quantidadeAdultos;
    @Column(name = "qtd_criancas")
    private Integer quantidadeCriancas;
    @Column(name = "total_servicos")
    private BigDecimal totalServicos;
    @Column(name = "total_reserva")
    private BigDecimal totalReserva;
    @Transient
    private Set<ServicoAdicional> servicoAdicional = new HashSet<>();

    public Reserva(Integer idReserva) {
        this.idReserva = idReserva;
    }

    public Reserva(Integer idReserva, Hospede hospede, LocalDate checkIn, LocalDate checkOut, Integer quantidadeAdultos,
                   Integer quantidadeCriancas, Alojamento quarto, Hotel hotel, BigDecimal totalServicos, Set<ServicoAdicional> servicoAdicional,
                   BigDecimal totalReserva) {
        this.idReserva = idReserva;
        this.hospede = hospede;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.quantidadeAdultos = quantidadeAdultos;
        this.quantidadeCriancas = quantidadeCriancas;
        this.quarto = quarto;
        this.hotel = hotel;
        this.totalServicos = totalServicos;
        this.totalReserva = totalReserva;
        this.servicoAdicional = servicoAdicional;
    }

    public Reserva(Hotel hotel, Alojamento quarto, LocalDate checkIn, LocalDate checkOut, Hospede hospede,
                   Integer quantidadeAdultos, Integer quantidadeCriancas, BigDecimal totalServicos, BigDecimal totalReserva) {
        this.hotel = hotel;
        this.quarto = quarto;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.hospede = hospede;
        this.quantidadeAdultos = quantidadeAdultos;
        this.quantidadeCriancas = quantidadeCriancas;
        this.totalServicos = totalServicos;
        this.totalReserva = totalReserva;
    }

    public Reserva() {

    }

    public Integer getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(Integer idReserva) {
        this.idReserva = idReserva;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public Alojamento getQuarto() {
        return quarto;
    }

    public void setQuarto(Alojamento quarto) {
        this.quarto = quarto;
    }

    public LocalDate getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(LocalDate checkIn) {
        this.checkIn = checkIn;
    }

    public LocalDate getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(LocalDate checkOut) {
        this.checkOut = checkOut;
    }

    public Hospede getHospede() {
        return hospede;
    }

    public void setHospede(Hospede hospede) {
        this.hospede = hospede;
    }

    public Integer getQuantidadeAdultos() {
        return quantidadeAdultos;
    }

    public void setQuantidadeAdultos(Integer quantidadeAdultos) {
        this.quantidadeAdultos = quantidadeAdultos;
    }

    public Integer getQuantidadeCriancas() {
        return quantidadeCriancas;
    }

    public void setQuantidadeCriancas(Integer quantidadeCriancas) {
        this.quantidadeCriancas = quantidadeCriancas;
    }

    public BigDecimal getTotalServicos() {
        return totalServicos;
    }

    public void setTotalServicos(BigDecimal totalServicos) {
        this.totalServicos = totalServicos;
    }

    public BigDecimal getTotalReserva() {
        return totalReserva;
    }

    public void setTotalReserva(BigDecimal totalReserva) {
        this.totalReserva = totalReserva;
    }

    public BigDecimal calculaValorDiaria(Reserva reserva) {
        BigDecimal totalDiaria = BigDecimal.ZERO;

        if (quantidadeAdultos > 2) {
            BigDecimal temp = new BigDecimal(quantidadeAdultos - 2).multiply(BigDecimal.valueOf(10.00));
            totalDiaria = totalDiaria.add(temp);
        }

        if (quantidadeCriancas > 2) {
            BigDecimal temp = new BigDecimal(quantidadeCriancas - 2).multiply(BigDecimal.valueOf(5.00));
            totalDiaria = totalDiaria.add(temp);
        }

        Integer dias = Integer.valueOf(checkOut.getDayOfYear() - checkIn.getDayOfYear());

        totalDiaria = totalDiaria.add(quarto.getValor());
        totalDiaria = totalDiaria.multiply(new BigDecimal(dias));

        return totalDiaria;
    }

    public BigDecimal calculaTotalReserva(Set<ServicoAdicional> servicoAdicional, Reserva reserva) {
        BigDecimal diaria = calculaValorDiaria(reserva);
        this.totalServicos = calculaValorServico(servicoAdicional);

        this.totalReserva = this.totalReserva.add(diaria).add(this.totalServicos);

        return this.totalReserva;
    }

    public BigDecimal calculaValorServico(Set<ServicoAdicional> servicos) {

        for (ServicoAdicional servico : servicos) {
            this.totalServicos = this.totalServicos.add(servico.getPreco());
        }
        return this.totalServicos;
    }

    @Override
    public String toString() {
        DateTimeFormatter dataFormatada = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        StringBuilder sb = new StringBuilder();
        sb.append("Reserva efetuada com sucesso para o cliente: " + hospede.getNome());
        sb.append("\n\nDados da reserva:");
        sb.append("\nHotel: " + hotel.getDadosHotel().getNome());
        sb.append("\nQuarto: " + quarto.getNomeAlojamento());
        sb.append("\nData do CheckIn: " + checkIn.format(dataFormatada));
        sb.append("\nData do Checkout: " + checkOut.format(dataFormatada));
        sb.append("\nQuantidade de adultos: " + quantidadeAdultos);
        sb.append("\nQuantidade de crianças: " + quantidadeCriancas);
        sb.append("\nServiços adicionais selecionados:\n");
        for (ServicoAdicional servico : servicoAdicional) {
            sb.append(servico.getNome()).append(" - ");
        }
        return sb.toString();
    }

}
