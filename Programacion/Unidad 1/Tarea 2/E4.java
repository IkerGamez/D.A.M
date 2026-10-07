import java.util.Scanner;

public class E4 {
    public static void main(String[] args) throws Exception {
        // Creo scanner
        Scanner sc = new Scanner(System.in);
        do {
            // Pido entero positivo y lo guardo en num
            System.out.println("Introduce un número entero positivo (0 para salir): ");
            int num = sc.nextInt();
            // Salgo del bucle si num == 0
            if (num == 0) {
                break;
            }
            // Compruebo que num sea positivo
            while (num < 0) {
                System.out.println("No es un número positivo, introduce otro (0 para salir):");
                num = sc.nextInt();
            }
            // Declaro sumaCuadrados a 0 para la primera iteración
            int sumaDivisores = 0;
            for (int i = num - 1; i > 0; i--) {
                if (num % i == 0) {
                    sumaDivisores += i;
                }
            }
            //Compruebo si es perfecto y muestro mensaje
            if (sumaDivisores == num) {
                System.out.println(num + " Es un número perfecto");
            } else {
                System.out.println(num + " No es un número perfecto");
            }
        } while (true);
        // Cierro el scanner
        sc.close();
    }
}