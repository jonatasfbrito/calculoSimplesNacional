package com.github.kairoCesar.simplesnacional.anexos;

import com.github.kairoCesar.simplesnacional.tributos.Tributos;

public class Anexo1 {


    double rbt12;
    double faturamentoDoMes;
    double[] aliquotasFixas = {0.04, 0.073, 0.095, 0.107, 0.143, 0.19};
    double[] valoresDeducao = {0.00, 5940.00, 13860.00, 22500.00, 87300.00, 378000.00};
    Tributos tributos = new Tributos();


    double encontrarAliquotaEfetiva(double rbt12, double faturamentoDoMes) {
        int indiceFaixa = verificarFaixa(rbt12);

        double aliquotaEfetiva = ((rbt12 * aliquotasFixas[indiceFaixa]) - valoresDeducao[indiceFaixa]) / rbt12;

        return aliquotaEfetiva;
    }

    private int verificarFaixa(double rbt12) {
        int indiceFaixa;

        if (rbt12 < 180000.00) {
            indiceFaixa = 0;
        } else if (rbt12 < 360000.00) {
            indiceFaixa = 1;
        } else if (rbt12 < 720000.00) {
            indiceFaixa = 2;
        } else if (rbt12 < 1800000.00) {
            indiceFaixa = 3;
        } else if (rbt12 < 3600000.00) {
            indiceFaixa = 4;
        } else if (rbt12 < 4800000.00) {
            indiceFaixa = 5;
        } else {
            indiceFaixa = -1;
        }

        return indiceFaixa;
    }

    public double calcularTributos(double rbt12, double faturamentoDoMes) {
        double aliquotaEfetiva = encontrarAliquotaEfetiva(rbt12, faturamentoDoMes);

        boolean icmsST = tributos.verificarIcmsST();
        tributos.icms = (icmsST) ? 0.00: (0.34 * aliquotaEfetiva) * 100;
        tributos.cpp = (0.4150 * aliquotaEfetiva) * 100;
        tributos.csll = (0.0350 * aliquotaEfetiva) * 100;
        tributos.irpj = (0.0550 * aliquotaEfetiva) * 100;
        tributos.cofins = (0.01274 * aliquotaEfetiva) * 100;
        tributos.pisPasep = (0.0276 * aliquotaEfetiva) * 100;

        aliquotaEfetiva = (tributos.icms + tributos.cpp + tributos.csll + tributos.irpj + tributos.cofins + tributos.pisPasep);

        return aliquotaEfetiva;
    }

    public void simularSimplesNacional(double rbt12, double faturamentoDoMes) {
        double aliquotaEfetiva = calcularTributos(rbt12, faturamentoDoMes);

        System.out.printf("O valor da guia é de R$%.2f%n", faturamentoDoMes * aliquotaEfetiva);
        System.out.printf("Alíquota efetiva: %.3f%%%nValor por tributo:%nICMS: %.4f%%%nCPP: %.4f%%%nCSLL: %.4f%%%n" +
                        "IRPJ: %.4f%%%nPIS/PASEP: %.4f%%%nCOFINS: %.4f%%%n", aliquotaEfetiva * 100, tributos.icms, tributos.cpp,
                tributos.csll, tributos.irpj, tributos.pisPasep, tributos.cofins);
    }
}
