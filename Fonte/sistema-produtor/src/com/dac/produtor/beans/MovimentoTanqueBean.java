package com.dac.produtor.beans;

import java.io.Serializable;
import java.util.Date;

public abstract class MovimentoTanqueBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private double quantidade;
    private Date date;

    public MovimentoTanqueBean() {
    }

    public double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}
