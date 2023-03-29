package br.com.hotel.devaneio.repository;

import br.com.hotel.devaneio.model.Contato;
import br.com.hotel.devaneio.model.Hotel;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
public class ContatoDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public void cadastra(Contato contato) {
        this.entityManager.persist(contato);
    }

    public Contato buscaPor(Integer id) {return this.entityManager.find(Contato.class, id);}

    @Transactional
    public void delete(Integer id){
        Contato contato = this.entityManager.find(Contato.class, id);
        this.entityManager.remove(contato);
    }

}
