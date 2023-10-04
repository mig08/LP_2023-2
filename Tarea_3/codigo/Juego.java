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

        Zona p10 = new Muralla(150);
        Zonas[10] = p10;

        Amarillo amaPikinim = new Amarillo();
        Cyan cyaPikinim = new Cyan();
        Magenta magPikinim = new Magenta();
        
        Scanner scanner = new Scanner(System.in); // Crear un objeto Scanner
        while ((turno <= 30) && (perdio != true) && (gano != true)){
            System.out.println("Turno "+ turno + " (Cyan - "+cyaPikinim.cantidad+", Amarillo - "+amaPikinim.cantidad+", Magenta - "+magPikinim.cantidad+")");
            System.out.print("Zona Actual: ");
            Zonas[posicion].que_soy();
            System.out.println("");
            System.out.println("Opciones: ");
            System.out.print("1. Ir a la derecha (");
            if (posicion-1 == -1){
                System.out.print("No hay mas alla");
            }else{
                Zonas[posicion-1].que_soy();
            }
            System.out.print(") ");
            System.out.print("2. Ir a la izquierda (");
            if (posicion+1 == 11){
                System.out.print("No hay mas alla");
            }else{
                Zonas[posicion+1].que_soy();
            }
            System.out.print(") ");
            System.out.println("3. Quedarse aquí ");

            System.out.print("Por favor ingresa un número: "); // Solicitar entrada al usuario
            int numero = 0;
            numero =  scanner.nextInt(); // Leer un entero del usuario

            switch (numero) {
                case 1:
                    posicion-= 1;
                    if (posicion <= 0){
                        posicion = 0;
                    }
                    if(Zonas[posicion].GetCompletada()){
                        System.out.println("Se completo ya");
                    }else{
                        Zonas[posicion].interactuar(amaPikinim, cyaPikinim, magPikinim);
                    }
                    break;
        
                case 2:
                    posicion += 1;
                    if (posicion >= 10){
                        posicion = 10;
                    }
                    if(Zonas[posicion].GetCompletada()){
                        System.out.println("Se completo ya");
                    }else{
                        System.out.println("Hay cosas que hacer");
                        Zonas[posicion].interactuar(amaPikinim, cyaPikinim, magPikinim);
                    }
                    break;

                case 3:
                    System.out.println("Me quede aqui :3");
                    if(Zonas[posicion].GetCompletada()){
                        System.out.println("Se completo ya");
                    }else{
                        Zonas[posicion].interactuar(amaPikinim, cyaPikinim, magPikinim);
                    }
                    break;

            }
                
                
            
            turno+=1;
            System.out.println("");
        }
        scanner.close();
        


    }


}