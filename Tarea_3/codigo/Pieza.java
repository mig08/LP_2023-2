public class Pieza extends Zona implements ILevantable {
    private int peso;
    private static int piezas_faltantes;

    Pieza(int peso){
                  /*
    Funcion: constructor de pieza, crea el objeto de la clase pieza 

    Parametro: int peso, peso de la pieza
    
    Return: constructor de pieza
    */
        super();
        this.peso = peso;
        piezas_faltantes = 3;
    }

    public void que_soy(){
                    /*
    Funcion: void que_soy, esta funcion imprime por consola el nombre de la clase con sus parametros 

    Parametro: sin parametro
    
    Return: no retorna nada

    */
        System.out.print("Pieza (peso - "+ peso +")");
    }

    
    public void interactuar(Amarillo amarillo, Cyan cyan, Magenta magenta){
                  /*
    Funcion: void interactuar, verifica si la zona esta completada, en caso de estarlo llama a interactuar de la super clase zona. En caso contrario llama a la funcion
    levantar

    Parametro: Amarillo amarillo, Cyan cyan, Magenta magenta. Los 3 tipos de pikinim
    
    Return: no retorna nada
    */

        if (GetCompletada()){
            super.interactuar(amarillo, cyan, magenta);
        }else{
            levantar(amarillo, cyan, magenta);
        }
    }    


    public void levantar(Amarillo amarillo, Cyan cyan, Magenta magenta){
                  /*
    Funcion: void levantar, esta funcion verifica si la pieza se puede levantar, si es que se puede le resta 1 a piezas faltantes y completa la zona. En caso contrario
    imprime en pantalla

    Parametro: Amarillo amarillo, Cyan cyan, Magenta magenta. Los 3 tipos de pikinim
    
    Return: no retorna nada
    */
        boolean levantable; 

        int ama = amarillo.GetCantidad() * amarillo.GetCapacidad();
        int cya = cyan.GetCantidad() * cyan.GetCapacidad();
        int mag = magenta.GetCantidad() * magenta.GetCapacidad();

        if ((ama + cya + mag) >= peso){
            levantable = true;
        }else{
            levantable = false;
        }
        
        if ((this.completada == false) && levantable == true) {
            System.out.println("ENCONTRASTE UNA PIEZA");
            try {Thread.sleep(1500);}catch(Exception e){System.out.println(e);}
            SetCompletada(true);
            piezas_faltantes -= 1;

        }else{
            System.out.println("Tus pikinims no pueden levantar la pieza D:, vuelve con mas pikinims");
            try {Thread.sleep(1500);}catch(Exception e){System.out.println(e);}
        }
    }



    public int GetPeso(){
                  /*
    Funcion: int GetPeso, esta funcion es para obtener el valor de peso

    Parametro: si parametro
    
    Return: retorna el valor actual de peso
    */
        return peso;
    }

    public void SetPeso(int peso){
                   /*
    Funcion: void SetPeso, cambia el valor de peso

    Parametro: int peso, el nuevo valor de peso
    
    Return: no retorna nada
    */
        this.peso = peso;
    }

    public static int GetPiezas(){
                   /*
    Funcion: int GetPiezas, esta funcion es para obtener el valor de piezas faltantes 

    Parametro: sin parametro
    
    Return: retorna el valor actual de piezas_faltantes 
    */
        return piezas_faltantes;
    }

    public void SetPiezas(int piezas){
                   /*
    Funcion: SetPiezas, esta funcion es para cambiar el valor de piezas_faltantes 

    Parametro: int piezas, nuevo valor de piezas
    
    Return: no retorna nada
    */
        piezas_faltantes = piezas;
    }

}