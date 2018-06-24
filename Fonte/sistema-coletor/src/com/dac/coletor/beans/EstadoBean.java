package com.dac.coletor.beans;

import java.io.Serializable;

public class EstadoBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer id;
    private String nome;
    private String sigla;

    public EstadoBean() {
    }

    public Integer getId() {
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

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

}
