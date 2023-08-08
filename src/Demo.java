import java.util.ArrayList;
import java.util.List;

public class Demo {

    public static void main(String[] args){

        List<Carros> listaDeCarros = new ArrayList<>();
        listaDeCarros.add(new Audi());
        listaDeCarros.add(new Toyota());
        System.out.println(listaDeCarros);
    }
}
