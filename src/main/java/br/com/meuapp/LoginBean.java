package br.com.meuapp;


import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.faces.context.FacesContext;
import jakarta.faces.application.FacesMessage;
import java.io.Serializable;

@Named
@SessionScoped
public class LoginBean implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String usuario;
    private String senha;

    public String login() {
        // Simulação de autenticação (substitua por um banco de dados real)
        if ("admin".equals(usuario) && "1234".equals(senha)) {
            FacesContext facesContext = FacesContext.getCurrentInstance();
            HttpSession session = ((HttpServletRequest) facesContext.getExternalContext().getRequest()).getSession();
            session.setAttribute("usuarioLogado", usuario);

            return "index.xhtml?faces-redirect=true"; // Redireciona para index.xhtml
        }

        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuário ou senha inválidos", null));
        return null;
    }

    public String logout() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpSession session = ((HttpServletRequest) facesContext.getExternalContext().getRequest()).getSession();
        session.invalidate(); // Finaliza a sessão

        return "login.xhtml?faces-redirect=true"; // Redireciona para login.xhtml
    }

    // Getters e Setters
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
