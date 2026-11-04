import java.util.Scanner;

public class E1 {
    public void main(String[] args) {
        int numeros[] = new int[5];
        cargarNumeros(numeros);
        mostrarNumeros(numeros);
        System.out.println("El numero de positivos del array es: " + contarPositivos(numeros));
        System.out.println("El numero de negativos del array es: " + contarNegativos(numeros));
        System.out.println("El numero de ceros del array es: "
                + (numeros.length - contarNegativos(numeros) - contarPositivos(numeros)));
    }

    // Procedimiento que guarda los numeros en el array
    public void cargarNumeros(int[] numeros) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce 5 numeros enteros: ");
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = sc.nextInt();
        }
        sc.close();
    }

    // Procedimiento que muestra el array1
    public void mostrarNumeros(int[] numeros) {
        System.out.print("Array: [");
        for (int i = 0; i < numeros.length; i++) {
            System.out.print(numeros[i]);
            if (i < numeros.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    // Función que retorna el número de positivos de un array
    public int contarPositivos(int[] numeros) {
        int contador = 0;
        for (int numero : numeros) {
            if (numero > 0) {
                contador++;
            }
        }
        return contador;
    }

    // Función que retorna el número de negativos de un array
    public int contarNegativos(int[] numeros) {
        int contador = 0;
        for (int numero : numeros) {
            if (numero < 0) {
                contador++;
            }
        }
        return contador;
    }
}
