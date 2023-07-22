package com.github.kairoCesar.calculoSimplesNacional.tributos;

import java.util.Scanner;

public class CalculadoraTributosFederais {
    Scanner entrada = new Scanner(System.in);

    public double cpp;
    public double csll;
    public double irpj;
    public double cofins;
    public double pisPasep;
    public double aliquotaTributosFederais;
    public double receitaComTributacaoMonofasica;
    public double receitaSemTributacaoMonofasica;
    public double valorDeTributosFederaisApagar;


    public CalculadoraTributosFederais calcularTributosFederais
            (double rbt12, double faturamentoDoMes, double aliquotaEfetiva,
             CalculadoraTributosFederais reparticao) {
        CalculadoraTributosFederais tributosFederaisCalculados = new CalculadoraTributosFederais();

        return tributosFederaisCalculados;
    }

    private CalculadoraTributosFederais calcularTributosComMonofasico
            (double rbt12, double faturamentoDoMes, double aliquotaEfetiva,CalculadoraTributosFederais reparticao) {

        CalculadoraTributosFederais tributosFederaisCalculadosComMonofasico = new CalculadoraTributosFederais();


        return tributosFederaisCalculadosComMonofasico;
    }


    private double verificarTributacaoMonofasicaDePisCofins(double faturamentoDoMes) {
        System.out.print("A empresa vendeu mercadorias sujeitas à tributação monofásica de Pis/Cofins? ");
        String tributacaoMonofasica = entrada.next();

        if (tributacaoMonofasica.equals("sim")) {
            System.out.print("Digite o valor da receita sujeita à tributação monofásica de Pis/Cofins: ");
            double receitaComTributacaoMonofasica = entrada.nextDouble();
            while (receitaComTributacaoMonofasica > faturamentoDoMes) {
                System.out.printf("A receita sujeita à tributação monofásica não pode ser superior ao faturamento mensal de %.2f%n" +
                        "Digite novamente o valor da receita sujeita à tributação monofásica: ", faturamentoDoMes);
                receitaComTributacaoMonofasica = entrada.nextDouble();
            }
            return receitaComTributacaoMonofasica;
        } else {
            return 0.00;
        }
    }
}
