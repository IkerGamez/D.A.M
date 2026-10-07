import java.util.Scanner;

public class E2 {
    public static void main(String[] args) throws Exception {
        // Creo scanner
        Scanner sc = new Scanner(System.in);
        // Pido entero positivo y lo guardo en num
        System.out.println("Introduce un número entero positivo:");
        int num = sc.nextInt();
       // Compruebo que num sea positivo
        while (num <= 0) {
            System.out.println("No es un número positivo, introduce otro:");
            num = sc.nextInt();
        }
        // Declaro sumaCuadrados a 0 para la primera iteración 
        int sumaCuadrados = 0;
        int cuadrado = 0;
        for (int i = 1; i <= num ; i++) {
            cuadrado = i * i;
            System.out.println(i + "² = " + cuadrado );
            sumaCuadrados += cuadrado;
        }
        // Muestro el resultado guardado en sumaCuadrados
        System.out.println("La suma de los cuadrados es: " + sumaCuadrados);
        // Cierro el scanner
        sc.close();
    }
}