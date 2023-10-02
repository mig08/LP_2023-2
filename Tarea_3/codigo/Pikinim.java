abstract class Pikinim {
    protected int ataque;
    protected int capacidad;
    protected int cantidad;

    Pikinim(){
        ataque = 0;
        capacidad = 0;
        cantidad = 10;
    }

    abstract void disminuir(int cantidad);

    abstract void multiplicar(int cantidad);


}
