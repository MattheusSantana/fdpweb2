package fdpweb2;

import br.com.fabricadeprogramador.Persistencias.DAO.DAO;
import br.com.fabricadeprogramador.Persistencias.DAO.DAOFactory;
import br.com.fabricadeprogramador.entidades.Estado;
import br.com.fabricadeprogramador.entidades.Usuario;

import javax.swing.*;
import java.util.List;

/**
 * Created by Matheus on 28/02/2016.
 */
public class testEstadoDAO {
    //2 - faz cast para criar um DAO / 1 - Chama metodo da fabrica de DAO passando nome como parametro.
    static DAO<Usuario> usuarioDAO = DAOFactory.getDAO("UsuarioDAO");
    static DAO<Estado> estadoDAO = DAOFactory.getDAO("estadoDAO");
    public static void main(String[] args) {
          testSalvar();
        //testAlterar();
        //testExcluir();
        //testBuscarPorId();
        //testBuscarTodos();
        //testBuscarTodos2();
    }

    public static void testSalvar(){
    estadoDAO.salvar(new Estado("MG"));
    }

    public static void testAlterar() {
        Estado estado = new Estado();
        estado.setUf("RN");
        estado.setId(13);
        estadoDAO.salvar(estado);
    }
    public static void testExcluir(){
        estadoDAO.excluir(estadoDAO.buscarPorId(10));
    }
    public static void testBuscarPorId(){
        Estado	estadoRetorno = estadoDAO.buscarPorId(1);
        JOptionPane.showMessageDialog(null,estadoRetorno);
    }
    public static void testBuscarTodos(){
        List<Estado> lista = estadoDAO.buscarTodos();
        for(Estado u : lista){
            System.out.println(u);
        }

    }
}
