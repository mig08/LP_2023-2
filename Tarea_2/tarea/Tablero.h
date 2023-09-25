#ifndef TABLERO_H
#define TABLERO_H
#include <stdlib.h>

typedef struct Celda{
    void* estructura;
    int tiene_bomba;
    int tesoro_descubierto;
} Celda;


extern void*** tablero;
extern int dimension;
extern int turnos;
extern int contador_tesoros;

Bomba* crear_bomba(int tipo_bomba);
void IniciarTablero(int n);
void PasarTurno();
void ColocarBomba(Bomba* b, int fila, int columna);
void MostrarTablero();
void MostrarBombas();
void VerTesoros();
void BorrarTablero();
#endif