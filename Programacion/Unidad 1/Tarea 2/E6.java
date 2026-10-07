import java.util.Scanner;

public class E6 {
    public static void main(String[] args) throws Exception {
        // Creo scanner
        Scanner sc = new Scanner(System.in);
        // Pido la altura del árbol y la guardo en altura
        System.out.println("Introduce la altura del árbol:");
        int altura = sc.nextInt();
        // Compruebo que altura sea positivo
        while (altura < 0) {
            System.out.println("La altura tiene que ser positiva:");
            altura = sc.nextInt();
        }
        String hoja = "*";
        String arbol = "";
        for (int i = 0; i <= altura; i++) {
            System.out.println(arbol);
            arbol += hoja;
        }
        System.out.println("1");
        // Cierro el scanner
        sc.close();
    }
}
