/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cantina.entidade;

/**
 *
 * @author patri
 */
public class ItemCardapio
        extends Entidade {

    private Cardapio cardapio;
    private Produto produto;

    private Integer quantidade;
    private Double preco;

    //<editor-fold defaultstate="collapsed" desc="Construtores">
    public ItemCardapio() {
    }

    public ItemCardapio(Cardapio cardapio, Produto produto, Integer quantidade, Double preco) {
        this.cardapio = cardapio;
        this.produto = produto;
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

    public Cardapio getCardapio() {
        return cardapio;
    }

    public void setCardapio(Cardapio cardapio) {
        this.cardapio = cardapio;
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
        return "ItemCardapio{"
                + "id=" + getId()
//                + ", idCardapio=" + cardapio.getId()
//                + ", idProduto=" + produto.getId()
                + ", quantidade=" + quantidade
                + ", preco=" + preco
                + '}' + '\n';
    }

}
