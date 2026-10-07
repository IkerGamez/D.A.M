import java.util.Scanner;

public class E4 {
    public static void main(String[] args) throws Exception {
        //Instancia del escaner
        Scanner sc = new Scanner(System.in);
        //Pide precio y lo guarda en precioProducto
        System.out.println("Introduce el precio de un producto:");
        float precioProducto = sc.nextFloat();
        //Muestra el precio aplicando el IGIC
        System.out.println("El precio aplicando el IGIC es de: " + precioProducto * 1.07f + " EUR");
        sc.close();
    }
}