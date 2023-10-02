public class Pieza extends Zona implements ILevantable {
    private int peso;

    public Pieza(int peso){
        super();
        this.peso = peso;
    }


    public void interactuar(Amarillo amarillo, Cyan cyan, Magenta magenta){
        levantar(amarillo, cyan, magenta);
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
        
        
        if ((this.completada == false) && levantable == true) {
            System.out.println("");
        }
    }



    public int GetPeso(){
        return peso;
    }

    public void SetPeso(int peso){
        this.peso = peso;
    }

}
