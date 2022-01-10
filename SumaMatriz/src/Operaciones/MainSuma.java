package Operaciones;

import java.util.Arrays;

import Operaciones.SumaMatriz;

public class MainSuma {
    public static void main(String[] args) {
        int [][] matrizA = {{1,2,3},{4,5,6}};

        int [][] matrizB = {{7,8,9},{10,11,12}};

        int [][] Resultado;

            Operaciones.SumaMatriz os = new Operaciones.SumaMatriz(matrizA, matrizB);

        try {
            Resultado = os.sumaMatrices();
            System.out.println("Suma de la matriz A + B");
            for(int[] v : Resultado){
                System.out.println(Arrays.toString(v));
            }
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }

        System.exit(0);
    }
}
