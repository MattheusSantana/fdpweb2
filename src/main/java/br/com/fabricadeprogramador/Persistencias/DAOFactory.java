package br.com.fabricadeprogramador.Persistencias;

/**
 * Created by Matheus on 28/02/2016.
 */
public class DAOFactory {
    private static EstadoDAO estadoDAO;
    private static UsuarioDAO usuarioDAO;

    public static DAO getDAO (String nomeDAO){
        if (nomeDAO.equalsIgnoreCase("EstadoDAO")){
            if(estadoDAO == null){
                estadoDAO = new EstadoDAO();
            }
            return estadoDAO;


        }else if (nomeDAO.equalsIgnoreCase("UsuarioDAO")){
            if(usuarioDAO == null){
                usuarioDAO = new UsuarioDAO();
            }
            return usuarioDAO;
        }
        return null;
    }
}
