import java.util.Scanner;

public class E5 {
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

        // Inicializo los tres primeros valores de la sucesión
        int a = 1;
        int b = 1;
        int c = 2;

        // Calculo e imprimo los primeros n + 2 términos de la sucesión de Fibonacci
        for (int i = 1; i <= num + 2; i++) {
            System.out.println(a + " + " + b + " = " + c);
            a = b;
            b = c;
            c = a + b;
        }
        
        // Cierro el scanner
        sc.close();
    }
}
