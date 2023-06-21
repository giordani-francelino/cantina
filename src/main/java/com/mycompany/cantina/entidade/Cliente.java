/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cantina.entidade;

/**
 *
 * @author patri
 */
public class Cliente
        extends Pessoa {

    private Boolean especial;

    //<editor-fold defaultstate="collapsed" desc="Construtores">
    public Cliente() {
    }

    public Cliente(Boolean especial, Long cpf, String nome, String endereco) {
        super(cpf, nome, endereco);
        this.especial = especial;
    }

//</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Getters / Setters">
    public Boolean getEspecial() {
        return especial;
    }

    public void setEspecial(Boolean especial) {
        this.especial = especial;
    }

//</editor-fold>
    @Override
    public String toString() {
        return "Cliente{"
//                + super.toString()
                + "id=" + getId()
                + "especial=" + especial
                + '}' + '\n';
    }

}
