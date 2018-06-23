/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dac.produtor.beans;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author joaov
 */
public class OrdenhaBean implements Serializable{
  
  private int id;
  private int vacas;
  private Date dataHora;
  private float total;
  private UsuarioBean usuario;

  public OrdenhaBean() {
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getVacas() {
    return vacas;
  }

  public void setVacas(int vacas) {
    this.vacas = vacas;
  }

  public Date getDataHora() {
    return dataHora;
  }

  public void setDataHora(Date dataHora) {
    this.dataHora = dataHora;
  }

  public float getTotal() {
    return total;
  }

  public void setTotal(float total) {
    this.total = total;
  }

  public UsuarioBean getUsuario() {
    return usuario;
  }

  public void setUsuario(UsuarioBean usuario) {
    this.usuario = usuario;
  }
  
  
}
