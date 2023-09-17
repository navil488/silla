import java.util.Date;

public class pedido {
    private material material;
    private  int cantidad;
    private Date fecha;
    private  proveedor proveedor;
    private double montoApagar;
    private String serie;
    //constructor
    public  pedido(material material, int cantidad,Date fecha,proveedor proveedor,double montoApagar,String serie){
    this.material = material;
    this.cantidad = cantidad;
    this.fecha = fecha;
    this.proveedor = proveedor;
    this.montoApagar = montoApagar;
    this.serie = serie;

    }
}