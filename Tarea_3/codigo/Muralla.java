public class Muralla extends Zona{

    private int vida;

    public Muralla(int vida){
        super();
        this.vida = vida;
    }
    
    public int GetVida(){
        return vida;
    }

    public void SetVida(int vida){
        this.vida = vida;
    }

    public boolean TryRomper(Amarillo amarillo, Cyan cyan, Magenta magenta){
        
        
        return false;
    }

}

