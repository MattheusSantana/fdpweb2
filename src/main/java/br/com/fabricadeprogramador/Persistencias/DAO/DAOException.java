package br.com.fabricadeprogramador.Persistencias.DAO;

/**
 * Created by Matheus on 17/03/2016.
 */
public class DAOException extends Exception {
    public DAOException(String msg) {
        super(msg);
    }

    public DAOException(Exception e) {
        super(e);
     }



}
