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
        historicoViagens.add(novaViagem);
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

}




