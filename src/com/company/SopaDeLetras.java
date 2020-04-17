package com.company;

import java.util.Scanner;

public class SopaDeLetras {
    static int numFilas = 20;
    static int numColumns = 25;
    static int cuantasEncontrar = 5;
    static String sopa = "BOOLEANSAZIIMPEPROTOCOLOCMMOTAERAWDRAHILZEDERWWYRNFCUGYTJFQCAQPCPHIPBIUBRORBFBSOBOQRZFAOLIERAWTFOSDEPFQUDROGOCQMTKHÑIHBPPCUAAXUÑMFUILÑÑPPNOCÑWCSKOQOSKAKSDCGFOIUUPMÑEEMESHMXEEOBBSTAGOYTKÑTONQWUDGFJNÑCTOQQBKWNAÑHIXCCBDAFEWOGSOYXUYJÑRDGURIRAAODATIIZMORAYTJSJONAONIISCIMYYCUNQQPOELQPRXCGTPGEORCBPAATUUFOECPUDRULETNDDEIAAMIUNJVTRODMACAARAUEICIGRAMRLPFORCUODJIIFRWDGTYEYRFQULADOUIIIQOIANBAOOOMCGUGXEIGDGMMKJHYZEOTHRLITOYJDJONENONTIICXPGOAIDEORYFAÑJAYVZDRBIJQIUSCOYEEPLYETUDCUEBKXLZUAIROMEMRBZOUJQGYAXGQEFAT";
    static String pal = "BooleanChipProtocolo Base de datos  Compilador";

    static char[][] tablero = new char[numFilas][numColumns];

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

    public static char[][] sToString(String s) {//?2d array
        int k = 0, row, column;
        row = numFilas;
        column = numColumns;
        char v[][] = new char[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (k < s.length())
                    v[i][j] = s.charAt(k);
                k++;
            }
        }
        return v;
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
            trobades[p - cuantasEncontrar]++;
        else
            trobades[p]++;
        return trobades;
    }

    private static String[] trobaHorizontal(String[] palabras, char[][] tablero) {
//        int w = 0, found = 0;
//        for (int i = 0; i < numFilas; i++) {
//            for (int j = 0; j < numColumns; j++) {
//                for (w = 0; w < palabras.length; w++) {
//                    found = 0;
//                    char[] ch = palabras[w].toCharArray();
//                    j = 0;
//                    for (int c = 0; c < ch.length; c++) {
//                        System.out.println(tablero[i][j]);
//                        while (tablero[i][j] != ch[0]) { //Se incrementan los caracteres
//                            j++; //Esto no funcionará porque necesito la referencia
//                        }
//                        if (tablero[i][j] == ch[0]) {
//                            found++;
//                            if (found == palabras[w].length()) {
//                                System.out.println(palabras[w]);
//                            }
//                        }
//                    }
//                }
//            }
//        }

        for (int i = 0; i < numFilas; i++) {
            for (int w = 0; w < palabras.length; w++) {
                char[] ch = palabras[w].toCharArray();
                for (int j = 0; j < numColumns; j++) {
                    System.out.println(tablero[i][j]);
                    if (tablero[i][j] != ch[0]) {
                        continue;
                    } else {
                        int sav = j;
                        int found = 0;
                        for (int c = 0; c < ch.length; c++) {
                            if (ch[c] == tablero[i][sav]) {
                                sav++;
                                found++;
                                continue;
                            }
                            break;
                        }
                        if (ch.length == found) {
                            System.out.println(palabras[w]);
                            sav = 0;
                        }
                    }
                    break;
                }

            }
        }


        return palabras;
    }

    public static void main(String[] args) {

        tablero = sToString(sopa);
//        for (int i = 0; i < numFilas; i++) {
//            for (int j = 0; j < numColumns; j++) {
//                if (tablero[i][j] == 0) {
//                    break;
//                }
//                System.out.print(tablero[i][j] + " ");
//            }
//            System.out.println(" ");
//        }
        trobaHorizontal(palabras, tablero);
    }
}
