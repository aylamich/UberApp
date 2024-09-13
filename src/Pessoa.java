// Classe PAI
public class Pessoa {
    // Atributos
    protected String nome;
    protected String cpf;

    // Construtor
    public Pessoa(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    // Método
    public String getNome() {
        return nome;
    }
}
