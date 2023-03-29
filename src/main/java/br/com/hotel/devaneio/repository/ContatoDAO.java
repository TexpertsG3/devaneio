package br.com.hotel.devaneio.repository;

import br.com.hotel.devaneio.model.Contato;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class ContatoDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public void cadastra(Contato contato) {
        this.entityManager.persist(contato);
    }

}
