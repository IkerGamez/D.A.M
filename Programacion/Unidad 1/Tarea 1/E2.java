import java.util.Scanner;

public class E2 {
    public static void main(String[] args) throws Exception {
        //Instancia del escaner para el input
        Scanner sc = new Scanner(System.in);
        //Pide numeros decimales, y guarda valor
        System.out.println("Introduce un número decimal:");
        float num1 = sc.nextFloat();
        System.out.println("Introduce otro número decimal:");
        float num2 = sc.nextFloat();
        // Calculo de las operaciones
        float producto = num1 * num2;
        float cociente = num1 / num2;
        //Muestra los resultados de las operaciones
        System.out.println("El producto de " + num1 + " y " + num2 + " es: " + producto);
        System.out.println("El cociente de " + num1 + " entre " + num2 + " es: " + cociente);
        //Cierra el escaner
        sc.close();
    }
}