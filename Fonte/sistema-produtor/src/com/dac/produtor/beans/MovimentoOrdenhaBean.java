package com.dac.produtor.beans;

import java.io.Serializable;

public class MovimentoOrdenhaBean extends MovimentoTanqueBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private OrdenhaBean ordenha;

    public MovimentoOrdenhaBean() {
    }

    public OrdenhaBean getOrdenha() {
        return ordenha;
    }

    public void setOrdenha(OrdenhaBean ordenha) {
        this.ordenha = ordenha;
    }

}
