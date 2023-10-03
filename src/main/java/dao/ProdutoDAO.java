package main.java.dao;

import main.java.dao.jdbc.ConnectionFactory;
import main.java.domain.Cliente;
import main.java.domain.Produto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO implements IProdutoDAO {
    @Override
    public Integer cadastrar(Produto produto) throws SQLException {
        Connection connection = null;
        PreparedStatement stm = null;

        try {
            connection = ConnectionFactory.getConnection();
            String sql = "INSERT INTO TB_PRODUTO (ID, NOME, PRECO, CODIGO) VALUES (NEXTVAL('SQ_PRODUTO'),?,?,?)";
            stm = connection.prepareStatement(sql); //aqui faz a compilação do sql
            stm.setString(1, produto.getNome());
            stm.setInt(2, produto.getPreco());
            stm.setString(3, produto.getCodigo());

            return stm.executeUpdate();

        } catch(Exception e) {
            throw e;
        } finally {
            fecharConexao(connection, stm, null);
        }
    }

    @Override
    public Produto consultar(String codigo) throws SQLException {
        Connection connection = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        Produto produto = null;

        try {
            connection = ConnectionFactory.getConnection();
            String sql = "SELECT * FROM TB_PRODUTO WHERE CODIGO = ?";
            stm = connection.prepareStatement(sql); //aqui faz a compilação do sql
            stm.setString(1, codigo);
            rs = stm.executeQuery();

            if (rs.next()) {
                produto = new Produto();
                produto.setId(rs.getLong("id"));
                produto.setCodigo(rs.getString("codigo"));
                produto.setNome(rs.getString("nome"));
            }
            return produto;

        } catch(Exception e) {
            throw e;
        } finally {
            fecharConexao(connection, stm, rs);
        }
    }

    @Override
    public Integer excluir(Produto produto) throws SQLException {
        Connection connection = null;
        PreparedStatement stm = null;

        try {
            connection = ConnectionFactory.getConnection();
            String sql = "DELETE FROM TB_PRODUTO WHERE CODIGO = ?";
            stm = connection.prepareStatement(sql);
            stm.setString(1, produto.getCodigo());
            return stm.executeUpdate();

        } catch (Exception e) {
            throw e;
        } finally {
            fecharConexao(connection, stm, null);
        }
    }

    @Override
    public List<Produto> consultarTodos() throws SQLException {
        Connection connection = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<Produto> listaProdutos = new ArrayList<>();
        Produto produto = null;

        try {
            connection = ConnectionFactory.getConnection();
            String sql = "SELECT * FROM TB_PRODUTO";
            stm = connection.prepareStatement(sql); //aqui faz a compilação do sql
            rs = stm.executeQuery();

            while (rs.next()) {
                produto = new Produto();
                long id = rs.getLong("ID");
                String nome = rs.getString("NOME");
                int preco = rs.getInt("PRECO");
                String codigo = rs.getString("CODIGO");

                produto.setId(id);
                produto.setNome(nome);
                produto.setPreco(preco);
                produto.setCodigo(codigo);
                listaProdutos.add(produto);
            }
        } catch(Exception e) {
            throw e;
        } finally {
            fecharConexao(connection, stm, rs);
        }
        return listaProdutos;
    }

    @Override
    public Integer atualizar(Produto produto) throws SQLException {
        Connection connection = null;
        PreparedStatement stm = null;

        try {
            connection = ConnectionFactory.getConnection();
            String sql = "UPDATE TB_PRODUTO SET NOME = ?, PRECO = ?, CODIGO = ? WHERE ID = ?";
            stm = connection.prepareStatement(sql); //aqui faz a compilação do sql
            stm.setString(1, produto.getNome());
            stm.setInt(2, produto.getPreco());
            stm.setString(3, produto.getCodigo());
            stm.setLong(4, produto.getId());

            return stm.executeUpdate();

        } catch(Exception e) {
            throw e;
        } finally {
            fecharConexao(connection, stm, null);
        }
    }

    private void fecharConexao(Connection connection, PreparedStatement stm, ResultSet rs){

        try {
            if (rs != null && !rs.isClosed()) {
                rs.close();
            }

            if(stm != null && !stm.isClosed()) {
                stm.close();
            }
            if(connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        }

    }
}
