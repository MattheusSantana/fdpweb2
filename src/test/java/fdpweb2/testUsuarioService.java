package fdpweb2;

import br.com.fabricadeprogramador.Persistencias.DAO.DAO;
import br.com.fabricadeprogramador.Persistencias.DAO.UsuarioDAO;
import br.com.fabricadeprogramador.entidades.Usuario;
import br.com.fabricadeprogramador.service.ServiceUsuarioException;
import br.com.fabricadeprogramador.service.UsuarioService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Matheus on 14/03/2016.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/springbeans.xml")
@TransactionConfiguration(transactionManager ="transactionManager",defaultRollback = true)
public class testUsuarioService {

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    DAO<Usuario> usuarioDAO;


    @Test
    @Transactional
    public void testSalvar() throws ServiceUsuarioException {
        Usuario usuario = new Usuario();
        usuario.setLogin("testUsuario");
        usuario.setNome("testeu");
        usuario.setSenha("123");

       usuarioService.salvar(usuario);


    }

    @Test(expected=ServiceUsuarioException.class) // O teste esperar uma exception para dar certo.
    public void testNãoSalvar() throws ServiceUsuarioException {
        Usuario usuario = new Usuario();
        usuario.setLogin("testeService");
        usuario.setNome("teste");
        usuario.setSenha("123");

        usuarioDAO.salvar(usuario);

        usuarioService.salvar(usuario);

    }


}
