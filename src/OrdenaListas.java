import java.util.*;

public class OrdenaListas {

    public static void main (String[] args){
        System.out.println(RetornaListDeNomesOrdenado());
        PrintaListasDeSexos();
    }

    public static List<String> RetornaListDeNomesOrdenado() {
        List<String> listaOrdenada = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Adicione vários nomes separados por ',' : ");
        String[] resposta = scanner.next().split(",");

        Collections.addAll(listaOrdenada, resposta);
        Collections.sort(listaOrdenada);

        return listaOrdenada;
    }

    public static void PrintaListasDeSexos() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Escreva o nome e o sexo das pessoas do grupo. Como no exemplo => nome-M-nome-F : ");
        String[] resposta = scanner.next().split("-");

        List<String> listaMasculina = new ArrayList<>();
        List<String> listaFeminina = new ArrayList<>();

        for(int i = 0; i < resposta.length; i++) {
            if(Objects.equals(resposta[i], "M")){
                listaMasculina.add(resposta[i - 1]);
            } else if (Objects.equals(resposta[i], "F")){
                listaFeminina.add(resposta[i - 1]);
            }
        }
        System.out.println("**********LISTA MASCULINA**********");
        System.out.println(listaMasculina);
        System.out.println("***********************************");
        System.out.println("**********LISTA FEMININA**********");
        System.out.println(listaFeminina);
        System.out.println("**********************************");
    }
}
