package fdpweb2;

import br.com.fabricadeprogramador.Persistencias.DAO.DAO;
import br.com.fabricadeprogramador.Persistencias.DAO.DAOException;
import br.com.fabricadeprogramador.entidades.Usuario;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.*;
import javax.transaction.TransactionManager;
import java.util.List;

/**
 * Created by Matheus on 28/02/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/springbeans.xml")
@TransactionConfiguration(transactionManager ="transactionManager",defaultRollback = true)
public class testUsuarioDAO {

    @Autowired //Para receber um usuarioDAO com todas as suas depêndecias injetadas.
    private DAO<Usuario> usuarioDAO;

    @Test
    @Transactional
    public void testCadastrar() {
        Usuario usuario = new Usuario();
        usuario.setLogin("UsuarioTeste");
        usuario.setNome("uuu");
        usuario.setSenha("123");

        Usuario usuarioRetorno = null;
        try {
            usuarioRetorno = usuarioDAO.salvar(usuario);
        } catch (DAOException e) {
            e.printStackTrace();
        }
        System.out.println(usuarioRetorno);
        Assert.assertNotNull(usuarioRetorno);


    }
    @Test
    @Transactional
    public void testAlterar() {
        Usuario usuario = new Usuario();
        usuario.setNome("teste");
        usuario.setLogin("teste");
        usuario.setSenha("123");

        Usuario usuarioRetorno1 = null;
        try {
            usuarioRetorno1 = usuarioDAO.salvar(usuario);
        } catch (DAOException e) {
            e.printStackTrace();
        }

        Usuario usuario2 = new Usuario();
        usuario2.setNome("teste2");
        usuario2.setLogin("teste2");
        usuario2.setSenha("123");
        usuario2.setId(usuarioRetorno1.getId());

        Usuario usuarioRetorno2 = null;
        try {
            usuarioRetorno2 = usuarioDAO.salvar(usuario2);
        } catch (DAOException e) {
            e.printStackTrace();
        }
        //Comparando se o Id dos objetos são os mesmos para o update dar certo.
        Assert.assertEquals(usuarioRetorno1.getId(),usuarioRetorno2.getId());
        //Comparando o nome do primeiro usuario salvo e o nome do mesmo usuario após a alteração.
        Assert.assertNotEquals(usuario.getNome(),usuarioRetorno2.getNome());
    }

    @Test
    @Transactional
    public void testExcluir(){
        Usuario usuario = new Usuario();
        usuario.setNome("teste");
        usuario.setLogin("teste");
        usuario.setSenha("123");

        Usuario usuarioRetorno = null;
        try {
            usuarioRetorno = usuarioDAO.salvar(usuario);
        } catch (DAOException e) {
            e.printStackTrace();
        }
        try {
            usuarioDAO.excluir(usuarioRetorno);
        } catch (DAOException e) {
            e.printStackTrace();
        }
        Assert.assertNull(usuarioDAO.buscarPorId(usuarioRetorno.getId()));


    }
    @Test
    @Transactional
    public void testBuscarPorId(){
        Usuario usuario = new Usuario();
        usuario.setNome("teste");
        usuario.setLogin("teste");
        usuario.setSenha("123");

        Usuario usuarioRetorno = null;
        try {
            usuarioRetorno = usuarioDAO.salvar(usuario);
        } catch (DAOException e) {
            e.printStackTrace();
        }
        Assert.assertNotNull(usuarioDAO.buscarPorId(usuarioRetorno.getId()));

    }




    @Test
    public void testBuscarTodos(){
        List<Usuario> lista = usuarioDAO.buscarTodos();
        assert(lista!= null && lista.size()>0);
        for(Usuario u : lista){
            System.out.println(u);
        }

    }
}
