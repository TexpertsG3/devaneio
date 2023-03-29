package br.com.hotel.devaneio.model.dto;

public class HotelOutputDTO {

    private Integer id;
    private String nome;
    private String cnpj;
    private String email;
    private String telefone;
    private String celular;
    private String rua;
    private String bairro;
    private Integer numero;
    private String cep;
    private String cidade;
    private String uf;
    private String complemento;

    public HotelOutputDTO(Integer id, String nome, String cnpj, String email, String telefone, String celular, String rua, String bairro,
                          Integer numero, String cep, String cidade, String uf, String complemento) {
        this.id = id;
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

}
