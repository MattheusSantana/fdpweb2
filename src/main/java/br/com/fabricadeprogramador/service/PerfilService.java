package br.com.fabricadeprogramador.service;

import br.com.fabricadeprogramador.Persistencias.DAO.DAO;
import br.com.fabricadeprogramador.Persistencias.DAO.DAOException;
import br.com.fabricadeprogramador.entidades.Perfil;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Matheus on 22/03/2016.
 */
@Service
public class PerfilService {

    @Autowired
    private DAO<Perfil> perfilDAO;

    public Perfil salvar (Perfil perfil) throws ServiceUsuarioException {
        Perfil perfilExistente = perfilDAO.buscarPorId(perfil.getId());
        try {
            Perfil perfilRetorno = perfilDAO.salvar(perfil);

        }catch (DAOException e){
            throw new ServiceUsuarioException(e);
        }
        return null;
    }

    public void excluir (Perfil perfil) throws ServiceUsuarioException {
        Perfil perfilRetorno = perfilDAO.buscarPorId(perfil.getId());

        try {
            perfilDAO.excluir(perfil);
        } catch (DAOException e) {
            throw new ServiceUsuarioException(e);
        }
    }

    public List<Perfil>buscarTodos(){

        return perfilDAO.buscarTodos();
    }

    public Perfil buscarPorId(int id) {

        return perfilDAO.buscarPorId(id);
    }

}
