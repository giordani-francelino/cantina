/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cantina.repositorio;

import com.mycompany.cantina.entidade.Pessoa;
import com.mycompany.cantina.entidade.Venda;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author patri
 */
public class VendaDao
        extends Dao<Venda> {

    public static final String TABLE = "venda";

    @Override
    public String getSaveStatment() {
        return "insert into " + TABLE + "(idPessoa, dataVenda) values (?, ?)";
    }

    @Override
    public String getUpdateStatment() {
        return "update " + TABLE + " set idPessoa = ?, dataVenda = ? where id = ?";
    }

    @Override
    public void composeSaveOrUpdateStatement(PreparedStatement pstmt, Venda e) {
        try
        {
            pstmt.setObject(1, e.getPessoa().getId(), java.sql.Types.BIGINT);
            pstmt.setObject(2, e.getDataVenda(), java.sql.Types.DATE);

            if (e.getId() != null)
            {
                pstmt.setObject(3, e.getId(), java.sql.Types.BIGINT);
            }
        } catch (SQLException ex)
        {
            Logger.getLogger(VendaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getDeleteByIdStatment() {
        return "delete from " + TABLE + " where id = ?";
    }

    @Override
    public String getFindByIdStatment() {
        return "select id, idPessoa, dataVenda"
                + " from " + TABLE + " where id = ?";
    }

    @Override
    public String getFindAllStatment() {
        return "select id, idPessoa, dataVenda"
                + " from " + TABLE;
    }

    @Override
    public Venda extractObject(ResultSet resultSet) {
        Venda venda = null;
        Pessoa pessoa = null;

        try
        {
            Long idPessoa = resultSet.getLong("idPessoa");
            
            pessoa = new PessoaDao().findById(idPessoa);
            
            venda = new Venda();
            venda.setPessoa(pessoa);
            venda.setId(resultSet.getLong("id"));
            venda.setDataVenda(
                    resultSet.getObject("dataVenda", LocalDate.class));
        } catch (SQLException ex)
        {
            Logger.getLogger(VendaDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(VendaDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return venda;
    }

}
