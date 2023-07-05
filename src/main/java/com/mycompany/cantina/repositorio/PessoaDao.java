/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cantina.repositorio;

import com.mycompany.cantina.entidade.Pagamento;
import com.mycompany.cantina.entidade.Pessoa;
import com.mycompany.cantina.entidade.Venda;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
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
                + " from " + TABLE + " order by nome";
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
        public List<Venda> localizarVendasPorIdPessoa(Pessoa pessoa) {

        try (PreparedStatement preparedStatement
                = DbConnection.getConnection().prepareStatement(
                        "select id, idPessoa, dataVenda"
                + " from Venda  where idPessoa = ? order by dataVenda")) {
            preparedStatement.setObject(1, pessoa.getId(), java.sql.Types.BIGINT);

            // Show the full sentence
            System.out.println(">> SQL: " + preparedStatement);

            // Performs the query on the database
            ResultSet resultSet = preparedStatement.executeQuery();

            // Returns the respective object
            return new VendaDao().extractObjects(resultSet);

        } catch (Exception ex) {
            System.out.println("Exception: " + ex);
        }

        return null;
    }

    
}
