/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cantina.entidade;

/**
 *
 * @author patri
 */
public class Pessoa
        extends Entidade {

    private Long cpf;
    private String nome;
    private String endereco;

    //<editor-fold defaultstate="collapsed" desc="Construtores">
    public Pessoa() {
    }

    public Pessoa(Long cpf, String nome, String endereco) {
        this.cpf = cpf;
        this.nome = nome;
        this.endereco = endereco;
    }

//</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Getters / Setters">
    public Long getCpf() {
        return cpf;
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

//</editor-fold>
    @Override
    public String toString() {
        return "Pessoa{"
                + "id=" + getId()
                + ", cpf=" + cpf
                + ", nome=" + nome
                + ", endereco=" + endereco
                + '}' + '\n';
    }

}
