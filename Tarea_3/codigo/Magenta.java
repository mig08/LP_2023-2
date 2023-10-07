public class Magenta extends Pikinim{
    public Magenta(){
                           /*
    Funcion: constructor de magenta, es para crear objetos de clase magenta 

    Parametro: sin parametro
    
    Return: constructor de la clase 
    */
        super();
        ataque = 2;
        capacidad = 1;
    }

    public boolean atacable(){
                         /*
    Comentado en Amarillo.java
    */
        if (cantidad <= 0){
            cantidad = 0;

            return false;

        }else{
            return true;
        }
    }

    public int GetAtaque(){
                         /*
    Comentado en Amarillo.java
    */
        return ataque;
    }

    public int GetCapacidad(){
                         /*
    Comentado en Amarillo.java
    */
        return capacidad;
    }

    public int GetCantidad(){
                         /*
    Comentado en Amarillo.java
    */
        return cantidad;
    }
   
    public void SetAtaque(int ataque){
                         /*
    Comentado en Amarillo.java
    */
        this.ataque = ataque;
    }

    public void SetCapacidad(int capacidad){
                         /*
    Comentado en Amarillo.java
    */
        this.capacidad = capacidad;
    }

    public void SetCantidad(int cantidad){
                         /*
    Comentado en Amarillo.java
    */
        this.cantidad = cantidad;
    }

    public void disminuir(int cantidad){
                         /*
    Comentado en Amarillo.java
    */
        this.cantidad -= cantidad;
        if (this.cantidad <= 0){
            this.cantidad = 0;
        }
    }

    public void multiplicar(int cantidad){
                   /*
    Funcion: void multiplicar, funcion para aumentar la cantidad de pikinims usando cantidad * ataque

    Parametro: int cantidad, numero que va en la formula de cada multiplicar
    
    Return: no retorna nada
    */
        this.cantidad += cantidad * ataque;

    }
    
}
