package com.dac.produtor.beans;

import java.io.Serializable;

/**
 *
 * @author joaov
 */
public class VacaOrdenhadaBean implements Serializable {
    
    private static final long serialVersionUID = 1L;
    private Integer id;
    private Float quantidadeLeite;
    private VacaBean vaca;
    private OrdenhaBean ordenha;

    public VacaOrdenhadaBean() {
    }

    public Float getQuantidadeLeite() {
        return quantidadeLeite;
    }

    public void setQuantidadeLeite(Float quantidadeLeite) {
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}
