package br.com.hotel.devaneio.repository;

import br.com.hotel.devaneio.model.DadosHotel;
import br.com.hotel.devaneio.model.Hotel;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DadosHotelDAO {

    @PersistenceContext
    private EntityManager entityManager;
    

    public void cadastra(DadosHotel dadosHotel) {
        this.entityManager.persist(dadosHotel);
    }

    public Hotel buscaPor(Integer id) {return this.entityManager.find(Hotel.class, id);}
}
