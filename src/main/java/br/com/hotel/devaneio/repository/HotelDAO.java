package br.com.hotel.devaneio.repository;

import br.com.hotel.devaneio.model.Hotel;
import br.com.hotel.devaneio.model.dto.HotelOutputDTO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HotelDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public void cadastra(Hotel hotel) {
        this.entityManager.persist(hotel);
    }

    public List<HotelOutputDTO> lista() {
        String jpql = "SELECT new br.com.hotel.devaneio.model.dto.HotelOutputDTO(h.id, d.nome, d.cnpj, c.email, c.telefone, c.celular, e.rua, e.bairro, e.numero, e.cep, e.cidade, e.uf, e.complemento) FROM Hotel h "
                + "INNER JOIN h.dadosHotel d "
                + "INNER JOIN d.contato c "
                + "INNER JOIN d.endereco e";
        TypedQuery<HotelOutputDTO> query = entityManager.createQuery(jpql, HotelOutputDTO.class);
        return query.getResultList();
    }

    public Hotel buscaPor(Integer id) {return this.entityManager.find(Hotel.class, id);}

    @Transactional
    public void delete(Integer id){
        Hotel hotel = this.entityManager.find(Hotel.class, id);
        this.entityManager.remove(hotel);
    }

}
