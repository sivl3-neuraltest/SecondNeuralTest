/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package neuraltest2;

/**
 *
 * @author Marcin
 */
public class Matrix {

    public static void add() {
    }

    public static void subtract() {
    }

    public static void multiply(double[][] a, double[][] b, double[][] out, boolean checking) {
        int aw, ah, bw, bh, sum;
        boolean check = false;

        //Sprawdzanie czy można pomnożyć dwie macierze
        if (checking) {
            System.out.println("Sprawdzanie wielkości macierzy wejściowych włączone");
            check = true;
            //Sprawdzenie czy ilość kolumn macierzy a jest równa liczbie wierszy macierzy b
            if (a[0].length != b.length) {
                System.out.println("Macierz a ma inną liczbę kolumn niż macierz b wierszy");
                check = false;
            }

            //Sprawdzanie ilości wierszy macierzy wynikowej z ilością wierszy macierzy a
            if (out.length != a.length) {
                System.out.println("Macierz wynikowa ma inną liczbę wierszy niż macierz a");
                check = false;
            }

            //Sprawdzenie czy wszystkie wiersze macierzy a mają taką samą długość
            for (ah = 1; ah < a.length && check == true; ah++) {
                if (a[ah].length != a[ah - 1].length) {
                    System.out.println("Macierz a ma niedobór kolumn");
                    check = false;
                }
            }

            //Sprawdzenie czy wszystkie kolumny macierzy b mają taką samą długość
            for (ah = 1; ah < b.length && check == true; ah++) {
                if (b[ah].length != b[ah - 1].length) {
                    System.out.println("Macierz b ma niedobór kolumn");
                    check = false;
                }
            }

            //Sprawdzenie czy wszystkie wiersze macierzy out mają taką samą długość
            for (ah = 1; ah < out.length && check == true; ah++) {
                if (out[ah].length != out[ah - 1].length) {
                    System.out.println("Macierz out ma niedobór kolumn");
                    check = false;
                }
            }

            //Sprawdzenie czy ilość kolumn macierzy out ma długość zgodną z ilością kolumn macierzy b
            if (out[0].length != b[0].length) {
                System.out.println("Macierz wynikowa ma inną liczbę kolumn niż macierz b kolumn");
                check = false;
            }

        }
        
        
        if (!checking || (checking && check)) {
            for (ah = 0; ah < a.length; ah++) {
                for (bw = 0; bw < b[0].length; bw++) {
                    sum = 0;
                    for (aw = 0; aw < b.length; aw++) {
                        sum += a[ah][aw] * b[aw][bw];
                    }
                    out[ah][bw] = sum;
                }
            }
        }
    }

    public static void divide() {
    }
}
