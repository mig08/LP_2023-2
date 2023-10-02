public class Juego {
    public static void main(String[] args){

    Zona[] Zonas;
    Zonas = new Zona[11];

    Zona p0 = new Pieza(50);
    Zonas[0] = p0;

    Zona p1 = new Enemigo(130, 20, 25);
    Zonas[1] = p1;

    Zona p2 = new Enemigo(50, 10, 15);
    Zonas[2] = p2;

    Zona p3 = new Pildora(25);
    Zonas[3] = p3;

    Zona p4 = new Muralla(50);
    Zonas[4] = p4;

    Zona p5 = new Pieza(100);
    Zonas[5] = p5;

    Zona p6 = new Enemigo(45, 8, 10);
    Zonas[6] = p6;

    Zona p7 = new Pieza(35);
    Zonas[7] = p7;

    Zona p8 = new Pildora(15);
    Zonas[8] = p8;

    Zona p9 = new Enemigo(75, 15, 20);
    Zonas[9] = p9;

    Zona p10 = new Muralla(150);
    Zonas[10] = p10;

    Pikinim amaPikinim = new Amarillo();
    Pikinim cyaPikinim = new Cyan();
    Pikinim magPikinim = new Magenta();

    


    

    }


}
