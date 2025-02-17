import java.util.List;
import java.util.ArrayList;

// Classe filho, herda da Pessoa
public class Usuario extends Pessoa {
    // Atributos
    private String email;
    private String telefone;
    private List<Viagem> historicoViagens;

    // Construtor
    public Usuario(String nome, String cpf, String email, String telefone) {
        super(nome, cpf);
        this.email = email;
        this.telefone = telefone;
        this.historicoViagens = new ArrayList<>();
    }

    // Métodos
    public void solicitarViagem(String partida, String destino, double distancia) {
        Viagem novaViagem = new Viagem(partida, destino, distancia, this);
        System.out.println("Viagem solicitada de " + partida + " para " + destino);
    }

    public void cancelarViagem() {
        if (historicoViagens.isEmpty()) {
            System.out.println("Nenhuma viagem para cancelar.");
        } else {
            Viagem ultimaViagem = historicoViagens.remove(historicoViagens.size() - 1);
            System.out.println("Viagem de " + ultimaViagem.getLocalPartida() + " para " + ultimaViagem.getLocalDestino() + " foi cancelada.");
        }
    }

    public void adicionarViagem(Viagem viagem) {
        historicoViagens.add(viagem); // Adiciona a viagem ao histórico após o motorista aceitá-la
    }

    public void exibirHistoricoViagens() {
        if (historicoViagens.isEmpty()) {
            System.out.println("Histórico de viagens vazio.");
        } else {
            System.out.println("--- Histórico de Viagens ---");
            for (Viagem viagem : historicoViagens) {
                String nomeMotorista = (viagem.getMotorista() != null) ? viagem.getMotorista().getNome() : "Motorista não definido";
                System.out.println("Partida: " + viagem.getLocalPartida() + ", Destino: " + viagem.getLocalDestino() + ", Motorista: " + nomeMotorista + ", Avaliação: " + viagem.getAvaliacao());
            }
        }
    }
}
