import dao.ClienteDAOMock;
import dao.IClienteDAO;
import exceptions.TipoChaveNaoEncontradaException;
import main.Cliente;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import services.ClienteService;
import services.IClienteService;

public class ClienteServiceTest {

    private IClienteService clienteService;
    private Cliente cliente;

    public ClienteServiceTest() {
        IClienteDAO dao = new ClienteDAOMock();
        clienteService = new ClienteService(dao);
    }

    @Before
    public void init() {
        cliente = new Cliente();
        cliente.setCpf(1231231231L);
        cliente.setNome("Matheus");
        cliente.setEnd("Honorato Coelho da Rocha");
        cliente.setNumero(275);
        cliente.setCidade("Navegantes");
        cliente.setEstado("SC");
        cliente.setTel(47991268180L);
    }

    @Test
    public void pesquisarCliente() {
        Cliente clienteConsultado = clienteService.buscarPorCPF(cliente.getCpf());
        Assert.assertNotNull(clienteConsultado);
    }

    @Test
    public void salvarCliente() throws TipoChaveNaoEncontradaException {
        boolean retorno = clienteService.salvar(cliente);
        Assert.assertTrue(retorno);
    }

    @Test
    public void excluirCliente() {
        clienteService.excluir(cliente.getCpf());
    }

    @Test
    public void alterarCliente() throws TipoChaveNaoEncontradaException {
        cliente.setNome("Matheus Barbosa");
        clienteService.alterar(cliente);

        Assert.assertEquals("Matheus Barbosa", cliente.getNome());
    }
}
