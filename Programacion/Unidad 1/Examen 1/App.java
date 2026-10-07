import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        // Creo escaner
        Scanner sc = new Scanner(System.in);
        // Variabe para opcion del menu
        int option;
        do {
            // Pido opcion e imprimo el menu
            System.out.println("Elige una opción: ");
            System.out.println("1 --------> Edades");
            System.out.println("2 --------> Numero vocales/consonantes");
            System.out.println("0 --------> Salir");
            // Guardo la opcion
            option = sc.nextInt();
            switch (option) {
                case 1:
                    System.out.println("Cuántas personas entran al evento?");
                    int numPersonas = sc.nextInt();
                    int numMenoresEdad = 0;
                    int numMayoresEdad = 0;
                    int edadTotal = 0;
                    int edadMayor = 0;
                    for (int i = 0; i < numPersonas; i++) {
                        System.out.println("Introduce la edad de la persona número " + (i + 1));
                        int edadPersona = sc.nextInt();
                        if (edadPersona > edadMayor) {
                            edadMayor = edadPersona;
                        }
                        if (edadPersona < 18) {
                            numMenoresEdad++;
                        } else {
                            numMayoresEdad++;
                        }
                        edadTotal += edadPersona;
                    }
                    // Muestro los datos que pide
                    System.out.println("El número de menores de edad es: " + numMenoresEdad);
                    System.out.println("El número de mayores de edad es: " + numMayoresEdad);
                    System.out.println("La edad media es: " + (edadTotal / numPersonas));
                    System.out.println("La edad de la persona mayor es: " + edadMayor);
                    break;
                case 2:
                    sc.nextLine();
                    System.out.println("Introduce una palabra: ");
                    String palabra = sc.nextLine().toLowerCase();
                    int numVocales = 0;
                    int numConsonantes = 0;
                    for (int i = 0; i < palabra.length(); i++) {
                        if (palabra.charAt(i) == 'a' ||
                                palabra.charAt(i) == 'e' ||
                                palabra.charAt(i) == 'i' ||
                                palabra.charAt(i) == 'o' ||
                                palabra.charAt(i) == 'u') {
                            numVocales++;
                        } else {
                            numConsonantes++;
                        }
                    }
                    System.out.println("Número vocales: " + numVocales);
                    System.out.println("Número vocales: " + numConsonantes);
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