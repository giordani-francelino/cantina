/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cantina.entidade;

import java.time.LocalDate;

/**
 *
 * @author patri
 */
public class Pagamento
        extends Entidade {

    private LocalDate dataPagamento;
    private LocalDate dataVencimento;
    private Double valorPagamento;
    private Double acrescimo;
    private Double desconto;
    private Venda venda;
    private Integer tipoPagamento;

    //<editor-fold defaultstate="collapsed" desc="Construtores">
    public Pagamento() {
    }

    public Pagamento(LocalDate dataPagamento, LocalDate dataVencimento, Double valorPagamento, Double acrescimo, Double desconto, Venda venda, Integer tipoPagamento) {
        this.dataPagamento = dataPagamento;
        this.dataVencimento = dataVencimento;
        this.valorPagamento = valorPagamento;
        this.acrescimo = acrescimo;
        this.desconto = desconto;
        this.venda = venda;
        this.tipoPagamento = tipoPagamento;
    }

//</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Getters / Setters">
    public LocalDate getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(LocalDate dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public LocalDate getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(LocalDate dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public Double getValorPagamento() {
        return valorPagamento;
    }

    public void setValorPagamento(Double valorPagamento) {
        this.valorPagamento = valorPagamento;
    }

    public Double getAcrescimo() {
        return acrescimo;
    }

    public void setAcrescimo(Double acrescimo) {
        this.acrescimo = acrescimo;
    }

    public Double getDesconto() {
        return desconto;
    }

    public void setDesconto(Double desconto) {
        this.desconto = desconto;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public Integer getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(Integer tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }
//</editor-fold>

    @Override
    public String toString() {
        return "Pagamento{"
                + "dataPagamento=" + dataPagamento
                + ", dataVencimento=" + dataVencimento
                + ", valorPagamento=" + valorPagamento
                + ", acrescimo=" + acrescimo
                + ", desconto=" + desconto
                + ", venda=" + venda
                + ", tipoPagamento=" + tipoPagamento
                + '}';
    }

}
