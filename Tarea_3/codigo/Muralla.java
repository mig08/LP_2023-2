public class Muralla extends Zona{
    private int vida;

    public Muralla(int vida){
        super();
        this.vida = vida;
    }
    
    public void que_soy(){
        System.out.print("Muralla");
    }


    public int GetVida(){
        return vida;
    }

    public void SetVida(int vida){
        this.vida = vida;
    }

    public void interactuar(Amarillo amarillo, Cyan cyan, Magenta magenta){
        boolean se_rompe = TryRomper(amarillo, cyan, magenta);
        if (se_rompe == true){
            completada = true;
        }else{
            return;
        }
    }    

    public boolean TryRomper(Amarillo amarillo, Cyan cyan, Magenta magenta){
        int total = 0;
        int ama = amarillo.cantidad * amarillo.ataque;
        int cya = cyan.cantidad * cyan.ataque;
        int mag = magenta.cantidad * magenta.ataque;

        total = ama + cya + mag;

        vida -= total;

        if (vida > 0){
            System.out.println("vida restante: " + vida);
            return false;
        }else{
            System.out.println("Se rompio la muralla :)");
            return true;
        }

    }

}
