package br.com.fabricadeprogramador.Persistencias.DAO;

import br.com.fabricadeprogramador.entidades.Usuario;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by Matheus on 28/02/2016.
 */
@Repository
@Transactional
public class UsuarioDAO implements DAO<Usuario> {
    @PersistenceContext
    private EntityManager em;


    public UsuarioDAO() {

    }

    public Usuario salvar(Usuario usuario) throws DAOException {
        try {
            return em.merge(usuario);
        }catch (Exception e){
            throw new DAOException("Erro ao salvar");
        }
    }

    public void excluir(Usuario usuario) throws DAOException {
        try {
            em.remove(buscarPorId(usuario.getId()));
        }catch (Exception e){
            throw new DAOException("Erro ao excluir");

        }
    }

    @Override
    public Usuario buscarPorId(int id) {
        return em.find(Usuario.class, id);
    }

    @Override
    public List<Usuario> buscarTodos() {
        Query query = em.createQuery("select u from Usuario u order by u.id");//JPQL
        List<Usuario> usuarios = (List<Usuario>) query.getResultList();
        return usuarios;
    }

    public Usuario buscarPorLogin(String login) {
        try {
            Query query = em.createQuery("select u from Usuario u where u.login=:login");
            query.setParameter("login", login);
            query.setMaxResults(1); //Para retornar apenas um resultado caso tenha mais de um.
            return (Usuario)query.getSingleResult();
        }catch(NoResultException e){
        return null;

        }

    }
}
