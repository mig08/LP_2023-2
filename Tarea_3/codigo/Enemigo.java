import java.util.Scanner;
import  java.util.Random;

public class Enemigo extends Zona implements ILevantable{
    private int vida;
    private int peso;
    private int ataque;

    public Enemigo(int vida, int peso, int ataque){
                  /*
    Funcion: constructor enemigo, crea un objeto de la clase enemigo

    Parametro: int vida, vida del enemigo
    int peso, peso del enemigo
    int ataque, ataque del enemigo
    
    Return: constructor del enemigo
    */
        super();
        this.vida = vida;
        this.peso = peso;
        this.ataque = ataque;
    }


    public void que_soy(){
                    /*
    Funcion: void que_soy, esta funcion imprime por consola el nombre de la clase con sus parametros 

    Parametro: sin parametro
    
    Return: no retorna nada

    */
        System.out.print("Enemigo (vida - "+GetVida()+", peso - "+GetPeso()+", ataque - "+GetAtaque()+")");
    }


    public void interactuar(Amarillo amarillo, Cyan cyan, Magenta magenta){
                  /*
    Funcion: void interactuar, primero verifica si la zona esta completada, en caso de estarlo llama al interactuar de la super clase. En caso contrario crea una variable
    de tipo bool y la iguala a la funcion pelear. Si es true, llama a la funcion levantar, en caso contrario el enemigo sigue vivo

    Parametro: Amarillo amarillo, Cyan cyan, Magenta magenta, los 3 tipos de pikinim
    
    Return: no retorna nada
    */
        if (GetCompletada()){
            super.interactuar(amarillo, cyan, magenta);
        }else{
            boolean ganar_perder = Pelear(amarillo, cyan, magenta);
            
            if (ganar_perder == true){
                levantar(amarillo, cyan, magenta);
            }else{
                System.out.println("Sigue vivo :o con "+ vida +" de vida");
            }

        }

        
    }    
    public void levantar(Amarillo amarillo, Cyan cyan, Magenta magenta){
                  /*
    Funcion: void levantar, esta funcion verifica si el enemigo se puede levantar con los pikinims disponibles, si es que se puede levantar multiplica los pikinims y se
    completa la zona. En caso contrario no se multiplica nada pero igualmente se completa la zona

    Parametro: Amarillo amarillo, Cyan cyan, Magenta magenta. Los 3 tipos de pikinim
    
    Return: no retorna nada
    */
        boolean levantable; 

        int ama = amarillo.GetCantidad() * amarillo.GetCapacidad();
        int cya = cyan.GetCantidad()* cyan.GetCapacidad();
        int mag = magenta.GetCantidad()* magenta.GetCapacidad();

        if ((ama + cya + mag) >= peso){
            levantable = true;
        }else{
            levantable = false;
        }
        if ((this.completada == false) && levantable == true){
            System.out.println("");
            System.out.println("Con esta victoria tus pikinims se llevan al enemigo a la base");
            System.out.println("");
            System.out.println("Qué color de pikinim desea que se multiplique? (cantidad a multiplicar: " + peso + ")");
            System.out.println("1.Cyan 2.Magenta 3.Amarillo");
            Scanner scanner = new Scanner(System.in); // Crear un objeto Scanner

            System.out.print("Por favor ingresa un número: "); // Solicitar entrada al usuario
            int numero = scanner.nextInt(); // Leer un entero del usuario

            switch (numero){
                case 1:
                    cyan.multiplicar(peso);
                    System.out.println("Los Pikinim cyan han aumentado su cantidad en "+ cyan.GetCantidad()+".");
                    break;
    
                case 2:
                    magenta.multiplicar(peso);
                    System.out.println("Los Pikinim magenta han aumentado su cantidad en "+ magenta.GetCantidad()+".");

                    break;

                case 3:
                    amarillo.multiplicar(peso);
                    System.out.println("Los Pikinim amarillos han aumentado su cantidad en "+ amarillo.GetCantidad()+".");

                    break;

            }
            completada = true;



        }else{
            System.out.println("");
            System.out.println("Ganaste, pero no tienes los pikinims suficientes para levantar al enemigo... Lo vamos a dejar aca");
            completada = true;
        }


    }
    
    Random rand = new Random();
    public boolean Pelear(Amarillo amarillo, Cyan cyan, Magenta magenta){
                  /*
    Funcion: boolean pelear, en esta funcion se le resta vida al enemigo y se le resta a cantidad el valor de ataque a un pikinim al azar

    Parametro: Amarillo amarillo, Cyan cyan, Magenta magenta. Los 3 tipos de pikinim
    
    Return: retorna un booleano, true si la vida del enemigo es menor o igual a 0, false en caso contrario
    */
        int total = 0;
        int ama = amarillo.GetCantidad() * amarillo.GetAtaque();
        int cya = cyan.GetCantidad()* cyan.GetAtaque();
        int mag = magenta.GetCantidad()* magenta.GetAtaque();

        total = ama + cya + mag;
        System.out.println("Tus pikinim se unen y logran hacerle "+total+" de daño al enemigo");
        vida -= total;
        if (vida < 0) {
            vida = 0;
        }
        int pikinim_atacado = rand.nextInt(3);
        switch (pikinim_atacado) {
            case 0:
                if (amarillo.atacable()){
                    amarillo.disminuir(ataque);
                    System.out.println("Al enemigo no le gusta el color amarillo, se comió "+GetAtaque()+" pikinims amarillos");
                    try {Thread.sleep(2500);}catch(Exception e){System.out.println(e);}

                }else{
                    pikinim_atacado = rand.nextInt(2);
                    switch (pikinim_atacado) {
                        case 0:
                            if(cyan.atacable()){
                                cyan.disminuir(ataque);
                                System.out.println("Cyan miro feo al enemigo, a este no le gustó eso... perdiste "+GetAtaque()+" pikinims cyan");
                                try {Thread.sleep(2500);}catch(Exception e){System.out.println(e);}
                            }else{
                                magenta.disminuir(ataque);
                                System.out.println("Magenta llego al lugar equivocado, en un momento equivocado. Perdiste "+GetAtaque()+" pikimins magenta");
                                try {Thread.sleep(2500);}catch(Exception e){System.out.println(e);}

                            }


                            break;
                    
                        case 1:
                            if(magenta.atacable()){
                                magenta.disminuir(ataque);
                                System.out.println("Magenta insulto al enemigo, este le pegó un tate quieto. Perdiste "+GetAtaque()+" pikimins magenta");
                                try {Thread.sleep(2500);}catch(Exception e){System.out.println(e);}
                            }else{
                                cyan.disminuir(ataque);
                                System.out.println("Cyan intento escapar, pero el enemigo fue mas rapido. Perdiste "+GetAtaque()+" pikimins cyan");
                                try {Thread.sleep(2500);}catch(Exception e){System.out.println(e);}
                            }
                            break;
                    }
                }

                break;
        
            case 1:
                if (cyan.atacable()){
                    cyan.disminuir(ataque);
                    System.out.println("Tus pikinims cyan saltan para proteger a los amarillos. Perdiste "+GetAtaque()+" pikinims cyan");
                    try {Thread.sleep(2500);}catch(Exception e){System.out.println(e);}

                }else{
                    pikinim_atacado = rand.nextInt(2);
                    switch (pikinim_atacado) {
                        case 0:
                            if(amarillo.atacable()){
                                amarillo.disminuir(ataque);
                                System.out.println("Los pikinims amarillos se lanzan a vengar a los cyan, no salio bien. Perdiste "+GetAtaque()+" pikinims amarillos");
                                try {Thread.sleep(2500);}catch(Exception e){System.out.println(e);}
                            }else{
                                magenta.disminuir(ataque);
                                System.out.println("Otro ataque va dirigido a los pikinims amarillos, los magenta los empujan fuera del alcance de ataque! Perdiste "+GetAtaque()+" pikinims magenta");
                                try {Thread.sleep(2500);}catch(Exception e){System.out.println(e);}
                            }


                            break;
                    
                        case 1:
                            if(magenta.atacable()){
                                magenta.disminuir(ataque);
                                System.out.println("Los pikinims magenta vieron el sacrificio de los cyan, se lanzaron solos al enemigo! pero salio mal. Perdiste "+GetAtaque()+" pikinims magenta");
                                try {Thread.sleep(2500);}catch(Exception e){System.out.println(e);}
                            }else{
                                amarillo.disminuir(ataque);
                                System.out.println("Los pikinims amarillos no van a dejar que este sacrificio sea en vano... Se lanzan al enemigo! no salio bien. Perdiste "+GetAtaque()+" pikimins amarillos");
                                try {Thread.sleep(2500);}catch(Exception e){System.out.println(e);}
                            }
                            break;
                    }
                }
                break;
            case 2:
                if (magenta.atacable()){
                    magenta.disminuir(ataque);
                    System.out.println("Tus pikinims magenta se mandaron un Leeroy Jenkins! Perdiste "+GetAtaque()+" pikinims magenta");
                    try {Thread.sleep(2500);}catch(Exception e){System.out.println(e);}
                }else{
                    pikinim_atacado = rand.nextInt(2);
                    switch (pikinim_atacado) {
                        case 0:
                            if(cyan.atacable()){
                                cyan.disminuir(ataque);
                                System.out.println("Por el descuido de los pikinims magenta, tus pikinims cyan fueron atacados. Perdiste "+GetAtaque()+" pikinims cyan");
                                try {Thread.sleep(2500);}catch(Exception e){System.out.println(e);}
                            }else{
                                amarillo.disminuir(ataque);
                                System.out.println("Tus pikinims amarillos se intentan hacer los héroes. Perdiste "+GetAtaque()+" pikinims amarillos");
                                try {Thread.sleep(2500);}catch(Exception e){System.out.println(e);}
                            }


                            break;
                    
                        case 1:
                            if(amarillo.atacable()){
                                amarillo.disminuir(ataque);
                                System.out.println("Tus pikinims amarillos no pueden contener su ira! Se tiran a golpear al enemigo. Perdiste "+GetAtaque()+" pikinims amarillos");
                                try {Thread.sleep(2500);}catch(Exception e){System.out.println(e);}
                            }else{
                                cyan.disminuir(ataque);
                                System.out.println("El enemigo hace un ataque que tus pikinims no puedon ver... Fue muy rapido. Perdiste "+GetAtaque()+" pikinims cyan");
                                try {Thread.sleep(2500);}catch(Exception e){System.out.println(e);}
                            }
                            break;
                    }
                }

                break;
        }
        if (vida <= 0){
            return true;
        }else{
            return false;

        }
        
        
    }
    
    public int GetVida(){
                  /*
    Funcion: int GetVida, funcion para obtener el valor de vida

    Parametro: sin parametro
    
    Return: retorna el valor actual de vida
    */
        return vida;

    }
    public int GetPeso(){
                  /*
    Funcion: int GetPeso, funcion para obtener el valor de peso 

    Parametro: si parametro
    
    Return: retorna el valor actual de peso
    */
        return peso;
    }

    public int GetAtaque(){
                  /*
    Funcion: int GetAtaque, funcion para obtener el valor de ataque 

    Parametro: sin parametro
    
    Return: retorna el valor actual de parametro 
    */
        return ataque;
    }
    public void SetVida(int vida){
                  /*
    Funcion: void SetVida, funcion para poder cambiar el valor de vida

    Parametro: int vida, en nuevo valor de vida
    
    Return: no retorna nada
    */
        this.vida = vida;
    }

    public void SetPeso(int peso){
                  /*
    Funcion: void SetPeso, funcion para cambiar el valor de peso 

    Parametro: int peso, nuevo valor de peso
    
    Return: no retorna nada
    */
        this.peso = peso;
    }

    public void SetAtaque(int ataque){
                  /*
    Funcion: void SetAtaque, funcion para cambiar el valor de ataque 

    Parametro: int ataque, nuevo valor de ataque
    
    Return: no retorna nada
    */
        this.ataque = ataque;
    }

}