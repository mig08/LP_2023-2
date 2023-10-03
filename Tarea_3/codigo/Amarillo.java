public class Amarillo extends Pikinim{
    public Amarillo(){
        super();
        ataque = 1;
        capacidad = 3;
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
        this.cantidad += Math.ceil(cantidad*1.5);

    }
    
}