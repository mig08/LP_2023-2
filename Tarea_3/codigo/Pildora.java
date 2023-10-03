import java.util.Scanner;
public class Pildora extends Zona{
    private int cantidad;

    public Pildora(int cantidad){
        super();
        this.cantidad = cantidad;
    }

    public void SetCantidad(int cantidad){
        this.cantidad = cantidad;
    }
   
    public int GetCantidad(){
        return cantidad;
    }

    public void interactuar(Amarillo amarillo, Cyan cyan, Magenta magenta){
        System.out.println("Qué color de pikinim desea que se multiplique? (cantidad a multiplicar: " + cantidad + ")");
        System.out.println("1.Cyan 2.Magenta 3.Amarillo");
        Scanner scanner = new Scanner(System.in); // Crear un objeto Scanner

        System.out.print("Por favor ingresa un número: "); // Solicitar entrada al usuario
        int numero = scanner.nextInt(); // Leer un entero del usuario

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
        scanner.close();
    
    }   


}