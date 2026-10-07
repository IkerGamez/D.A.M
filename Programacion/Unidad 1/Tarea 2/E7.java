import java.util.Scanner;

public class E7 {
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
        System.out.println(num);
        while (num != 1) {
            if (num % 2 == 0) {
                num /= 2;
            } else {
                num = num * 3 + 1;
            }
            System.out.println(num);
        }
        sc.close();
    }
}
