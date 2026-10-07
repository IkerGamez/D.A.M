import java.util.Scanner;

public class E1 {
    public static void main(String[] args) throws Exception {
        //Instancia del escaner para el input
        Scanner sc = new Scanner(System.in);
        //Muestra mensaje
        System.out.println("Introduce dos números:");
        //Declarción de los numeros a operar
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        //Calculo de las operaciones
        int suma = num1 + num2;
        int resta = num1 - num2;
        int producto = num1 * num2;
        //Muestra los resultados de las operaciones
        System.out.println("La suma de " + num1 + " y " + num2 + " es: " + suma);
        System.out.println("La resta de " + num1 + " y " + num2 + " es: " + resta);
        System.out.println("El producto de " + num1 + " y " + num2 + " es: " + producto);
        //Cierra el escaner
        sc.close();
    }
}