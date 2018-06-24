package com.dac.produtor.beans;

import java.io.Serializable;
import java.util.Date;

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

    @Override
    public Float getQuantidade() {
        Float quantidade = 0F;
        if (getOrdenha() != null && getOrdenha().getVacas() != null)
            for (VacaOrdenhadaBean vacaOrdenhada : getOrdenha().getVacas()) {
                if (vacaOrdenhada.getQuantidadeLeite() != null)
                    quantidade += vacaOrdenhada.getQuantidadeLeite();
            }
        return quantidade;
    }

    @Override
    public Date getDataHora() {
        return getOrdenha() != null ? getOrdenha().getDataHora() : null;
    }
}
