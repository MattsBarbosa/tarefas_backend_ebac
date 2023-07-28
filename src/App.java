public class App {

    public static void main(String[] args){
        PessoaFisica pessoa1 = new PessoaFisica("Matheus Barbosa", 88376529951L);
        PessoaJuridica empresa1 = new PessoaJuridica("Arte Mar Pescados", 15869596262626322L);
        System.out.println(pessoa1);
        System.out.println(empresa1);
    }
}
