/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cantina.repositorio;

import com.mycompany.cantina.entidade.Pessoa;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author patri
 */
public class PessoaDao
        extends Dao<Pessoa> {
    public static final String TABLE = "pessoa";

    @Override
    public String getSaveStatment() {
        return "insert into " + TABLE + "(cpf, nome, endereco) values (?, ?, ?)";
    }

    @Override
    public String getUpdateStatment() {
        return "update " + TABLE + " set cpf = ?, nome = ?, endereco = ? where id = ?";
    }

    @Override
    public void composeSaveOrUpdateStatement(PreparedStatement pstmt, Pessoa e) {
        try
        {
            pstmt.setObject(1, e.getCpf(), java.sql.Types.BIGINT);
            pstmt.setObject(2, e.getNome(), java.sql.Types.VARCHAR);
            pstmt.setObject(3, e.getEndereco(), java.sql.Types.VARCHAR);

            if (e.getId() != null)
            {
                pstmt.setObject(4, e.getId(), java.sql.Types.BIGINT);
            }
        } catch (SQLException ex)
        {
            Logger.getLogger(PessoaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getDeleteByIdStatment() {
        return "delete from " + TABLE + " where id = ?";
    }

    @Override
    public String getFindByIdStatment() {
        return "select id, cpf, nome, endereco"
                + " from " + TABLE + " where id = ?";
    }

    @Override
    public String getFindAllStatment() {
        return "select id, cpf, nome, endereco"
                + " from " + TABLE;
    }

    @Override
    public Pessoa extractObject(ResultSet resultSet) {
        Pessoa pessoa = null;

        try
        {
            pessoa = new Pessoa();
            pessoa.setId(resultSet.getLong("id"));
            pessoa.setCpf(resultSet.getLong("cpf"));
            pessoa.setNome(resultSet.getString("nome"));
            pessoa.setEndereco(resultSet.getString("endereco"));
        } catch (SQLException ex)
        {
            Logger.getLogger(PessoaDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return pessoa;
    }
}
