import java.util.Scanner;

public class E2 {
    public void main(String[] args) {
        //Creo el array de 8 posiciones
        double notas[] = new double[8];
        solicitarNotas(notas);
        mostrarResultados(notas);
    }

    // Procedimiento que pide y rellena el array
    public void solicitarNotas(double[] notas) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce las notas de 8 alumnos: ");
        for (int i = 0; i < notas.length; i++) {
            notas[i] = sc.nextDouble();
            while (notas[i] < 0 || notas[i] > 10) {
                System.out.println("La calificacion tiene que estar entre 0 y 10");
                notas[i] = sc.nextDouble();
            }
        }
        sc.close();
    }

    // Función que devuelve la nota media de un array que recibe
    public double calcularMedia(double[] notas) {
        double notasTotales = 0.0;
        for (double nota : notas) {
            notasTotales += nota;
        }
        return notasTotales / notas.length;
    }

    // Función que retorna la mayor nota de un array
    public double obtenerMayor(double[] notas) {
        double notaMayor = 0.0;
        for (double nota : notas) {
            if (nota > notaMayor) {
                notaMayor = nota;
            }
        }
        return notaMayor;
    }
    
    // Función que retorna la mayor nota de un array
    public double obtenerMenor(double[] notas) {
        double notaMenor = 10.0;
        for (double nota : notas) {
            if (nota < notaMenor) {
                notaMenor = nota;
            }
        }
        return notaMenor;
    }

    // Profcedimiento que muestra los resultados de las demás funciones
    public void mostrarResultados(double[] notas) {
        System.out.println("Calificacion media: " + calcularMedia(notas));
        System.out.println("Calificacion más alta: " + obtenerMayor(notas));
        System.out.println("Calificacion más baja: " + obtenerMenor(notas));
    }
}