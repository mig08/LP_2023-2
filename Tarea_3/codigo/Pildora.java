public class Pildora extends Zona {

    private int cantidad;

    public Pildora(int cantidad){
        super();
        this.cantidad = cantidad;
    }

    public void SetCantidad(int cantidad){
        this.cantidad = cantidad;
    }
   
    public int GetCantidad(){
        return cantidad;
    }
}
