package main.java.dao;

import main.java.domain.Produto;

import java.sql.SQLException;
import java.util.List;

public interface IProdutoDAO {

    Integer cadastrar(Produto produto) throws SQLException;

    Produto consultar(String codigo) throws SQLException;

    Integer excluir(Produto produto) throws SQLException;

    List<Produto> consultarTodos() throws SQLException;

    Integer atualizar(Produto produto) throws SQLException;
}
