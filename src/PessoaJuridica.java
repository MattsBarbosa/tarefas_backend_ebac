public class PessoaJuridica extends Pessoa {

    private Long cnpj;

    public PessoaJuridica(String nome, Long cnpj){
        this.nome = nome;
        this.cnpj = cnpj;
    }

    @Override
    public String toString() {
        return "PessoaJuridica{" +
                "cnpj=" + cnpj +
                ", nome='" + nome + '\'' +
                '}';
    }

    public Long getCnpj() {
        return cnpj;
    }

    public void setCnpj(Long cnpj) {
        this.cnpj = cnpj;
    }
}
