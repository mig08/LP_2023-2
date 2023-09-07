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

    Bomba b;
    srand(time(0));
    printf("Ingrese tamaño de tablero: ");
    printf("\n");
    int tam;
    scanf("%d", &tam);

    IniciarTablero(tam);
    MostrarTablero();
    ColocarBomba(&b, 1, 2);
    printf("\n");
    MostrarTablero();
    printf("\n");
    ColocarBomba(&b, 1, 1);
    printf("\n");
    MostrarTablero();
    printf("\n");
    BorrarBomba(1,1);
    printf("\n");
    VerTesoros();
    BorrarTablero();

    return 0;
}

/* EJEMPLOS DE RANDOM PARA FACILITAR SU USO.
*
*   srand(time(0)); // Setea la seed del random.
*   int ejemplo_vida = (rand() % 3) + 1; // Obtiene al azar la vida de Tierra a asignar.
*/
