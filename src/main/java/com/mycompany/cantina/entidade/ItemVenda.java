/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cantina.entidade;

/**
 *
 * @author patri
 */
public class ItemVenda
        extends Entidade {

    private Produto produto;
    private Venda venda;
    private Integer quantidade;
    private Double preco;

    //<editor-fold defaultstate="collapsed" desc="Construtores">
    public ItemVenda() {
    }

    public ItemVenda(Produto produto, Venda venda, Integer quantidade, Double preco) {
        this.produto = produto;
        this.venda = venda;
        this.quantidade = quantidade;
        this.preco = preco;
    }

//</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Getters / Setters">
    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
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
        return "ItemVenda{"
                + "produto=" + produto
                + ", venda=" + venda
                + ", quantidade=" + quantidade
                + ", preco=" + preco
                + '}';
    }

}
