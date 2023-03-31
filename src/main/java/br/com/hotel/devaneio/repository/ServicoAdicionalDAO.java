package br.com.hotel.devaneio.repository;

import br.com.hotel.devaneio.model.Hotel;
import br.com.hotel.devaneio.model.ServicoAdicional;
import br.com.hotel.devaneio.model.dto.ServicoAdicionalOutputDTO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ServicoAdicionalDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private HotelDAO hotelDAO;

    public void cadastra(ServicoAdicional servicoAdicional) {
        this.entityManager.persist(servicoAdicional);
    }

    public List<ServicoAdicionalOutputDTO> lista() {
        String jpql = "SELECT new br.com.hotel.devaneio.model.dto.ServicoAdicionalOutputDTO(s.id, s.nome, s.preco, h.idHotel) FROM ServicoAdicional s "
                + "INNER JOIN s.hotel h";
        TypedQuery<ServicoAdicionalOutputDTO> query = entityManager.createQuery(jpql, ServicoAdicionalOutputDTO.class);
        return query.getResultList();
    }

    public ServicoAdicional buscaPor(Integer id) {
        return this.entityManager.find(ServicoAdicional.class, id);
    }

    public void atualiza(ServicoAdicionalOutputDTO servicoDTO) {
        ServicoAdicional servico = buscaPor(servicoDTO.getId());
        servico.setNome(servicoDTO.getNome());
        servico.setPreco(servicoDTO.getPreco());
        Hotel hotel = this.hotelDAO.buscaPor(servicoDTO.getHotel());
        servico.setHotel(hotel);
        this.entityManager.merge(servico);
    }

    public void deleta(Integer id) {
        ServicoAdicional servico = buscaPor(id);
        this.entityManager.remove(servico);
    }
}
