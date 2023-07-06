/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cantina.gui;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

/**
 *
 * @author Caixa
 */
public class TxtField extends javax.swing.JTextField {

    /**
     * Cor de fundo padrão.
     */
    private Color corPadrao;

    /**
     * Cor de fundo quando o componente ganha o foco.
     */
    private Color corFoco;

    //<editor-fold defaultstate="collapsed" desc="Construtores">
    public TxtField() {
        this(new Color(255, 255, 255), new Color(255, 255, 230));
    }

    public TxtField(Color corPadrao, Color corFoco) {
        corPadrao = this.getBackground();
        this.corPadrao = corPadrao;
        this.setBackground(this.corPadrao);
        this.corFoco = corFoco;
        this.addFocusListener(new FocusHander());
    }

    //</editor-fold>
//    
    //<editor-fold defaultstate="collapsed" desc="Getters/Setters">
    public Color getCorPadrao() {
        return corPadrao;
    }

    public void setCorPadrao(Color corPadrao) {
        this.corPadrao = corPadrao;
    }

    public Color getCorFoco() {
        return corFoco;
    }

    public void setCorFoco(Color corFoco) {
        this.corFoco = corFoco;
    }
    //</editor-fold>

    /**
     * Procedimento para alternância de cores de fundo.
     */
    private void alternarCor() {
        setBackground(
                getBackground().equals(corFoco)
                ? corPadrao
                : corFoco
        );
    }

    /**
     * Classe interna responsável pelo tratamento dos eventos de foco.
     */
    private class FocusHander implements FocusListener {

        /**
         * Ação para foco obtido.
         *
         * @param e Evento de foco.
         */
        @Override
        public void focusGained(FocusEvent e) {
            alternarCor();
            TxtField.this.selectAll();
        }

        /**
         * Ação para foco perdido.
         *
         * @param e Evento de foco.
         */
        @Override
        public void focusLost(FocusEvent e) {
            alternarCor();
        }

    }

}
