import java.util.ArrayList;
import java.util.List;

public class MaleOrFemale {

    public static void main (String args[]) {
        List<Pessoa> listaPessoas = new ArrayList<>();
        List<Pessoa> listaMasculina = new ArrayList<>();
        List<Pessoa> listaFeminina = new ArrayList<>();

        Pessoa matheus = new Pessoa("Matheus Augusto", "Masculino");
        Pessoa maria = new Pessoa("Maria Loruis", "Feminino");
        Pessoa julia = new Pessoa("Julia Motta", "Feminino");
        Pessoa roger = new Pessoa("Roger Watters", "Masculino");

        listaPessoas.add(matheus);
        listaPessoas.add(maria);
        listaPessoas.add(julia);
        listaPessoas.add(roger);

        for (Pessoa pessoa : listaPessoas) {
            if (pessoa.getSexo() == "Masculino") {
                listaMasculina.add(pessoa);
            } else {
                listaFeminina.add(pessoa);
            }
        }
        System.out.println("**********LISTA MASCULINA**********");
        System.out.println(listaMasculina);
        System.out.println("***********************************");
        System.out.println("**********LISTA FEMININA***********");
        System.out.println(listaFeminina);
        System.out.println("***********************************");
    }
}

