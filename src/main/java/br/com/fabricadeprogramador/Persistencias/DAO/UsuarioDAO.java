package br.com.fabricadeprogramador.Persistencias.DAO;

import br.com.fabricadeprogramador.entidades.Usuario;
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
public class UsuarioDAO implements DAO<Usuario> {
    @PersistenceContext
    private EntityManager em;


    public UsuarioDAO() {
      System.out.println("Instanciando...");
    }

    @Transactional
    public void salvar(Usuario usuario) {
        em.merge(usuario);
        if (usuario.getId() != null) {
            System.out.println("alterado!");
        } else {
            System.out.println("salvo!");
        }

    }

    @Transactional
    public void excluir(Usuario usuario) {
        em.remove(usuario);

    }

    @Override
    public Usuario buscarPorId(int id) {
        return em.find(Usuario.class, id);
    }

    @Override
    public List<Usuario> buscarTodos() {
        Query query = em.createQuery("select u from Usuario u");//JPQL
        List<Usuario> usuarios = query.getResultList();
        return usuarios;
    }
}
