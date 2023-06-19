/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cantina.repositorio;

import com.mycompany.cantina.entidade.Cardapio;
import com.mycompany.cantina.entidade.ItemCardapio;
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
public class ItemCardapioDao
        extends Dao<ItemCardapio> {

    public static final String TABLE = "itemCardapio";

    @Override
    public String getSaveStatment() {
        return "insert into " + TABLE + "(idCardapio, idProduto, quantidade, preco) values (?, ?, ?, ?)";
    }

    @Override
    public String getUpdateStatment() {
        return "update " + TABLE + " set idCardapio = ?, idProduto = ?, quantidade = ?, preco = ? where id = ?";
    }

    @Override
    public void composeSaveOrUpdateStatement(PreparedStatement pstmt, ItemCardapio e) {
        try
        {
            pstmt.setObject(1, e.getCardapio().getId(), java.sql.Types.BIGINT);
            pstmt.setObject(2, e.getProduto().getId(), java.sql.Types.BIGINT);
            pstmt.setObject(3, e.getQuantidade(), java.sql.Types.INTEGER);
            pstmt.setObject(4, e.getPreco(), java.sql.Types.INTEGER);

            if (e.getId() != null)
            {
                pstmt.setObject(5, e.getId(), java.sql.Types.BIGINT);
            }
        } catch (SQLException ex)
        {
            Logger.getLogger(ItemCardapioDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getDeleteByIdStatment() {
        return "delete from " + TABLE + " where id = ?";
    }

    @Override
    public String getFindByIdStatment() {
        return "select id, idCardapio, idProduto, quantidade, preco"
                + " from " + TABLE + " where id = ?";
    }

    @Override
    public String getFindAllStatment() {
        return "select id, idCardapio, idProduto, quantidade, preco"
                + " from " + TABLE;
    }

    @Override
    public ItemCardapio extractObject(ResultSet resultSet) {
        Cardapio cardapio = null;
        Produto produto = null;
        ItemCardapio itemCardapio = null;

        try
        {
            Long idCardapio = resultSet.getLong("idCardapio");
            Long idProduto = resultSet.getLong("idProduto");
            
            cardapio = new CardapioDao().findById(idCardapio);
            produto = new ProdutoDao().findById(idProduto);
            
            itemCardapio = new ItemCardapio();
            itemCardapio.setCardapio(cardapio);
            itemCardapio.setProduto(produto);
            itemCardapio.setId(resultSet.getLong("id"));
            itemCardapio.setQuantidade(resultSet.getInt("quantidade"));
            itemCardapio.setPreco(resultSet.getDouble("preco"));
        } catch (SQLException ex)
        {
            Logger.getLogger(ItemCardapioDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return itemCardapio;
    }

}
