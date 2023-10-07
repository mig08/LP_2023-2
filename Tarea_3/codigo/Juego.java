import java.util.Scanner;

public class Juego{
    public static void main(String[] args){

        int posicion = 5;
        int turno = 1;
        boolean gano = false;
        boolean perdio = false;

        Zona[] Zonas;
        Zonas = new Zona[11];

        Pieza p0 = new Pieza(50);
        Zonas[0] = p0;

        Enemigo p1 = new Enemigo(130, 20, 25);
        Zonas[1] = p1;

        Enemigo p2 = new Enemigo(50, 10, 15);
        Zonas[2] = p2;

        Pildora p3 = new Pildora(25);
        Zonas[3] = p3;

        Muralla p4 = new Muralla(50);
        Zonas[4] = p4;

        Pieza p5 = new Pieza(100);
        Zonas[5] = p5;

        Enemigo p6 = new Enemigo(45, 8, 10);
        Zonas[6] = p6;

        Pieza p7 = new Pieza(35);
        Zonas[7] = p7;

        Pildora p8 = new Pildora(15);
        Zonas[8] = p8;

        Enemigo p9 = new Enemigo(75, 15, 20);
        Zonas[9] = p9;

        Muralla p10 = new Muralla(150);
        Zonas[10] = p10;

        Amarillo amaPikinim = new Amarillo();
        Cyan cyaPikinim = new Cyan();
        Magenta magPikinim = new Magenta();

        Scanner scanner = new Scanner(System.in); // Crear un objeto Scanner
        System.out.println("Eres el capitán Lomiar. Tu nave chocó con un asteroide en tu viaje de rutina y ahora estas en un planeta extraño con criaturas extrañas. No hay oxigeno en este planeta. ¡Debes buscar las piezas de tu nave con la ayuda de los Pikinims y reparar la nave! Antes de que sea demasiado tarde...");
        System.out.println("");
        System.out.println("Tienes 30 horas...");
        System.out.println("");
        try {Thread.sleep(5000);}catch(Exception e){System.out.println(e);}
        while ((turno <= 30) && (perdio != true) && (gano != true)){
            System.out.println("TURNO "+ turno + " (Cyan - "+cyaPikinim.cantidad+", Amarillo - "+amaPikinim.cantidad+", Magenta - "+magPikinim.cantidad+")");
            System.out.println("Aun quedan "+Pieza.GetPiezas()+" piezas...");
            System.out.print("Zona Actual: ");
            Zonas[posicion].que_soy();
            System.out.println("");
            System.out.println("Opciones: ");
            System.out.print("1. Ir a la izquierda (");
            if (posicion-1 == -1){
                System.out.print("No hay mas alla");
            }else{
                Zonas[posicion-1].que_soy();
            }
            System.out.print(") ");
            System.out.print("2. Ir a la derecha (");
            if (posicion+1 == 11){
                System.out.print("No hay mas alla");
            }else{
                Zonas[posicion+1].que_soy();
            }
            System.out.print(") ");
            System.out.println("3. Quedarse aquí ");

            System.out.println("Estamos en posicion: "+posicion);
            System.out.print("Por favor ingresa un número: "); // Solicitar entrada al usuario
            int numero = 0;
            try {Thread.sleep(1000);}catch(Exception e){System.out.println(e);}
            numero =  scanner.nextInt(); // Leer un entero del usuario
            System.out.println("");
            switch (numero){
                case 1:
                    if ((Zonas[posicion].getClass().getName() == "Muralla") && !Zonas[posicion].GetCompletada()) {
                        System.out.println("Hay una muralla que impide el paso :o, para intentar romperla quedate en la zona");
                        try {Thread.sleep(2500);}catch(Exception e){System.out.println(e);}
                        turno-=1;
                    }else{
                        posicion-= 1;

                        if (posicion <= 0){
                            posicion = 0;
                            turno-=1;
                        }

                        Zonas[posicion].interactuar(amaPikinim, cyaPikinim, magPikinim);
                        }

                    break;
        
                case 2:
                    if ((Zonas[posicion].getClass().getName() == "Muralla") && !Zonas[posicion].GetCompletada()) {
                        System.out.println("Hay una muralla que impide el paso :o, para intentar romperla quedate en la zona");
                        turno-=1;

                    }else{

                        posicion += 1;
                        if (posicion >= 10){
                            posicion = 10;
                            turno-=1;
                        }
                        Zonas[posicion].interactuar(amaPikinim, cyaPikinim, magPikinim);

                    }
                    
                    break;

                case 3:
                    System.out.println("Decidimos quedarnos aca");
                    Zonas[posicion].interactuar(amaPikinim, cyaPikinim, magPikinim);

                    break;

            }
                
            if (amaPikinim.GetCantidad() == 0 && cyaPikinim.GetCantidad() == 0 && magPikinim.GetCantidad() == 0) {
                perdio = true;
            }
            

            turno+=1;
            if (Pieza.GetPiezas() == 0) {
                gano = true;
                
            }

            System.out.println("");
        }


        if (perdio == true){
            System.out.println("No quedan pikimins :c, perdiste");
            System.out.println("");
        }else if (gano == true){
            System.out.println("Conseguiste todas las piezas y pudiste volver vivo, ganaste c:");
            System.out.println("");
        }else if(turno == 31){
            System.out.println("Se acabaron las horas de oxigeno :c, perdiste");
            System.out.println("");
        }

        
        scanner.close();
        
    }


}