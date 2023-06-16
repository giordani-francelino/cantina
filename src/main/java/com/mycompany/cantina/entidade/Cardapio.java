/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cantina.entidade;

/**
 *
 * @author patri
 */
public class Cardapio
        extends Entidade {

    private String descricao;

    // valor: Atríbuto derivado
    private Double valor;

    //<editor-fold defaultstate="collapsed" desc="Construtores">
    public Cardapio() {
    }

    public Cardapio(String descricao, Double valor) {
        this.descricao = descricao;
        this.valor = valor;
    }

//</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Getters / Setters">
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    // TODO: Implementar o cálculo do valor
//</editor-fold>
    @Override
    public String toString() {
        return "Cardapio{"
                + "descricao=" + descricao
                + ", valor=" + valor
                + '}';
    }

}
