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
public class MovimentoTanqueBean implements Serializable{
  
  private double quantidade;
  private Date date;

  public MovimentoTanqueBean() {
  }

  public double getQuantidade() {
    return quantidade;
  }

  public void setQuantidade(double quantidade) {
    this.quantidade = quantidade;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }
  
  
  
}
