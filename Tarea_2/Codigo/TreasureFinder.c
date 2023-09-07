#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include "Tierra.h"
#include "Tablero.h"
#include "Tablero.c"
#include "Bomba.h"
#include "Bomba.c"

int main(int argc, char const *argv[])
{
    srand(time(0));
    int tam;
    Bomba* bomb;
    bomb = (Bomba*)malloc(sizeof(Bomba));
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
    
    default:
        break;
    }

    IniciarTablero(tam);
    printf("\nEmpezando el juego, suerte <:");
    printf("\n");
    int x;
    
    while (x != 4){
        MostrarTablero();
        printf("(1) Colocar Bomba    (2) Mostrar Bombas   (3) Mostrar Tesoros");
        printf("\nSeleccione una accion: ");
        scanf("%d", &x);
        
        switch (x){
        
            case 1:
                int fila;
                int columna;
                printf("Indique coordenadas de la bomba");
                printf("\nFila: ");
                scanf("%d", &fila);
                printf("Columna: ");
                scanf("%d", &columna);
                ColocarBomba(bomb,fila,columna);


                break;


            case 2:

                break;

            case 3:

                break;


            case 4:
                printf("Gracias por jugar\n");
                BorrarTablero();
                break;
        }
    }
    

    return 0;
}

/* EJEMPLOS DE RANDOM PARA FACILITAR SU USO.
*
*   srand(time(0)); // Setea la seed del random.
*   int ejemplo_vida = (rand() % 3) + 1; // Obtiene al azar la vida de Tierra a asignar.
*/
