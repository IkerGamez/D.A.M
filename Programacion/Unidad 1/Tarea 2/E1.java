import java.util.Scanner;

public class E1 {
    public static void main(String[] args) throws Exception {
        // Creo scanner
        Scanner sc = new Scanner(System.in);
        // Pido entero positivo y lo guardo en num
        System.out.println("Introduce un número entero positivo:");
        int num = sc.nextInt();
       // Compruebo que num sea positivo
        while (num < 0) {
            System.out.println("El número es negativo, introduce uno positivo:");
            num = sc.nextInt();
        }
        // Declaro factorial a 1 para la primera iteración 
        int factorial = 1;
        System.out.print(num + "! = ");
        for (int i = num; i > 0; i--) {
            factorial *= i;
            if (i == 1) { System.out.print(i); }
            else { System.out.print(i + " x "); }
        }
        System.out.print( " = " + factorial);
        // Cierro el scanner
        sc.close();
    }
}