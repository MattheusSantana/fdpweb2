package br.com.fabricadeprogramador.Persistencias.DAO;

import br.com.fabricadeprogramador.entidades.Usuario;

import java.util.List;
/**
 * Created by Matheus on 28/02/2016.
 */


public interface DAO <T> {
     void salvar (T obj);
     void excluir (T obj);
     T buscarPorId(int id);
     List<T>buscarTodos();
}
