/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dac.produtor.beans;

import java.io.Serializable;

/**
 *
 * @author joaov
 */
public class VacaOrdenhadaBean implements Serializable{
  
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
