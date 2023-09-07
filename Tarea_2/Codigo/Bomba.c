#include "Tierra.h"
#include "Tablero.h"
#include "Bomba.h"

void TryExplotar(int fila, int columna){
    // Su codigo
    return;
}

void BorrarBomba(int fila, int columna){
    
    Celda* celda = ((Celda*)tablero[fila-1][columna-1]);
    Bomba* aux2 = (Bomba*)celda->estructura;

    celda->estructura = aux2->tierra_debajo;
    celda->tiene_bomba = 0;
    free(aux2);

    
   // Bomba* aux2= celda->estructura;//Bomba

    //celda->estructura = ((Bomba*)celda->estructura)->tierra_debajo; //tierra
    //celda->tiene_bomba = 0;
    //free(aux2);

    return;
}

void ExplosionPunto(int fila, int columna){
    // Su codigo
    return;
}

void ExplosionX(int fila, int columna){
    // Su codigo
    return;
}
 