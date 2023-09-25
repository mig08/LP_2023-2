#include "Tierra.h"
#include "Bomba.h"
#include "Tablero.h"
#include <stdio.h>
#include <stdlib.h>
#include <time.h>



int main(int argc, char const *argv[])
{
    srand(time(0));
    int tam;
    printf("¡Bienvenido a TreasureFinder!\n ");
    printf("Ingrese tamaño de tablero: ");
    printf("\n (1) 7x7      (2) 10x10       (3) 12x12");
    printf("\n");
    printf("Su respuesta: ");
    scanf("%d", &tam);
    switch (tam)
    {
    case 1:
        tam = 7;
        break;
    
    case 2:
        tam = 10;
        break;

    case 3:
        tam = 12;
        break;
    
    }

    IniciarTablero(tam);
    printf("\nEmpezando el juego, suerte c:");
    printf("\n");
    int x = 10;
    
    while (x != 0 && contador_tesoros > 1){
        int fila = 0;
        int columna = 0;
        int tipo_bomba = 0;
        printf("Tablero (Turno %d)\n", turnos);
        MostrarTablero();
        printf("\nContador tesoros: %d", contador_tesoros);
        printf("\nSeleccione una accion: ");
        printf("\n(1) Colocar Bomba    (2) Mostrar Bombas    (3) Mostrar Tesoros ");
        printf("\nEscoja una opcion: ");
        scanf("%d", &x);
        
        switch (x){
        
            case 1:
                printf("Indique coordenadas de la bomba");
                printf("\nFila: ");
                scanf("%d", &fila);
                printf("Columna: ");
                scanf("%d", &columna);
                printf("\n");
                printf("Indique forma en que explota la bomba\n 1.Punto  2.X \n");
                printf("Su input: ");
                scanf("%d",&tipo_bomba);
                switch (tipo_bomba){
                case 1:
                    ColocarBomba(crear_bomba(1),fila,columna);
                    break;
                
                case 2:
                    ColocarBomba(crear_bomba(2),fila,columna);
                    break;
                }
                PasarTurno();
                break;


            case 2:
                MostrarBombas();
                break;

            case 3:
                printf("Aqui estan los tesoros: \n");
                VerTesoros();
                printf("\n");


                break;

        }
    }
    BorrarTablero();
    printf("¡Felicidades Ganaste!\n");
    
    return 0;
}

/* EJEMPLOS DE RANDOM PARA FACILITAR SU USO.
*
*   srand(time(0)); // Setea la seed del random.
*   int ejemplo_vida = (rand() % 3) + 1; // Obtiene al azar la vida de Tierra a asignar.
*/