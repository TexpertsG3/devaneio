package br.com.hotel.devaneio.repository;

import br.com.hotel.devaneio.model.Endereco;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class EnderecoDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public void cadastra(Endereco endereco) {
        this.entityManager.persist(endereco);
    }

}
