
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List
;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Ma1terial> material = new ArrayList<>();
        List<Inventario> inventario = new ArrayList<>();
        List<Transaccion> transacciones = new ArrayList<>();
        List<Pedido> pedidos = new ArrayList<>();

        while (true) {
            System.out.println("Menú:");
            System.out.println("1. Agregar material");
            System.out.println("2. Registrar transacción");
            System.out.println("3. Realizar pedido");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine();  // Consumir la nueva línea después del número

            switch (opcion) {
                case 1:
                    //  agregar material al inventario
                    // Solicitar al usuario los datos del nuevo material
                    System.out.print("Ingrese el ID del material: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Consumir la nueva línea

                    System.out.print("Ingrese el nombre del material: ");
                    String nombre = scanner.nextLine();

                    System.out.print("Ingrese el precio del material: ");
                    double precio = scanner.nextDouble();
                    scanner.nextLine(); // Consumir la nueva línea

                    System.out.print("Ingrese la cantidad en stock: ");
                    int stock = scanner.nextInt();
                    scanner.nextLine(); // Consumir la nueva línea

                    // Crear una nueva instancia de Material con los datos proporcionados
                    Material nuevoMaterial = new Material();

                    // Agregar el nuevo material al inventario
                    material.add(nuevoMaterial);

                    System.out.println("Material agregado al inventario.");

                    break;
                case 2:
                    // registrar una transacción
                    // Mostrar lista de materiales disponibles
                    System.out.println("Lista de materiales disponibles:");
                    for (int i = 0; i < material.size(); i++) {
                        Ma1terial Material = material.get(i);
                        System.out.println(i + 1 + ". " + material.getClass());
                    }

                    // Solicitar al usuario seleccionar un material
                    System.out.print("Seleccione un material (número): ");
                    int materialIndex = scanner.nextInt();
                    scanner.nextLine(); // Consumir la nueva línea

                    if (materialIndex < 1 || materialIndex > material.size()) {
                        System.out.println("Opción no válida.");
                        break;
                    }

                    Material materialSeleccionado = (Material) material.get(materialIndex - 1);

                    // Solicitar la cantidad y la fecha de la transacción
                    System.out.print("Ingrese la cantidad de material: ");
                    int cantidad = scanner.nextInt();
                    scanner.nextLine(); // Consumir la nueva línea

                    System.out.print("Ingrese la fecha de la transacción (YYYY-MM-DD): ");
                    String fechaStr = scanner.nextLine();
                    // Puedes convertir la cadena de fecha a un objeto Date usando SimpleDateFormat

                    // Registrar la transacción
                    Transaccion transaccion = new Transaccion();
                    transacciones.add(transaccion);

                    System.out.println("Transacción registrada con éxito.");



                    break;
                case 3:
                    //  realizar un pedido
// Solicitar al usuario el nombre del material
                    System.out.print("Ingrese el nombre del material a pedir: ");
                    String nombreMaterial = scanner.nextLine();

                    // Buscar el material por nombre en la lista de materiales
                    Material materialPedido = null;
                    for (Ma1terial Material : material) {
                        if (Material.getClass().equals(nombreMaterial)) {
                            materialPedido = (Main.Material) Material;
                            break;
                        }
                    }

                    if (materialPedido == null) {
                        System.out.println("Material no encontrado. Verifique el nombre.");
                        break;
                    }

                    // Solicitar al usuario la cantidad y la fecha del pedido
                    System.out.print("Ingrese la cantidad a pedir: ");
                    int cantidadPedido = scanner.nextInt();
                    scanner.nextLine(); // Consumir la nueva línea

                    System.out.print("Ingrese la fecha del pedido (YYYY-MM-DD): ");
                    String fechaPedidoStr = scanner.nextLine();
                    // Puedes convertir la cadena de fecha a un objeto Date usando SimpleDateFormat

                    // Crear una instancia de Pedido con los datos ingresados
                    Pedido pedido = new Pedido();
                    pedidos.add(pedido);

                    System.out.println("Pedido realizado con éxito.");


                    break;


                case 4:
                    System.out.println("Saliendo del programa...");
                    System.exit(0);
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
                    break;
            }
        }
    }

    private static class Inventario {
    }

    private static class Transaccion {
    }

    private static class Pedido {
    }

    private static class Material extends Ma1terial {
        private String nombre;

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }
    }

    private static class Ma1terial {
    }
}
