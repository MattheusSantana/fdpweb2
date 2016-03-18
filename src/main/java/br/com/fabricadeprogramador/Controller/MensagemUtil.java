package br.com.fabricadeprogramador.Controller;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 * Created by Matheus on 17/03/2016.
 */
public class MensagemUtil {


    public static final String EXCLUIDO_SUCESSO = "Excluido com Sucesso!";
    public static final String EXCLUSAO_FALHA = "Não foi possível excluir!";
    public static final String SALVAR_SUCESSO = "Salvo com Sucesso!";
    public static final String SALVAR_FALHA = "Não foi possível salvar!";


    public static void mensagemInfo (String mensagem) {
        //Carregando contexto JSF
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,mensagem, null);
        //Adcionando objeto de mensagem no contexto.
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public static void mensagemErro(String mensagem){
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,mensagem,null);
        FacesContext.getCurrentInstance().addMessage(null, msg);

    }

    public static void mensagemAviso(String mensagem){
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_WARN,mensagem,null);
        FacesContext.getCurrentInstance().addMessage(null, msg);

    }
}
