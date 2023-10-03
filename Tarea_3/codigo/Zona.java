public class Zona {
    protected boolean completada;
    
    Zona(){
        completada = false;
    }
    

    public void que_soy(){
        System.out.print("Zona");
    }

    public void interactuar(Amarillo amarillo, Cyan cyan, Magenta magenta){
        if (completada == true){
            System.out.println("No queda nada que hacer aqui");
            return;
        }else{
            return;
        }
    }    


    public boolean GetCompletada(){
        return completada;
    }

    public void SetCompletada(boolean completada){
        this.completada = completada;

    }
    
}
