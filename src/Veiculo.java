public class Veiculo {
    private String modelo;
    private String placa;
    private String cor;

    public Veiculo(String modelo, String placa, String cor) {
        this.modelo = modelo;
        this.placa = placa;
        this.cor = cor;
    }

    // Retorna o modelo do veículo
    public String getModelo() {
        return modelo;
    }

    // Retorna a placa do veículo
    public String getPlaca() {
        return placa;
    }

    // Exibe os detalhes do veículo
    public void exibirDetalhes() {
        System.out.println("Modelo: " + modelo);
        System.out.println("Placa: " + placa);
        System.out.println("Cor: " + cor);
    }
}
