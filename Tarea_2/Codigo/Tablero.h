#ifndef TABLERO_H
#define TABLERO_H
#include "Bomba.h"
#include <stdlib.h>

/*
typedef struct Celda{
    Bomba* bomb;
    Tierra* tierra_celda;
    int tiene_bomba;
} Celda;
*/

void*** tablero;
int dimension; // 7 en 7x7, 10 en 10x10, 12 en 12x12

void IniciarTablero(int n);
void PasarTurno();
void ColocarBomba(Bomba* b, int fila, int columna);
void MostrarTablero();
void MostrarBombas();
void VerTesoros();
void BorrarTablero();
#endif