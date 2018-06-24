package com.dac.produtor.beans;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class OrdenhaBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private Date dataHora;
    private List<VacaOrdenhadaBean> vacas;
    private UsuarioBean usuario;

    public OrdenhaBean() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public List<VacaOrdenhadaBean> getVacas() {
        return vacas;
    }

    public void setVacas(List<VacaOrdenhadaBean> vacas) {
        this.vacas = vacas;
    }
}
