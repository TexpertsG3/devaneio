package br.com.hotel.devaneio.repository;

import br.com.hotel.devaneio.model.Hospede;
import br.com.hotel.devaneio.model.dto.HospedeOutputDTO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HospedeDAO {
    @PersistenceContext
    private EntityManager entityManager;
    public void cadastraHospede(Hospede hospede){
        this.entityManager.persist(hospede);
    }
    public List<HospedeOutputDTO> lista() {
        String jpql = "SELECT new br.com.hotel.devaneio.model.dto.HospedeOutputDTO(h.idHospede, h.nome,h.sobrenome,h.cpf,h.senha,c.email, c.telefone, c.celular) FROM Hospede h "
                + "INNER JOIN h.contato c";
        TypedQuery<HospedeOutputDTO> query = entityManager.createQuery(jpql, HospedeOutputDTO.class);
        return query.getResultList();
    }
    public Hospede buscaHospede(Long idHospede) {return this.entityManager.find(Hospede.class, idHospede);}

    @Transactional
    public void deletaHospede(Long idHospede){
        Hospede hospede = this.entityManager.find(Hospede.class, idHospede);
        this.entityManager.remove(hospede);
    }
}
