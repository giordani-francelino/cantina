/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cantina.repositorio;

import com.mycompany.cantina.entidade.Produto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author patri
 */
public class ProdutoDao
        extends Dao<Produto> {

    public static final String TABLE = "produto";

    @Override
    public String getSaveStatment() {
        return "insert into " + TABLE + "(descricao, preco) values (?, ?)";
    }

    @Override
    public String getUpdateStatment() {
        return "update " + TABLE + " set descricao = ?, preco = ? where id = ?";
    }

    @Override
    public void composeSaveOrUpdateStatement(PreparedStatement pstmt, Produto e) {
        try
        {

            pstmt.setObject(1, e.getDescricao(), java.sql.Types.VARCHAR);
            pstmt.setObject(2, e.getPreco(), java.sql.Types.DOUBLE);

            if (e.getId() != null)
            {
                pstmt.setObject(3, e.getId(), java.sql.Types.BIGINT);
            }
        } catch (SQLException ex)
        {
            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getDeleteByIdStatment() {
        return "delete from " + TABLE + " where id = ?";
    }

    @Override
    public String getFindByIdStatment() {
        return "select id, descricao, preco"
                + " from " + TABLE + " where id = ?";
    }

    @Override
    public String getFindAllStatment() {
        return "select id, descricao, preco"
                + " from " + TABLE;
    }

    @Override
    public Produto extractObject(ResultSet resultSet) {
        Produto produto = null;

        try
        {
            produto = new Produto();
            produto.setId(resultSet.getLong("id"));
            produto.setDescricao(resultSet.getString("descricao"));
            produto.setPreco(resultSet.getDouble("preco"));
        } catch (SQLException ex)
        {
            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return produto;
    }
}
