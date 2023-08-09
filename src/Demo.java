import java.util.ArrayList;
import java.util.List;

public class Demo {

    public static void main(String[] args){

        List<Carros> listaDeCarros = new ArrayList<>();
        listaDeCarros.add(new Audi());
        listaDeCarros.add(new Toyota());
        imprimir(listaDeCarros);
    }

    public static <T> void imprimir(List<T> lista) {
        for (T item : lista) {
            System.out.println(item);
        }
    }
}
