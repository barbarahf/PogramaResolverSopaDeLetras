package com.company;

import java.util.Scanner;

public class Main {
    static int numFilas = 20;
    static int numColumns = 25;

    static int cuantasEncontrar;
    static String sopa = "NAELOOBSAZIIMPEPROTOCOLOCMMOTAERAWDRAHILZEDERWWYRNFCUGYTJFQCAQPCPHIPBIUBRORBFBSOBOQRZFAOLIERAWTFOSDEPFQUDROGOCQMTKHÑIHBPPCUAAXUÑMFUILÑÑPPNOCÑWCSKOQOSKAKSDCGFOIUUPMÑEEMESHMXEEOBBSTAGOYTKÑTONQWUDGFJNÑCTOQQBKWNAÑHIXCCBDAFEWOGSOYXUYJÑRDGURIRAAODATIIZMORAYTJSJONAONIISCIMYYCUNQQPOELQPRXCGTPGEORCBPAATUUFOECPUDRULETNDDEIAAMIUNJVTRODMACAARAUEICIGRAMRLPFORCUODJIIFRWDGTYEYRFQULADOUIIIQOIANBAOOOMCGUGXEIGDGMMKJHYZEOTHRLITOYJDJONENONTIICXPGOAIDEORYFAÑJAYVZDRBIJQIUSCOYEEPLYETUDCUEBKXLZUAIROMEMRBZOUJQGYAXGQEFAT";
    static String pal = "Algoritmo Base de datos BooleanChipCompiladorComputadorDirectorioEncriptarGigabyteHardwareInterfazKilobyteProgramaciónMegabyteMemoriaMicroprocesadorProtocoloPseudocódigoRedSoftware";

    static char[] tablero = new char[numColumns * numFilas]; //Sopa de letras

    static String palsearch = treuAccents(treuEspais(pal.toUpperCase()));


    static char[] palabras = new char[palsearch.length()];


    static Scanner teclado = new Scanner(System.in).useDelimiter("\n");

    static void introducirDatos() {
//        Scanner teclado = new Scanner(System.in);
//        System.out.print("Numero de filas de la sopa:");
//        numFilas = comprobar(teclado.nextLine());
//        System.out.println(numFilas);
//
//        System.out.print("Numero de columnas de la sopa: ");
//        numColumns = comprobar(teclado.nextLine());
//        System.out.println(numColumns);
//
//        System.out.print("Introduce la sopa de letras: ");
//        sopa = teclado.nextLine();
//        System.out.println(sopa);
//
//        System.out.print("¿Cuantas palabras deseas encontrar en la sopa?: ");
//        cuantasEncontrar = comprobar(teclado.nextLine());
//        System.out.println(cuantas);
//
//        System.out.print("Introduce las palabras que deseas buscar en la sopa: ");
//        inputWords = teclado.nextLine();
//        System.out.println(inputWords);

    }

    static int comprobar(String s) {
        while (!s.matches("[0-9]*")) {
            System.out.print("Lo siento, introduce un numero: ");
            s = teclado.nextLine();
        }
        return Integer.parseInt(s);
    }


    static String treuEspais(String s) {
        String cad = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ')
                cad += s.charAt(i);
        }
        return cad;
    }

    static char[] sToString(String s) {
        return s.toCharArray();
    }

    static String giraCad(String s) {
        String r = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            r += s.charAt(i);
        }
        return r;
    }

    static String treuAccents(String s) {
        String accents = "ÀÈÌÒÙÁÉÍÓÚÄËÏÖÜÂÊÎÔÛ";
        String sense = "AEIOUAEIOUAEIOUAEIOU";
        String cad = "";
        char c;
        int p;
        for (int n = 0; n < s.length(); n++) {
            c = s.charAt(n);
            p = accents.indexOf(c);
            if ((p != -1)) {
                c = sense.charAt(p);
                cad += c;
            } else
                cad += c;
        }
        return cad;
    }

    public static void main(String[] args) {
        tablero = sToString(sopa);
        for (int k = 0; k < tablero.length; k++) {
            System.out.print(tablero[k] + " ");
            if ((k + 1) % numColumns == 0) {
                System.out.println();
            }
        }

    }
}
