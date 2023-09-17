import java.util.Date;

public class Main {
    public static void main(String[] args) {
        // Crear materiales y proveedores
        material material1 = new material(1, "Material 1", 10.0, 100);
        material material2 = new material(2, "Material 2", 15.0, 50);

        proveedor proveedor1 = new proveedor(1, "Proveedor 1", "Dirección 1", "123-456-7890");
        proveedor proveedor2 = new ´proveedor(2, "Proveedor 2", "Dirección 2", "987-654-3210");

        // Crear un inventario y agregar materiales
        inventario inventario = new inventario();
        inventario.agregar Material(material1, 50);
        inventario.agregar Material(material2, 25);

        // Realizar una transacción
        transaccion transaccion = new transaccion(material1, 10, new Date());
        inventario.registrar Transaccion(transaccion);

        // Crear facturación y pedido
        facturacion facturacion = new facturacion("S001", 1, new Date(), 150.0);
        pedido pedido = new pedido(material2, 20, new Date(), proveedor1, 300.0, "P001");

        // Imprimir información de los materiales en el inventario
        System.out.println("Inventario:");
        for (Map.Entry<Material, Integer> entry : inventario.getMateriales().entrySet()) {
            Material material = entry.getKey();
            int stock = entry.getValue();
            System.out.println(material.getNombre() + ": Stock - " + stock);
        }

        // Imprimir información de la transacción, facturación y pedido
        System.out.println("\nTransacción realizada: Material - " + transaccion.getMaterial().getNombre()
                + ", Cantidad - " + transaccion.getCantidad());

        System.out.println("\nFacturación: Serie - " + facturacion.getSerie() + ", Monto a pagar - "
                + facturacion.getMontoAPagar());

        System.out.println("\nPedido: Material - " + pedido.getMaterial().getNombre() + ", Cantidad - "
                + pedido.getCantidad() + ", Proveedor - " + pedido.getProveedor().getNombre());
    }
}
