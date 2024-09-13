import java.util.Scanner;
// Objetos existentes: Pessoa (Classe Pai), Motorista (herda de pessoa), Usuario (herda de pessoa), Veiculo e Viagem
/* Relações: Motorista -> Veiculo: um para um, um motorista tem um veiculo;
Viagem -> Usuario: um para um, cada viagem tem um usuario; Viagem -> Motorista: um para um, uma viagem é aceita por um motorista;
Usuario -> Viagem: um para muitos, um usuario pode ter varias viagens no historico.
 */

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Criando um usuário (cliente)
        Usuario usuario = new Usuario("José", "123.456.789-00", "jose@email.com", "9999-8888");

        // Criando um veículo para o motorista
        Veiculo veiculo = new Veiculo("Toyota Corolla", "ABC-1234", "Preto");

        // Criando um motorista com o veículo associado
        Motorista motorista = new Motorista("Zé", "987.654.321-00", veiculo, 5.0, 0);

        Viagem viagemAtual = null;

        // Menu interativo
        while (true) {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Solicitar Viagem");
            System.out.println("2. Cancelar Viagem");
            System.out.println("3. Motorista Aceitar Viagem");
            System.out.println("4. Iniciar Viagem");
            System.out.println("5. Finalizar Viagem");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o local de partida: ");
                    String partida = scanner.nextLine();
                    System.out.print("Digite o local de destino: ");
                    String destino = scanner.nextLine();
                    System.out.print("Digite a distância (em km com virgula): ");
                    double distancia = scanner.nextDouble();
                    scanner.nextLine();
                    usuario.solicitarViagem(partida, destino, distancia);
                    viagemAtual = new Viagem(partida, destino, distancia, usuario);
                    break;

                case 2:
                    usuario.cancelarViagem();
                    break;

                case 3:
                    if (viagemAtual != null) {
                        motorista.aceitarViagem(viagemAtual);
                        System.out.print("Consultar perfil do motorista (S/N)? ");
                        String opcaoPerfil = scanner.nextLine().toUpperCase();
                        if (opcaoPerfil.equals("S")) {
                            motorista.exibirPerfil();
                        }
                    } else {
                        System.out.println("Nenhuma viagem para aceitar.");
                    }
                    break;

                case 4:
                    if (viagemAtual != null) {
                        if (viagemAtual.getMotorista() != null) {
                            viagemAtual.iniciarViagem();
                        } else {
                            System.out.println("Ops, nenhum motorista aceitou sua viagem. Clique em: Motorista Aceitar Viagem.");
                        }
                    } else {
                        System.out.println("Nenhuma viagem para iniciar.");
                    }
                    break;

                case 5:
                    if (viagemAtual != null) {
                        if (viagemAtual.getMotorista() != null) {
                            if (!viagemAtual.isFinalizada()) {
                                viagemAtual.finalizarViagem();
                                System.out.print("Avalie a viagem (ex: 5.0): ");
                                String avaliacaoStr = scanner.nextLine();

                                try {
                                    // Substituir vírgulas por pontos, se necessário
                                    avaliacaoStr = avaliacaoStr.replace(',', '.');
                                    double avaliacao = Double.parseDouble(avaliacaoStr);

                                    // Definir a avaliação
                                    viagemAtual.setAvaliacao(avaliacao);
                                    motorista.finalizarViagem(viagemAtual);
                                } catch (NumberFormatException e) {
                                    System.out.println("Entrada inválida. Use um número decimal com ponto como separador.");
                                }
                            } else {
                                System.out.println("A viagem já foi finalizada.");
                            }
                        } else {
                            System.out.println("Ops, nenhum motorista aceitou sua viagem. Clique em: Motorista Aceitar Viagem.");
                        }
                    } else {
                        System.out.println("Nenhuma viagem para finalizar.");
                    }
                    break;



                case 6:
                    System.out.println("Saindo...");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
}
