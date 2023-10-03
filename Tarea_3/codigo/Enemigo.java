import java.util.Scanner;
import  java.util.Random;

public class Enemigo extends Zona implements ILevantable{
    private int vida;
    private int peso;
    private int ataque;

    public Enemigo(int vida, int peso, int ataque){
        super();
        this.vida = vida;
        this.peso = peso;
        this.ataque = ataque;
    }


    public void que_soy(){
        System.out.print("Enemigo");
    }


    public void interactuar(Amarillo amarillo, Cyan cyan, Magenta magenta){
        boolean ganar_perder = Pelear(amarillo, cyan, magenta);

        if (ganar_perder == true){
            levantar(amarillo, cyan, magenta);
        }else{
            System.out.println("Sigue vivo :o con "+ vida +" de vida");
        }
        
    }    
    public void levantar(Amarillo amarillo, Cyan cyan, Magenta magenta){
        boolean levantable; 

        int ama = amarillo.cantidad * amarillo.capacidad;
        int cya = cyan.cantidad * cyan.capacidad;
        int mag = magenta.cantidad * magenta.cantidad;

        if ((ama + cya + mag) >= peso){
            levantable = true;
        }else{
            levantable = false;
        }
        if ((this.completada == false) && levantable == true){
            System.out.println("derrotado y levantado");

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
            scanner.close();


        }else{
            System.out.println("derrotado pero no levantado");
            completada = true;
        }


    }
    
    Random rand = new Random();
    public boolean Pelear(Amarillo amarillo, Cyan cyan, Magenta magenta){
        int total = 0;
        int ama = amarillo.cantidad * amarillo.ataque;
        int cya = cyan.cantidad * cyan.ataque;
        int mag = magenta.cantidad * magenta.ataque;

        total = ama + cya + mag;
        vida -= total;
        int pikinim_atacado = rand.nextInt(3);
        switch (pikinim_atacado) {
            case 0:
                if (amarillo.atacable()){
                    amarillo.cantidad -= ataque;
                    System.out.println("Amarillo fue atacado :c");

                }else{
                    pikinim_atacado = rand.nextInt(2);
                    switch (pikinim_atacado) {
                        case 0:
                            if(cyan.atacable()){
                                cyan.cantidad -= ataque;
                                System.out.println("Cyan fue atacado :c");
                            }else{
                                magenta.cantidad -= ataque;
                                System.out.println("Magenta fue atacado :c");
                            }


                            break;
                    
                        case 1:
                            if(magenta.atacable()){
                                magenta.cantidad -= ataque;
                                System.out.println("Magenta fue atacado :c");
                            }else{
                                cyan.cantidad -= ataque;
                                System.out.println("Cyan fue atacado :c");
                            }
                            break;
                    }
                }

                break;
        
            case 1:
                if (cyan.atacable()){
                    cyan.cantidad -= ataque;
                    System.out.println("Cyan fue atacado :c");

                }else{
                    pikinim_atacado = rand.nextInt(2);
                    switch (pikinim_atacado) {
                        case 0:
                            if(amarillo.atacable()){
                                amarillo.cantidad -= ataque;
                                System.out.println("Amarillo fue atacado :c");
                            }else{
                                magenta.cantidad -= ataque;
                                System.out.println("Magenta fue atacado :c");
                            }


                            break;
                    
                        case 1:
                            if(magenta.atacable()){
                                magenta.cantidad -= ataque;
                                System.out.println("Magenta fue atacado :c");
                            }else{
                                amarillo.cantidad -= ataque;
                                System.out.println("Amarillo fue atacado :c");
                            }
                            break;
                    }
                }
                break;
            case 2:
                if (magenta.atacable()){
                    magenta.cantidad -= ataque;
                    System.out.println("Magenta fue atacado :c");

                }else{
                    pikinim_atacado = rand.nextInt(2);
                    switch (pikinim_atacado) {
                        case 0:
                            if(cyan.atacable()){
                                cyan.cantidad -= ataque;
                                System.out.println("Cyan fue atacado :c");
                            }else{
                                amarillo.cantidad -= ataque;
                                System.out.println("Amarillo fue atacado :c");
                            }


                            break;
                    
                        case 1:
                            if(amarillo.atacable()){
                                amarillo.cantidad -= ataque;
                                System.out.println("Amarillo fue atacado :c");
                            }else{
                                cyan.cantidad -= ataque;
                                System.out.println("Cyan fue atacado :c");
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
        return vida;

    }
    public int GetPeso(){
        return peso;
    }

    public int GetAtaque(){
        return ataque;
    }
    public void SetVida(int vida){
        this.vida = vida;
    }

    public void SetPeso(int peso){
        this.peso = peso;
    }

    public void SetAtaque(int ataque){
        this.ataque = ataque;
    }

}