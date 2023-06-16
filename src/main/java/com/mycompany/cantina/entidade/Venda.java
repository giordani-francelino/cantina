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

    //<editor-fold defaultstate="collapsed" desc="Construtores">
    public Venda() {
        pagamentos = new ArrayList<>();
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

//</editor-fold>
    
    /* OPCIONAL */
    public void adicionarPagamentos(Pagamento pagamento) {
        pagamentos.add(pagamento);
        pagamento.setVenda(this);
    }

    @Override
    public String toString() {
        return "Venda{"
                + "dataVenda=" + dataVenda
                + ", pagamentos=" + pagamentos
                + '}';
    }
    
}
