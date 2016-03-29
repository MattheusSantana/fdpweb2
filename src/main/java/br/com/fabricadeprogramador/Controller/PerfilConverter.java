package br.com.fabricadeprogramador.Controller;

import br.com.fabricadeprogramador.entidades.Perfil;
import br.com.fabricadeprogramador.service.PerfilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

/**
 * Created by Matheus on 26/03/2016.
 */
@Component("perfilConverter")
public class PerfilConverter implements Converter {

    @Autowired
    private PerfilService perfilService;

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
        //Aqui a conversão do ID que vem como String da tela para uma
        //instancia de objeto do tipo Perfil
        if (value==null ||  value.isEmpty())  return null;
        int id = Integer.parseInt(value);
        Perfil p = perfilService.buscarPorId(id);
        return p;

    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
        //Aqui a conversão do Objeto que vem do Controller para um ID
        //String para a tela
        if(value==null|| !(value instanceof Perfil)) return ""; // se o valor vindo da tela for nulo ele retorno vazio.

        Perfil perfil = (Perfil)value;
        return perfil.getId().toString();
    }
}
