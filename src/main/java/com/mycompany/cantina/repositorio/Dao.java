/*
 * CC BY-NC-SA 4.0
 */
package com.mycompany.cantina.repositorio;

import com.mycompany.cantina.entidade.Entidade;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Class Dao
 *
 * @author Luis Guisso &lt;luis dot guisso at ifnmg dot edu dot br&gt;
 * @version 0.1, 2022-10-24
 * @param <T> Entidade data type
 */
public abstract class Dao<T>
        implements IDao<T> {

    public static final String DB = "cantina";

    @Override
    public Long saveOrUpdate(T e) throws Exception {

        // Primary key
        Long id = 0L;

        if (((Entidade) e).getId() == null
                || ((Entidade) e).getId() == 0) {

            // Insert a new register
            // try-with-resources
            try (PreparedStatement preparedStatement
                    = DbConnection.getConnection().prepareStatement(
                            getSaveStatment(),
                            Statement.RETURN_GENERATED_KEYS)) {

                // Assemble the SQL statement with the data (->?)
                composeSaveOrUpdateStatement(preparedStatement, e);

                // Show the full sentence
                System.out.println(">> SQL: " + preparedStatement);

                // Performs insertion into the database
                preparedStatement.executeUpdate();

                // Retrieve the generated primary key
                ResultSet resultSet = preparedStatement.getGeneratedKeys();

                // Moves to first retrieved data
                if (resultSet.next()) {

                    // Retrieve the returned primary key
                    id = resultSet.getLong(1);
                }

            } catch (Exception ex) {
                System.out.println(">> " + ex);
                throw new Exception("Não foi possível inserir ou atualizar o registro");
            }

        } else {
            // Update existing record
            try (PreparedStatement preparedStatement
                    = DbConnection.getConnection().prepareStatement(
                            getUpdateStatment())) {

                // Assemble the SQL statement with the data (->?)
                composeSaveOrUpdateStatement(preparedStatement, e);

                // Show the full sentence
                System.out.println(">> SQL: " + preparedStatement);

                // Performs the update on the database
                preparedStatement.executeUpdate();

                // Keep the primary key
                id = ((Entidade) e).getId();

            } catch (Exception ex) {
                System.out.println("Exception: " + ex);
                throw new Exception("Não foi possível inserir ou atualizar o registro");
            }
        }

        return id;
    }

    @Override
    public T findById(Long id) throws Exception {

        try (PreparedStatement preparedStatement
                = DbConnection.getConnection().prepareStatement(
                        getFindByIdStatment())) {

            // Assemble the SQL statement with the id
            preparedStatement.setLong(1, id);

            // Show the full sentence
            System.out.println(">> SQL: " + preparedStatement);
            // Performs the query on the database
            ResultSet resultSet = preparedStatement.executeQuery();

            // Returns the respective object if exists
            if (resultSet.next()) {
                return extractObject(resultSet);
            }

        } catch (Exception ex) {
            System.out.println("Exception: " + ex);
            throw new Exception("Não foi possível consultar o registro");
        }

        return null;
    }

    @Override
    public boolean deleteById(Long id) throws Exception {

        try (PreparedStatement preparedStatement
                = DbConnection.getConnection().prepareStatement(
                        getDeleteByIdStatment())) {

            // Assemble the SQL statement with the id
            preparedStatement.setLong(1, id);

            // Show the full sentence
            System.out.println(">> SQL: " + preparedStatement);
            // Performs the query on the database

            // Returns the respective object if exists
            return preparedStatement.execute();

        } catch (Exception ex) {
            System.out.println("Exception: " + ex);
            throw new Exception("Não foi possível excluir o registro");
        }
    }

    @Override
    public List<T> findAll() {

        try (PreparedStatement preparedStatement
                = DbConnection.getConnection().prepareStatement(
                        getFindAllStatment())) {

            // Show the full sentence
            System.out.println(">> SQL: " + preparedStatement);

            // Performs the query on the database
            ResultSet resultSet = preparedStatement.executeQuery();

            // Returns the respective object
            return extractObjects(resultSet);

        } catch (Exception ex) {
            System.out.println("Exception: " + ex);
        }

        return null;
    }

    @Override
    public List<T> extractObjects(ResultSet resultSet) {
        List<T> objects = new ArrayList<>();

        try {
            while (resultSet.next()) {
                objects.add(extractObject(resultSet));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return objects.isEmpty() ? null : objects;
    }

    @Override
    public Long salvar(T o) {

        Long id = 0L;

        // Novo registro
        if (((Entidade) o).getId() == null || ((Entidade) o).getId() == 0) {

            // try-with-resources libera recurso ao final do bloco (PreparedStatement)
            try (PreparedStatement pstmt
                    = DbConnection.getConnection().prepareStatement(
                            // Sentença SQL para inserção de registros
                            getSaveStatment(),
                            // Especifica que a(s) chave(s) primária(s) devem ser
                            // retornadas como resposta
                            Statement.RETURN_GENERATED_KEYS)) {

                // Prepara a declaração com os dados do objeto passado
                composeSaveOrUpdateStatement(pstmt, o);

                // Executa o comando SQL
                pstmt.executeUpdate();

                // Recupera os resultados da execução: chaves primárias dos registros criados
                ResultSet rs = pstmt.getGeneratedKeys();

                // Se há alguma chave, move para o primeiro registro...
                if (rs.next()) {
                    // TODO Retorno imediato (return ...)?
                    // TODO Repensar a estratégia de uso de K: Integer? String?
                    // ... e recupera o (único) longo retornado
                    id = rs.getLong(1);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        } else {
            // Atualizar registro

            try (PreparedStatement pstmt
                    = DbConnection.getConnection().prepareStatement(
                            // Sentença SQL para atualização de registros
                            getUpdateStatment())) {

                // Prepara a declaração com os dados do objeto passado
                composeSaveOrUpdateStatement(pstmt, o);

                // Executa o comando SQL
                pstmt.executeUpdate();

                // Retorno da mesma id recebida com o objeto para manter
                // compatibilidade com o procedimento do método
                // TODO Retorno imediato (return ...)?
                id = ((Entidade) o).getId();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        // Cast requerido para adaptação do tipo pois, mesmo que a id seja sempre
        // longa, esse trecho de código não reconhece tal tipo implicitamente
        return id;
    }

}
