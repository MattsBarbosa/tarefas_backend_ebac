package test.java;

import main.java.dao.IClienteDAO;
import main.java.dao.IProdutoDAO;
import main.java.dao.ProdutoDAO;
import main.java.domain.Produto;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ProdutoTest {

    private IProdutoDAO produtoDAO;

    @Test
    public void cadastrarTest() throws SQLException {
        produtoDAO = new ProdutoDAO();

        Produto produto = new Produto();
        produto.setNome("Canivete");
        produto.setPreco(35);
        produto.setCodigo("13");

        Integer countPro = produtoDAO.cadastrar(produto);
        assertEquals(1,countPro);

        Produto produtoBD = produtoDAO.consultar(produto.getCodigo());
        assertNotNull(produtoBD);
        assertNotNull(produtoBD.getId());
        assertEquals(produto.getCodigo(),produtoBD.getCodigo());
        assertEquals(produto.getNome(),produtoBD.getNome());

        Integer countDel = produtoDAO.excluir(produtoBD);
        assertEquals(1, countDel);
    }

    @Test
    public void consultarTest() throws SQLException {
        produtoDAO = new ProdutoDAO();

        Produto produto = new Produto();
        produto.setNome("chaveiro");
        produto.setPreco(5);
        produto.setCodigo("11");

        Integer countCad = produtoDAO.cadastrar(produto);
        assertEquals(1,countCad);

        Produto produtoBD = produtoDAO.consultar("11");
        assertNotNull(produtoBD);
        assertEquals(produto.getNome(), produtoBD.getNome());

        Integer countDel = produtoDAO.excluir(produtoBD);
        assertEquals(1, countDel);
    }

    @Test
    public void excluirTest() throws SQLException {
        produtoDAO = new ProdutoDAO();

        Produto produto = new Produto();
        produto.setNome("chaveiro");
        produto.setPreco(5);
        produto.setCodigo("11");

        Integer countCad = produtoDAO.cadastrar(produto);
        assertEquals(1,countCad);

        Produto produtoBD = produtoDAO.consultar("11");
        assertNotNull(produtoBD);
        assertEquals(produto.getNome(), produtoBD.getNome());

        Integer countDel = produtoDAO.excluir(produtoBD);
        assertEquals(1, countDel);
    }

    @Test
    public void consultarTodosTest() throws SQLException {
        produtoDAO = new ProdutoDAO();

        Produto produto = new Produto();
        produto.setNome("chaveiro");
        produto.setPreco(5);
        produto.setCodigo("11");

        Integer countCad = produtoDAO.cadastrar(produto);
        assertEquals(1,countCad);

        Produto produto1 = new Produto();
        produto1.setNome("pá");
        produto1.setPreco(250);
        produto1.setCodigo("13");

        Integer countCad1 = produtoDAO.cadastrar(produto1);
        assertEquals(1,countCad1);

        List<Produto> listaProdutos = produtoDAO.consultarTodos();
        assertEquals(2, listaProdutos.size());

        int countDel = 0;
        for (Produto pro : listaProdutos) {
            produtoDAO.excluir(pro);
            countDel++;
        }

        assertEquals(listaProdutos.size(), countDel);

        listaProdutos = produtoDAO.consultarTodos();
        assertEquals(listaProdutos.size(), 0);
    }

    @Test
    public void atualizarTest() throws SQLException {
        produtoDAO = new ProdutoDAO();

        Produto produto = new Produto();
        produto.setNome("martelo");
        produto.setPreco(50);
        produto.setCodigo("13");

        Integer countCad = produtoDAO.cadastrar(produto);
        assertEquals(1,countCad);

        Produto produtoBD = produtoDAO.consultar("13");
        assertNotNull(produtoBD);

        produtoBD.setNome("prego");
        produtoBD.setPreco(1);
        produtoBD.setCodigo("02");
        Integer countUpdate = produtoDAO.atualizar(produtoBD);
        assertEquals(1,countUpdate);

        Produto produtoBD1 = produtoDAO.consultar("13");
        assertNull(produtoBD1);

        Produto produtoBDUpdated = produtoDAO.consultar("02");
        assertNotNull(produtoBDUpdated);
        assertEquals(produtoBD.getCodigo(), produtoBDUpdated.getCodigo());
        assertEquals(produtoBD.getNome(), produtoBDUpdated.getNome());

        List<Produto> listaProdutos = produtoDAO.consultarTodos();
        for (Produto pro : listaProdutos) {
            produtoDAO.excluir(pro);
        }
    }
}
