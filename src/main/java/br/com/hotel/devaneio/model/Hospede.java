package br.com.hotel.devaneio.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "hospede")
public class Hospede {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idHospede;
    @Column(name = "nome")
    private String nome;
    @Column(name = "sobrenome")
    private String sobrenome;
    @Column(name = "cpf")
    private String cpf;
    @Column(name = "senha")
    private String senha;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_contato")
    private Contato contato;

    public Hospede(Long idHospede) {
        this.idHospede = idHospede;
    }

    public Hospede(String nome, String sobrenome, String cpf, String senha, Contato contato) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
        this.senha = senha;
        this.contato = contato;
    }

    public Hospede(String nome, String sobrenome, String cpf, String senha) {

    }

    public Hospede() {
    }

    public Long getIdHospede() {
        return idHospede;
    }

    public void setIdHospede(Long idHospede) {
        this.idHospede = idHospede;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Contato getContato() {
        return contato;
    }

    public void setContato(Contato contato) {
        this.contato = contato;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hospede hospede = (Hospede) o;
        return getSenha().equals(hospede.getSenha()) && contato.getEmail().equals(hospede.contato.getEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSenha(), contato.getEmail());
    }
}
