public abstract class Magenta extends Pikinim{
    public Magenta(){
        super();
        ataque = 2;
        capacidad = 1;
    }
   
    public void disminuir(int cantidad){
        this.cantidad -=cantidad;

    }

    public void multiplicar(int cantidad){
        this.cantidad += cantidad * ataque;

    }
    
}
