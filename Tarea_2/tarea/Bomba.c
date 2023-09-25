#include "Tierra.h"
#include "Bomba.h"
#include "Tablero.h"



void TryExplotar(int fila, int columna){
    /*
    Funcion: void TryExplotar: Esta funcion le resta 1 al contador_turnos de la bomba en una casilla en especifica, si contador_turnos llega a 0, llama a su respectiva explosion


    Parametro: 
    int fila: fila de la bomba
    int columna: columna de la bomba
    
    Return: sin returns

    */

    Celda* celda = ((Celda*)tablero[fila-1][columna-1]);
    Bomba* bomb = (Bomba*)celda->estructura;
    bomb->contador_turnos -= 1;
    if (bomb->contador_turnos <= 0){
        bomb->explotar(fila,columna);
    }

    return;
}

void BorrarBomba(int fila, int columna){

    /*
    Funcion: void BorrarBomba: Esta funcion borra la bomba del tablero, sin antes devolver la tierra_debajo a la casilla

    Parametro: 
    int fila: fila de la bomba
    int columna: columna de la bomba
    
    Return: sin returns 

    */    
    Celda* celda = ((Celda*)tablero[fila-1][columna-1]);
    Bomba* aux = (Bomba*)celda->estructura;

    celda->estructura = aux->tierra_debajo;
    celda->tiene_bomba = 0;
    free(aux);

    
    return;
}

void ExplosionPunto(int fila, int columna){
    /*
    Funcion: void ExplosionPunto: Este tipo de explosion le quita toda la vida a una casilla en especifico

    Parametro:
    int fila: fila de la casilla
    int columna: columna de la casilla
   
    Return: sin returns 

    */
    Celda* celda = (Celda*)tablero[fila-1][columna-1];
    Bomba* bomb = (Bomba*)celda->estructura;

    bomb->tierra_debajo->vida -= 3;

    if (bomb->tierra_debajo->vida <= 0){
        bomb->tierra_debajo->vida = 0;
    }

    BorrarBomba(fila,columna);

    return;
}

void ExplosionX(int fila, int columna){

    /*
    Funcion: void ExplosionX: Este tipo de explosion en forma de Xle quita 1 de vida a algunas casillas tomando una casilla como central

    Parametro:
    int fila: fila de la casilla central
    int columna: columna de la casilla central

    Return: sin returns

    */
    int fila_centro = fila-1;
    int columna_centro = columna-1;
    
    int fila_arriba_izq = fila_centro - 1;
    int columna_arriba_izq = columna_centro - 1;

    int fila_abajo_der = fila_centro + 1;
    int columna_abajo_der = columna_centro + 1;

    int fila_arriba_der = fila_centro - 1;
    int columna_arriba_der = columna_centro + 1;

    int fila_abajo_izq = fila_centro + 1;
    int columna_abajo_izq = columna_centro - 1;

    Celda* celda_centro = (Celda*)tablero[fila_centro][columna_centro];
    Celda* celda_abajo_der = (Celda*)tablero[fila_abajo_der][columna_abajo_der];
    Celda* celda_abajo_izq = (Celda*)tablero[fila_abajo_izq][columna_abajo_izq];
    Celda* celda_arriba_der = (Celda*)tablero[fila_arriba_der][columna_arriba_der];
    Celda* celda_arriba_izq = (Celda*)tablero[fila_arriba_izq][columna_arriba_izq];
    
    
    Bomba* bomb = (Bomba*)celda_centro->estructura;
    bomb->tierra_debajo->vida -= 1;
    ((Tierra*)celda_abajo_der->estructura)->vida -= 1;
    ((Tierra*)celda_abajo_izq->estructura)->vida -= 1;
    ((Tierra*)celda_arriba_izq->estructura)->vida -= 1;
    ((Tierra*)celda_arriba_der->estructura)->vida -= 1;

    BorrarBomba(fila,columna);


    return;
}