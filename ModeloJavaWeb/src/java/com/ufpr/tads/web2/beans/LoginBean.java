package com.ufpr.tads.web2.beans;

import java.io.Serializable;


public class LoginBean implements Serializable {
    
    private int id;
    private String nome;

    public LoginBean() {}

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
    
}
