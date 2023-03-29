package br.com.hotel.devaneio.repository;

import br.com.hotel.devaneio.model.DadosHotel;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class DadosHotelDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public void cadastra(DadosHotel dadosHotel) {
        this.entityManager.persist(dadosHotel);
    }
}
