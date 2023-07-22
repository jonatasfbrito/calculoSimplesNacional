package com.github.kairoCesar.simplesnacional.tributos;

import java.util.Scanner;

public class Tributos {
    Scanner entrada = new Scanner(System.in);

    public double cpp;
    public double csll;
    public double icms;
    public double irpj;
    public double cofins;
    public double pisPasep;


    public boolean verificarIcmsST() {
        System.out.print("A empresa vendeu mercadorias com ICMS ST? ");
        String icmsST = entrada.next();

        if(icmsST.equals("sim")) {
            return true;
        } else {
            return false;
        }
    }
}
