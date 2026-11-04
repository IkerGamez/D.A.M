import java.util.Scanner;

public class E4 {
    public void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[] temperaturas = new double[solicitarCantidadDias(sc)];
        rellenarTemperaturas(temperaturas, sc);
        mostrarEstadisticas(temperaturas);
        sc.close();
    }

    public int solicitarCantidadDias(Scanner sc) {
        System.out.println("Introduce la cantidad de días a analizar (5 - 30): ");
        int numDias = sc.nextInt();
        while (numDias < 5 || numDias > 30) {
            System.out.println("La cantidad de días debe estar entre 5 y 30, vuleve a introducirlo: ");
            numDias = sc.nextInt();
        }
        return numDias;
    }

    public void rellenarTemperaturas(double[] temperaturas, Scanner sc) {
        System.out.println("Introduce la temperatura de " + temperaturas.length + " días: ");
        for (int i = 0; i < temperaturas.length; i++) {
            temperaturas[i] = sc.nextDouble();
        }
    }

    public double calcularMedia(double[] temperaturas) {
        double temperaturaTotal = 0.0;
        for (int i = 0; i < temperaturas.length; i++) {
            temperaturaTotal += temperaturas[i];
        }
        return temperaturaTotal / temperaturas.length;
    }

    public int contarSuperiores(double[] temperaturas, double referencia) {
        int numTempSuperior = 0;
        for (int i = 0; i < temperaturas.length; i++) {
            if (temperaturas[i] > referencia) {
                numTempSuperior++;
            }
        }
        return numTempSuperior;
    }

    public void mostrarEstadisticas(double[] temperaturas) {
        System.out.println("Temperatura media: " + calcularMedia(temperaturas));
        System.out.println("Días con temperatura superior a la media: "
                + contarSuperiores(temperaturas, calcularMedia(temperaturas)));
        System.out.println("Días con temperaturas inferiores a 15º C: "
                + (temperaturas.length - contarSuperiores(temperaturas, 14.99999)));
    }
}
