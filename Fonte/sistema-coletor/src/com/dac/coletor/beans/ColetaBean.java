package com.dac.coletor.beans;

import java.io.Serializable;
import java.util.Date;

public class ColetaBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private Float quantidade;
    private Date dataHora;
    private PropriedadeBean propriedade;

    public ColetaBean() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Float getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(float quantidade) {
        this.quantidade = quantidade;
    }

    public Date getDataHora() {
        return dataHora;
    }

    public void setDataHora(Date dataHora) {
        this.dataHora = dataHora;
    }

    public PropriedadeBean getPropriedade() {
        return propriedade;
    }

    public void setPropriedade(PropriedadeBean propriedade) {
        this.propriedade = propriedade;
    }

}
