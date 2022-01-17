import java.util.Scanner;

public class DFrecuencias
{
   public static void main(String args[])
   {
        int rangos[][] = new int[10][3];
        int i, c, r, numero;

    try (Scanner entrada = new Scanner(System.in)) {
        System.out.println("\nDISTRIBUCION DE FRECUENCIAS");

           for (r = 0; r <= 10; r++)
           {
               System.out.print("Ingrese rangos[" + r + ",1]: ");
               rangos[r][0] = entrada.nextInt();

               System.out.print("Ingrese rangos[" + r + ",2]: ");
               rangos[r][1] = entrada.nextInt();
               rangos[r][2] = 0;
           }

           for (i = 1; i <= 45; i++)
           {
               System.out.print("Ingresar numero: ");
               numero = entrada.nextInt();

               r = -1;
               do
               {
                   r = r + 1;
                   if (numero >= rangos[r][0] && numero <= rangos[r][1])
                   {
                      rangos[r][2] = rangos[r][2] + 1;
                   }
               } while (!(numero >= rangos[r][0] && numero <= rangos[r][1]));
           }
    }

       System.out.println("\nDISTRIBUCION DE FRECUANCIAS");
       System.out.println("RANGO  LIM.INFERIOR  LIM.SUPERIOR No.OCURRENCIAS");
       for (r = 0; r <= 14; r++)
       {
           System.out.print("  " + r + "          ");
           for (c = 0; c <= 2; c++)
           {
               System.out.print(rangos[r][c] + "            ");
           }
           System.out.println();
       }
   }
}
