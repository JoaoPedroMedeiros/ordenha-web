package com.dac.coletor.beans;

import java.io.Serializable;

public class UsuarioBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private int id;
    private String nome;
    private String login;
    private String senha;

    public UsuarioBean() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}
