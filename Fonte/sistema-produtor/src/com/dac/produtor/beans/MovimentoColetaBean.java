package com.dac.produtor.beans;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author joaov
 */
public class MovimentoColetaBean extends MovimentoTanqueBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private Float quantidade;
    
    private Date dataHora;
    
    @Override
    public Float getQuantidade() {
        return quantidade;
    }

    @Override
    public Date getDataHora() {
        return dataHora;
    }

    public void setQuantidade(Float quantidade) {
        this.quantidade = quantidade;
    }

    public void setDataHora(Date dataHora) {
        this.dataHora = dataHora;
    }
}
