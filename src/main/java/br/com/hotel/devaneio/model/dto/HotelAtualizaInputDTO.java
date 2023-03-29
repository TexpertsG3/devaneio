package br.com.hotel.devaneio.model.dto;

import jakarta.validation.constraints.*;

public class HotelAtualizaInputDTO {

    @NotBlank
    private Integer id;
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
    private String cep;
    @NotBlank
    private String cidade;
    @NotNull
    @Pattern(regexp = "[A-Z]{2}", message = "Deve ter dois caracteres maiúsculos de acordo com seu estado. (Ex: SP).")
    private String uf;
    @NotBlank
    private String complemento;

    public Integer getId() {
        return id;
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

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }
}
