import java.util.Scanner;

public class E5 {
    public void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] nombres = new String[6];
        double[] precios = new double[6];
        int[] cantidades = new int[6];

        solicitarNombres(nombres, sc);
        solicitarPrecios(precios, sc);
        solicitarCantidades(cantidades, sc);

        mostrarMenu(nombres, precios, cantidades, sc);

    }

    public void solicitarNombres(String[] nombres, Scanner sc) {
        for (int i = 0; i < nombres.length; i++) {
            System.out.println("Introduce el nombre del producto nº " + (i + 1));
            nombres[i] = sc.nextLine();
        }
    }

    public void solicitarPrecios(double[] precios, Scanner sc) {
        for (int i = 0; i < precios.length; i++) {
            System.out.println("Introduce el precio del producto nº " + (i + 1));
            precios[i] = sc.nextDouble();
        }
    }

    public void solicitarCantidades(int[] cantidades, Scanner sc) {
        for (int i = 0; i < cantidades.length; i++) {
            System.out.println("Introduce la cantidad del producto nº " + (i + 1));
            cantidades[i] = sc.nextInt();
        }
    }

    public void mostrarProductos(String[] nombres, double[] precios, int[] cantidades) {
        System.out.println("Producto \t Precio \t Cantidad disponible");
        for (int i = 0; i < nombres.length; i++) {
            System.out.println(nombres[i] + "\t" + precios[i] + "\t" + cantidades[i]);
        }
    }

    public double calcularValorTotal(double[] precios, int[] cantidades) {
        double valorTotal = 0.0;
        for (int i = 0; i < precios.length; i++) {
            valorTotal += (precios[i] * cantidades[i]);
        }
        System.out.println("Valor total: " + valorTotal);
        return valorTotal;
    }

    public int buscarProducto(String[] nombres, Scanner sc) {
        System.out.println("Introduce el nombre de un producto: ");
        String producto = sc.nextLine();
        for (int i = 0; i < nombres.length; i++) {
            if (nombres[i].equals(producto)) {
                return i;
            }
        }
        System.out.println("Producto no encontrado");
        return -1;
    }

    public void venderProducto(int[] cantidades, String[] nombres, Scanner sc) {
        int indiceProducto = buscarProducto(nombres, sc);
        System.out.println("Introduce la cantidad de productos a vender: ");
        int cantidadVendida = sc.nextInt();

        cantidades[indiceProducto] -= cantidadVendida;
    }

    public void mostrarMenu(String[] nombres, double[] precios, int[] cantidades, Scanner sc) {
        int opcion = 0;
        do {
            System.out.println("1. Mostrar productos.\n" +
            "2. Calcular valor total del almacén.\n" +
            "3. Buscar producto.\n" +
            "4. Vender producto.\n" +
                "5. Salir.");
                opcion = sc.nextInt();
                sc.nextLine();
                switch (opcion) {
            case 1:
                mostrarProductos(nombres, precios, cantidades);
                break;
            case 2:
                calcularValorTotal(precios, cantidades);
                break;
            case 3:
                System.out.println("El producto está en el índice: " + buscarProducto(nombres, sc));
                break;
            case 4:
                venderProducto(cantidades, nombres, sc);
                break;
            case 5:
                System.out.println("Saliendo del programa...");
                break;
            default:
                System.out.println("Opción invalida");
            }
        } while (opcion != 5);
        }
}
