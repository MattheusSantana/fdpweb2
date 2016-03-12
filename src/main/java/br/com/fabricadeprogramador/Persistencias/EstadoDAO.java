package br.com.fabricadeprogramador.Persistencias;

import br.com.fabricadeprogramador.entidades.Estado;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by Matheus on 28/02/2016.
 */
@Repository
public class EstadoDAO implements DAO <Estado>{
    @PersistenceContext
    private EntityManager em;

    public EstadoDAO(){

    }

    @Transactional
    public Estado salvar (Estado estado){
        em.merge(estado);
        return estado;

    }

    @Transactional
    public void excluir (Estado estado){
        em.remove(estado);

    }


    public Estado buscarPorId (int id){
        return em.find(Estado.class, id);
    }
    public List<Estado> buscarTodos (){

        Query query = em.createQuery("select u from Estado u");//JPQL
        List<Estado> estados = query.getResultList();
        return estados;
    }
    public List<Object[]> buscarTodos2 (){

        Query query = em.createQuery("select u.id, u.uf from Estado u");//JPQL
        List<Object[]> estados = query.getResultList();
        return estados;
    }
}
