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
        // para quando o form acessar o get do usuarioList para printar, ele receba a lista atualizada.
        return usuarioService.buscarTodos();
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
            if (usuario.getId() == null) {
                usuarioService.salvar(usuario);
                MensagemUtil.mensagemInfo(MensagemUtil.SALVAR_SUCESSO);
            } else if (usuario.getId() !=null){
                usuarioService.salvar(usuario);
                MensagemUtil.mensagemInfo("Alterado!");
            }

        } catch (ServiceUsuarioException e) {
            e.printStackTrace();
            MensagemUtil.mensagemErro(MensagemUtil.SALVAR_FALHA);
        }

    }

    public void cancelar (){
        Usuario usuario = new Usuario();

    }

    public void excluir(Usuario usuario){
        try {
            usuarioService.excluir(usuario);
            MensagemUtil.mensagemInfo(MensagemUtil.EXCLUIDO_SUCESSO);
        } catch (ServiceUsuarioException e) {
            e.printStackTrace();
            MensagemUtil.mensagemErro(MensagemUtil.EXCLUSAO_FALHA);
        }

    }

    public void editar(Usuario usuario){
        setUsuario(usuario); // para os campos do form receberem o usuario selecionado no botão editar.

    }
}
