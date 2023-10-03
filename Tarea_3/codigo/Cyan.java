public class Cyan extends Pikinim{

    public Cyan(){
        super();
        ataque = 1;
        capacidad = 1;
    }

    public boolean atacable(){
        if (cantidad <= 0){
            cantidad = 0;
            return false;

        }else{
            return true;
        }
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