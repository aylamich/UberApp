// Classe filho, herda da Pessoa
public class Motorista extends Pessoa {
    // Atributos
    private Veiculo veiculo;
    private double avaliacao;
    private int totalViagens;

    // Construtor
    public Motorista(String nome, String cpf, Veiculo veiculo, double avaliacao, int totalViagens) {
        super(nome, cpf);
        this.veiculo = veiculo;
        this.avaliacao = avaliacao;
        this.totalViagens = totalViagens;
    }

    // Métodos
    public Veiculo getVeiculo() {
        return veiculo;
    }

    public double getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(double avaliacao) {
        this.avaliacao = avaliacao;
    }

    public int getTotalViagens() {
        return totalViagens;
    }

    public void incrementarTotalViagens() {
        this.totalViagens++;
    }

    public void aceitarViagem(Viagem viagem) {
        viagem.setMotorista(this);
        System.out.println("Motorista " + getNome() + " aceitou a viagem.");
    }

    public void finalizarViagem(Viagem viagem) {
        if (viagem.getMotorista() == this) {
            incrementarTotalViagens();
            System.out.println("Viagem finalizada pelo motorista " + getNome());
        } else {
            System.out.println("Este motorista não está associado a esta viagem.");
        }
    }

    public void exibirPerfil() {
        System.out.println("Nome: " + getNome());
        System.out.println("Veículo: " + veiculo.getModelo() + " (" + veiculo.getPlaca() + ")");
        System.out.println("Avaliação: " + avaliacao);
        System.out.println("Total de Viagens: " + totalViagens);
    }
}
