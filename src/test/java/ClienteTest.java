package test.java;

import org.junit.jupiter.api.Test;

import main.java.dao.ClienteDAO;
import main.java.dao.IClienteDAO;
import main.java.domain.Cliente;

import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ClienteTest {

    private IClienteDAO clienteDAO;

    @Test
    public void cadastrarTest() throws SQLException {
        clienteDAO = new ClienteDAO();

        Cliente cliente = new Cliente();
        cliente.setCodigo("01");
        cliente.setNome("Matheus A");

        Integer qtd = clienteDAO.cadastrar(cliente);
        assertEquals(1, qtd);

        Cliente clienteBD = clienteDAO.consultar(cliente.getCodigo());
        assertNotNull(clienteBD);
        assertNotNull(clienteBD.getId());
        assertEquals(cliente.getCodigo(),clienteBD.getCodigo());
        assertEquals(cliente.getNome(),clienteBD.getNome());

        Integer qtdDel = clienteDAO.excluir(clienteBD);
        assertEquals(1, qtdDel);
    }

    @Test
    public void consultarTest() throws SQLException {
        clienteDAO = new ClienteDAO();
        Cliente cliente = new Cliente();
        cliente.setCodigo("8");
        cliente.setNome("Jhon Lokl");

        Integer countCad = clienteDAO.cadastrar(cliente);
        assertEquals(1, countCad);

        Cliente clienteBD = clienteDAO.consultar("8");
        assertNotNull(clienteBD);
        assertEquals(cliente.getCodigo(), clienteBD.getCodigo());
        assertEquals(cliente.getNome(), clienteBD.getNome());

        Integer countDel = clienteDAO.excluir(clienteBD);
        assertEquals(1, countDel);
    }

    @Test
    public void excluirTest() throws SQLException {
        clienteDAO = new ClienteDAO();

        Cliente cliente = new Cliente();
        cliente.setCodigo("8");
        cliente.setNome("Lucas Snow");

        Integer countCad = clienteDAO.cadastrar(cliente);
        assertEquals(1, countCad);

        Cliente clienteBD = clienteDAO.consultar("8");
        assertNotNull(clienteBD);
        assertEquals(cliente.getCodigo(), clienteBD.getCodigo());
        assertEquals(cliente.getNome(), clienteBD.getNome());

        Integer countDel = clienteDAO.excluir(clienteBD);
        assertEquals(1, countDel);
    }

    @Test
    public void consultarTodosTest() throws SQLException {
        clienteDAO = new ClienteDAO();

        Cliente cliente = new Cliente();
        cliente.setCodigo("8");
        cliente.setNome("Lucas Snow");
        Integer countCad = clienteDAO.cadastrar(cliente);
        assertEquals(1, countCad);

        Cliente cliente2 = new Cliente();
        cliente2.setCodigo("6");
        cliente2.setNome("John Snow");
        Integer countCad2 = clienteDAO.cadastrar(cliente2);
        assertEquals(1, countCad2);

        List<Cliente> listaClientes = clienteDAO.consultarTodos();
        assertNotNull(listaClientes);
        assertEquals(2, listaClientes.size());

        int countDel = 0;
        for ( Cliente cli : listaClientes) {
            clienteDAO.excluir(cli);
            countDel++;
        }
        assertEquals(listaClientes.size(), countDel);

        listaClientes = clienteDAO.consultarTodos();
        assertEquals(listaClientes.size(), 0);
    }

    @Test
    public void atualizarTest() throws SQLException {
        clienteDAO = new ClienteDAO();

        Cliente cliente = new Cliente();
        cliente.setNome("Matheus Test");
        cliente.setCodigo("10");

        Integer countCad = clienteDAO.cadastrar(cliente);
        assertEquals(1, countCad);

        Cliente clienteBD = clienteDAO.consultar("10");
        assertNotNull(clienteBD);

        clienteBD.setCodigo("15");
        clienteBD.setNome("Jonathan");
        Integer countUpdate = clienteDAO.atualizar(clienteBD);
        assertEquals(1, countUpdate);

        Cliente clienteBD1 = clienteDAO.consultar("10");
        assertNull(clienteBD1);

        Cliente clienteBD2 = clienteDAO.consultar("15");
        assertNotNull(clienteBD2);
        assertEquals(clienteBD.getId(), clienteBD2.getId());
        assertEquals(clienteBD.getCodigo(), clienteBD2.getCodigo());
        assertEquals(clienteBD.getNome(), clienteBD2.getNome());

        List<Cliente> listaClientes = clienteDAO.consultarTodos();
        for (Cliente cli : listaClientes) {
            clienteDAO.excluir(cli);
        }
    }
}
