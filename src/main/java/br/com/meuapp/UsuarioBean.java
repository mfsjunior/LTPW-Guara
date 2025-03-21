package br.com.meuapp;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;

@Named
@SessionScoped
public class UsuarioBean implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nome;
    private String email;
    private int idade;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String cadastrar() {
        return "sucesso.xhtml?faces-redirect=true";
    }
}
