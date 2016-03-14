package fdpweb2;

import br.com.fabricadeprogramador.Persistencias.DAO.DAO;
import br.com.fabricadeprogramador.Persistencias.DAO.DAOFactory;
import br.com.fabricadeprogramador.entidades.Estado;
import br.com.fabricadeprogramador.entidades.Usuario;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.*;
import java.util.List;

/**
 * Created by Matheus on 28/02/2016.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/springbeans.xml")
@TransactionConfiguration(transactionManager ="transactionManager",defaultRollback = true)
public class testEstadoDAO {
    @Autowired
    private DAO<Estado> estadoDAO;

    @Test
    @Transactional
    public void testSalvar(){

      Estado estadoRetorno = estadoDAO.salvar(new Estado("MG"));
        System.out.println(estadoRetorno);
        Assert.assertNotNull(estadoDAO.buscarPorId(estadoRetorno.getId()));
    }
    @Test
    @Transactional
    public void testAlterar() {
        Estado estado = new Estado();
        estado.setUf("MT");

        Estado estadoRetorno1 = estadoDAO.salvar(estado);

        Estado estado1 = new Estado();
        estado1.setUf("TO");
        estado1.setId(estadoRetorno1.getId());

        Estado estadoRetorno2 = estadoDAO.salvar(estado1);

        Assert.assertEquals(estadoRetorno1.getId(), estadoRetorno2.getId());
        Assert.assertNotEquals(estado.getUf(), estadoRetorno2.getUf());

    }

    @Test
    @Transactional
    public void testExcluir() {
        Estado estado = new Estado();
        estado.setUf("TO");

        Estado estadoRetorno = estadoDAO.salvar(estado);

        estadoDAO.excluir(estadoRetorno);

        Assert.assertNull(estadoDAO.buscarPorId(estadoRetorno.getId()));

    }

    @Test
    @Transactional
    public void testBuscarPorId(){
        Estado estado = new Estado();
        estado.setUf("TO");

        Estado estadoRetorno = estadoDAO.salvar(estado);
        Assert.assertNotNull(estadoDAO.buscarPorId(estadoRetorno.getId()));
        System.out.println(estadoRetorno);
    }

    @Test
    @Transactional
    public void testBuscarTodos(){
        List<Estado> lista = estadoDAO.buscarTodos();
        assert(lista != null && lista.size()>0);
        for(Estado u : lista){
            System.out.println(u);
        }

    }
}
