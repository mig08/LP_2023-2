import java.util.Scanner;
public class Pildora extends Zona{
    private int cantidad;

    public Pildora(int cantidad){
        super();
        this.cantidad = cantidad;
    }


    public void que_soy(){
        System.out.print("Pildora");
    }

    public void SetCantidad(int cantidad){
        this.cantidad = cantidad;
    }
   
    public int GetCantidad(){
        return cantidad;
    }
    
    public void interactuar(Amarillo amarillo, Cyan cyan, Magenta magenta){
        Scanner sc = new Scanner(System.in); // Crear un objeto Scanner
        System.out.println("Qué color de pikinim desea que se multiplique? (cantidad a multiplicar: " + cantidad + ")");
        System.out.println("1.Cyan 2.Magenta 3.Amarillo");

        System.out.print("Por favor ingresa un número: "); // Solicitar entrada al usuario
        int numero = sc.nextInt(); // Leer un entero del usuario

        switch (numero) {
            case 1:
                cyan.multiplicar(cantidad);
                System.out.println("Los Pikinim cyan han aumentado su cantidad en "+ cyan.GetCantidad()+".");
                break;
    
            case 2:
                magenta.multiplicar(cantidad);
                System.out.println("Los Pikinim magenta han aumentado su cantidad en "+ magenta.GetCantidad()+".");

                break;

            case 3:
                amarillo.multiplicar(cantidad);
                System.out.println("Los Pikinim amarillos han aumentado su cantidad en "+ amarillo.GetCantidad()+".");

                break;

        }
        
        completada = true;
        
        // No olvides cerrar el Scanner al terminar de usarlo
        sc.close();
    
    }   


}