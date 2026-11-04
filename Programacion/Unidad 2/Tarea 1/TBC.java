import java.util.Scanner;

public class TBC {

    public void main(String[] args) {
        // Instanciamos el escaner
        Scanner sc = new Scanner(System.in);

        // Inicializamos la vida del jugador y el enemigo
        int vidaJugador = 100;
        int vidaEnemigo = 120;
        int contadorTurno = 1;
        int dañoEnemigo = 0;
        int ataquesRestantes = 3;
        int curacionesRestantes = 2;
        boolean defendiendo = false;

        do {
            mostrarEstado(vidaJugador, vidaEnemigo);
            mostrarMenu();

            // Manejo de opciones
            int opcion = sc.nextInt();

            // Repito petición si no quedan ataques especiales
            while (opcion == 2 && ataquesRestantes <= 0) {
                System.out.println("\u001B[31m[ERROR] No te quedan ataques especiales\u001B[0m");
                opcion = sc.nextInt();
            }

            // Repito petición si no quedan curaciones
            while (opcion == 3 && curacionesRestantes <= 0) {
                System.out.println("\u001B[31m[ERROR] No te quedan curaciones\u001B[0m");
                opcion = sc.nextInt();
            }

            switch (opcion) {
                case 1:
                    System.out.println(
                            "\u001B[33m[ATAQUE] Golpeas al enemigo con un ataque flojo, 15 puntos de daño\u001B[0m");
                    vidaEnemigo = realizarAtaque(vidaEnemigo, 15);
                    break;

                case 2:
                    System.out.println(
                            "\u001B[35m[ATAQUE ESPECIAL] Golpeas al enemigo con un ataque especial, 30 puntos de daño\u001B[0m");
                    System.out
                            .println("\u001B[35mAtaques especiales restantes: " + (ataquesRestantes - 1) + "\u001B[0m");
                    ataquesRestantes--;
                    vidaEnemigo = realizarAtaque(vidaEnemigo, 30);
                    break;

                case 3:
                    System.out.println("\u001B[32m[CURACIÓN] Te curas 20 puntos de vida\u001B[0m");
                    System.out.println("\u001B[32mCuraciones restantes: " + (curacionesRestantes - 1) + "\u001B[0m");
                    curacionesRestantes--;
                    vidaJugador = curarJugador(vidaJugador, 100);
                    break;

                case 4:
                    defendiendo = true;
                    break;

                default:
                    break;
            }
            if (combateTerminado(vidaJugador, vidaEnemigo)) {
                break;
            }
            // Gestiono golpes fuertes/flojo y si defiendo
            dañoEnemigo = 12;

            if (contadorTurno % 3 == 0) {
                System.out.println("\u001B[31m[¡ATAQUE FUERTE!] Recibes un ataque fuerte\u001B[0m");
                dañoEnemigo = 25;
            } else {
                System.out.println("\u001B[31m[ATAQUE ENEMIGO] Recibes un ataque flojo\u001B[0m");
            }

            if (defendiendo) {
                System.out.println(
                        "\u001B[36m[DEFENSA] Pero te defiendes con éxito reduciendo el daño a la mitad\u001B[0m");
            }

            vidaJugador = recibirDaño(vidaJugador, dañoEnemigo, defendiendo);

            // Aumento el contador de turno y vuelta a no defender
            contadorTurno++;
            defendiendo = false;

        } while (!combateTerminado(vidaJugador, vidaEnemigo));
        System.out.println("\u001B[1;32m[COMBATE FINALIZADO]\u001B[0m");
        sc.close();
    }

    // Procedimiento que muestra la vida restante del jugador y enemigo
    public void mostrarEstado(int vidaJugador, int vidaEnemigo) {
        System.out.println("\u001B[36m╔══════════════════════╗");
        System.out.println("║        ESTADO        ║");
        System.out.println("╠══════════════════════╣");
        System.out.println("    Jugador: " + vidaJugador + " HP");
        System.out.println("    Enemigo: " + vidaEnemigo + " HP");
        System.out.println("╠══════════════════════╣\u001B[0m");
    }

    // Procedimiento que muestra el menú de acciones
    public void mostrarMenu() {
        System.out.println("\u001B[1;36m║        COMBATE       ║");
        System.out.println("╠══════════════════════╣");
        System.out.println("║ - 1. Ataque normal   ║");
        System.out.println("║ - 2. Ataque especial ║");
        System.out.println("║ - 3. Curarse         ║");
        System.out.println("║ - 4. Defenderse      ║");
        System.out.println("╚══════════════════════╝\u001B[0m");
    }

    // Función que retorna true cuando la vidaJugador || vidaEnemigo alcanza 0
    public boolean combateTerminado(int vidaJugador, int vidaEnemigo) {
        boolean finalizarCombate = false;

        if (vidaJugador <= 0 || vidaEnemigo <= 0) {
            finalizarCombate = true;
        }

        return finalizarCombate;
    }

    // Función que devuelve la vida del enemigo tras atacar
    public int realizarAtaque(int vidaEnemigo, int daño) {
        // En caso de dejarlo a menos de 0 de vida, retorna 0
        if ((vidaEnemigo - daño) < 0) {
            return 0;
        }

        return vidaEnemigo - daño;
    }

    // Función que devuelve la vida restante del jugador tras un ataque
    public int recibirDaño(int vidaJugador, int daño, boolean defendiendo) {
        // En caso de defenderse recibe la mitad de daño
        if (defendiendo) {
            daño /= 2;
        }

        // En caso de dejarlo a menos de 0 de vida, retorna 0
        if ((vidaJugador - daño) < 0) {
            return 0;
        }

        return vidaJugador - daño;
    }

    // Función que devuelve la vida del jugador tras curarte
    public int curarJugador(int vidaActual, int vidaMaxima) {
        // En caso de superar los 100 puntos de vida, retorna 100
        if ((vidaActual + 20) > vidaMaxima) {
            return vidaMaxima;
        }

        return vidaActual + 20;
    }
}