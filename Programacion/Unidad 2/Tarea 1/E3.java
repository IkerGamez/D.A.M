import java.util.Scanner;

public class E3 {
    public void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce 10 números enteros: ");
        int[] numeros = new int[10];
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = sc.nextInt();
        }
        System.out.println("Introduce un número para realizar la busqueda: ");
        int numeroBusqueda = sc.nextInt();
        mostrarResultado(numeros, numeroBusqueda);
        sc.close();
    }

    public boolean buscarNumero(int[] numeros, int buscado) {
        boolean encontrado = false;
        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i] == buscado) {
                encontrado = true;
            }
        }
        return encontrado;
    }

    public int contarApariciones(int[] numeros, int buscado) {
        int numApariciones = 0;
        for (int numero : numeros) {
            if (numero == buscado) {
                numApariciones++;
            }
        }
        return numApariciones;
    }

    public int primeraPosicion(int[] numeros, int buscado) {
        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i] == buscado) {
                return i;
            }
        }
        return -1;
    }

    public void mostrarResultado(int[] numeros, int buscado) {
        if (buscarNumero(numeros, buscado) == true) {
            System.out.println("El número está en el array");
            System.out.println("Número de apariciones: " + contarApariciones(numeros, buscado));
            System.out.println("Primera posición: " + primeraPosicion(numeros, buscado));
        } else {
            System.out.println("El número no está en el array");
        }

    }
}
