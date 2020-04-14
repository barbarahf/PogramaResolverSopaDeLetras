package com.company;

import java.util.*;

public class SopaDeLetras {
    static int numFilas = 20;
    static int numColumns = 25;
    static int cuantasEncontrar = 5;
    static String sopa = "CAELOOBSAZIIMPEPROTOCOLOCHMOTAERAWDRAHILZEDERWWYRNFIUGYTJFQCAQPCPHIPBIUPRORBFBSOBOQRZFAOLIERAWTFOSDEPFQUDROGOCQMTKHÑIHBPPCUAAXUÑMFUILÑÑPPNOCÑWCSKOQOSKAKSDCGFOIUUPMÑEEMESHMXEEOBBSTAGOYTKÑTONQWUDGFJNÑCTOQQBKWNAÑHIXCCBDAFEWOGSOYXUYJÑRDGURIRAAODATIIZMORAYTJSJONAONIISCIMYYCUNQQPOELQPRXCGTPGEORCBPAATUUFOECPUDRULETNDDEIAAMIUNJVTRODMACAARAUEICIGRAMRLPFORCUODJIIFRWDGTYEYRFQULADOUIIIQOIANBAOOOMCGUGXEIGDGMMKJHYZEOTHRLITOYJDJONENONTIICXPGOAIDEORYFAÑJAYVZDRBIJQIUSCOYEEPLYETUDCUEBKXLZUAIROMEMRBZOUJQGYAXGQEFAT";
    static String pal = "ChipProtocolo Base de datos BooleanCompilador";


    static char[][] tablero = new char[numFilas][numColumns]; //Sopa de letras

    static String[] palabras = buscarPalabras(pal);

    static int[] trobades = new int[cuantasEncontrar];


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

    private static String[] buscarPalabras(String sav) {
        String[] v = new String[cuantasEncontrar * 2];
        int x = 1, indice = 0;
        String s = sav + sav;
        for (int j = 0; j < v.length; j++) {
            while ((x < s.length() && !Character.isUpperCase(s.charAt(x)))) {
                x++;
            }
            if (x <= s.length() / 2) {
                v[j] = (treuAccents(treuEspais(s.substring(indice, x).toUpperCase())));
            } else {

                v[j] = (treuAccents(treuEspais(giraCad(s.substring(indice, x)).toUpperCase())));
            }
            indice = x;
            x++;
        }
        return v;
    }

    static int comprobar(String s) {
        while (!s.matches("[0-9]*")) {
            System.out.print("Lo siento, introduce un numero: ");
            s = teclado.nextLine();
        }
        return Integer.parseInt(s);
    }

    private static String treuEspais(String s) {
        String cad = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ')
                cad += s.charAt(i);
        }
        return cad;
    }

    private static char[][] sToString(String s) {//?2d array
//        return s.toCharArray();
        char[][] sopa1 = new char[numColumns][numFilas];
        return sopa1;
    }


    private static String giraCad(String s) {
        String r = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            r += s.charAt(i);
        }
        return r;
    }

    private static String treuAccents(String s) {
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

    private static int[] contador(int p) {
        if (p >= cuantasEncontrar)
            trobades[p - cuantasEncontrar]++;//posicion +1, trobades esta en blanco
        else
            trobades[p]++;
        return trobades;
    }

    static void trobaHoritzontals(String[] palabras, char[] tablero) {
        for (int x = 0; x < palabras.length; x++) {
            for (int i = 0; i < tablero.length; i++) {
                char[] ch = palabras[x].toCharArray();
                if (ch[0] != tablero[i]) {
                    continue;
                } else {
                    int salvar = i;
                    int wordLong = 0;
                    for (char c : ch) {
                        if (c == tablero[salvar]) {
                            salvar++;
                            wordLong++;
                            continue;
                        }
                        break;
                    }
                    if (ch.length == wordLong) {
                        contador(x);
                    }
                }
            }
        }
    }

//    private static void trobaVerticales(String[] palabras, char[] tablero) {
//        int number;
//        for (int i = 1; i <= numFilas; i++) {
//            for (int j = 1; j <= numColumns; j++) {
//                number = i + ((j * numFilas) - numFilas);
//                System.out.println(number);
//            }
//        }
//    }


    public static void main(String[] args) {
//        tablero = sToString(sopa);
//        for (int k = 0; k < tablero.length; k++) {
//            System.out.print(" " + tablero[k]);
//            if ((k + 1) % numColumns == 0) {
//                System.out.println();
//            }
//        }

//        System.out.println(Arrays.toString(buscarPalabras(pal)));
//        trobaVerticales(palabras, tablero);
    }
}
