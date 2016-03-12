package fdpweb2;

import br.com.fabricadeprogramador.Persistencias.DAO;
import br.com.fabricadeprogramador.entidades.Estado;
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
@ContextConfiguration("file:src/main/webapp/WEB-INF/springbeans.xml")
@TransactionConfiguration(transactionManager="transactionManager", defaultRollback=false)
public class testEstadoDAO {

    @Autowired // Me dê um estadoDAO com todas suas depêndencias.
    DAO<Estado> estadoDAO;


    @Test
    @Transactional
    public void testSalvar(){

        estadoDAO.salvar(new Estado("MG"));
    }
    @Test
    @Transactional
    public void testAlterar() {
        Estado estado = new Estado();
        estado.setUf("RN");
        estado.setId(13);
        estadoDAO.salvar(estado);
    }
    @Test
    @Transactional
    public void testExcluir(){
        estadoDAO.excluir(estadoDAO.buscarPorId(10));
    }
    @Test
    @Transactional
    public void testBuscarPorId(){
        Estado	estadoRetorno = estadoDAO.buscarPorId(1);
        JOptionPane.showMessageDialog(null,estadoRetorno);
    }
    public void testBuscarTodos(){
        List<Estado> lista = estadoDAO.buscarTodos();
        for(Estado u : lista){
            System.out.println(u);
        }

    }
}
