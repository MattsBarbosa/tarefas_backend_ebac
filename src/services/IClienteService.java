package services;

import exceptions.TipoChaveNaoEncontradaException;
import main.Cliente;

public interface IClienteService {

    boolean salvar(Cliente cliente) throws TipoChaveNaoEncontradaException;

    Cliente buscarPorCPF(Long cpf);

    void excluir(Long cpf);

    void alterar(Cliente cliente) throws TipoChaveNaoEncontradaException;
}
