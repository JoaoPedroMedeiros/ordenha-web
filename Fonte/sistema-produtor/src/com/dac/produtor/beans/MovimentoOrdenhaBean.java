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
public class MovimentoOrdenhaBean implements Serializable{
  
  private OrdenhaBean ordenha;

  public MovimentoOrdenhaBean() {
  }

  public OrdenhaBean getOrdenha() {
    return ordenha;
  }

  public void setOrdenha(OrdenhaBean ordenha) {
    this.ordenha = ordenha;
  }
  
  
}
