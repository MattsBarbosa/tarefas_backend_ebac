public class PessoaFisica extends Pessoa {
    private Long cpf;

    public PessoaFisica(String nome, Long cpf){
        this.nome = nome;
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return "PessoaFisica{" +
                "cpf=" + cpf +
                ", nome='" + nome + '\'' +
                '}';
    }

    public Long getCpf() {
        return cpf;
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }
}
