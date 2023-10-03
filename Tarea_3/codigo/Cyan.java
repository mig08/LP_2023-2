public class Cyan extends Pikinim{

    public Cyan(){
        super();
        ataque = 1;
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
        this.cantidad -= cantidad;
    }

    public void multiplicar(int cantidad){
        this.cantidad += cantidad * 3;
    }
    
}
