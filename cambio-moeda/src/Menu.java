import java.util.Scanner;

public class Menu {
    public void exibir() {
        Scanner scanner = new Scanner(System.in);
        int escolha;

        do {
            System.out.println("****************************************************************");
            System.out.println("----------------------------------------------------------------");
            System.out.println("      ██████╗ █████╗ ███╗   ███╗██████╗ ██╗ ██████╗ ");
            System.out.println("     ██╔════╝██╔══██╗████╗ ████║██╔══██╗██║██╔═══██╗");
            System.out.println("     ██║     ███████║██╔████╔██║██████╔╝██║██║   ██║");
            System.out.println("     ██║     ██╔══██║██║╚██╔╝██║██╔══██╗██║██║   ██║");
            System.out.println("     ╚██████╗██║  ██║██║ ╚═╝ ██║██████╔╝██║╚██████╔╝");
            System.out.println("      ╚═════╝╚═╝  ╚═╝╚═╝     ╚═╝╚═════╝ ╚═╝ ╚═════╝ ");
            System.out.println("----------------------------------------------------------------");
            System.out.println("Seja bem-vindo/a ao Conversor de Moeda!");
            System.out.println("----------------------------------------------------------------");
            System.out.println("1) Dólar >> Real Brasileiro");
            System.out.println("2) Real Brasileiro =>> Dólar");
            System.out.println("3) Dólar >> Peso Argentino");
            System.out.println("4) Peso Argentino =>> Dólar");
            System.out.println("5) Dólar >> Peso Colombiano");
            System.out.println("6) Peso Colombiano =>> Dólar");
            System.out.println("7) Digitar moeda de origem, destino e valor");
            System.out.println("8) Sair \n");

            System.out.print("Escolha uma opção válida: ");
            escolha = scanner.nextInt();

            switch (escolha) {
                case 1:
                    Conversor.converterMoeda("USD", "BRL", scanner);
                    break;
                case 2:
                    Conversor.converterMoeda("BRL", "USD", scanner);
                    break;
                case 3:
                    Conversor.converterMoeda("USD", "ARS", scanner);
                    break;
                case 4:
                    Conversor.converterMoeda("ARS", "USD", scanner);
                    break;
                case 5:
                    Conversor.converterMoeda("USD", "COP", scanner);
                    break;
                case 6:
                    Conversor.converterMoeda("COP", "USD", scanner);
                    break;
                case 7:
                    DigitarMoeda.digitar(scanner);
                    break;
                case 8:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("*********************** - ERRO - *******************************");
                    System.out.println("Opção inválida.");
                    System.out.println("****************************************************************");
                    // Após exibir o resultado, aguarda a entrada do usuário para retornar ao menu principal
                    System.out.println("\nPressione Enter para voltar ao menu principal...");
                    scanner.nextLine(); // Limpa o buffer
                    scanner.nextLine(); // Aguarda a entrada do usuário
            }
        } while (escolha != 8);

        scanner.close();
        // Finalizar a aplicação
        System.exit(1);
    }
}
