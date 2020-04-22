package com.company;

import java.util.*;

public class LetterSoup {
/* static int numFilas = 20;
    static int numColumns = 25;
    static int cuantasEncontrar = 20;
    static String sopa = "NAELOOBSAZIIMPEPROTOCOLOCMMOTAERAWDRAHILZEDERWWYRNFCUGYTJFQCAQPCPHIPBIUBRORBFBSOBOQRZFAOLIERAWTFOSDEPFQUDROGOCQMTKHÑIHBPPCUAAXUÑMFUILÑÑPPNOCÑWCSKOQOSKAKSDCGFOIUUPMÑEEMESHMXEEOBBSTAGOYTKÑTONQWUDGFJNÑCTOQQBKWNAÑHIXCCBDAFEWOGSOYXUYJÑRDGURIRAAODATIIZMORAYTJSJONAONIISCIMYYCUNQQPOELQPRXCGTPGEORCBPAATUUFOECPUDRULETNDDEIAAMIUNJVTRODMACAARAUEICIGRAMRLPFORCUODJIIFRWDGTYEYRFQULADOUIIIQOIANBAOOOMCGUGXEIGDGMMKJHYZEOTHRLITOYJDJONENONTIICXPGOAIDEORYFAÑJAYVZDRBIJQIUSCOYEEPLYETUDCUEBKXLZUAIROMEMRBZOUJQGYAXGQEFAT";
    static String pal = "AlgoritmoBase de datosBooleanChipCompiladorComputadorDirectorioEncriptarGigabyteHardwareInterfazKilobyteProgramaciónMegabyteMemoriaMicroprocesadorProtocoloPseudocódigoRedSoftware";
    static char[][] tablero = new char[numFilas][numColumns];*/
    static int numFilas = 20;
    static int numColumns = 25;
    static int cuantasEncontrar = 5;
    static String sopa = "CAELOOBSAZIIMPEPROTOCOLOCHMOTAERAWDRAHILZEDERWWYRNIIUGYTJFQCAQPCPHIPBIUPRORPFBSOBOQRZFAOLIERAWTFOSDEPFQUDROGOCQMTKHÑIHBPPCUAAXUÑMFUILÑÑPPNOCÑWCSKOQOSKAKSDCGFOIUUPMÑEEMESHMXEEOBBSTAGOYTKÑTONQWUDGFJNÑCTOQQBKWNAÑHIXCCBDAFEWOGSOYXUYJÑRDGURIRAAODATIIZMORAYTJSJONAONIISCIMYYCUNQQPOELQPRXCGTPGEORCBPAATUUFOECPUDRULETNDDEIAAMIUNJVTRODMACAARAUEICIGRAMRLPFORCUODJIIFRWDGTYEYRFQULADOUIIIQOIANBAOOOMCGUGXEIGDGMMKJHYZEOTHRLITOYJDJONENONTIICXPGOAIDEORYFAÑJAYVZDRBIJQIUSCOYEEPLYETUDCUEBKXLZUAIROMEMRBZOUJQGYAXGQEFAT";
    static String pal = "ChipProtocolo Base de datos BooleanCompilador";


    static char[] tablero = new char[numColumns * numFilas]; //Sopa de letras

    static String[] palabras = buscarPalabras(pal);

    static int[] trobades = new int[cuantasEncontrar];


    static Scanner teclado = new Scanner(System.in).useDelimiter("\n");

    private static void introducirDatos() {
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

    private static int comprobar(String s) {
        while (!s.matches("[0-9]*")) {
            System.out.print("Lo siento, introduce un numero: ");
            s = teclado.nextLine();
        }
        return Integer.parseInt(s);
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

    private static String treuEspais(String s) {
        String cad = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ')
                cad += s.charAt(i);
        }
        return cad;
    }

    private static char[] sToString(String s) {
        return s.toCharArray();
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

//    static void trobaHoritzontals(String[] palabras, char[] tablero) {
//        for (int x = 0; x < palabras.length; x++) {
//            for (int i = 0; i < tablero.length; i++) {
//                char[] ch = palabras[x].toCharArray();
//                if (ch[0] != tablero[i]) {
//                    continue;
//                } else {
//                    int salvar = i;
//                    int wordLong = 0;
//                    for (int chrs = 0; chrs < ch.length; chrs++) {
//                        if (ch[chrs] == tablero[salvar]) {
//                            salvar++;
//                            wordLong++;
//                            continue;
//                        }
//                        break;
//                    }
//                    if (ch.length == wordLong) {
//                        contador(x);
//                        System.out.println(palabras[x]);
//                    }
//                }
//            }
//        }
//    }

    //
    private static void trobaVerticals(String[] palabras, char[][] tablero) {
        int found = 0;
        boolean allCharFound = true;
        for (int n = 0; n < numFilas; n++) {
            for (int m = 0; m < numColumns; m++) {
                for (int p = 0; p < palabras.length; p++) {
                    if (palabras[p].charAt(0) == tablero[n][m]) {
                        int searchRow = n;
                        int searchColum = m;
                        char[] ch = palabras[p].toCharArray();
                        for (int c = 0; c < ch.length; c++) {
                            if (numColumns == searchColum || numFilas == searchRow ||
                                    tablero[searchRow][searchColum] != ch[c]) {
                                allCharFound = false;
                                searchColum++;
                                break;
                            }
                            if (tablero[searchRow][searchColum] == ch[c] && found != palabras[p].length()) {
                                searchRow++;
                                found++;
                                if (found == palabras[p].length() - 1) {
                                    allCharFound = true;
                                    break;
                                }
                            }
                        }
                        String color = (char) 27 + "[0;35;41m";
                        if (allCharFound) {
                            System.out.print(palabras[p] + " ");
                            found = 0;
                        }
                    }
                }
            }
        }
    }


    private static void trobaVerticales(char[] tablero) {
        int number = 0;
        for (int i = 1; i < numColumns; i++) {
            for (int j = 1; j < numFilas; j++) {
                number = i + ((j * numColumns) - numColumns);
                System.out.println(tablero[number - 1]);
            }
        }
    }


    public static void main(String[] args) {
        tablero = sToString(sopa);
//        for (int k = 0; k < tablero.length; k++) {
//            System.out.print(" " + tablero[k]);
//            if ((k + 1) % numColumns == 0) {
//                System.out.println();
//            }
//        }

        System.out.println(Arrays.toString(buscarPalabras(pal)));
        trobaVerticales(tablero);
    }
}


