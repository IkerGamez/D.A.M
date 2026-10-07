import java.util.Scanner;

public class E3 {
    public static void main(String[] args) throws Exception {
        //Instancia del escaner para el input
        Scanner sc = new Scanner(System.in);
        //Pide nombre y apellido y guarda valor en nombre
        System.out.println("Introduce tu nombre y apellido:");
        String nombre = sc.nextLine();
        //Muestra primera letra de nombre y ultima del apellido
        System.out.println("La primera letra de tu nombre y última de tu apellido son: " + 
                            nombre.charAt(0) + nombre.charAt(nombre.length()-1));   
        //Cierra el escaner                                                                                                                                                                                                                       
        sc.close();                                                                                                                                                                                                             
    }    
}

















































