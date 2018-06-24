package com.dac.produtor.beans;

import java.io.Serializable;
import java.util.Date;

public class VacaBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private String nome;
    private float peso;
    private String observacao;
    private Date dataNascimento;
    private boolean doente;
    private boolean prenha;
    private RacaBean raca;

    public VacaBean() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public boolean isDoente() {
        return doente;
    }

    public void setDoente(boolean doente) {
        this.doente = doente;
    }

    public boolean isPrenha() {
        return prenha;
    }

    public void setPrenha(boolean prenha) {
        this.prenha = prenha;
    }

    public RacaBean getRaca() {
        return raca;
    }

    public void setRaca(RacaBean raca) {
        this.raca = raca;
    }

}
