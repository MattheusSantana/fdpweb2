package fdpweb2;

import br.com.fabricadeprogramador.Persistencias.DAO;
import br.com.fabricadeprogramador.entidades.Usuario;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Matheus on 28/02/2016.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/springbeans.xml")
@TransactionConfiguration(transactionManager="transactionManager", defaultRollback=false)
public class testUsuarioDAO {


    @Autowired //Me dê um usuarioDAO com todas suas dependencias injetadas.
    DAO<Usuario> usuarioDAO;

    @Test
    @Transactional
    public void testCadastrar() {
        Usuario usuario = new Usuario();
        usuario.setLogin("Usuarionn");
        usuario.setNome("usuarionn");
        usuario.setSenha("123");
        Usuario usuRetorno =  usuarioDAO.salvar(usuario);


    }

    @Test
    @Transactional
    public void testBuscarPorId(){

        Usuario	usuRetorno = usuarioDAO.buscarPorId(14);
        System.out.println(usuRetorno);

    }


    @Test
    @Transactional
    public void testExcluir(){
        usuarioDAO.excluir(usuarioDAO.buscarPorId(12));

    }

    public void testBuscarTodos() {
        List<Usuario> lista = usuarioDAO.buscarTodos();
        for (Usuario u : lista) {
            System.out.println(u);
        }


    }
}
