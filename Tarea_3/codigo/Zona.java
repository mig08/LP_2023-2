public class Zona {
    protected boolean completada;
    
    Zona(){
                   /*
    Funcion: constructor de zona, crea un objeto de la clase zona 

    Parametro: sin parametro
    
    Return: constructor de la clase zona
    */
        completada = false;
    }
    

    public void que_soy(){
                    /*
    Funcion: void que_soy, esta funcion imprime por consola el nombre de la clase con sus parametros 

    Parametro: sin parametro
    
    Return: no retorna nada

    */
        System.out.print("Zona");
    }

    public void interactuar(Amarillo amarillo, Cyan cyan, Magenta magenta){
                   /*
    Funcion: void interactuar, esta funcion verifica si esta completada la zona, en caso de estarlo imprime por pantalla 

    Parametro: Amarillo amarillo, Cyan cyan, Magenta magenta. Los 3 tipos de pikinim
    
    Return: no retorna nada
    */
        if (GetCompletada()){
            System.out.println("No queda nada que hacer aqui");
            try {Thread.sleep(2500);}catch(Exception e){System.out.println(e);}
    
        }
    }    


    public boolean GetCompletada(){
                   /*
    Funcion: boolean GetCompletada, esta funcion es para obtener el valor de completada

    Parametro: sin parametro
    
    Return: retorna el valor actual de completada
    */
        return completada;
    }

    public void SetCompletada(boolean completada){
                   /*
    Funcion: void SetCompletada, esta funcion es para cambiar el valor de completada 

    Parametro: boolean completada, el nuevo valor de completada
    
    Return: no retorna nada
    */
        this.completada = completada;

    }
    
}