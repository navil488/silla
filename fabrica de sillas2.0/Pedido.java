import java.util.Date;

public class Pedido {
    private date material;
    private int cantidad;
    private Date fecha;
    private Proveedor proveedor;
    private double montoAPagar;
    private String serie;

    // Constructor y métodos getters y setters
    public Pedido(date material, int cantidad, Date fecha, Proveedor proveedor, double montoAPagar, String serie) {
        this.material = material;
        this.cantidad = cantidad;
        this.fecha = fecha;
        this.proveedor = proveedor;
        this.montoAPagar = montoAPagar;
        this.serie = serie;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public double getMontoAPagar() {
        return montoAPagar;
    }

    public void setMontoAPagar(double montoAPagar) {
        this.montoAPagar = montoAPagar;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }


}
