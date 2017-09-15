package br.com.assembleia.controller;

import br.com.assembleia.model.Usuario;
import java.util.Calendar;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/**
 *
 * @author fernandosaltoleto
 */
@Controller
@Scope("session")
public class AplicacaoControle {

    private Usuario usuario;

    public String sair() {
        return "login?faces-redirect=true";
    }

    public Usuario getUsuario() {
        usuario = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
        return usuario;
    }

    public boolean validaUsuario() {
        usuario = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
        if (usuario != null) {
            if (usuario.getAutorizacao().toString().equals("ADMIN")) {
                return true;
            }
        }
        adicionaMensagem("Usuário sem permissão para Exclusão!", FacesMessage.SEVERITY_WARN);
        return false;
    }

    public static void adicionaMensagem(String message, FacesMessage.Severity tipo) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.getExternalContext().getFlash().setKeepMessages(true);
        context.addMessage(null, new FacesMessage(tipo, message, null));
    }

    public String dataAno() {
        Calendar data = Calendar.getInstance();
        String ano = String.valueOf(data.get(Calendar.YEAR));
        return ano;
    }

    public static Integer dataAnoInteger() {
        Calendar data = Calendar.getInstance();
        Integer ano = (data.get(Calendar.YEAR));
        return ano;
    }

}
