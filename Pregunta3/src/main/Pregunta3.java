package main;

import java.util.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Pregunta3 {
	
	public static List<Integer> Datos = new ArrayList<Integer>();
	
	public static void main(String[] args) throws IOException {

		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
	    
	    System.out.println("Digite los valores: ");
	   
	    String[] datos = entrada.readLine().split(",");
	    
	
		 for (int i = 0; i < datos.length; i++) {
			 	Datos.add(Integer.parseInt(datos[i]));
			 }
	    
	    System.out.println("Los datos son: " + Datos.toString());
	    
	    //Calcular el rango
	    Integer rango = Collections.max(Datos) - Collections.min(Datos);
	    System.out.println("Rango: " + rango);
	    
	    System.out.println("--------------------------");
	    
	    //Calcular numero de intervalos
	    Integer numerodatos = Datos.size();
	    Integer intervalos = (int) (Math.round((1+3.32)*Math.log10(numerodatos)-0.5));
	    System.out.println("Numero de Intervalos: " + intervalos);
	    
	    System.out.println("--------------------------");
	    
	    //Calcular Amplitud de la clase
	    Integer amplitud = (int) (Math.round((double)rango/(double)intervalos));
	    System.out.println("Amplitud: " + amplitud);
	    
	    System.out.println("--------------------------");
	    //Nuevo rango 
	    rango = intervalos*amplitud;
	    System.out.println("Nuevo rango: " + rango);
	    
	    
	    
	    System.out.println("\n-----TABLA DE FRECUENCIAS-----");
	    
	    System.out.format("| Clases | f  | Ci | fi | Fi | ni | Fa |%n");
	    System.out.format("----------------------------------------%n");

	    Integer clase_anterior = 0;
	    Integer frAbs = 0;
	    Integer frAcm = 0;
	    Double  frRel = 0.0;
	    Double frRelAc = 0.0;
	    
	    for (int i=0; clase_anterior < Collections.max(Datos); i++) {
	    	Integer nueva_clase = clase_anterior + (intervalos-1);
	    	
	    	Double Ci = ((double)(nueva_clase+clase_anterior)/2);
	    	
	    	frAbs = frecuenciaAbsoluta(clase_anterior, nueva_clase);
	    	
	    	frAcm += frAbs;
	    	
	    	frRel = (double)frAbs/Datos.size();
	    	
	    	frRelAc = (double) frAcm/Datos.size(); 
	    	
	    	System.out.println("| " + clase_anterior + "," + nueva_clase + " | " + Ci + " | " + frAbs + 			" | " + frAcm + " | " + frRel+ " | " + frRelAc);
	    	
	    	clase_anterior = nueva_clase;
		}

	    System.out.format("-----------------------------------------%n");
	    
	}
	
    /**
     * @param limInf
     * @param limSup
     * @return
     */
        private static int frecuenciaAbsoluta(Integer limInf, Integer limSup) {
	        int count = 0;
	        for (int i = 0; i < Datos.size(); i++) {
	            if (Datos.get(i) >= limInf && Datos.get(i) < limSup) {
	                count++;
	            }
	        }
	        return count;
	    }
}