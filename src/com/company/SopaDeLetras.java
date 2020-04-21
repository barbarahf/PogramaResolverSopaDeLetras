package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class SopaDeLetras {
    static int numFilas = 4;
    static int numColumns = 3;
    static int cuantasEncontrar = 2;
    static String sopa = "CCRHHEIIDPPA";
    static String pal = "RedChip";
    static char[][] tablero = new char[numFilas][numColumns];
    static String[][] sopacol = new String[numFilas][numColumns];
    static String[] palabras = buscarPalabras(pal);
    static int[] trobades = new int[cuantasEncontrar];
    static Scanner teclado = new Scanner(System.in).useDelimiter("\n");

//    static void introducirDatos() {
//        Scanner teclado = new Scanner(System.in);
//        System.out.print("Numero de filas de la sopa:");
//        numFilas = comprobar(teclado.nextLine());
//        System.out.println(numFilas);
//        System.out.print("Numero de columnas de la sopa: ");
//        numColumns = comprobar(teclado.nextLine());
//        System.out.println(numColumns);
//        System.out.print("Introduce la sopa de letras: ");
//        sopa = teclado.nextLine();
//        System.out.println(sopa);
//        System.out.print("¿Cuantas palabras deseas encontrar en la sopa?: ");
//        cuantasEncontrar = comprobar(teclado.nextLine());
//        System.out.println(cuantasEncontrar);
//        System.out.print("Introduce las palabras que deseas buscar en la sopa: ");
//        pal = teclado.nextLine();
//        System.out.println(pal);
//    }

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

    public static char[][] sToString(String s) {
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

    public static String[][] sArrayStr(char[][] s) {
        String[][] v = new String[numFilas][numColumns];
        for (int i = 0; i < numFilas; i++) {
            for (int j = 0; j < numColumns; j++) {
                v[i][j] = Character.toString(s[i][j]);
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

    private static void trobaHorizontal(String[] palabras, char[][] tablero) {
        boolean trobada = false;
        for (int n = 0; n < numFilas; n++) {
            outer:
            for (int m = 0; m < numColumns; m++) {
                for (int p = 0; p < palabras.length; p++) {
                    if (palabras[p].charAt(0) == tablero[n][m]) {
                        int searchRow = n;
                        int searchColum = m;
                        boolean allCharFound = true;
                        char[] ch = palabras[p].toCharArray();
                        for (int c = 0; c < ch.length; c++) {
                            if (tablero[searchRow][searchColum] != ch[c] || numColumns - 1 == searchColum) {
                                allCharFound = false;//ciega mija
                                break;
                            }
                            searchColum++;
                        }
                        String color = (char) 27 + "[0;36;40m";
                        if (allCharFound) {
                            System.out.println(palabras[p]);
//                            trobada = true;
                            for (int q = 0; q < palabras[p].length(); q++) {
                                sopacol[searchRow][searchColum - q - 1] = color + tablero[searchRow][searchColum - q - 1] + (char) 27 + "[0m";
                            }
                        }
                    }
                }
            }
        }
    }

    private static void trobaVerticals(String[] palabras, char[][] tablero) {
        boolean trobada = false;
        for (int n = 0; n < numFilas; n++) {
            outer:
            for (int m = 0; m < numColumns; m++) {
                for (int p = 0; p < palabras.length; p++) {
                    if (palabras[p].charAt(0) == tablero[n][m]) {
                        int searchRow = n;
                        int searchColum = m;
                        boolean allCharFound = true;
                        char[] ch = palabras[p].toCharArray();
                        for (int c = 0; c < ch.length; c++) {
                            if (tablero[searchRow][searchColum] != ch[c] || numColumns - 1 == searchColum) {
                                allCharFound = false;//ciega mija
                                break;
                            }
                            searchRow++;
                        }
                        String color = (char) 27 + "[0;36;40m";
                        if (allCharFound) {
                            System.out.println(palabras[p]);
//                            trobada = true;
                            for (int q = 0; q < palabras[p].length(); q++) {
                                sopacol[searchRow][searchColum - q - 1] = color + tablero[searchRow][searchColum - q - 1] + (char) 27 + "[0m";
                            }
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        tablero = sToString(sopa);
        sopacol = sArrayStr(tablero);
        trobaHorizontal(palabras, tablero);
        for (int i = 0; i < numFilas; i++) {
            for (int j = 0; j < numColumns; j++) {
                System.out.print(sopacol[i][j] + " ");
            }
            System.out.println(" ");
        }
    }
}
