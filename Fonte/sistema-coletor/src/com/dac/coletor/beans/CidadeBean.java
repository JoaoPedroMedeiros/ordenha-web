package com.dac.coletor.beans;

import java.io.Serializable;

public class CidadeBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id;
    private String nome;
    private EstadoBean estado;

    public CidadeBean() {
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

    public EstadoBean getEstado() {
        return estado;
    }

    public void setEstado(EstadoBean estado) {
        this.estado = estado;
    }

}
