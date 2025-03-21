package br.com.meuapp;


import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import java.io.Serializable;


@Named
@ViewScoped
public class MeuBean implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nome;
    private String mensagem;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void saudacao() {
        this.mensagem = "Olá, " + nome + "! Seja bem-vindo ao JSF!";
    }
}
