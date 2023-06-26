/* 
 * Material didático destinado ao curso
 * de Programação Orientada a Objetos do 
 * Bacharelado em Ciência da Computação 
 * do IFNMG - Câmpus Montes Claros
 */
package com.mycompany.cantina.entidade;

/**
 *
 * @author Luis Guisso <luis dot guisso at ifnmg dot edu dot br>
 */
public class Usuario extends Entidade {

    private String nome;
    private String email;
    private String senha;
    private Boolean administrador;

    public Usuario() {
    }

    public Usuario(Long id, String nome, String email, String senha, Boolean administrador) {
        super( id);
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.administrador = administrador;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Boolean getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Boolean administrador) {
        this.administrador = administrador;
    }

    @Override
    public String toString() {
        return nome + ", admin=" + administrador;
    }

}
