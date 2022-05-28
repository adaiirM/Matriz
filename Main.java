package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int[][] m = new int[4][4];

        Scanner s = new Scanner(System.in);
        int op = 0;
        System.out.println("""
                    - Menu -
                     -1. Llenar matriz
                     -2. Suma de una fila
                     -3. Suma de una columna
                     -4. Sumar de la diagonal principal
                     -5. Sumar la diagonal inversa
                     -6. Calcular la media de todos los valores de la matriz
                     -7. Mostar los elementos de la matriz
                     -8. Salir""");
        while (op != 8){
            System.out.print("\nIngresa la opcion que desees realizar: ");
            menu(op = s.nextInt(), m);
        }
    }

    //Metodo para verificar si la matriz está vacia
    public static boolean vacia(int[][] a){
        int b = 0;
        for(int i = 0; i < 4; i ++){
            for (int j = 0; j < 4; j ++){
                if(a[i][j] == 0){
                    b++;
                }
            }
        }
        boolean v = false;
        if(b == 16){ //Si todos los valores dentro de la matriz son 0
            v = true;
        }
        return v; //Retorna un verdadero si la matriz está vacia y un falso si no
    }
    //Metodo para verificar si se ingresaron los valores correctos para la suma de filas y columnas
    public static boolean valoresCorrectos(int n){
        return n > 0 && n <= 4; //Retorna un verdadero si lo valores son correctos(entreo 1 y 4)
    }
    //Metodo para llenar la matriz
    public static void llenarMatriz(int[][] m){
        Scanner s = new Scanner(System.in);
        for(int i = 0; i < 4; i ++){
            for (int j = 0; j < 4; j ++){
                System.out.print("["+i+"]"+"["+j+"]= ");
                m[i][j] = s.nextInt();
            }
        }
    }
    //Metodo para sumar los elemetos que se encuentran en una fila
    public static int sumarFila(int[][] m, int f){
        int s = 0;
        for(int i = 0; i < 4; i ++){
            s = s + m[f - 1][i];
        }
        return s;
    }
    //Metodo para sumar los elemetos que se encuentran en una columna
    public static int sumarColumna(int[][] m, int c){
        int s = 0;
        for(int i = 0; i < 4; i ++){
            s = s + m[i][c - 1];
        }
        return s;
    }
    //Metodo para sumar elementos de la diagonal principal
    public static int sumaDiagonalPrin(int[][] m){
        int s = 0;
        for(int i = 0; i < 4; i ++){
            for (int j = 0; j < 4; j ++){
                if(i == j){
                    s = s + m[i][j];
                }
            }
        }
        return s;
    }
    //Metodo para sumar elementos de la diagonal inversa
    public static int sumaDiagonalInv(int[][] m){
        int s = 0;
        for (int i = 0, j = 3; i < 4 && j >= 0; i++, j--){
            s = s + m[i][j];
        }
        return s;
    }
    //Metodo para calcular la media
    public static float media(int[][] m){
        int s = 0;
        for(int i = 0; i < 4; i ++){
            for (int j = 0; j < 4; j ++){
                s = s + m[i][j];
            }
        }
        float f = (float) s; //La suma de todos los elementos se convierte a flotante para al momento de dividir obtengamos un resutlado
        //apropiado
        return f / 16;
    }
    //Metodo para mostrar los elementos de la matriz
    public static void mostrar(int[][] m){
        for(int i = 0; i < 4; i ++){
            System.out.print("[");
            for (int j = 0; j < 4; j ++){
                System.out.print(m[i][j]+" ");
            }
            System.out.print("]\n");
        }
    }
    //Metodo para toda las opciones
    public static void menu(int op, int[][] m){
        Scanner s = new Scanner(System.in);
        switch (op){
            case 1:
                System.out.println("Llenar matriz");
                if(vacia(m)){
                    llenarMatriz(m);
                }else
                    System.out.println("La matriz ya contiene elementos");
                break;
            case 2:
                System.out.println("- Suma de una fila -");
                if(!vacia(m)){
                    System.out.println("Ingresa la fila que desees sumar: ");
                    int fila = s.nextInt();
                    if(valoresCorrectos(fila)){
                        System.out.println("La suma de la fila "+fila+" es igual a "+sumarFila(m, fila));
                    }else
                        System.out.println("ERROR - Ingresa un valor entre 1 y 4");
                }else
                    System.out.println("La matriz esta vacia.");
                break;
            case 3:
                System.out.println(" -Suma de una columna -");
                if(!vacia(m)){
                    System.out.println("Ingresa la columna que desees sumar: ");
                    int c = s.nextInt();
                    if(valoresCorrectos(c)){
                        System.out.println("La suma de la columna "+c+" es igual a "+sumarColumna(m, c));
                    }else
                        System.out.println("ERROR - Ingresa un valor entre 1 y 4");
                }else
                    System.out.println("La matriz esta vacia.");
                break;
            case 4:
                System.out.println("Suma diagonal principal");
                if(!vacia(m)){
                    System.out.println("La suma de la diagonal principal es igual a "+sumaDiagonalPrin(m));
                }else
                    System.out.println("La matriz esta vacia.");
                break;
            case 5:
                System.out.println("Suma diagonal inversa");
                if(!vacia(m)){
                    System.out.println("La suma de la diagonal inversa es igual a "+sumaDiagonalInv(m));
                }else
                    System.out.println("La matriz esta vacia.");
                break;
            case 6:
                System.out.println("- Media de la suma de todos los elementos de la matriz");
                if(!vacia(m)){
                    System.out.println("La media es igual a: "+media(m));
                }else
                    System.out.println("La matriz esta vacia.");
                break;
            case 7:
                System.out.println("- Mostar matriz -");
                mostrar(m);
                break;
            case 8:
                System.out.println("Ha salido del progama");
                break;
            default:
                System.out.println("ERROR - Ingresa una opcion correcta");
                break;
        }
    }
}
