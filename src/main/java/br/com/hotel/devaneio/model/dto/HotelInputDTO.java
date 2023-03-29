package br.com.hotel.devaneio.model.dto;

import jakarta.validation.constraints.*;

public class HotelInputDTO {
    @NotBlank
    private String nome;
    @NotBlank
    private String cnpj;
    @NotBlank
    @Email
    private String email;
    @NotBlank
    private String telefone;
    @NotBlank
    private String celular;
    @NotBlank
    private String rua;
    @NotBlank
    private String bairro;
    @NotNull
    @Min(value = 1, message = "O número deve ser no mínimo 1.")
    private Integer numero;
    @NotNull
    @Max(value = 8)
    private String cep;
    @NotBlank
    private String cidade;
    @NotNull
    @Pattern(regexp = "[A-Z]{2}", message = "Deve ter dois caracteres maiúsculos de acordo com seu estado. (Ex: SP).")
    private String uf;
    @NotBlank
    private String complemento;

    public HotelInputDTO(String nome, String cnpj, String email, String telefone, String celular, String rua, String bairro,
                         Integer numero, String cep, String cidade, String uf, String complemento) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.email = email;
        this.telefone = telefone;
        this.celular = celular;
        this.rua = rua;
        this.bairro = bairro;
        this.numero = numero;
        this.cep = cep;
        this.cidade = cidade;
        this.uf = uf;
        this.complemento = complemento;
    }

    public String getNome() {
        return nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getCelular() {
        return celular;
    }

    public String getRua() {
        return rua;
    }

    public String getBairro() {
        return bairro;
    }

    public Integer getNumero() {
        return numero;
    }

    public String getCep() {
        return cep;
    }

    public String getCidade() {
        return cidade;
    }

    public String getUf() {
        return uf;
    }

    public String getComplemento() {
        return complemento;
    }
}
