abstract class Pikinim {
    protected int ataque;
    protected int capacidad;
    protected int cantidad;

    Pikinim(){
        ataque = 0;
        capacidad = 0;
        cantidad = 10;
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

    abstract void disminuir(int cantidad);

    abstract void multiplicar(int cantidad);


}
