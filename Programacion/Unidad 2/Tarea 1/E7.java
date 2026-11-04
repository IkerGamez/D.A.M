import java.util.Scanner;

public class E7 {
    public void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] primero = new int[8];
        int[] segundo = new int[8];

        System.out.println("Introduce los numeros del primer array:");
        solicitarNumeros(primero, sc);

        System.out.println("Introduce los numeros del segundo array:");
        solicitarNumeros(segundo, sc);

        System.out.println("Primer array:");
        mostrarArray(primero);
        System.out.println("Segundo array:");
        mostrarArray(segundo);

        mostrarComparacion(primero, segundo);

        sc.close();
    }

    public void solicitarNumeros(int[] numeros, Scanner sc) {
        for (int i = 0; i < numeros.length; i++) {
            System.out.println("Introduce el numero nº " + (i + 1));
            numeros[i] = sc.nextInt();
        }
    }

    public void mostrarArray(int[] numeros) {
        for (int i = 0; i < numeros.length; i++) {
            System.out.print(numeros[i] + " ");
        }
        System.out.println();
    }

    public boolean existeEnArray(int[] numeros, int buscado) {
        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i] == buscado) {
                return true;
            }
        }
        return false;
    }

    public int contarCoincidencias(int[] primero, int[] segundo) {
        int coincidencias = 0;

        for (int i = 0; i < primero.length; i++) {
            if (existeEnArray(segundo, primero[i])) {
                coincidencias++;
            }
        }

        return coincidencias;
    }

    public int[] obtenerNoCoincidentes(int[] primero, int[] segundo) {
        int cantidad = primero.length - contarCoincidencias(primero, segundo);
        int[] noCoincidentes = new int[cantidad];
        int indice = 0;

        for (int i = 0; i < primero.length; i++) {
            if (!existeEnArray(segundo, primero[i])) {
                noCoincidentes[indice] = primero[i];
                indice++;
            }
        }

        return noCoincidentes;
    }

    public void mostrarComparacion(int[] primero, int[] segundo) {
        int coincidencias = contarCoincidencias(primero, segundo);
        int[] noCoincidentes = obtenerNoCoincidentes(primero, segundo);

        System.out.println("Cantidad de coincidencias: " + coincidencias);
        System.out.println("Valores coincidentes:");
        for (int i = 0; i < primero.length; i++) {
            if (existeEnArray(segundo, primero[i])) {
                System.out.print(primero[i] + " ");
            }
        }
        System.out.println();

        System.out.println("Elementos no presentes en el segundo array:");
        mostrarArray(noCoincidentes);
    }
}
