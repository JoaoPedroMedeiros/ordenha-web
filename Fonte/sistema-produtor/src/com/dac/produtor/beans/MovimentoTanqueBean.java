package com.dac.produtor.beans;

import java.io.Serializable;
import java.util.Date;

public abstract class MovimentoTanqueBean implements Serializable {

    private static final long serialVersionUID = 1L;

    public MovimentoTanqueBean() {
    }

    public abstract Float getQuantidade();
    
    public abstract Date getDataHora();

}
