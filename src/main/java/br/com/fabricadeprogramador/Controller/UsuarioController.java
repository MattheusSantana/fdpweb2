package br.com.fabricadeprogramador.Controller;

import br.com.fabricadeprogramador.entidades.Usuario;

import javax.faces.bean.ManagedBean;

/**
 * Created by Matheus on 12/03/2016.
 */
@ManagedBean (name="usuarioController")
public class UsuarioController {


    private Usuario usuario = new Usuario();

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void salvar(){
        System.out.println("Salvando usuario:" +usuario.getNome()+" "+ usuario.getLogin());

    }
}
