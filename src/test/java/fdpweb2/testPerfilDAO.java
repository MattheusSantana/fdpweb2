package fdpweb2;

import br.com.fabricadeprogramador.Persistencias.DAO.DAO;
import br.com.fabricadeprogramador.Persistencias.DAO.DAOException;
import br.com.fabricadeprogramador.Persistencias.DAO.PerfilDAO;
import br.com.fabricadeprogramador.entidades.Perfil;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import javax.transaction.TransactionManager;


/**
 * Created by Matheus on 22/03/2016.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/springbeans.xml")
@TransactionConfiguration(transactionManager ="transactionManager", defaultRollback = false)
public class testPerfilDAO {

    @Autowired
    private DAO<Perfil> perfilDAO;

    @Test
    public void testSalvarPerfil(){
    Perfil p = new Perfil();
        p.setDescricao("VISITA");
        try {
            p = perfilDAO.salvar(p);
            Assert.assertNotNull(p.getId());
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }
}
