package br.com.fabricadeprogramador.Persistencias.DAO;

import br.com.fabricadeprogramador.entidades.Usuario;

import java.util.List;
/**
 * Created by Matheus on 28/02/2016.
 */


public interface DAO <T> {
     T salvar (T obj) throws DAOException;
     void excluir (T obj) throws DAOException;
     T buscarPorId(int id);
     List<T>buscarTodos();

     T buscarPorLogin(String login);
}
