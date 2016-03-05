import br.com.fabricadeprogramador.Persistencias.DAO.DAO;
import br.com.fabricadeprogramador.Persistencias.DAO.UsuarioDAO;
import br.com.fabricadeprogramador.entidades.Usuario;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.swing.*;
import java.util.List;

/**
 * Created by Matheus on 28/02/2016.
 */
public class testUsuarioDAO {
    ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("file:src/main/webapp/WEB-INF/springbeans.xml");

    private DAO<Usuario> usuDAO = (DAO<Usuario>) ctx.getBean("usuarioDAO");

    @Test
    public void testCadastrar() {
        Usuario usuario = new Usuario();
        usuario.setLogin("ppp");
        usuario.setNome("ppp");
        usuario.setSenha("123");
        usuDAO.salvar(usuario);


    }
    public void testAlterar() {
        Usuario usuario = new Usuario();
        usuario.setNome("joInt");
        usuario.setLogin("josiint");
        usuario.setSenha("123");
        usuario.setId(6);
        usuDAO.salvar(usuario);

    }
    public void testExcluir(){
        usuDAO.excluir(usuDAO.buscarPorId(10));
    }
    public void testBuscarPorId(){
        Usuario	usuRetorno = usuDAO.buscarPorId(1);
        JOptionPane.showMessageDialog(null,usuRetorno);
    }
    public void testBuscarTodos(){
        List<Usuario> lista = usuDAO.buscarTodos();
        for(Usuario u : lista){
            System.out.println(u);
        }

    }


}
