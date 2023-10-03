public class Magenta extends Pikinim{
    public Magenta(){
        super();
        ataque = 2;
        capacidad = 1;
    }

    public int GetAtaque(){
        return ataque;
    }

    public int GetCapacidad(){
        return capacidad;
    }

    public int GetCantidad(){
        return cantidad;
    }
   
    public void disminuir(int cantidad){
        this.cantidad -=cantidad;

    }

    public void multiplicar(int cantidad){
        this.cantidad += cantidad * ataque;

    }
    
}
