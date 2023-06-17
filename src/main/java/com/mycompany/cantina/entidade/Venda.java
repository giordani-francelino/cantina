/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cantina.entidade;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author patri
 */
public class Venda
        extends Entidade {

    private LocalDate dataVenda;
    ArrayList<Pagamento> pagamentos;
    ArrayList<ItemVenda> itensVendas;

    //<editor-fold defaultstate="collapsed" desc="Construtores">
    public Venda() {
        pagamentos = new ArrayList<>();
        itensVendas = new ArrayList<>();
    }

    public Venda(LocalDate dataVenda) {
        this();
        this.dataVenda = dataVenda;
    }

//</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Getters / Setters">
    public LocalDate getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(LocalDate dataVenda) {
        this.dataVenda = dataVenda;
    }

    public ArrayList<Pagamento> getPagamentos() {
        return pagamentos;
    }

    public void setPagamentos(ArrayList<Pagamento> pagamentos) {
        this.pagamentos = pagamentos;
    }

    public ArrayList<ItemVenda> getItemVendas() {
        return itensVendas;
    }

    public void setItemVendas(ArrayList<ItemVenda> itemVendas) {
        this.itensVendas = itemVendas;
    }

//</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Adciona PAGAMENTO e ItemVenda">
    public void adicionarPagamentos(Pagamento pagamento) {
        pagamentos.add(pagamento);
        pagamento.setVenda(this);
    }

    public void adicionarItemVenda(ItemVenda itemVenda) {
        itensVendas.add(itemVenda);
        itemVenda.setVenda(this);
    }

//</editor-fold>
    @Override
    public String toString() {
        return "Venda{"
                + "dataVenda=" + dataVenda
                + ", pagamentos=" + pagamentos
                + ", itensVendas=" + itensVendas
                + '}';
    }

}
