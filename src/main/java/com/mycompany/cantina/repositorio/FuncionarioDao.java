/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cantina.repositorio;

import com.mycompany.cantina.entidade.Funcionario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author patri
 */
public class FuncionarioDao extends
        Dao<Funcionario> {

    public static final String TABLE = "funcionario";

    @Override
    public String getSaveStatment() {
        return "insert into " + TABLE
                + "(funcao, chave, senha, ativo) values (?, ?, ?, ?)";
    }

    @Override
    public String getUpdateStatment() {
        return "update " + TABLE
                + " set funcao = ?, chave = ?, senha = ?, ativo = ? where id = ?";
    }

    @Override
    public void composeSaveOrUpdateStatement(PreparedStatement pstmt, Funcionario e) {
        try
        {
            pstmt.setObject(1, e.getFuncao(), java.sql.Types.VARCHAR);
            pstmt.setObject(2, e.getChave(), java.sql.Types.VARCHAR);
            pstmt.setObject(3, e.getSenha(), java.sql.Types.VARCHAR);
            pstmt.setObject(4, e.getAtivo(), java.sql.Types.BOOLEAN);

            if (e.getId() != null)
            {
                pstmt.setObject(5, e.getId(), java.sql.Types.BIGINT);
            }
        } catch (SQLException ex)
        {
            Logger.getLogger(FuncionarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getDeleteByIdStatment() {
        return "delete from " + TABLE + " where id = ?";
    }

    @Override
    public String getFindByIdStatment() {
        return "select id, funcao, chave, senha, ativo"
                + " from " + TABLE + " where id = ?";
    }

    @Override
    public String getFindAllStatment() {
        return "select id, funcao, chave, senha, ativo"
                + " from " + TABLE;
    }

    @Override
    public Funcionario extractObject(ResultSet resultSet) {
        Funcionario funcionario = null;

        try
        {
            funcionario = new Funcionario();

            funcionario.setId(resultSet.getLong("id"));
            funcionario.setFuncao(resultSet.getString("funcao"));
            funcionario.setChave(resultSet.getString("chave"));
            funcionario.setSenha(resultSet.getString("senha"));
            funcionario.setAtivo(resultSet.getBoolean("ativo"));

        } catch (SQLException ex)
        {
            Logger.getLogger(FuncionarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return funcionario;
    }

}
