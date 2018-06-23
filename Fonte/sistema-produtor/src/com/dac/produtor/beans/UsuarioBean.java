package com.dac.produtor.beans;

import java.io.Serializable;

/**
 *
 * @author joaov
 */
public class UsuarioBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id;
    private String login;
    private String nome;
    private String senha;
    private PropriedadeBean propriedade;

    public UsuarioBean() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public PropriedadeBean getPropriedade() {
        return propriedade;
    }

    public void setPropriedade(PropriedadeBean propriedade) {
        this.propriedade = propriedade;
    }

}
