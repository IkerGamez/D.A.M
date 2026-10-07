import java.util.Scanner;

public class E8 {
    public static void main(String[] args) throws Exception {
        // Creo scanner
        Scanner sc = new Scanner(System.in);
        // Pido cadena de texto y la guardo en texto
        System.out.println("Introduce una cadena de texto: ");
        String texto = sc.nextLine();    

        String minusculas = "abcdefghijklmnñopqrstuvwxyz";
        String mayusculas = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ";
        
        String resultado = "";

        for (int i = 0; i < texto.length(); i++) {
            if (texto.charAt(i) == ' ') {
                resultado += " ";
            }
            for (int j = 0; j < minusculas.length(); j++) {
                if (texto.charAt(i) == minusculas.charAt(j)) {
                    resultado += mayusculas.charAt(j);
                }
            }

            for (int k = 0; k < mayusculas.length(); k++) {
                if (texto.charAt(i) == mayusculas.charAt(k)) {
                    resultado += minusculas.charAt(k);
                }
            }
        }
        System.out.println(resultado);
        sc.close();
    }
}
