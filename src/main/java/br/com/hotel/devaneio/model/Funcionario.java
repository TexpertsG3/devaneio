package br.com.hotel.devaneio.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "funcionario")
public class Funcionario {

    private static final String MSG_SALARIO_INVALIDO = "O valor digitado é inválido. Deve ser maior que 0";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_funcionario")
    private Integer idFuncionario;
    @Column(name = "nome_funcionario")
    private String nome;
    @Column(name = "sobrenome_funcionario")
    private String sobrenome;
    @OneToOne
    @JoinColumn(name = "id_cargo")
    private Cargo cargo;
    @OneToOne
    @JoinColumn(name = "id_contato")
    private Contato contato;
    @OneToOne
    @JoinColumn(name = "id_endereco")
    private Endereco endereco;
    private BigDecimal salario;
    @ManyToOne
    @JoinColumn(name = "id_hotel")
    private Hotel idHotel;

    public Funcionario(String nome, String sobrenome, Cargo cargo, BigDecimal salario, Hotel idHotel) {
        this.idHotel = idHotel;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cargo = cargo;
        this.salario = salario;
    }

    public Funcionario() {

    }

    public Integer getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(Integer idFuncionario) {
        this.idFuncionario = idFuncionario;
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

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public Hotel getIdHotel() {
        return idHotel;
    }

    public void setIdHotel(Hotel idHotel) {
        this.idHotel = idHotel;
    }

    public void modificarSalarioFuncionario(BigDecimal novoSalario) {
        if (novoSalario.compareTo(BigDecimal.ZERO) > 0) {
            this.salario = novoSalario;
        } else {
            throw new RuntimeException(MSG_SALARIO_INVALIDO);
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, sobrenome);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Funcionario other = (Funcionario) obj;
        return Objects.equals(nome, other.nome) && Objects.equals(sobrenome, other.sobrenome);
    }

    @Override
    public String toString() {
        return "\nNome: " + this.nome + "\nSobrenome: " + this.sobrenome + "\nCargo: " + this.cargo + "\nSalário: R$"
                + this.salario;
    }

}
