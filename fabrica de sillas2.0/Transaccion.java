import java.util.Date;

public class Transaccion {
    private Material material;
    private int cantidad;
    private Date fecha;

    // Constructor y métodos getters y setters
    public Transaccion(Material material, int cantidad, Date fecha) {
        this.material = material;
        this.cantidad = cantidad;
        this.fecha = fecha;
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

}
