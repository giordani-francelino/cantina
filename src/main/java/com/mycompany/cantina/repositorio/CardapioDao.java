/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cantina.repositorio;

import com.mycompany.cantina.entidade.Cardapio;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author patri
 */
public class CardapioDao
        extends Dao<Cardapio> {

    public static final String TABLE = "cardapio";

    @Override
    public String getSaveStatment() {
        return "insert into" + TABLE + "(id, descricao, valor) values (?, ?, ?)";
    }

    @Override
    public String getUpdateStatment() {
        return "update" + TABLE + "set descricao = ?, valor = ? where id = ?";
    }

    @Override
    public void composeSaveOrUpdateStatement(PreparedStatement pstmt, Cardapio e) {
        try
        {
            if (e.getId() != null)
            {
                pstmt.setObject(1, e.getId(), java.sql.Types.BIGINT);
            }

            pstmt.setObject(2, e.getDescricao(), java.sql.Types.VARCHAR);
            pstmt.setObject(3, e.getValor(), java.sql.Types.DOUBLE);
        } catch (SQLException ex)
        {
            Logger.getLogger(CardapioDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getDeleteByIdStatment() {
        return "delete from " + TABLE + " where id = ?";
    }

    @Override
    public String getFindByIdStatment() {
        return "select id, descricao, valor"
                + " from " + TABLE + "where id = ?";
    }

    @Override
    public String getFindAllStatment() {
        return "select id, descricao, valor"
                + " from " + TABLE;
    }

    @Override
    public Cardapio extractObject(ResultSet resultSet) {
        Cardapio cardapio = null;

        try
        {
            cardapio = new Cardapio();
            cardapio.setId(resultSet.getLong("id"));
            cardapio.setDescricao(resultSet.getString("descricao"));
            cardapio.setValor(resultSet.getDouble("valor"));
        } catch (Exception ex)
        {
            Logger.getLogger(CardapioDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return cardapio;
    }

}
