package app;

import java.util.List;

public class App {

    public static void main (String[] args) {
        List<Pessoa> listaPessoas = Pessoa.popularPessoas().stream()
                .filter(pessoa -> pessoa.getSexo().equals("Feminino"))
                .toList();

        System.out.println(listaPessoas);
    }
}
