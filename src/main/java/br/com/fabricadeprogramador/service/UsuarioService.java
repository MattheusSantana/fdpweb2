package br.com.fabricadeprogramador.service;

import br.com.fabricadeprogramador.Persistencias.DAO.DAO;
import br.com.fabricadeprogramador.Persistencias.DAO.DAOException;
import br.com.fabricadeprogramador.entidades.Usuario;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Matheus on 14/03/2016.
 */
@Service
public class UsuarioService {

    @Autowired
    private DAO<Usuario> usuarioDAO;

    public Usuario salvar(Usuario usuario) throws ServiceUsuarioException {

        Usuario usuarioExistente = usuarioDAO.buscarPorLogin(usuario.getLogin());

        try {
            Usuario usuarioRetorno = usuarioDAO.salvar(usuario);
        } catch (DAOException e) {
           throw new ServiceUsuarioException(e);
        }
            return null;
    }


    public void excluir (Usuario usuario)throws ServiceUsuarioException{

        Usuario usuarioRetorno = usuarioDAO.buscarPorId(usuario.getId());


        try {
            usuarioDAO.excluir(usuarioRetorno);
        } catch (DAOException e) {
            throw new ServiceUsuarioException(e);
        }


    }

    public List<Usuario> buscarTodos (){

        return usuarioDAO.buscarTodos();

    }

    }

