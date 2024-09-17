import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Lista de motoristas disponíveis
        List<Motorista> motoristas = new ArrayList<>();
        motoristas.add(new Motorista("Zé", "987.654.321-00", new Veiculo("Toyota Corolla", "ABC-1234", "Preto"), 5.0, 0));
        motoristas.add(new Motorista("Ana", "123.456.789-10", new Veiculo("Honda Civic", "DEF-5678", "Branco"), 4.8, 10));
        motoristas.add(new Motorista("Carlos", "987.654.321-11", new Veiculo("Ford Fusion", "GHI-9012", "Cinza"), 4.9, 20));

        // Criando um usuário (cliente)
        Usuario usuario = new Usuario("José", "123.456.789-00", "jose@email.com", "9999-8888");

        Viagem viagemAtual = null;

        // Menu interativo
        while (true) {
            try {
                System.out.println("\n--- MENU ---");
                System.out.println("1. Solicitar Viagem");
                System.out.println("2. Cancelar Viagem");
                System.out.println("3. Motorista Aceitar Viagem");
                System.out.println("4. Iniciar Viagem");
                System.out.println("5. Finalizar Viagem");
                System.out.println("6. Ver Histórico de Viagens");
                System.out.println("7. Sair");
                System.out.print("Escolha uma opção: ");
                int opcao = scanner.nextInt();
                scanner.nextLine();  // Consumir a nova linha restante

                switch (opcao) {
                    case 1:
                        String partida = "";
                        String destino = "";

                        // Validação para o local de partida
                        while (true) {
                            System.out.print("Digite o local de partida: ");
                            partida = scanner.nextLine();
                            if (contemSomenteNumeros(partida)) {
                                System.out.println("O local de partida não pode conter apenas números. Tente novamente.");
                            } else {
                                break;
                            }
                        }

                        // Validação para o destino
                        while (true) {
                            System.out.print("Digite o local de destino: ");
                            destino = scanner.nextLine();
                            if (contemSomenteNumeros(destino)) {
                                System.out.println("O destino não pode conter apenas números. Tente novamente.");
                            } else {
                                break;
                            }
                        }

                        double distancia = -1;
                        while (distancia < 0) {
                            try {
                                System.out.print("Digite a distância (em km com vírgula): ");
                                distancia = scanner.nextDouble();
                                scanner.nextLine();
                                if (distancia < 0) {
                                    System.out.println("Distância deve ser um valor positivo.");
                                }
                            } catch (InputMismatchException e) {
                                System.out.println("Entrada inválida! Digite um valor numérico.");
                                scanner.nextLine(); // Limpar entrada inválida
                            }
                        }
                        usuario.solicitarViagem(partida, destino, distancia);
                        viagemAtual = new Viagem(partida, destino, distancia, usuario);
                        break;

                    case 2:
                        usuario.cancelarViagem();
                        break;

                    case 3:
                        if (viagemAtual != null) {
                            Motorista motoristaSelecionado = motoristas.get(random.nextInt(motoristas.size()));
                            motoristaSelecionado.aceitarViagem(viagemAtual);
                            viagemAtual.setMotorista(motoristaSelecionado);
                            usuario.adicionarViagem(viagemAtual);

                            String opcaoPerfil = "";
                            while (!opcaoPerfil.equals("S") && !opcaoPerfil.equals("N")) {
                                System.out.print("Consultar perfil do motorista (S/N)? ");
                                opcaoPerfil = scanner.nextLine().toUpperCase();
                                if (!opcaoPerfil.equals("S") && !opcaoPerfil.equals("N")) {
                                    System.out.println("Opção inválida! Digite 'S' para Sim ou 'N' para Não.");
                                }
                            }

                            if (opcaoPerfil.equals("S")) {
                                motoristaSelecionado.exibirPerfil();
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
                                    String avaliacaoStr = "";
                                    double avaliacao = -1;
                                    while (avaliacao < 0 || avaliacao > 5) {
                                        try {
                                            System.out.print("Avalie a viagem (0.0 a 5.0): ");
                                            avaliacaoStr = scanner.nextLine();
                                            avaliacaoStr = avaliacaoStr.replace(',', '.');
                                            avaliacao = Double.parseDouble(avaliacaoStr);
                                            if (avaliacao < 0 || avaliacao > 5) {
                                                System.out.println("A avaliação deve estar entre 0.0 e 5.0.");
                                            }
                                        } catch (NumberFormatException e) {
                                            System.out.println("Entrada inválida! Digite um número decimal.");
                                        }
                                    }

                                    viagemAtual.setAvaliacao(avaliacao);
                                    viagemAtual.getMotorista().finalizarViagem(viagemAtual);
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
                        usuario.exibirHistoricoViagens();
                        break;

                    case 7:
                        System.out.println("Saindo...");
                        scanner.close();
                        System.exit(0);
                        break;

                    default:
                        System.out.println("Opção inválida! Escolha um número entre 1 e 7.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida! Por favor, digite um número correspondente às opções.");
                scanner.nextLine();
            }
        }
    }

    // Método auxiliar para verificar se uma string contém apenas números
    public static boolean contemSomenteNumeros(String entrada) {
        return entrada.matches("\\d+");
    }
}
