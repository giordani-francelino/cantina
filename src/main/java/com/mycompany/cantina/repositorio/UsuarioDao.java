/* 
 * Material didático destinado ao curso
 * de Programação Orientada a Objetos do 
 * Bacharelado em Ciência da Computação 
 * do IFNMG - Câmpus Montes Claros
 */
package com.mycompany.cantina.repositorio;

import com.mycompany.cantina.entidade.Usuario;
import com.mycompany.cantina.repositorio.UsuarioDao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Operações de persistência com a entidade Tarefa.
 *
 * <pre>CREATE TABLE `usuario` (
 *  `id` int(11) NOT NULL AUTO_INCREMENT,
 *  `nome` varchar(55) NOT NULL,
 *  `email` varchar(125) NOT NULL,
 *  `senha` char(32) NOT NULL,
 *  `administrador` tinyint(1) DEFAULT '0',
 *  PRIMARY KEY (`id`),
 *  UNIQUE KEY `email` (`email`)
 * ) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1</pre>
 *
 * @author Luis Guisso <luis dot guisso at ifnmg dot edu dot br>
 * @version 0.0.1, 10/08/2021
 */
public class UsuarioDao extends Dao<Usuario> {

    /**
     * Recupera a sentença SQL específica para a inserção da entidade no banco
     * de dados.
     *
     * @return Sentença SQl para inserção.
     */
    @Override
    public String getSaveStatment() {
        return "INSERT INTO usuario (id, nome, email, senha, administrador) VALUES (default, ?, ?, MD5(?), ?)";
    }

    /**
     * Recupera a sentença SQL específica para a busca da entidade no banco de
     * dados.
     *
     * @return Sentença SQl para busca por entidade.
     */
    @Override
    public String getFindByIdStatment() {
        return "SELECT * FROM usuario WHERE id = ?";
    }

    /**
     * Recupera a sentença SQL específica para a busca das entidades no banco de
     * dados.
     *
     * @return Sentença SQl para busca por entidades.
     */
    @Override
    public String getFindAllStatment() {
        return "SELECT * FROM usuario";
    }

    /**
     * Recupera a sentença SQL específica para a atualização da entidade no
     * banco de dados.
     *
     * @return Sentença SQl para atualização.
     */
    @Override
    public String getUpdateStatment() {
        return "UPDATE usuario SET nome = ?, email = ?, senha = MD5(?), administrador = ? WHERE id = ?";
    }

    /**
     * Recupera a sentença SQL específica para a exclusão da entidade no banco
     * de dados.
     *
     * @return Sentença SQl para exclusão.
     */
    @Override
    public String getDeleteByIdStatment() {
        return "DELETE FROM usuario WHERE id = ?";
    }

    /**
     * Insere os valores do objeto na senteça SQL específica para inserção ou
     * atualização de registros no banco de dados.
     *
     * @param pstmt Declaração previamente preparada.
     * @param usuario Dados do usuário a serem montados na SQL.
     */
    @Override
    public void composeSaveOrUpdateStatement(PreparedStatement pstmt, Usuario usuario) {
        // Tenta definir valores junto à sentença SQL preparada para execução 
        // no banco de dados.
        try {
            pstmt.setString(1, usuario.getNome());
            pstmt.setString(2, usuario.getEmail());
            pstmt.setString(3, usuario.getSenha());
            pstmt.setBoolean(4, usuario.getAdministrador());

            if (usuario.getId() != null) {
                pstmt.setLong(5, usuario.getId());
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Cria objeto a partir do registro fornecido pelo banco de dados.
     *
     * @param resultSet Resultado proveniente do banco de dados relacional.
     * @return Objeto constituído.
     */
    @Override
    public Usuario extractObject(ResultSet resultSet) {
        // Cria referência para montagem da tarefa
        Usuario usuario = new Usuario();

        // Tenta recuperar dados do registro retornado pelo banco de dados
        // e ajustar o estado da tarefa a ser mapeada
        try {
            usuario.setId(resultSet.getLong("id"));
            usuario.setNome(resultSet.getString("nome"));
            usuario.setEmail(resultSet.getString("email"));
            usuario.setSenha(resultSet.getString("senha"));
            usuario.setAdministrador(resultSet.getBoolean("administrador"));
            
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Devolve a tarefa mapeada
        return usuario;
    }

    public Usuario autenticar(Usuario usuario) {
        try ( PreparedStatement pstmt
                = DbConnection.getConnection().prepareStatement(
                        // Sentença SQL para validação de usuário
                        "SELECT * "
                        + "FROM usuario "
                        + "WHERE email = ? "
                        + "AND senha = MD5(?)")) {

            // Prepara a declaração com os dados do objeto passado
            pstmt.setString(1, usuario.getEmail());
            pstmt.setString(2, usuario.getSenha());

            // Executa o comando SQL
            ResultSet resultSet = pstmt.executeQuery();

            // Se há resultado retornado...
            if (resultSet.next()) {
                // ... implica que email e senha estão corretos 
                // para o usuário e devolve os dados completos deste
                return extractObject(resultSet);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

}
