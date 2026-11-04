
import java.util.Scanner;

public class E10 {
    public void main(String[] args) throws Exception {
        // Instanciamos scanner
        Scanner sc = new Scanner(System.in);

        // Pedimos y guardamos la capacidad máxima
        System.out.println("Introduce la capacidad máxima de alumnos (5-25): ");
        int capacidadMaxima = sc.nextInt();

        // Validamos que la capacidad máxima esté dentro del rango permitido
        while (capacidadMaxima < 5 || capacidadMaxima > 25) {
            System.out.println("La capacidad debe estar entre 5 y 25, vuelve a introducirla: ");
            capacidadMaxima = sc.nextInt();
        }

        // Creamos los arrays según la capacidad máxima
        String[] nombres = new String[capacidadMaxima];
        double[] notasExamen = new double[capacidadMaxima];
        double[] notasPractica = new double[capacidadMaxima];
        double[] notasProyecto = new double[capacidadMaxima];

        // Llamada a mostrarMenu()
        mostrarMenu(nombres, notasExamen, notasPractica, notasProyecto, sc);

        // Cerramos el scanner al finalizar el programa
        sc.close();
    }

    // Procedimiento que muestra el menú y ejecuta la opción seleccionada
    public void mostrarMenu(String[] nombres, double[] notasExamen, double[] notasPractica, double[] notasProyecto, Scanner sc) {
        int opcion = 0;

        // Repetimos el menú hasta que el usuario seleccione la opción de salir
        do {
            System.out.println("1. Registrar alumnos.\n" +
                    "2. Buscar alumno.\n" +
                    "3. Mostrar todas las calificaciones.\n" +
                    "4. Calcular media del grupo.\n" +
                    "5. Mostrar alumno con mejor calificación.\n" +
                    "6. Mostrar cantidad de aprobados.\n" +
                    "7. Salir.");

            // Leemos la opción seleccionada por el usuario
            opcion = sc.nextInt();

            // Limpiamos el salto de línea pendiente
            sc.nextLine();

            // Ejecutamos el método correspondiente según la opción elegida
            switch (opcion) {
                case 1:
                    registrarAlumno(nombres, notasExamen, notasPractica, notasProyecto, sc);
                    break;
                case 2:
                    // Pedimos el nombre del alumno que queremos buscar
                    System.out.println("Introduce el nombre del alumno a buscar: ");
                    String alumnoBuscado = sc.nextLine();

                    // Mostramos el índice del alumno encontrado o -1 si no existe
                    System.out.println("El índice del alumno buscado es: "
                            + buscarAlumno(nombres, alumnoBuscado));
                    break;
                case 3:
                    // Mostramos los alumnos registrados y sus calificaciones
                    mostrarAlumnos(nombres, notasExamen, notasPractica, notasProyecto);
                    break;
                case 4:
                    // Calculamos y mostramos la media de las notas finales del grupo
                    System.out.println("La media del grupo es de: " + calcularMediaGrupo(nombres, notasExamen,
                            notasPractica, notasProyecto));
                    break;
                case 5:
                    // Comprobamos que haya alumnos registrados
                    if (nombres[0] == null) {
                        System.out.println("No hay alumnos registrados.");
                    } else {
                        // Mostramos el nombre del alumno con la nota final más alta
                        System.out.println("El alumno con mejor calificación es: "
                                + nombres[obtenerMejorAlumno(nombres, notasExamen,
                                        notasPractica, notasProyecto)]);
                    }
                    break;
                case 6:
                    // Calculamos y mostramos la cantidad de alumnos aprobados
                    System.out.println("La cantidad de alumnos aprobados es de: " + contarAprobados(nombres,
                            notasExamen, notasPractica, notasProyecto));
                    break;
                case 7:
                    // Mostramos un mensaje antes de finalizar el programa
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    // No ejecutamos ninguna acción si la opción no coincide con las anteriores
                    break;
            }
        } while (opcion != 7);
    }

    // Método que registra varios alumnos y sus correspondientes calificaciones
    public void registrarAlumno(String[] nombres, double[] notasExamen, double[] notasPractica, double[] notasProyecto, Scanner sc) {

        // Buscamos la primera posición libre del array
        int primeraPosicionLibre = 0;

        while (primeraPosicionLibre < nombres.length && nombres[primeraPosicionLibre] != null) {
            primeraPosicionLibre++;
        }

        // Comprobamos si el array está completo
        if (primeraPosicionLibre == nombres.length) {
            System.out.println("No quedan plazas disponibles.");
            return;
        }

        // Pedimos la cantidad de alumnos que queremos registrar
        System.out.println("Introduce el número de alumnos a registrar: ");
        int cantidadAlumnos = sc.nextInt();

        // Comprobamos que la cantidad de alumnos no supere el espacio disponible
        while (cantidadAlumnos <= 0 || cantidadAlumnos > nombres.length - primeraPosicionLibre) {
            System.out.println("Puedes registrar entre 1 y " + (nombres.length - primeraPosicionLibre)
                    + " alumnos. Introduce otra cantidad:");
            cantidadAlumnos = sc.nextInt();
        }

        // Limpiamos el salto de línea pendiente
        sc.nextLine();

        // Contador de alumnos registrados durante esta operación
        int registrados = 0;

        // Recorremos el array desde la primera posición libre
        for (int i = primeraPosicionLibre; i < nombres.length && registrados < cantidadAlumnos; i++) {

            // Pedimos y guardamos el nombre del alumno
            System.out.println("Introduce el NOMBRE del alumno:");
            nombres[i] = sc.nextLine();

            // Pedimos la nota del examen y comprobamos que esté entre 0 y 10
            System.out.println("Introduce la nota del examen (0-10): ");
            notasExamen[i] = sc.nextDouble();
            while (notasExamen[i] < 0.0 || notasExamen[i] > 10.0) {
                System.out.println("La calificación debe estar entre 0 y 10:");
                notasExamen[i] = sc.nextDouble();
            }

            // Pedimos la nota de la práctica y comprobamos que esté entre 0 y 10
            System.out.println("Introduce la nota de la práctica (0-10): ");
            notasPractica[i] = sc.nextDouble();
            while (notasPractica[i] < 0.0 || notasPractica[i] > 10.0) {
                System.out.println("La calificación debe estar entre 0 y 10:");
                notasPractica[i] = sc.nextDouble();
            }

            // Pedimos la nota del proyecto y comprobamos que esté entre 0 y 10
            System.out.println("Introduce la nota del proyecto (0-10): ");
            notasProyecto[i] = sc.nextDouble();
            while (notasProyecto[i] < 0.0 || notasProyecto[i] > 10.0) {
                System.out.println("La calificación debe estar entre 0 y 10:");
                notasProyecto[i] = sc.nextDouble();
            }

            // Limpiamos el salto de línea y aumentamos el contador de registrados
            sc.nextLine();
            registrados++;
        }
    }

    // Método que busca un alumno por su nombre y devuelve su índice
    public int buscarAlumno(String[] nombres, String buscado) {

        // Recorremos las posiciones que corresponden a los alumnos registrados
        for (int i = 0; i < nombres.length; i++) {

            // Si encontramos una posición vacía, detenemos la búsqueda
            if (nombres[i] == null) {
                break;
            }

            // Comprobamos si el nombre de la posición coincide con el buscado
            if (nombres[i].equals(buscado)) {
                return i;
            }
        }

        // Avisamos si no encontramos al alumno y devolvemos -1
        System.out.println("Alumno no encontrado");
        return -1;
    }

    // Método que calcula la nota final ponderando las tres calificaciones
    public double calcularNotaFinal(double examen, double practica, double proyecto) {
        // Aplicamos el peso del examen (50 %), la práctica (30 %) y el proyecto (20 %)
        return 0.5 * examen + 0.3 * practica + 0.2 * proyecto;
    }

    // Método que muestra los alumnos registrados y sus calificaciones
    public void mostrarAlumnos(String[] nombres, double[] notasExamen, double[] notasPractica, double[] notasProyecto) {
        // Mostramos la cabecera de la tabla
        System.out.println("Alumno \t Nota examen \t Nota práctica \t Nota proyecto");

        // Recorremos el array de nombres para mostrar únicamente los alumnos registrados
        for (int i = 0; i < nombres.length; i++) {

            // Si encontramos una posición vacía, terminamos
            if (nombres[i] == null) {
                break;
            }

            System.out.println(
                    nombres[i] + "\t" + notasExamen[i] + "\t" + notasPractica[i] + "\t" + notasProyecto[i]);
        }
    }

    // Método que calcula la media de las notas finales de todos los alumnos registrados
    public double calcularMediaGrupo(String[] nombres, double[] notasExamen, double[] notasPractica,
            double[] notasProyecto) {
        double mediaGrupo = 0.0;
        int contador = 0;

        // Sumamos las notas finales de los alumnos registrados
        for (int i = 0; i < nombres.length; i++) {

            // Si encontramos una posición vacía, terminamos
            if (nombres[i] == null) {
                break;
            }

            mediaGrupo += calcularNotaFinal(notasExamen[i], notasPractica[i], notasProyecto[i]);
            contador++;
        }

        // Comprobamos que haya alumnos antes de dividir
        if (contador == 0) {
            return 0.0;
        }

        // Dividimos la suma entre la cantidad de alumnos registrados y devolvemos la media
        return mediaGrupo / contador;
    }

    // Método que obtiene el índice del alumno con la nota final más alta
    public int obtenerMejorAlumno(String[] nombres, double[] notasExamen, double[] notasPractica,
            double[] notasProyecto) {
        int indiceAlumnoNotaMayor = 0;
        double notaMediaMayor = 0.0;
        double notaMedia = 0.0;

        // Recorremos las notas finales de los alumnos registrados
        for (int i = 0; i < nombres.length; i++) {

            // Si encontramos una posición vacía, terminamos
            if (nombres[i] == null) {
                break;
            }

            // Calculamos la nota final del alumno actual
            notaMedia = calcularNotaFinal(notasExamen[i], notasPractica[i], notasProyecto[i]);

            // Actualizamos la nota más alta y su índice si encontramos una mayor
            if (notaMedia > notaMediaMayor) {
                notaMediaMayor = notaMedia;
                indiceAlumnoNotaMayor = i;
            }
        }

        // Devolvemos la posición del alumno con la nota más alta
        return indiceAlumnoNotaMayor;
    }

    // Método que cuenta cuántos alumnos tienen una nota final igual o superior a 5
    public int contarAprobados(String[] nombres, double[] notasExamen, double[] notasPractica,
            double[] notasProyecto) {
        int cantidadAprobados = 0;

        // Recorremos las notas finales de los alumnos registrados
        for (int i = 0; i < nombres.length; i++) {

            // Si encontramos una posición vacía, terminamos
            if (nombres[i] == null) {
                break;
            }

            // Comprobamos si la nota final del alumno es suficiente para aprobar
            if (calcularNotaFinal(notasExamen[i], notasPractica[i], notasProyecto[i]) >= 5.0) {
                cantidadAprobados++;
            }
        }

        // Devolvemos la cantidad total de alumnos aprobados
        return cantidadAprobados;
    }
}
