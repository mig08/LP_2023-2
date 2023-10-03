public class Juego{
    public static void main(String[] args){

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

    p5.levantar(amaPikinim,cyaPikinim,magPikinim);
    System.out.println(amaPikinim.GetAtaque());
    //p3.interactuar(amaPikinim, cyaPikinim, magPikinim);
    p10.interactuar(amaPikinim, cyaPikinim, magPikinim);
    p10.interactuar(amaPikinim, cyaPikinim, magPikinim);
    p10.interactuar(amaPikinim, cyaPikinim, magPikinim);
    p10.interactuar(amaPikinim, cyaPikinim, magPikinim);
    



    }


}