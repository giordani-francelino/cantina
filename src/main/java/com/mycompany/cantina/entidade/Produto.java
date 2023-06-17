/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cantina.entidade;

import java.util.ArrayList;

/**
 *
 * @author patri
 */
public class Produto
        extends Entidade {

    private String descricao;
    private Double preco;
    ArrayList<ItemVenda> itensVendas;
    ArrayList<ItemCardapio> itensCardapios;

    //<editor-fold defaultstate="collapsed" desc="Construtores">
    public Produto() {
        itensVendas = new ArrayList<>();
        itensCardapios = new ArrayList<>();
    }

    public Produto(String descricao, Double preco) {
        this();
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

    public ArrayList<ItemVenda> getItemVendas() {
        return itensVendas;
    }

    public void setItemVendas(ArrayList<ItemVenda> itemVendas) {
        this.itensVendas = itemVendas;
    }

    public ArrayList<ItemVenda> getItens() {
        return itensVendas;
    }

    public void setItens(ArrayList<ItemVenda> itens) {
        this.itensVendas = itens;
    }

    public ArrayList<ItemCardapio> getCardapios() {
        return itensCardapios;
    }

    public void setCardapios(ArrayList<ItemCardapio> cardapios) {
        this.itensCardapios = cardapios;
    }

//</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Adiciona item (VENDA e CARDÁPIO">
    public void adicionarItemVenda(ItemVenda itemVenda) {
        itensVendas.add(itemVenda);
        itemVenda.setProduto(this);
    }

    public void adicionarCardapio(ItemCardapio itemCardapio) {
        itensCardapios.add(itemCardapio);
        itemCardapio.setProduto(this);
    }

//</editor-fold>
    @Override
    public String toString() {
        return "Produto{"
                + "descricao=" + descricao
                + ", preco=" + preco
                + ", itensVendas=" + itensVendas
                + ", itensCardapios=" + itensCardapios
                + '}';
    }

}
