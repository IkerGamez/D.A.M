import java.util.Scanner;

public class E3 {
    public static void main(String[] args) throws Exception {
        // Creo scanner
        Scanner sc = new Scanner(System.in);
        // Pido cadena de texto y la guardo en texto
        System.out.println("Introduce una cadena de texto: ");
        String texto = sc.nextLine().toLowerCase();
        // contadorVocales -> contador del numero de vocales
        int contadorVocales = 0;

        // Sustituyo b por V y s,c por z
        texto = texto.replace("b", "V")
                     .replace("s", "z")
                     .replace("c", "z");

        // Recorro texto y compruebo si cada carácter es una vocal
        for (int i = 0; i < texto.length(); i++) {
            if (texto.charAt(i) == 'a' ||
                texto.charAt(i) == 'e' ||
                texto.charAt(i) == 'i' ||
                texto.charAt(i) == 'o' ||
                texto.charAt(i) == 'u') {
                contadorVocales++;
            }
        }

        // Muestro el número de vocales y la cadena modificada
        System.out.println("La cadena introducida tiene " + contadorVocales + " vocales");
        System.out.println("La cadena modificada es: \n" + texto);

        // Cierro el scanner
        sc.close();
    }
}
