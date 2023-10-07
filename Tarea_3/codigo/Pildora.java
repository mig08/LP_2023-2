import java.util.Scanner;
public class Pildora extends Zona{
    private int cantidad;

    public Pildora(int cantidad){
            /*
    Funcion: Constructor de Pildora, crea la clase pildora

    Parametro: int cantidad: cantidad deseada de pildora
    
    Return: constructor

    */
        super();
        this.cantidad = cantidad;
    }


    public void que_soy(){
            /*
    Funcion: void que_soy, esta funcion imprime por consola el nombre de la clase con sus parametros 

    Parametro: sin parametro
    
    Return: no retorna nada

    */
        System.out.print("Pildora (cantidad - "+GetCantidad()+")");
    }

    public void SetCantidad(int cantidad){
            /*
    Funcion: void SetCantidad, esta funcion permite cambiar el valor de cantidad a gusto 

    Parametro: int cantidad, el nuevo valor de cantidad
    
    Return: no retorna nada

    */
        this.cantidad = cantidad;
    }
   
    public int GetCantidad(){
            /*
    Funcion: int GetCantidad, esta funcion permite rescatar el valor de cantidad para usarlo fuera de la clase

    Parametro: sin parametro
    
    Return: retorna el valor actual de cantidad

    */
        return cantidad;
    }
    
    public void interactuar(Amarillo amarillo, Cyan cyan, Magenta magenta){
            /*
    Funcion: void interactuar, esta funcion verifica si la zona esta completada (en caso de estarlo, llama a interactuar de la super clase). Si es que no esta completada
    le pide al usuario un numero para que elija un pikinim que multiplicar y le aumenta el valor de la cantidad al pikinim elegido

    Parametro: Amarillo amarillo, Cyan cyan, Magenta magenta. se necesitan los 3 tipos de pikinim para elegir a uno de ellos
    
    Return: no retorna nada

    */
        if (GetCompletada()){
            super.interactuar(amarillo, cyan, magenta);
        }else{
            Scanner sc = new Scanner(System.in); // Crear un objeto Scanner
            System.out.println("Qué color de pikinim desea que se multiplique? (cantidad a multiplicar: " + cantidad + ")");
            System.out.println("1.Cyan 2.Magenta 3.Amarillo");
    
            System.out.print("Por favor ingresa un número: "); // Solicitar entrada al usuario
            int numero = sc.nextInt(); // Leer un entero del usuario
    
            switch (numero) {
                case 1:
                    cyan.multiplicar(cantidad);
                    System.out.println("Los Pikinim cyan han aumentado su cantidad a "+ cyan.GetCantidad()+".");
                    break;
        
                case 2:
                    magenta.multiplicar(cantidad);
                    System.out.println("Los Pikinim magenta han aumentado su cantidad a "+ magenta.GetCantidad()+".");
    
                    break;
    
                case 3:
                    amarillo.multiplicar(cantidad);
                    System.out.println("Los Pikinim amarillos han aumentado su cantidad a "+ amarillo.GetCantidad()+".");
    
                    break;
    
            }
            try {Thread.sleep(2500);}catch(Exception e){System.out.println(e);}
            SetCompletada(true);
    
            

        }
    
    }   


}