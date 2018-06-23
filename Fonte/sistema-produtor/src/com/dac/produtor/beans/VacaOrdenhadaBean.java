package com.dac.produtor.beans;

import java.io.Serializable;

/**
 *
 * @author joaov
 */
public class VacaOrdenhadaBean implements Serializable {
    
    private static final long serialVersionUID = 1L;
            
    private float quantidadeLeite;
    private VacaBean vaca;
    private OrdenhaBean ordenha;

    public VacaOrdenhadaBean() {
    }

    public float getQuantidadeLeite() {
        return quantidadeLeite;
    }

    public void setQuantidadeLeite(float quantidadeLeite) {
        this.quantidadeLeite = quantidadeLeite;
    }

    public VacaBean getVaca() {
        return vaca;
    }

    public void setVaca(VacaBean vaca) {
        this.vaca = vaca;
    }

    public OrdenhaBean getOrdenha() {
        return ordenha;
    }

    public void setOrdenha(OrdenhaBean ordenha) {
        this.ordenha = ordenha;
    }

}
