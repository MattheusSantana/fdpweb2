package br.com.fabricadeprogramador.Persistencias.DAO;

import br.com.fabricadeprogramador.entidades.Estado;
import br.com.fabricadeprogramador.entidades.Usuario;
import org.springframework.stereotype.Repository;

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


    public void salvar (Estado estado){
        em.getTransaction().begin();
        em.merge(estado);
        em.getTransaction().commit();
        if(estado.getId()== null){
            System.out.println("salvo");
        }else{
            System.out.println("alterado!");

        }

    }

    public void excluir (Estado estado){
        em.getTransaction().begin();
        em.remove(estado);
        em.getTransaction().commit();
        System.out.println("Excluido!");
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
