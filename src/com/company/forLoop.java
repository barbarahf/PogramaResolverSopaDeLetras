//package com.company;
//
//public class forLoop {
//    public static void main(String[] args) {
//
//        int row = 25;
//        int column = 20;
//        int number = 0;
//
//        for (int i = 1; i <= row; i++) {
//            for (int j = 1; j <= column; j++) {
//                number = i + (j * row) - row;
//                if (number >= 10) {
//
//                    System.out.print(number + "  ");
//
////                } else {
////                    System.out.print(number + "   ");
////                }
//            }}
//        }
//    }
//}



//    static void printPrincipalDiagonal(int mat[][], int n) {
//        System.out.print("Principal Diagonal: ");
//
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                // Condition for principal diagonal
//                if (i == j) {
//                    System.out.print(mat[i][j] + ", ");
//                }
//            }
//        }
//        System.out.println("");
//    }
//    // Function to print the Secondary Diagonal
//    static void printSecondaryDiagonal(int mat[][], int n) {
//        System.out.print("Secondary Diagonal: ");
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                // Condition for secondary diagonal
//                if ((i + j) == (n - 1)) {
//                    System.out.print(mat[i][j] + ", ");
//                }
//            }
//        }
//        System.out.println("");
//    }
