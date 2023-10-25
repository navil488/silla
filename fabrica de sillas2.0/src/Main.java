import java.sql.*;
import java.util.Date;
import java.util.Scanner;

public class Main {
    private static Connection conexion;

    public static void main(String[] args) {
        conectarABaseDeDatos();
        mostrarMenu();
    }

    private static void conectarABaseDeDatos() {
        String jdbcUrl = "jdbc:mariadb://localhost:3306/bd_fabrica";
        String usuario = "root";
        String contraseña = "123456";
        try {
            conexion = DriverManager.getConnection(jdbcUrl, usuario, contraseña);
            System.out.println("Conexión a la base de datos exitosa.");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("No se pudo conectar a la base de datos.");
        }
    }

    private static void mostrarMenu() {
        Scanner scanner = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("\nMenú de Operaciones:");
            System.out.println("1. Consultar Materiales");
            System.out.println("2. Registrar Material");
            System.out.println("3. Consultar Proveedores");
            System.out.println("4. Registrar Proveedor");
            System.out.println("5. Realizar Pedido");
            System.out.println("6. Facturar");
            System.out.println("7. Salir");
            System.out.print("Elige una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    consultarMateriales();
                    break;
                case 2:
                    registrarMaterial();
                    break;
                case 3:
                    consultarProveedores();
                    break;
                case 4:
                    registrarProveedor();
                    break;
                case 5:
                    realizarPedido();
                    break;
                case 6:
                    facturar();
                    break;
                case 7:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        } while (opcion != 7);
        scanner.close();
    }

        private static void consultarMateriales() {
            try {
                // Crear y ejecutar una consulta SQL para obtener los materiales
                String consultaSQL = "SELECT * FROM materiales";
                Statement statement = conexion.createStatement();
                ResultSet resultado = statement.executeQuery(consultaSQL);

                // Procesar y mostrar los resultados
                System.out.println("Materiales disponibles:");
                while (resultado.next()) {
                    int id = resultado.getInt("id");
                    String nombre = resultado.getString("nombre");
                    double precio = resultado.getDouble("precio");
                    int stock = resultado.getInt("stock");

                    // Mostrar la información del material
                    System.out.println("ID: " + id);
                    System.out.println("Nombre: " + nombre);
                    System.out.println("Precio: " + precio);
                    System.out.println("Stock: " + stock);
                    System.out.println("-----");
                }

                // Cerrar recursos (ResultSet y Statement)
                resultado.close();
                statement.close();
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Error al consultar materiales.");
            }
        }



    private static void registrarMaterial() {
        try {
            // Solicitar información del nuevo material al usuario
            Scanner scanner = new Scanner(System.in);
            System.out.print("Nombre del material: ");
            String nombre = scanner.nextLine();
            System.out.print("Precio del material: ");
            double precio = scanner.nextDouble();
            System.out.print("Stock del material: ");
            int stock = scanner.nextInt();

            // Crear y ejecutar una consulta SQL para insertar el nuevo material
            String consultaSQL = "INSERT INTO materiales (nombre, precio, stock) VALUES (?, ?, ?)";
            PreparedStatement statement = conexion.prepareStatement(consultaSQL);
            statement.setString(1, nombre);
            statement.setDouble(2, precio);
            statement.setInt(3, stock);
            int filasAfectadas = statement.executeUpdate();

            // Verificar si la inserción fue exitosa
            if (filasAfectadas > 0) {
                System.out.println("Material registrado con éxito.");
            } else {
                System.out.println("Error al registrar el material.");
            }

            // Cerrar recursos (PreparedStatement)
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al registrar material.");
        }




    }

    private static void consultarProveedores() {
        try {
            // Crear y ejecutar una consulta SQL para obtener los proveedores
            String consultaSQL = "SELECT * FROM proveedores";
            Statement statement = conexion.createStatement();
            ResultSet resultado = statement.executeQuery(consultaSQL);

            // Procesar y mostrar los resultados
            System.out.println("Proveedores disponibles:");
            while (resultado.next()) {
                int id = resultado.getInt("id");
                String nombre = resultado.getString("nombre");
                String direccion = resultado.getString("direccion");
                String telefono = resultado.getString("telefono");

                // Mostrar la información del proveedor
                System.out.println("ID: " + id);
                System.out.println("Nombre: " + nombre);
                System.out.println("Dirección: " + direccion);
                System.out.println("Teléfono: " + telefono);
                System.out.println("-----");
            }

            // Cerrar recursos (ResultSet y Statement)
            resultado.close();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al consultar proveedores.");
        }

    }

    private static void registrarProveedor() {
        try {
            // Solicitar información del nuevo proveedor al usuario
            Scanner scanner = new Scanner(System.in);
            System.out.print("Nombre del proveedor: ");
            String nombre = scanner.nextLine();
            System.out.print("Dirección del proveedor: ");
            String direccion = scanner.nextLine();
            System.out.print("Teléfono del proveedor: ");
            String telefono = scanner.nextLine();

            // Crear y ejecutar una consulta SQL para insertar el nuevo proveedor
            String consultaSQL = "INSERT INTO proveedores (nombre, direccion, telefono) VALUES (?, ?, ?)";
            PreparedStatement statement = conexion.prepareStatement(consultaSQL);
            statement.setString(1, nombre);
            statement.setString(2, direccion);
            statement.setString(3, telefono);
            int filasAfectadas = statement.executeUpdate();

            // Verificar si la inserción fue exitosa
            if (filasAfectadas > 0) {
                System.out.println("Proveedor registrado con éxito.");
            } else {
                System.out.println("Error al registrar el proveedor.");
            }

            // Cerrar recursos (PreparedStatement)
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al registrar proveedor.");
        }

    }

    private static void realizarPedido() {
        try {
            // Solicitar información del pedido al usuario
            Scanner scanner = new Scanner(System.in);
            System.out.print("ID del material: ");
            int idMaterial = scanner.nextInt();
            System.out.print("ID del proveedor: ");
            int idProveedor = scanner.nextInt();
            System.out.print("Cantidad: ");
            int cantidad = scanner.nextInt();

            // Obtener la fecha actual
            Date fecha = new Date();

            // Crear y ejecutar una consulta SQL para registrar el pedido
            String consultaSQL = "INSERT INTO transacciones (id_material, id_proveedor, cantidad, fecha) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = conexion.prepareStatement(consultaSQL);
            statement.setInt(1, idMaterial);
            statement.setInt(2, idProveedor);
            statement.setInt(3, cantidad);
            statement.setDate(4, new java.sql.Date(fecha.getTime()));
            int filasAfectadas = statement.executeUpdate();

            // Verificar si el pedido fue registrado con éxito
            if (filasAfectadas > 0) {
                System.out.println("Pedido registrado con éxito.");
            } else {
                System.out.println("Error al registrar el pedido.");
            }

            // Cerrar recursos (PreparedStatement)
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al realizar el pedido.");
        }
    }

    private static void facturar() {
        try {
            // Solicitar información de la factura al usuario
            Scanner scanner = new Scanner(System.in);
            System.out.print("Número de factura: ");
            String numeroFactura = scanner.nextLine();
            System.out.print("Monto a pagar: ");
            double montoAPagar = scanner.nextDouble();

            // Obtener la fecha actual
            Date fecha = new Date();

            // Crear y ejecutar una consulta SQL para registrar la factura
            String consultaSQL = "INSERT INTO facturas (numero, fecha, monto_a_pagar) VALUES (?, ?, ?)";
            PreparedStatement statement = conexion.prepareStatement(consultaSQL);
            statement.setString(1, numeroFactura);
            statement.setDate(2, new java.sql.Date(fecha.getTime()));
            statement.setDouble(3, montoAPagar);
            int filasAfectadas = statement.executeUpdate();

            // Verificar si la factura fue registrada con éxito
            if (filasAfectadas > 0) {
                System.out.println("Factura registrada con éxito.");
            } else {
                System.out.println("Error al registrar la factura.");
            }

            // Cerrar recursos (PreparedStatement)
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al facturar.");
        }

    }
}
