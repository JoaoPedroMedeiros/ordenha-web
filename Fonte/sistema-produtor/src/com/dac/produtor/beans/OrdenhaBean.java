package com.dac.produtor.beans;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *
 * @author joaov
 */
public class OrdenhaBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id;
    private Date dataHora;
    private List<VacaBean> vacas;
    private UsuarioBean usuario;

    public OrdenhaBean() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDataHora() {
        return dataHora;
    }

    public void setDataHora(Date dataHora) {
        this.dataHora = dataHora;
    }

    public UsuarioBean getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioBean usuario) {
        this.usuario = usuario;
    }

    public List<VacaBean> getVacas() {
        return vacas;
    }

    public void setVacas(List<VacaBean> vacas) {
        this.vacas = vacas;
    }

}
