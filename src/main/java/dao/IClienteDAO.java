package main.java.dao;

import main.java.domain.Cliente;

import java.sql.SQLException;
import java.util.List;

public interface IClienteDAO {

    Integer cadastrar(Cliente cliente) throws SQLException;

    Cliente consultar(String codigo) throws SQLException;

    Integer excluir(Cliente clienteBD) throws SQLException;

    List<Cliente> consultarTodos() throws SQLException;

    Integer atualizar(Cliente clienteBD) throws SQLException;
}
