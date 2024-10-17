package ImpostoCalc;


import java.util.Scanner;
import java.util.Locale;

public class CalculadoraImpostoRenda {

    public static void main(String[] args) {
        // Configura o Scanner para usar ponto como separador decimal
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        char continuar; // Variável para controlar a repetição

        do {
            double rendaAnualSalario = 0;
            double rendaAnualServico = 0;
            double rendaAnualGanhoCapital = 0;
            double gastosMedicos = 0;
            double gastosEducacionais = 0;

            // Validação das entradas
            while (true) {
                try {
                    System.out.print("Renda anual com salário: ");
                    rendaAnualSalario = scanner.nextDouble();
                    if (rendaAnualSalario < 0) throw new IllegalArgumentException();
                    break; // Saia do loop se a entrada for válida
                } catch (Exception e) {
                    System.out.println("Entrada inválida! Por favor, insira um valor numérico não negativo.");
                    scanner.nextLine(); // Limpa o buffer do scanner
                }
            }

            while (true) {
                try {
                    System.out.print("Renda anual com prestação de serviço: ");
                    rendaAnualServico = scanner.nextDouble();
                    if (rendaAnualServico < 0) throw new IllegalArgumentException();
                    break;
                } catch (Exception e) {
                    System.out.println("Entrada inválida! Por favor, insira um valor numérico não negativo.");
                    scanner.nextLine();
                }
            }

            while (true) {
                try {
                    System.out.print("Renda anual com ganho de capital: ");
                    rendaAnualGanhoCapital = scanner.nextDouble();
                    if (rendaAnualGanhoCapital < 0) throw new IllegalArgumentException();
                    break;
                } catch (Exception e) {
                    System.out.println("Entrada inválida! Por favor, insira um valor numérico não negativo.");
                    scanner.nextLine();
                }
            }

            while (true) {
                try {
                    System.out.print("Gastos médicos: ");
                    gastosMedicos = scanner.nextDouble();
                    if (gastosMedicos < 0) throw new IllegalArgumentException();
                    break;
                } catch (Exception e) {
                    System.out.println("Entrada inválida! Por favor, insira um valor numérico não negativo.");
                    scanner.nextLine();
                }
            }

            while (true) {
                try {
                    System.out.print("Gastos educacionais: ");
                    gastosEducacionais = scanner.nextDouble();
                    if (gastosEducacionais < 0) throw new IllegalArgumentException();
                    break;
                } catch (Exception e) {
                    System.out.println("Entrada inválida! Por favor, insira um valor numérico não negativo.");
                    scanner.nextLine();
                }
            }

            // Cálculo do imposto sobre salário
            double salarioMensal = rendaAnualSalario / 12;
            double impostoSalario;
            if (salarioMensal < 3000) {
                impostoSalario = 0;
            } else if (salarioMensal < 5000) {
                impostoSalario = rendaAnualSalario * 0.10;
            } else {
                impostoSalario = rendaAnualSalario * 0.20;
            }

            // Cálculo do imposto sobre serviços (15%)
            double impostoServico = rendaAnualServico * 0.15;

            // Cálculo do imposto sobre ganho de capital (20%)
            double impostoGanhoCapital = rendaAnualGanhoCapital * 0.20;

            // Imposto bruto total
            double impostoBrutoTotal = impostoSalario + impostoServico + impostoGanhoCapital;

            // Cálculo das deduções
            double maximoDedutivel = impostoBrutoTotal * 0.30;
            double gastosDedutiveis = gastosMedicos + gastosEducacionais;
            double abatimento = Math.min(gastosDedutiveis, maximoDedutivel);

            // Imposto devido
            double impostoDevido = impostoBrutoTotal - abatimento;

            // Relatório de imposto de renda
            System.out.println("\n### RELATÓRIO DE IMPOSTO DE RENDA ###");
            System.out.println("* CONSOLIDADO DE RENDA:");
            System.out.printf("Imposto sobre salário: %.2f\n", impostoSalario);
            System.out.printf("Imposto sobre serviços: %.2f\n", impostoServico);
            System.out.printf("Imposto sobre ganho de capital: %.2f\n", impostoGanhoCapital);

            System.out.println("* DEDUÇÕES:");
            System.out.printf("Máximo dedutível: %.2f\n", maximoDedutivel);
            System.out.printf("Gastos dedutíveis: %.2f\n", gastosDedutiveis);

            System.out.println("* RESUMO:");
            System.out.printf("Imposto bruto total: %.2f\n", impostoBrutoTotal);
            System.out.printf("Abatimento: %.2f\n", abatimento);
            System.out.printf("Imposto devido: %.2f\n", impostoDevido);

            // Perguntar se o usuário deseja calcular novamente
            continuar = ' '; // Inicializa com um valor padrão
            while (continuar != 'S' && continuar != 's' && continuar != 'N' && continuar != 'n') {
                System.out.print("\nDeseja fazer um novo cálculo? (S/N): ");
                continuar = scanner.next().charAt(0);

                if (continuar != 'S' && continuar != 's' && continuar != 'N' && continuar != 'n') {
                    System.out.println("Entrada inválida! Por favor, insira 'S' para sim ou 'N' para não.");
                }
            }

        } while (continuar == 'S' || continuar == 's');

        // Fechar o scanner após o uso
        System.out.println("Encerrando o programa...");
        scanner.close();
    }
}
