package com.github.kairoCesar.calculoSimplesNacional.tributos;

import java.util.Scanner;

public class CalculadoraIcms {
    Scanner entrada = new Scanner(System.in);

    public double icms;
    public double aliquotaIcms;
    public double valorDeIcmsApagar;
    public double receitaIcmsComSt;
    public double receitaIcmsSemSt;

    public CalculadoraIcms calcularIcms(double rbt12, double faturamentoDoMes, double aliquotaEfetiva, CalculadoraIcms reparticao) {
        // ICMS com substituição tributária
        CalculadoraIcms icmsCalculado = new CalculadoraIcms();
        icmsCalculado.receitaIcmsComSt = verificarIcmsComSt(rbt12, faturamentoDoMes);

        // ICMS sem substituição tributária
        aliquotaIcms = (reparticao.icms * aliquotaEfetiva) / 100;
        icmsCalculado.aliquotaIcms = (reparticao.icms * aliquotaEfetiva) * 100;
        icmsCalculado.receitaIcmsSemSt = faturamentoDoMes - icmsCalculado.receitaIcmsComSt;
        icmsCalculado.valorDeIcmsApagar = icmsCalculado.receitaIcmsSemSt * icmsCalculado.aliquotaIcms / 100;

        return icmsCalculado;
    }

    private double verificarIcmsComSt(double rbt12, double faturamentoDoMes) {
        System.out.print("A empresa vendeu mercadorias sujeitas à ICMS ST? ");
        String icmsComSt = entrada.next();

        if (icmsComSt.equals("sim")) {
            System.out.print("Digite o valor da receita sujeita à ICMS ST: ");
            double receitaComIcmsSt = entrada.nextDouble();
            while (receitaComIcmsSt > faturamentoDoMes) {
                System.out.printf("A receita sujeita à ICMS ST não pode ser superior ao faturamento mensal de %.2f%n" +
                        "Digite novamente o valor da receita sujeita à ICMS ST: ", faturamentoDoMes);
                receitaComIcmsSt = entrada.nextDouble();
            }
            return receitaComIcmsSt;
        } else {
            return 0.00;
        }
    }

}
