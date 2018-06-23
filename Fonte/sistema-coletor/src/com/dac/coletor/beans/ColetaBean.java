/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dac.coletor.beans;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author joaov
 */
public class ColetaBean implements Serializable{

  private int id;
  private float quantidade;
  private Date dataHora; 
  private PropriedadeBean propriedade;

  public ColetaBean() {
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public float getQuantidade() {
    return quantidade;
  }

  public void setQuantidade(float quantidade) {
    this.quantidade = quantidade;
  }

  public Date getDataHora() {
    return dataHora;
  }

  public void setDataHora(Date dataHora) {
    this.dataHora = dataHora;
  }

  public PropriedadeBean getPropriedade() {
    return propriedade;
  }

  public void setPropriedade(PropriedadeBean propriedade) {
    this.propriedade = propriedade;
  }
  
  
}
