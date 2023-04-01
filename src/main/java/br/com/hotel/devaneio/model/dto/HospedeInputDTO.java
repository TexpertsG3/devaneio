package br.com.hotel.devaneio.model.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class HospedeInputDTO {
    @NotBlank
    private String nome;
    @NotBlank
    private String sobrenome;
    @NotBlank
    private String cpf;
    @NotBlank
    private String senha;
    @NotBlank
    @Email
    private String email;
    @NotBlank
    private String telefone;
    @NotBlank
    private String celular;



    public HospedeInputDTO(String nome, String sobrenome, String cpf, String senha, String email, String telefone , String celular) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
        this.senha = senha;
        this.email = email;
        this.telefone = telefone;
        this.celular = celular;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getSenha() {
        return senha;
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
}

