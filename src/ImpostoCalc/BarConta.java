package ImpostoCalc;

import java.util.Scanner;

public class BarConta {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char continuar;

        do {
            char sexo;

            // Validação do sexo
            while (true) {
                System.out.print("Sexo (F ou M): ");
                sexo = scanner.next().charAt(0);
                if (sexo == 'F' || sexo == 'M' || sexo == 'f' || sexo == 'm') {
                    break; // Saia do loop se a entrada for válida
                } else {
                    System.out.println("Entrada inválida! Por favor, insira 'F' para feminino ou 'M' para masculino.");
                }
            }

            // Validação da quantidade de cervejas
            int qtdCervejas = -1;
            while (qtdCervejas < 0) {
                System.out.print("Quantidade de cervejas: ");
                if (scanner.hasNextInt()) {
                    qtdCervejas = scanner.nextInt();
                    if (qtdCervejas < 0) {
                        System.out.println("A quantidade de cervejas não pode ser negativa. Tente novamente.");
                    }
                } else {
                    System.out.println("Entrada inválida! Por favor, insira um número inteiro.");
                    scanner.next(); // Limpa a entrada inválida
                }
            }

            // Validação da quantidade de refrigerantes
            int qtdRefrigerantes = -1;
            while (qtdRefrigerantes < 0) {
                System.out.print("Quantidade de refrigerantes: ");
                if (scanner.hasNextInt()) {
                    qtdRefrigerantes = scanner.nextInt();
                    if (qtdRefrigerantes < 0) {
                        System.out.println("A quantidade de refrigerantes não pode ser negativa. Tente novamente.");
                    }
                } else {
                    System.out.println("Entrada inválida! Por favor, insira um número inteiro.");
                    scanner.next(); // Limpa a entrada inválida
                }
            }

            // Validação da quantidade de espetinhos
            int qtdEspetinhos = -1;
            while (qtdEspetinhos < 0) {
                System.out.print("Quantidade de espetinhos: ");
                if (scanner.hasNextInt()) {
                    qtdEspetinhos = scanner.nextInt();
                    if (qtdEspetinhos < 0) {
                        System.out.println("A quantidade de espetinhos não pode ser negativa. Tente novamente.");
                    }
                } else {
                    System.out.println("Entrada inválida! Por favor, insira um número inteiro.");
                    scanner.next(); // Limpa a entrada inválida
                }
            }

            // Definindo os valores
            double precoCerveja = 5.00;
            double precoRefrigerante = 3.00;
            double precoEspetinho = 7.00;
            double couvert = 4.00;
            double ingressoHomem = 10.00;
            double ingressoMulher = 8.00;

            // Calculando o consumo total
            double totalConsumo = (qtdCervejas * precoCerveja) + (qtdRefrigerantes * precoRefrigerante) + (qtdEspetinhos * precoEspetinho);

            // Calculando o ingresso com base no sexo
            double ingresso = (sexo == 'M' || sexo == 'm') ? ingressoHomem : ingressoMulher;

            // Verificar se a pessoa paga couvert ou não
            if (totalConsumo > 30.00) {
                couvert = 0.00; // Isento de couvert
            }

            // Calculando o valor total a pagar
            double totalPagar = totalConsumo + couvert + ingresso;

            // Relatório final
            System.out.println("\nRELATÓRIO:");
            System.out.printf("Consumo = R$ %.2f\n", totalConsumo);
            if (couvert == 0.00) {
                System.out.println("Isento de Couvert");
            } else {
                System.out.printf("Couvert = R$ %.2f\n", couvert);
            }
            System.out.printf("Ingresso = R$ %.2f\n", ingresso);
            System.out.printf("Valor a pagar = R$ %.2f\n", totalPagar);

            // Perguntar se o usuário deseja fazer outro pedido
            while (true) {
                System.out.print("\nDeseja fazer outro pedido? (S/N): ");
                continuar = scanner.next().charAt(0);
                if (continuar == 'S' || continuar == 's' || continuar == 'N' || continuar == 'n') {
                    break; // Saia do loop se a entrada for válida
                } else {
                    System.out.println("Entrada inválida! Por favor, insira 'S' para sim ou 'N' para não.");
                }
            }

        } while (continuar == 'S' || continuar == 's');

        // Fechar o scanner após o uso
        System.out.println("Encerrando o programa...");
        scanner.close();
    }
}
