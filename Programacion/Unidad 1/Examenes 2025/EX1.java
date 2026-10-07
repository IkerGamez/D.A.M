import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int option;
        do {
            System.out.println("Elige una opción: ");
            System.out.println("1 --------> Arbol");
            System.out.println("2 --------> Palindromo");
            System.out.println("0 --------> Salir");
            option = sc.nextInt();
            switch (option) {
                case 1:
                    System.out.println("Introduce la altura del árbol:");
                    int altura = sc.nextInt();
                    // Compruebo que altura sea positivo
                    while (altura < 0) {
                        System.out.println("La altura tiene que ser positiva:");
                        altura = sc.nextInt();
                    }
                    String arbol = "*";
                    for (int i = 0; i < altura; i++) {
                        System.out.println(arbol);
                        arbol += "*";
                    }
                    System.out.println("1");
                    break;
                case 2:
                    boolean palindromo = true;
                    sc.nextLine();
                    System.out.println("Introduce una palabra");
                    String word = sc.nextLine().toLowerCase();
                    for (int i = 0; i < (word.length() / 2); i++) {
                        if (word.charAt(i) != word.charAt(word.length() - 1 - i)) {
                            palindromo = false;
                            break;
                        }
                    }
                    if (palindromo) {
                        System.out.println("Tu palabra es palindroma");
                    } else {
                        System.out.println("Tu palabra no es palindroma");
                    }
                    break;
                case 0:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción invalida");
            }
        } while (option != 0);
        sc.close();
    }
}
