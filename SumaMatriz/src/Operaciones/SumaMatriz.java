package Operaciones;

public class SumaMatriz {
    
    private int[][] matrizA;
    private int[][] matrizB;

    public void Operaciones(){

    }

    public void Operaciones(int[][] matrizA, int[][] matrizB){
        this.matrizA = matrizA;
        this.matrizB = matrizB;
    }

    public void setmatrizA(int[][] matrizA){
        this.matrizA = matrizA;
    }

    public void setmatrizB(int[][] matrizB){
        this.matrizB = matrizB;
    }

    public int[][] getMatrizA() {
        return matrizA;
    }

    public int[][] getMatrizB() {
        return matrizB;
    }

    public int[][] sumaMatrices() throws Exception{

        int [][] mResultado = new int[matrizA.length][matrizA[0].length];
        if(matrizA.length == matrizB.length && matrizA[0].length == matrizB[0].length){
        
        for(int row=0; row<matrizA.length; row++){
            for(int col=0; col<matrizA[row].length; col++){
                mResultado[row][col] = matrizA[row][col] + matrizB[row][col];
            }
        }
    }   else {
            throw new Exception("La matriz no es cuadrada");
    }
        return mResultado;
    }

}
