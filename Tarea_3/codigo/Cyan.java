public abstract class Cyan extends Pikinim{

    public Cyan(){
        super();
        ataque = 1;
        capacidad = 1;
    }
   
    public void disminuir(int cantidad){
        this.cantidad -= cantidad;
    }

    public void multiplicar(int cantidad){
        this.cantidad += cantidad * 3;
    }
    
}
