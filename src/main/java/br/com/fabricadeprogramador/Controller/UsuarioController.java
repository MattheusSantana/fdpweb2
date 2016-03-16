package br.com.fabricadeprogramador.Controller;

import br.com.fabricadeprogramador.entidades.Usuario;
import br.com.fabricadeprogramador.service.ServiceUsuarioException;
import br.com.fabricadeprogramador.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.persistence.Basic;
import java.util.List;

/**
 * Created by Matheus on 12/03/2016.
 */

@Controller(value = "usuarioController")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    private List<Usuario> usuarioList;

    private Usuario usuario;

    public UsuarioController() {
        usuario = new Usuario();
    }

    public List<Usuario> getUsuarioList() {
        this.usuarioList = usuarioService.buscarTodos();
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void salvar() {
        try {
            usuarioService.salvar(usuario);
        } catch (ServiceUsuarioException e) {
            e.printStackTrace();
        }

    }
}
