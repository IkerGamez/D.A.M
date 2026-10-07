import java.util.Scanner;

public class E5 {
    public static void main(String[] args) throws Exception {
        //Instancia del escaner para input
        Scanner sc = new Scanner(System.in);
        //Pide numero y guarda en num
        System.out.println("Introduce un número entero positivo:");
        int num = sc.nextInt();
        //Muestra la tabla de multiplicar de num
        System.out.println("Tabla de multiplicar de " + num + ":");
        System.out.println(num + " x 1 = " + num);
        System.out.println(num + " x 2 = " + num * 2);
        System.out.println(num + " x 3 = " + num * 3);
        System.out.println(num + " x 4 = " + num * 4);
        System.out.println(num + " x 5 = " + num * 5);
        System.out.println(num + " x 6 = " + num * 6);
        System.out.println(num + " x 7 = " + num * 7);
        System.out.println(num + " x 8 = " + num * 8);
        System.out.println(num + " x 9 = " + num * 9);
        System.out.println(num + " x 10 = " + num * 10);
        //Cierra escaner
        sc.close();
    }
}