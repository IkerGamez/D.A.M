import java.util.Scanner;

public class E9 {
    public void main(String[] args) {
        int[][] ventas = new int[4][7];

        rellenarVentas(ventas);
        mostrarMatriz(ventas);
        mostrarInforme(ventas);
    }

    public void rellenarVentas(int[][] ventas) {
        Scanner sc = new Scanner(System.in);
        int cantidad = 0;

        for (int i = 0; i < ventas.length; i++) {
            for (int j = 0; j < ventas[i].length; j++) {
                do {
                    System.out.println("Introduce las ventas de la tienda nº " + (i + 1) + " en el dia " + (j + 1));
                    cantidad = sc.nextInt();

                    if (cantidad < 0) {
                        System.out.println("La cantidad no puede ser negativa");
                    }
                } while (cantidad < 0);

                ventas[i][j] = cantidad;
            }
        }
        sc.close();
    }

    public void mostrarMatriz(int[][] ventas) {
        System.out.print("Tienda\t");
        for (int j = 0; j < ventas[0].length; j++) {
            System.out.print("Dia " + (j + 1) + "\t");
        }
        System.out.println();

        for (int i = 0; i < ventas.length; i++) {
            System.out.print((i + 1) + "\t");
            for (int j = 0; j < ventas[i].length; j++) {
                System.out.print(ventas[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public int totalTienda(int[][] ventas, int tienda) {
        int total = 0;

        for (int j = 0; j < ventas[tienda].length; j++) {
            total += ventas[tienda][j];
        }

        return total;
    }

    public int totalDia(int[][] ventas, int dia) {
        int total = 0;

        for (int i = 0; i < ventas.length; i++) {
            total += ventas[i][dia];
        }

        return total;
    }

    public int mejorTienda(int[][] ventas) {
        int indiceTienda = 0;

        for (int i = 1; i < ventas.length; i++) {
            if (totalTienda(ventas, i) > totalTienda(ventas, indiceTienda)) {
                indiceTienda = i;
            }
        }

        return indiceTienda;
    }

    public int mejorDia(int[][] ventas) {
        int indiceDia = 0;

        for (int j = 1; j < ventas[0].length; j++) {
            if (totalDia(ventas, j) > totalDia(ventas, indiceDia)) {
                indiceDia = j;
            }
        }

        return indiceDia;
    }

    public void mostrarInforme(int[][] ventas) {
        System.out.println("Ventas totales por tienda:");
        for (int i = 0; i < ventas.length; i++) {
            System.out.println("Tienda nº " + (i + 1) + ": " + totalTienda(ventas, i) + " unidades");
        }

        System.out.println("Ventas totales por dia:");
        for (int j = 0; j < ventas[0].length; j++) {
            System.out.println("Dia " + (j + 1) + ": " + totalDia(ventas, j) + " unidades");
        }

        System.out.println("Tienda con mas ventas: " + (mejorTienda(ventas) + 1));
        System.out.println("Dia con mas ventas: " + (mejorDia(ventas) + 1));
    }
}
