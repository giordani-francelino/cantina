/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cantina.repositorio;

import com.mycompany.cantina.entidade.Pagamento;
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
public class PagamentoDao
        extends Dao<Pagamento> {

    public static final String TABLE = "pagamento";

    @Override
    public String getSaveStatment() {
        return "insert into " + TABLE
                + "(idVenda, dataPagamento, dataVencimento, valorPagamento"
                + ", acrescimo, desconto, tipoPagamento)"
                + " values (?, ?, ?, ?, ?, ?, ?)";
    }

    @Override
    public String getUpdateStatment() {
        return "update " + TABLE
                + " set idVenda = ?, dataPagamento = ?, dataVencimento = ?, valorPagamento = ?"
                + ", acrescimo = ?, desconto = ?, tipoPagamento = ?"
                + " where id = ?";
    }

    @Override
    public void composeSaveOrUpdateStatement(PreparedStatement pstmt, Pagamento e) {
        try
        {
            pstmt.setObject(1, e.getVenda().getId(), java.sql.Types.BIGINT);
            pstmt.setObject(2, e.getDataPagamento(), java.sql.Types.DATE);
            pstmt.setObject(3, e.getDataVencimento(), java.sql.Types.DATE);
            pstmt.setObject(4, e.getValorPagamento(), java.sql.Types.DOUBLE);
            pstmt.setObject(5, e.getAcrescimo(), java.sql.Types.DOUBLE);
            pstmt.setObject(6, e.getDesconto(), java.sql.Types.DOUBLE);
            pstmt.setObject(7, e.getTipoPagamento(), java.sql.Types.INTEGER);

            if (e.getId() != null)
            {
                pstmt.setObject(8, e.getId(), java.sql.Types.BIGINT);
            }
        } catch (SQLException ex)
        {
            Logger.getLogger(PagamentoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getDeleteByIdStatment() {
        return "delete from " + TABLE + " where id = ?";
    }

    @Override
    public String getFindByIdStatment() {
        return "select id, idVenda, dataPagamento, dataVencimento, valorPagamento"
                + ", acrescimo, desconto, tipoPagamento"
                + " from " + TABLE + " where id = ?";
    }

    @Override
    public String getFindAllStatment() {
        return "select id, idVenda, dataPagamento, dataVencimento, valorPagamento"
                + ", acrescimo, desconto, tipoPagamento"
                + " from " + TABLE;
    }

    @Override
    public Pagamento extractObject(ResultSet resultSet) {
        Venda venda = null;
        Pagamento pagamento = null;

        try
        {
            Long idVenda = resultSet.getLong("idVenda");

            venda = new VendaDao().findById(idVenda);

            pagamento = new Pagamento();
            pagamento.setVenda(venda);
            pagamento.setId(resultSet.getLong("id"));
            pagamento.setDataPagamento(
                    resultSet.getObject("dataPagamento", LocalDate.class));
            pagamento.setDataVencimento(
                    resultSet.getObject("dataVencimento", LocalDate.class));
            pagamento.setValorPagamento(resultSet.getDouble("valorPagamento"));
            pagamento.setAcrescimo(resultSet.getDouble("acrescimo"));
            pagamento.setDesconto(resultSet.getDouble("desconto"));
            pagamento.setTipoPagamento(resultSet.getInt("tipoPagamento"));
        } catch (SQLException ex)
        {
            Logger.getLogger(PagamentoDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return pagamento;
    }

}
