package br.com.hotel.devaneio.model.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;

public class ServicoAdicionalInputDTO {

    @NotBlank(message = "O campo nome deve ser preenchido.")
    private String nome;
    @DecimalMin(value = "50.00", message = "Valor mínimo de 50.00.")
    private BigDecimal valor;
    @Min(value = 1, message = "Deve ser digitado o id do hotel para onde se deseja cadastrar o serviço. O valor mínimo para id aceitável é 1.")
    private Integer hotel;

    public ServicoAdicionalInputDTO(String nome, BigDecimal valor, Integer hotel) {
        this.nome = nome;
        this.valor = valor;
        this.hotel = hotel;
    }

    public String getNome() {
        return nome;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public Integer getHotel() {
        return hotel;
    }

}
