abstract class Pikinim {
    protected int ataque;
    protected int capacidad;
    protected int cantidad;

    Pikinim(){
                   /*
    Funcion: constructor de pikinim, es para crear un objeto de la clase pikinim 

    Parametro: sin parametro
    
    Return: constructor de la clase 
    */
        ataque = 0;
        capacidad = 0;
        cantidad = 10;
    }


    abstract void disminuir(int cantidad);

    abstract void multiplicar(int cantidad);

    abstract boolean atacable();

}