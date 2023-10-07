public class Amarillo extends Pikinim{
    Amarillo(){
                   /*
    Funcion: constructor de la clase amarillo, crea un objeto de la clase amarillo 

    Parametro: sin parametro
    
    Return: constructor de la clase 
    */
        super();
        ataque = 1;
        capacidad = 3;
    }

    public boolean atacable(){
           /*
    Funcion: boolean atacable, esta funcion revisa la cantidad de pikinims, si es menor o igual a 0 no se puede atacar 

    Parametro: sin parametro
    
    Return: retorna un booleano, true si se puede atacar, false en caso contrario
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
    Funcion: int GetAtaque, funcion para obtener el valor de ataque 

    Parametro: sin parametro
    
    Return: retorna el valor de ataque
    */
        return ataque;
    }

    public int GetCapacidad(){
                   /*
    Funcion: int GetCapacidad, funcion para obtener el valor de capacidad 

    Parametro: sin parametro
    
    Return: retorna el valor de capacidad
    */
        return capacidad;
    }

    public int GetCantidad(){
                   /*
    Funcion: int GetCantidad, funcion para obtener el valor de cantidad 

    Parametro: sin parametro
    
    Return: retorna el valor de cantidad
    */
        return cantidad;
    }

    public void SetAtaque(int ataque){
                   /*
    Funcion: void SetAtaque, funcion para cambiar el valor de ataque 

    Parametro: int ataque, nuevo valor de ataque
    
    Return: no retorna nada
    */
        this.ataque = ataque;
    }

    public void SetCapacidad(int capacidad){
                   /*
    Funcion: void SetCapacidad, funcion para obtener el valor de capacidad 

    Parametro: int capacidad, nuevo valor de capacidad
    
    Return: no retorna nada
    */
        this.capacidad = capacidad;
    }

    public void SetCantidad(int cantidad){
                   /*
    Funcion: void SetCantidad, funcion para cambiar el valor de cantidad 

    Parametro: int cantidad, nuevo valor de cantidad
    
    Return: no retorna nada
    */
        this.cantidad = cantidad;
    }

    public void disminuir(int cantidad){
                   /*
    Funcion: void disminuir, funcion para restar un numero a la cantidad, en caso de que la resta sea menor a 0, lo iguala a 0

    Parametro: int cantidad, valor a restar
    
    Return: no retorna nada
    */
        this.cantidad -= cantidad;
        if (this.cantidad <= 0){
            this.cantidad = 0;
        }
    }

    public void multiplicar(int cantidad){
                   /*
    Funcion: void multiplicar, funcion para aumentar la cantidad de pikinims usando Math.ceil(cantidad*1.5) 

    Parametro: int cantidad, numero que va en la formula de cada multiplicar
    
    Return: no retorna nada
    */
        this.cantidad += Math.ceil(cantidad*1.5);

    }
    
}