package GaussJordan;

import java.util.Scanner;

public class InversaMatriz

{
	public static void main(String argv[])
	{
		Scanner input = new Scanner(System.in);
		System.out.println("Ingrese la dimensión de la matriz cuadrada: ");
		int n = input.nextInt();
		double a[][]= new double[n][n];
		System.out.println("Introduzca los elementos de la matriz: ");
		for(int i=0; i<n; i++)
			for(int j=0; j<n; j++)
				a[i][j] = input.nextDouble();
		double d[][] = invert(a);

		System.out.println("La inversa de la matriz es: ");

		for (int i=0; i<n; ++i) {
			for (int j=0; j<n; ++j)

			{System.out.print(d[i][j]+"  ");}

			System.out.println();
		}
		input.close();
	}	


	public static double[][] invert(double a[][])         {

		int n = a.length;
		double x[][] = new double[n][n];
		double b[][] = new double[n][n];
		int index[] = new int[n];
		for (int i=0; i<n; ++i)
			b[i][i] = 1;

 // Se transforma la matriz en un triángulo superior.

		gaussian(a, index);

 // Se actualiza la matriz b[i][j] con los ratios almacenados.
		for (int i=0; i<n-1; ++i)
			for (int j=i+1; j<n; ++j)
				for (int k=0; k<n; ++k)
					b[index[j]][k]
							-= a[index[j]][i]*b[index[i]][k];

 
 // Se realiza sustituciones hacia atrás.
		for (int i=0; i<n; ++i)             {
			x[n-1][i] = b[index[n-1]][i]/a[index[n-1]][n-1];
			for (int j=n-2; j>=0; --j)                 {
				x[j][i] = b[index[j]][i];
				for (int k=j+1; k<n; ++k)
				{
					x[j][i] -= a[index[j]][k]*x[k][i];
				}

				x[j][i] /= a[index[j]][j];
			}
		}
		return x;
	}

// Se ejecuta el método para realizar la Gaussiana de pivote parcial.

	public static void gaussian(double a[][], int index[])  {

		int n = index.length;
		double c[] = new double[n];

 // Inicializamos el índice.
		for (int i=0; i<n; ++i)
			index[i] = i;

 // Encuentramos los factores de cambio de escala, uno de cada fila.
		for (int i=0; i<n; ++i) {
			double c1 = 0;
			for (int j=0; j<n; ++j) {
				double c0 = Math.abs(a[i][j]);
				if (c0 > c1) c1 = c0;
			}
			c[i] = c1;
		}

 // Buscamos el elemento pivotante de cada columna.
		int k = 0;
		for (int j=0; j<n-1; ++j) {
			double pi1 = 0;
			for (int i=j; i<n; ++i)  {

				double pi0 = Math.abs(a[index[i]][j]);
				pi0 /= c[index[i]];
				if (pi0 > pi1) {
					pi1 = pi0;
					k = i;
				}
			}

 
   // Intercambiamos filas según el orden de rotación
			int itmp = index[j];
			index[j] = index[k];
			index[k] = itmp;
			for (int i=j+1; i<n; ++i) {
				double pj = a[index[i]][j]/a[index[j]][j];

 // Se registra las relaciones de pivote por debajo de la diagonal
				a[index[i]][j] = pj;

 // Se modifica otros elementos en consecuencia
				for (int l=j+1; l<n; ++l)
					a[index[i]][l] -= pj*a[index[j]][l];
			}
		}
	}
}