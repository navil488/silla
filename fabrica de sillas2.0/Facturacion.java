import java.util.Date;

public class Facturacion {
    private String serie;
    private int numero;
    private Date fecha;
    private double cantidad;
    private double montoAPagar;

    // Constructor y métodos getters y setters
    public Facturacion(String serie, int numero, Date fecha, double cantidad, double montoAPagar) {
        this.serie = serie;
        this.numero = numero;
        this.fecha = fecha;
        this.cantidad = cantidad;
        this.montoAPagar = montoAPagar;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public double getMontoAPagar() {
        return montoAPagar;
    }

    public void setMontoAPagar(double montoAPagar) {
        this.montoAPagar = montoAPagar;
    }
}
