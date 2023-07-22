package com.github.kairoCesar.calculoSimplesNacional.anexos;

import com.github.kairoCesar.calculoSimplesNacional.tributos.CalculadoraIcms;
import com.github.kairoCesar.calculoSimplesNacional.tributos.CalculadoraTributosFederais;

public class Anexo1 {

    double rbt12;
    double faturamentoDoMes;
    double[] aliquotasFixas = {0.04, 0.073, 0.095, 0.107, 0.143, 0.19};
    double[] valoresDeducao = {0.00, 5940.00, 13860.00, 22500.00, 87300.00, 378000.00};
    CalculadoraIcms icmsCalculado = new CalculadoraIcms();
    CalculadoraTributosFederais tributosFederaisCalculados = new CalculadoraTributosFederais();

    public void simularSimplesNacional(double rbt12, double faturamentoDoMes) {
       icmsCalculado = calcularIcms(rbt12, faturamentoDoMes);
       tributosFederaisCalculados = calcularTributosFederais(rbt12, faturamentoDoMes);

        System.out.printf("valor: %.2f%n", tributosFederaisCalculados.valorDeTributosFederaisApagar);
    }

    private CalculadoraIcms calcularIcms(double rbt12, double faturamentoDoMes) {
        double aliquotaEfetiva = encontrarAliquotaEfetiva(rbt12, faturamentoDoMes);
        CalculadoraIcms icmsCalculado = new CalculadoraIcms();

        icmsCalculado = icmsCalculado.calcularIcms(rbt12, faturamentoDoMes, aliquotaEfetiva, reparticaoDeIcmsAnexo1());

        return icmsCalculado;
    }

    private CalculadoraTributosFederais calcularTributosFederais(double rbt12, double faturamentoDoMes) {
        double aliquotaEfetiva = encontrarAliquotaEfetiva(rbt12, faturamentoDoMes);
        CalculadoraTributosFederais tributosFederaisCalculados = new CalculadoraTributosFederais();

        tributosFederaisCalculados = tributosFederaisCalculados.calcularTributosFederais(rbt12, faturamentoDoMes,
                aliquotaEfetiva, reparticaoDeTributosFederaisAnexo1());

        return  tributosFederaisCalculados;
    }

    public CalculadoraIcms reparticaoDeIcmsAnexo1() {
        CalculadoraIcms reparticaoDeCalculadoraIcmsAnexo1 = new CalculadoraIcms();

        reparticaoDeCalculadoraIcmsAnexo1.icms = 0.34;

        return reparticaoDeCalculadoraIcmsAnexo1;
    }

    public CalculadoraTributosFederais reparticaoDeTributosFederaisAnexo1() {
        CalculadoraTributosFederais reparticaoTributosFederaisAnexo1 = new CalculadoraTributosFederais();

        reparticaoTributosFederaisAnexo1.cpp = 0.4150;
        reparticaoTributosFederaisAnexo1.csll = 0.0350;
        reparticaoTributosFederaisAnexo1.irpj = 0.0550;
        reparticaoTributosFederaisAnexo1.cofins = 0.1274;
        reparticaoTributosFederaisAnexo1.pisPasep = 0.0276;

        return reparticaoTributosFederaisAnexo1;
    }

    private double encontrarAliquotaEfetiva(double rbt12, double faturamentoDoMes) {
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


}
