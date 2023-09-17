import java.util.Date;
public class transaccion {
    private material material;
    private int cantidad;
    private Date fecha;
    // constructor
    public transaccion (material material, int cantidad,Date fecha){
        this.material = material;
        this.cantidad= cantidad;
        this.fecha = fecha;
    }
}
