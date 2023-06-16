/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cantina.entidade;

/**
 *
 * @author patri
 */
public class Produto
        extends Entidade {

    private String descricao;
    private Double preco;

    //<editor-fold defaultstate="collapsed" desc="Construtores">
    public Produto() {
    }

    public Produto(String descricao, Double preco) {
        this.descricao = descricao;
        this.preco = preco;
    }

//</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Getters / Setters">
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

//</editor-fold>
    @Override
    public String toString() {
        return "Produto{"
                + "descricao=" + descricao
                + ", preco=" + preco
                + '}';
    }
}
