public class Viagem {
    // Atributos
    private String localPartida;
    private String localDestino;
    private double distancia;
    private double precoEstimado;
    private Usuario usuario;
    private Motorista motorista;
    private double avaliacao;
    private boolean finalizada; // Adicionado para verificar se a viagem foi finalizada

    // Construtor
    public Viagem(String localPartida, String localDestino, double distancia, Usuario usuario) {
        this.localPartida = localPartida;
        this.localDestino = localDestino;
        this.distancia = distancia;
        this.precoEstimado = calcularPreco();
        this.usuario = usuario;
        this.finalizada = false; // Inicialmente, a viagem não está finalizada
    }

    // Métodos
    public String getLocalPartida() {
        return localPartida;
    }

    public String getLocalDestino() {
        return localDestino;
    }

    public double getDistancia() {
        return distancia;
    }

    public double getPrecoEstimado() {
        return precoEstimado;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Motorista getMotorista() {
        return motorista;
    }

    public void setMotorista(Motorista motorista) {
        this.motorista = motorista;
    }

    public double getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(double avaliacao) {
        this.avaliacao = avaliacao;
    }

    public boolean isFinalizada() {
        return finalizada;
    }

    public double calcularPreco() {
        return distancia * 2.5;  // Custo de 2,5 por km de viagem
    }

    public void iniciarViagem() {
        if (!finalizada) {
            System.out.println("Viagem iniciada de " + localPartida + " para " + localDestino);
        } else {
            System.out.println("A viagem já foi finalizada.");
        }
    }

    public void finalizarViagem() {
        if (!finalizada) {
            finalizada = true;
            System.out.println("Viagem finalizada de " + localPartida + " para " + localDestino);
            System.out.println("Valor a pagar: " + precoEstimado);
        } else {
            System.out.println("A viagem já foi finalizada.");
        }
    }
}
