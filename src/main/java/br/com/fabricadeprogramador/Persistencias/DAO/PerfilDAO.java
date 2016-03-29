package br.com.fabricadeprogramador.Persistencias.DAO;

import br.com.fabricadeprogramador.entidades.Perfil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by Matheus on 22/03/2016.
 */
@Repository
@Transactional
public class PerfilDAO implements DAO<Perfil> {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Perfil salvar(Perfil perfil) throws DAOException {
        try {
            return em.merge(perfil);
        }catch (Exception e){
            throw new DAOException(e);
        }
    }

    @Override
    public void excluir(Perfil perfil) throws DAOException {
        try {
            em.remove(buscarPorId(perfil.getId()));
        }catch (Exception e){
            throw new DAOException("Erro ao excluir");

        }

    }

    @Override
    public Perfil buscarPorId(int id) {
        return em.find(Perfil.class, id);
    }

    @Override
    public List<Perfil> buscarTodos() {
        Query query = em.createQuery("select p from Perfil p order by p.id ");
        List<Perfil> perfil = (List<Perfil>)query.getResultList();
        return perfil;
    }

    @Override
    public Perfil buscarPorLogin(String login) {
        return null;
    }
}
