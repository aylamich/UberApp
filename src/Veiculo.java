public class Veiculo {
    // Atributos
    private String modelo;
    private String placa;
    private String cor;

    // Construtor
    public Veiculo(String modelo, String placa, String cor) {
        this.modelo = modelo;
        this.placa = placa;
        this.cor = cor;
    }

    // Métodos
    public String getModelo() {
        return modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public void exibirDetalhes() {
        System.out.println("Modelo: " + modelo);
        System.out.println("Placa: " + placa);
        System.out.println("Cor: " + cor);
    }
}
