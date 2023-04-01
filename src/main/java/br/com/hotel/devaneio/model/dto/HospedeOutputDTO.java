package br.com.hotel.devaneio.model.dto;

import jakarta.validation.constraints.NotBlank;

public class HospedeOutputDTO {


        private Long idHospede;
        private String nome;

        private String sobrenome;

        private String cpf;

        private String senha;
        private String email;
        private String telefone;
        private String celular;

        public HospedeOutputDTO(Long idHospede, String nome, String sobrenome, String cpf, String senha, String email, String telefone, String celular) {
            this.idHospede = idHospede;
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
        public Long getIdHospede() {return idHospede;}
    }


