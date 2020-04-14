package com.company;

public class arra {
    static int numFilas = 20;
    static int numColumns = 25;
    static String sopa = "CAELOOBSAZIIMPEPROTOCOLOCHMOTAERAWDRAHILZEDERWWYRNFIUGYTJFQCAQPCPHIPBIUPRORBFBSOBOQRZFAOLIERAWTFOSDEPFQUDROGOCQMTKHÑIHBPPCUAAXUÑMFUILÑÑPPNOCÑWCSKOQOSKAKSDCGFOIUUPMÑEEMESHMXEEOBBSTAGOYTKÑTONQWUDGFJNÑCTOQQBKWNAÑHIXCCBDAFEWOGSOYXUYJÑRDGURIRAAODATIIZMORAYTJSJONAONIISCIMYYCUNQQPOELQPRXCGTPGEORCBPAATUUFOECPUDRULETNDDEIAAMIUNJVTRODMACAARAUEICIGRAMRLPFORCUODJIIFRWDGTYEYRFQULADOUIIIQOIANBAOOOMCGUGXEIGDGMMKJHYZEOTHRLITOYJDJONENONTIICXPGOAIDEORYFAÑJAYVZDRBIJQIUSCOYEEPLYETUDCUEBKXLZUAIROMEMRBZOUJQGYAXGQEFAT";
//    public static void main(String[] args) {

    //        int[][] arr = {{1, 2}, {3, 4}};
//
//        for (int i = 0; i < 2; i++)
//            for (int j = 0; j < 2; j++)
//                System.out.println("arr[" + i + "][" + j + "] = "
//                        + arr[i][j]);
    public static void Board(String s) {
        int row = numFilas;
        int column = numColumns;
        // @param startConfig currently stores the string +dd+babd+b_a+ddc.
        // @param endConfig is currently unused.
        char[][] boardArray = new char[row][column]; // Creates a 4x4 board.
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                boardArray[i][j] = s.charAt(i);
                System.out.print(boardArray[i][j]);
            }
        }
    }

    public static char[] transform(String s) {
        return s.toCharArray();
    }

    public static void main(String[] args) {
//        String[] strArr = new String[sopa.length()];
//        char[][] char2D = new char[numFilas * numColumns][];
//
//        for (int i = 0; i < sopa.length(); i++) {
//            char2D[i] = strArr[sopa.charAt(i)].toCharArray();
//        }
//
//        for (char[] char1D : char2D) {
//            for (char c : char1D)
//                System.out.print(c + " ");
//
//            System.out.println();
//        }
        Board(sopa);
    }
}
