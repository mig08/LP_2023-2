#include "Tierra.h"
#include "Tablero.h"
#include "Bomba.h"

void TryExplotar(int fila, int columna){
    // Su codigo
    return;
}

void BorrarBomba(int fila, int columna){
    int cont_fila = 0;
    int cont_colum = 0;
    
    for (int i = 0; i < fila-1; i++){
        cont_fila++;
    }
    for (int j = 0; j < columna-1; j++){
        cont_colum++;
    }   
    
    Celda* celda = (Celda*)tablero[cont_fila][cont_colum];
    Tierra* tierra;
    ((Bomba*)celda->estructura)->tierra_debajo = tierra;
    free(celda->estructura);
    celda->estructura = (void*)tierra;    
    
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
 