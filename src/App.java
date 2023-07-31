import dao.ClienteMapDAO;
import dao.IClienteDAO;
import domain.Cliente;

import javax.swing.*;

public class App {

    private static IClienteDAO iClienteDAO;

    public static void main(String[] args) {
        iClienteDAO = new ClienteMapDAO();

        String opcao = input("Digite 1 para cadastro, 2 para consultar," +
                " 3 para exclusão, 4 para alteração ou 5 para sair", "Cadastro de Clientes");

        while (!isOpcaoValida(opcao)) {
            if ("".equals(opcao)) {
                sair();
            }
            opcao = input("Opção inválida digite 1 para cadastro, 2 para consulta," +
                    " 3 para exclusão, 4 para alteração ou 5 para sair", "Opção inválida");
        }

        while (isOpcaoValida(opcao)){

            if (isOpcaoSair(opcao)) {
                sair();
            } else if (isCadastro(opcao)) {
                String dados = input("Digite os dados do cliente separados por vígula," +
                        " conforme exemplo: Nome, CPF, Telefone, Endereço, Número, Cidade e Estado",
                        "Opção inválida");
                cadastrar(dados);
            } else if (isConsultar(opcao)) {
                String dados = input("Digite o cpf", "consultar");
                consultar(dados);
            } else if (isExclusao(opcao)) {
                String dados = input("Digite o CPF do cliente", "Consulta cliente");
                excluir(dados);
            } else {
                String dados = input("Digite os dados do cliente separados por vígula," +
                        " conforme exemplo: Nome, CPF, Telefone, Endereço, Número, Cidade e Estado",
                        "Atualização");
                atualizar(dados);
            }
            opcao = input("Digite 1 para cadastro, 2 para consultar," +
                    " 3 para exclusão, 4 para alteração ou 5 para sair", "Cadastro de Clientes");
        }
    }

    private static void atualizar(String dados) {
        String[] dadosSeparados = dados.split(",");
        //Validar dados antes de instanciar cliente
        Cliente cliente = new Cliente(dadosSeparados[0],dadosSeparados[1],dadosSeparados[2],dadosSeparados[3],dadosSeparados[4],dadosSeparados[5],dadosSeparados[6]);
        iClienteDAO.alterar(cliente);
    }

    private static void excluir(String dados) {
        iClienteDAO.excluir(Long.parseLong(dados));
        mensagem("Cliente excluído com sucesso: ", "Sucesso");
    }

    private static boolean isExclusao(String opcao) {
        return "3".equals(opcao);
    }

    private static void consultar(String dados) {
        //Validar se foi passado somento o cpf
        Cliente cliente = iClienteDAO.consultar(Long.parseLong(dados));
        if (cliente != null) {
            mensagem("Cliente encontrado:" + cliente, "Dados Cliente");
        } else {
            mensagem("Cliente não encontrado", "Erro");
        }
    }

    private static boolean isConsultar(String opcao) {
        return "2".equals(opcao);
    }

    private static void cadastrar(String dados) {
        String[] dadosSeparados = dados.split(",");
        //Tentar validar se todos os campos estão preenchidos.
        //Se não tiver, passar null no construtor onde o valor é nulo.
        Cliente cliente = new Cliente(dadosSeparados[0],dadosSeparados[1],dadosSeparados[2],
                dadosSeparados[3],dadosSeparados[4],dadosSeparados[5],dadosSeparados[6]);
        Boolean isCadastrado = iClienteDAO.cadastrar(cliente);
        if (isCadastrado) {
            mensagem("Cliente cadastrado com sucesso", "Sucesso");
        } else {
            mensagem("Cliente já se encontra cadastrado", "Erro");
        }
    }

    private static boolean isCadastro(String opcao) {
        return "1".equals(opcao);
    }

    private static boolean isOpcaoSair(String opcao) {
        return "5".equals(opcao);
    }

    private static void sair() {
        mensagem("Até logo", "Sair");
        System.exit(0);
    }

    private static boolean isOpcaoValida(String opcao) {
        return "1".equals(opcao) || "2".equals(opcao) || "3".equals(opcao) || "4".equals(opcao) || "5".equals(opcao);
    }
    private static String input(String mensagem, String titulo) {
        return JOptionPane.showInputDialog(null,
                mensagem, titulo, JOptionPane.INFORMATION_MESSAGE);
    }
    private static void mensagem(String mensagem, String titulo) {
        JOptionPane.showMessageDialog(null,
                mensagem, titulo, JOptionPane.INFORMATION_MESSAGE);
    }
}
