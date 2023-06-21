/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cantina.repositorio;

import com.mycompany.cantina.entidade.Cliente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author patri
 */
public class ClienteDao extends Dao<Cliente> {

    public static final String TABLE = "cliente";

    @Override
    public String getSaveStatment() {
        return "insert into " + TABLE
                + "(especial) values (?)";
    }

    @Override
    public String getUpdateStatment() {
        return "update " + TABLE
                + " set especial = ? where id = ?";
    }

    @Override
    public void composeSaveOrUpdateStatement(PreparedStatement pstmt, Cliente e) {
        try
        {
            pstmt.setObject(1, e.getEspecial(), java.sql.Types.BOOLEAN);

            if (e.getId() != null)
            {
                pstmt.setObject(2, e.getId(), java.sql.Types.BIGINT);
            }
        } catch (SQLException ex)
        {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getDeleteByIdStatment() {
        return "delete from " + TABLE + " where id = ?";
    }

    @Override
    public String getFindByIdStatment() {
        return "select id, especial"
                + " from " + TABLE + " where id = ?";
    }

    @Override
    public String getFindAllStatment() {
        return "select id, especial"
                + " from " + TABLE;
    }

    @Override
    public Cliente extractObject(ResultSet resultSet) {
        Cliente cliente = null;

        try
        {
            cliente = new Cliente();

            cliente.setId(resultSet.getLong("id"));
            cliente.setEspecial(resultSet.getBoolean("especial"));

        } catch (SQLException ex)
        {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return cliente;
    }

}
