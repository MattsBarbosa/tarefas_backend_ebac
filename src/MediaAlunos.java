import java.util.Scanner;

public class MediaAlunos {

    public static void main (String args[]){
        double notaDoAluno = CalcularMedia(10, 8 ,5 ,5);

        if (notaDoAluno >= 7) {
            System.out.println("APROVADO, sua média é " + notaDoAluno );
        } else if (notaDoAluno >= 5) {
            System.out.println("RECUPERAÇÃO, sua média é " + notaDoAluno );
        }else {
            System.out.println("REPROVADO, sua média é " + notaDoAluno );
        }
    }

    public static double CalcularMedia (int n1, int n2, int n3, int n4) {
        return  (n1 + n2 + n3 + n4) / 4;
    }
}
