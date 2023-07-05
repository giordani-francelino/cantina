/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cantina.repositorio;

import com.mycompany.cantina.entidade.ItemVenda;
import com.mycompany.cantina.entidade.Produto;
import com.mycompany.cantina.entidade.Venda;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author patri
 */
public class ItemVendaDao
        extends Dao<ItemVenda> {

    public static final String TABLE = "itemVenda";

    @Override
    public String getSaveStatment() {
        return "insert into " + TABLE + " (idProduto, idVenda, quantidade, preco) values (?, ?, ?, ?)";
    }

    @Override
    public String getUpdateStatment() {
        return "update " + TABLE + " set idProduto =  ?, idVenda = ?, quantidade = ?, preco = ? where id = ?";
    }

    @Override
    public void composeSaveOrUpdateStatement(PreparedStatement pstmt, ItemVenda e) {
        try
        {
            pstmt.setObject(1, e.getProduto().getId(), java.sql.Types.BIGINT);
            pstmt.setObject(2, e.getVenda().getId(), java.sql.Types.BIGINT);
            pstmt.setObject(3, e.getQuantidade(), java.sql.Types.INTEGER);
            pstmt.setObject(4, e.getPreco(), java.sql.Types.DOUBLE);

            if (e.getId() != null)
            {
                pstmt.setObject(5, e.getId(), java.sql.Types.BIGINT);
            }
        } catch (SQLException ex)
        {
            Logger.getLogger(ItemVendaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getDeleteByIdStatment() {
        return "delete from " + TABLE + " where id = ?";
    }

    @Override
    public String getFindByIdStatment() {
        return "select id, idProduto, idVenda, quantidade, preco from " + TABLE + " where id = ?";
    }

    @Override
    public String getFindAllStatment() {
        return "select id, idProduto, idVenda, quantidade, preco from " + TABLE;
    }

    @Override
    public ItemVenda extractObject(ResultSet resultSet) {
        Produto produto = null;
        ItemVenda itemVenda = null;
        Venda venda = null;

        try
        {
            Long idProduto = resultSet.getLong("idProduto");
            Long idVenda = resultSet.getLong("idVenda");

            produto = new ProdutoDao().findById(idProduto);
            venda = new VendaDao().findById(idVenda);

            itemVenda = new ItemVenda();
            itemVenda.setProduto(produto);
            itemVenda.setVenda(venda);
            itemVenda.setId(resultSet.getLong("id"));
            itemVenda.setQuantidade(resultSet.getInt("quantidade"));
            itemVenda.setPreco(resultSet.getDouble("preco"));

        } catch (SQLException ex)
        {
            Logger.getLogger(ItemVendaDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ItemVendaDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return itemVenda;
    }
}
