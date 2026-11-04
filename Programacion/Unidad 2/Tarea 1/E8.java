import java.util.Scanner;

public class E8 {
    public void main(String[] args) {
        int[] puntuaciones = new int[6];

        registrarRondas(puntuaciones);
        mostrarClasificacion(puntuaciones);
    }

    public void registrarRondas(int[] puntuaciones) {
        Scanner sc = new Scanner(System.in);
        int puntos = 0;

        for (int i = 0; i < puntuaciones.length; i++) {
            for (int j = 0; j < 4; j++) {
                do {
                    System.out.println("Introduce los puntos del jugador nº " + (i + 1) + " en la ronda " + (j + 1));
                    puntos = sc.nextInt();

                    if (puntos < 0 || puntos > 100) {
                        System.out.println("Puntuacion invalida");
                    }
                } while (puntos < 0 || puntos > 100);

                puntuaciones[i] += puntos;
            }
        }
        sc.close();
    }

    public int obtenerGanador(int[] puntuaciones) {
        int indiceGanador = 0;

        for (int i = 1; i < puntuaciones.length; i++) {
            if (puntuaciones[i] > puntuaciones[indiceGanador]) {
                indiceGanador = i;
            }
        }

        return indiceGanador;
    }

    public int contarClasificados(int[] puntuaciones, int minimo) {
        int clasificados = 0;

        for (int i = 0; i < puntuaciones.length; i++) {
            if (puntuaciones[i] > minimo) {
                clasificados++;
            }
        }

        return clasificados;
    }

    public void mostrarClasificacion(int[] puntuaciones) {
        System.out.println("Puntuaciones totales:");
        for (int i = 0; i < puntuaciones.length; i++) {
            System.out.println("Jugador nº " + (i + 1) + ": " + puntuaciones[i] + " puntos");
        }

        System.out.println("Ganador: jugador nº " + (obtenerGanador(puntuaciones) + 1));
        System.out.println("Jugadores que superan 250 puntos: " + contarClasificados(puntuaciones, 250));

        System.out.println("Clasificacion final:");
        int puesto = 1;
        for (int puntos = 400; puntos >= 0; puntos--) {
            for (int i = 0; i < puntuaciones.length; i++) {
                if (puntuaciones[i] == puntos) {
                    System.out.println(puesto + ". Jugador nº " + (i + 1) + ": " + puntuaciones[i] + " puntos");
                    puesto++;
                }
            }
        }
    }
}
