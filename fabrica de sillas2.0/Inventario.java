import java.util.Date;

public class Inventario {
    private Material material;
    private int sillasEnStock;

    // Constructor y métodos getters y setters
    public Inventario(Material material, int sillasEnStock) {
        this.material = material;
        this.sillasEnStock = sillasEnStock;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public int getSillasEnStock() {
        return sillasEnStock;
    }

    public void setSillasEnStock(int sillasEnStock) {
        this.sillasEnStock = sillasEnStock;
    }
}
