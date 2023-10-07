public class Muralla extends Zona{
    private int vida;

    public Muralla(int vida){
    /*
    Funcion: constructor muralla, crea un objeto de la clase muralla

    Parametro: int vida, valor de la vida de la muralla
    
    Return: constructor
    */
        super();
        this.vida = vida;
    }
    
    public void que_soy(){
             /*
    Funcion: void que_soy, esta funcion imprime por consola el nombre de la clase con sus parametros 

    Parametro: sin parametro
    
    Return: no retorna nada

    */
        System.out.print("Muralla (vida - "+GetVida()+")");
    }


    public int GetVida(){
                  /*
    Funcion: int GetVida, esta funcion es para poder usar el valor de vida de la muralla fuera de la clase

    Parametro: sin parametro
    
    Return: retorna el valor actual de vida
    */
        return vida;
    }

    public void SetVida(int vida){
                  /*
    Funcion: void SetVida, esta funcion es para poder cambiar el valor de vida 

    Parametro: int vida, el nuevo valor de vida
    
    Return: sin retorno
    */
        this.vida = vida;
    }

    public void interactuar(Amarillo amarillo, Cyan cyan, Magenta magenta){
                  /*
    Funcion: void interactuar, esta funcion verifica si la zona esta completada, en caso de estarlo llama a interactuar de la super clase zona. En caso contrario
    llama a la funcion tryRomper, si esta retorna true, cambia el valor de completada de la zona 

    Parametro: Amarillo amarillo, Cyan cyan, Magenta magenta, los 3 tipos de pikinim
    
    Return: sin retorno
    */
        if (GetCompletada()){
            super.interactuar(amarillo, cyan, magenta);
        }else{
            boolean se_rompe = TryRomper(amarillo, cyan, magenta);
            if (se_rompe == true){
                SetCompletada(true);
            }else{
                return;
            }

        }
    }    

    public boolean TryRomper(Amarillo amarillo, Cyan cyan, Magenta magenta){
                  /*
    Funcion: boolean TryRomper, esta funcion le resta a la vida de la muralla

    Parametro: Amarillo amarillo, Cyan cyan, Magenta magenta. Los 3 tipos de pikinim
    
    Return: retorna un booleano, true si es que se rompio, false si la vida es mayor a 0
    */
        int total = 0;
        int ama = amarillo.GetCantidad() * amarillo.GetAtaque();
        int cya = cyan.GetCantidad()* cyan.GetAtaque();
        int mag = magenta.GetCantidad() * magenta.GetAtaque();

        total = ama + cya + mag;

        vida -= total;
        if (vida < 0) {
            vida = 0;
        }

        if (vida > 0){
            System.out.println("La muralla esta bien dura, tus pikinim la golpearon pero no se cayo D:");
            System.out.println("vida restante: " + vida);
            try {Thread.sleep(2500);}catch(Exception e){System.out.println(e);}
            return false;
        }else{
            System.out.println("Despues de algunos ataques se rompio la muralla :), ahora puedes continuar tu camino");
            try {Thread.sleep(2500);}catch(Exception e){System.out.println(e);}
            return true;
        }

    }

}
