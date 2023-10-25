CREATE TABLE DetallePedido (
    ID_Detalle INT AUTO_INCREMENT PRIMARY KEY,
    ID_Pedido INT,
    ID_Silla INT,
    Cantidad INT,
    PRECIO_TOTAL DECIMAl (10, 2)

);
