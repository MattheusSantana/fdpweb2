package br.com.fabricadeprogramador.Controller;

import br.com.fabricadeprogramador.entidades.Perfil;
import br.com.fabricadeprogramador.service.PerfilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import java.util.List;

/**
 * Created by Matheus on 26/03/2016.
 */


@Controller(value = "perfilController")
public class PerfilController {

    private Perfil perfil = new Perfil();

    private List<Perfil> perfis;

    @Autowired
    private PerfilService perfilService;


    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    public List<Perfil> getPerfis() {
        return perfis;
    }

    public void setPerfis(List<Perfil> perfis) {
        this.perfis = perfis;
    }

    @PostConstruct
    public void init(){
       perfil = new Perfil();
       perfis = perfilService.buscarTodos();
    }


}
