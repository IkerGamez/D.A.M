import java.util.Scanner;

public class E9 {
    public static void main(String[] args) throws Exception {
        // Creo scanner
        Scanner sc = new Scanner(System.in);

        int opcion = 0;
        do {
        // Pido entero positivo y lo guardo en num
        System.out.println("Introduce dos números:");
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        System.out.println("1 --> + 2 --> -");
        System.out.println("3 --> x 4 --> /");
        System.out.println("5 -->   SALIR");
        opcion = sc.nextInt();

        switch (opcion) {
            case 1:
                System.out.println(num1 + " + " + num2 + " = " + (num1 + num2));
                break;
            case 2:
                System.out.println(num1 + " - " + num2 + " = " + (num1 - num2));
                break;
            case 3:
                System.out.println(num1 + " x " + num2 + " = " + (num1 * num2));
                break;
            case 4:
                System.out.println(num1 + " / " + num2 + " = " + (num1 / num2));
                break;
            case 5:
                System.out.println("Saliendo del programa...");;
            default:
                break;
        } 
        } while (opcion != 5);
        sc.close();
    }
}
