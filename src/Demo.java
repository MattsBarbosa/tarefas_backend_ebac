import java.lang.annotation.Annotation;

public class Demo {
    public static void main (String[] args) {

        Class classeProduto = Produto.class;

        Annotation annotation = classeProduto.getAnnotation(Tabela.class);
        System.out.println(annotation.toString());
    }

}
