package br.com.fabricadeprogramador.service;

import br.com.fabricadeprogramador.Persistencias.DAO.DAOException;

/**
 * Created by Matheus on 14/03/2016.
 */
public class ServiceUsuarioException extends Exception {


    public ServiceUsuarioException(String mensagem) {
        super(mensagem);
    }

    public ServiceUsuarioException(DAOException e) {
    }
}
