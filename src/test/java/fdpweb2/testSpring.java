package fdpweb2;

import br.com.fabricadeprogramador.Persistencias.DAO.DAO;
import br.com.fabricadeprogramador.Persistencias.DAO.DAOException;
import br.com.fabricadeprogramador.entidades.Estado;
import br.com.fabricadeprogramador.entidades.Usuario;
import org.apache.commons.dbcp.BasicDataSource;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 * Created by Matheus on 29/02/2016.
 */
public class testSpring {
    //classe caminho do contexto de aplicação xml, para carregar o xml de um framework. nesse caso o spring.
    ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("file:src/main/webapp/WEB-INF/springbeans.xml");
     EntityManager em;

    //public static void main (String[] args){
        //testUsuarioSpring();
        //testEstadoSpring();
        //testBasicDataSourceSpring();
        //testEntityManagerSpring();
        // testTransactionSpring();
    //}
    @Test
    public void testUsuarioSpring() {
        Usuario usuario = (Usuario) ctx.getBean("usu"); // recebendo usuario que será instanciando pelo spring e fazendo cast, pois vem como object.
        System.out.println(usuario.getNome());
    }
    @Test
    public void testEstadoSpring(){
        Estado estado = (Estado)ctx.getBean("est");
        System.out.println(estado.getUf());
    }
    @Test
    public void testBasicDataSourceSpring(){
        BasicDataSource basicDataSource = (BasicDataSource)ctx.getBean("dataSource");
        System.out.println(basicDataSource.getDriverClassName());
        System.out.println(basicDataSource.getUrl());
        System.out.println(basicDataSource.getUsername());
        System.out.println(basicDataSource.getPassword());
    }
    @Test
    public void testEntityManagerSpring(){
        EntityManagerFactory emf = (EntityManagerFactory)ctx.getBean("entityManagerFactory");
        em = emf.createEntityManager();
        Usuario usuario = new Usuario();
        usuario.setNome("baraca");
        usuario.setSenha("123");
        usuario.setLogin("baraca@bac");
        em.getTransaction().begin();
        em.merge(usuario);
        em.getTransaction().commit();

    }
    @Test
    public void testTransactionSpring () throws DAOException {
        DAO<Usuario> usuarioDAO = (DAO<Usuario>) ctx.getBean("usuarioDAO");
        // Pra instanciar um Usuario eu tenho que fazer o cast com o DAO pois usuarioDAO implementa DAO
        // Passo como objeto parametrizado o Usuario, para poder passar usuarios nos métodos.
        // Passar como parametro bean usuarioDAO com u minusculo, pois ele ja da um objeto assim por padrão spring.


        usuarioDAO.salvar(new Usuario("juaquim","juquim@jjj","123"));


    }
}
