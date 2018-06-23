package com.dac.produtor.beans;

import java.io.Serializable;

/**
 *
 * @author joaov
 */
public class RacaBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id;
    private String descricao;

    public RacaBean() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}
