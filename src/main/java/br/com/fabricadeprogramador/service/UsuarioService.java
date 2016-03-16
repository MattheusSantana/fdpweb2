package br.com.fabricadeprogramador.service;

import br.com.fabricadeprogramador.Persistencias.DAO.DAO;
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

    public Usuario salvar (Usuario usuario) throws ServiceUsuarioException {

        Usuario usuarioExistente = usuarioDAO.buscarPorLogin(usuario.getLogin());

        if (usuarioExistente != null){
            throw new ServiceUsuarioException("Usuario já existente!");
            }
       return usuarioDAO.salvar(usuario);

        }

    public void excluir (Usuario usuario){

        Usuario usuarioRetorno = usuarioDAO.buscarPorId(usuario.getId());

        if (usuario.equals(usuarioRetorno)){
            usuarioDAO.excluir(usuario);

        }
    }

    public List<Usuario> buscarTodos (){

        return usuarioDAO.buscarTodos();

    }

    }

