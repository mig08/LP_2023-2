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



    public void levantar(Amarillo amarillo, Cyan cyan, Magenta magenta){

    }

    public boolean Pelear(Amarillo amarillo, Cyan cyan, Magenta magenta){
        
        
        return false;
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
