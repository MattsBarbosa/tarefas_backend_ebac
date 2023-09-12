package app;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class AppTest {

    @Test
    public void testeListaFeminina() {
        List<Pessoa> listaPessoas = Pessoa.popularPessoas().stream()
                .filter(pessoa -> pessoa.getSexo().equals("Feminino"))
                .toList();

        listaPessoas.forEach(p -> Assert.assertEquals("Feminino", p.getSexo()));
    }
}
