import dao.ClienteDAOMock;
import dao.IClienteDAO;
import exceptions.TipoChaveNaoEncontradaException;
import main.Cliente;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ClienteDAOTest {

    private IClienteDAO clienteDao;
    private Cliente cliente;

    public ClienteDAOTest() {
        clienteDao = new ClienteDAOMock();
    }

    @Before
    public void init() throws TipoChaveNaoEncontradaException {
        cliente = new Cliente();
        cliente.setCpf(1231231231L);
        cliente.setNome("Matheus");
        cliente.setEnd("Honorato Coelho da Rocha");
        cliente.setNumero(275);
        cliente.setCidade("Navegantes");
        cliente.setEstado("SC");
        cliente.setTel(47991268180L);
        clienteDao.cadastrar(cliente);
    }

    @Test
    public void pesquisarCliente() {
        Cliente clienteConsultado = clienteDao.consultar(cliente.getCpf());
        Assert.assertNotNull(clienteConsultado);
    }

    @Test
    public void salvarCliente() throws TipoChaveNaoEncontradaException {
        boolean retorno = clienteDao.cadastrar(cliente);
    }

    @Test
    public void excluirCliente() {
        clienteDao.excluir(cliente.getCpf());
    }

    @Test
    public void alterarCliente() throws TipoChaveNaoEncontradaException {
        cliente.setNome("Matheus Barbosa");
        clienteDao.alterar(cliente);

        Assert.assertEquals("Matheus Barbosa", cliente.getNome());
    }
}
