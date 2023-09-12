import java.util.List;
import java.util.Objects;

public class Pessoa {

    public String nome;
    public Integer idade;
    public String sexo;

    public Pessoa(String nome, Integer idade, String sexo) {
        this.nome = nome;
        this.idade = idade;
        this.sexo = sexo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    @Override
    public String toString() {
        return nome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pessoa pessoa)) return false;
        return Objects.equals(sexo, pessoa.sexo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sexo);
    }

    static List<Pessoa> popularPessoas() {
        Pessoa pessoa1 = new Pessoa("Matheus", 26, "Masculino");
        Pessoa pessoa2 = new Pessoa("Julia", 30, "Feminino");
        Pessoa pessoa3 = new Pessoa("Ana", 40, "Feminino");
        Pessoa pessoa4 = new Pessoa("João", 28, "Masculino");
        return List.of(pessoa1, pessoa2, pessoa3, pessoa4);
    }
}


