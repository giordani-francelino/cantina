/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cantina.entidade;

/**
 *
 * @author patri
 */
public class Funcionario
        extends Pessoa {

    private String funcao;
    private String chave;
    private String senha;
    private Boolean ativo;

    //<editor-fold defaultstate="collapsed" desc="Construtores">
    public Funcionario() {
    }

    public Funcionario(String funcao, String chave, String senha, Boolean ativo, Long cpf, String nome, String endereco) {
        super(cpf, nome, endereco);
        this.funcao = funcao;
        this.chave = chave;
        this.senha = senha;
        this.ativo = ativo;
    }

//</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Getters / Setters">
    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public String getChave() {
        return chave;
    }

    public void setChave(String chave) {
        this.chave = chave;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

//</editor-fold>
    
    
    @Override
    public String toString() {
        return "Funcionario{"
//                + super.toString()
                + "id=" + getId()
                + ", funcao=" + funcao
                + ", chave=" + chave
                + ", senha=" + senha
                + ", ativo=" + ativo
                + '}' + '\n';
    }

}
