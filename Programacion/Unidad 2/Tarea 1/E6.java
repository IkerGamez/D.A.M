
import java.util.Scanner;

public class E6 {
    public void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int cantidad = solicitarCantidad(sc);
        int[] numeros = new int[cantidad];

        solicitarNumeros(numeros, sc);

        int[] pares = extraerPares(numeros);
        int[] impares = extraerImpares(numeros);

        System.out.println("Numeros pares:");
        mostrarArray(pares);
        System.out.println("Suma de los pares: " + sumarArray(pares));

        System.out.println("Numeros impares:");
        mostrarArray(impares);
        System.out.println("Suma de los impares: " + sumarArray(impares));

        sc.close();
    }

    public int solicitarCantidad(Scanner sc) {
        int cantidad = 0;
        do {
            System.out.println("Introduce cuantos numeros quieres (entre 5 y 20):");
            cantidad = sc.nextInt();

            if (cantidad < 5 || cantidad > 20) {
                System.out.println("Cantidad invalida");
            }
        } while (cantidad < 5 || cantidad > 20);

        return cantidad;
    }

    public void solicitarNumeros(int[] numeros, Scanner sc) {
        for (int i = 0; i < numeros.length; i++) {
            System.out.println("Introduce el numero nº " + (i + 1));
            numeros[i] = sc.nextInt();
        }
    }

    public boolean esPar(int numero) {
        if (numero % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }

    public int contarPares(int[] numeros) {
        int cantidadPares = 0;

        for (int i = 0; i < numeros.length; i++) {
            if (esPar(numeros[i])) {
                cantidadPares++;
            }
        }

        return cantidadPares;
    }

    public int[] extraerPares(int[] numeros) {
        int[] pares = new int[contarPares(numeros)];
        int indice = 0;

        for (int i = 0; i < numeros.length; i++) {
            if (esPar(numeros[i])) {
                pares[indice] = numeros[i];
                indice++;
            }
        }

        return pares;
    }

    public int[] extraerImpares(int[] numeros) {
        int cantidadImpares = numeros.length - contarPares(numeros);
        int[] impares = new int[cantidadImpares];
        int indice = 0;

        for (int i = 0; i < numeros.length; i++) {
            if (!esPar(numeros[i])) {
                impares[indice] = numeros[i];
                indice++;
            }
        }

        return impares;
    }

    public int sumarArray(int[] numeros) {
        int suma = 0;

        for (int i = 0; i < numeros.length; i++) {
            suma += numeros[i];
        }

        return suma;
    }

    public void mostrarArray(int[] numeros) {
        for (int i = 0; i < numeros.length; i++) {
            System.out.println(numeros[i]);
        }
    }
}
