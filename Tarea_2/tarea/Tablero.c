#include "Tierra.h"
#include "Bomba.h"
#include "Tablero.h"
#include <stdio.h>

void*** tablero;
int dimension; // 7 en 7x7, 10 en 10x10, 12 en 12x12
int turnos = 1;
int contador_tesoros = 0;

Bomba* crear_bomba(int tipo_bomba){

    /*
    Funcion Bomba* crear_bomba: Esta funcion crea una bomba con memoria dinamica para poder usarla globalmente, tambien tiene como parametro el tipo de explosion
    que se le va a asignar a esta nueva bomba.
    
    Parametros: tipo int (1 o 2) el tipo de explosion que tendra la bomba 

    Return: Un puntero al struct Bomba    
    */
    Bomba* bomb = (Bomba*)malloc(sizeof(Bomba));

    switch (tipo_bomba){
        case 1:
            bomb->explotar = ExplosionPunto;
            bomb->contador_turnos = 1;
            break;
                
        case 2:
            bomb->explotar = ExplosionX;
            bomb->contador_turnos = 3;
            break;
        }
    return bomb;
}




void IniciarTablero(int n){

    /*
    Funcion void IniciarTablero: Esta funcion crea el tablero void*** con memoria dinamica y con tierra inicialmente en todas sus casillas

    Parametros: int n es el tamaño NxN del tablero
    
    Returns: No retorna nada
    */

    dimension = n;
    tablero = (void***)malloc(n * sizeof(void**));
    for (int i = 0; i < n; i++){
        tablero[i] = (void**)malloc(n * sizeof(void*));
        for (int j = 0; j < n; j++){
            tablero[i][j] = (void*)malloc(n * sizeof(Celda*));
            Celda* celda = (Celda*)tablero[i][j];
            Tierra* tierra = (Tierra*)malloc(sizeof(Tierra));
            celda->estructura =(Tierra*)tierra;
            ((Tierra*)celda->estructura)->vida = (rand() % 3) + 1;
            ((Tierra*)celda->estructura)->es_tesoro = ((rand() % 100) < 5);
            celda->tesoro_descubierto = 0;
            if (((Tierra*)celda->estructura)->es_tesoro){
                contador_tesoros++;
            }

        }
    }
    return;  
}  



void PasarTurno(){

    /*
    Funcion: void PasarTurno: Esta funcion aumenta en 1 la cantidad de turnos y llama a la funcion TryExplotar 

    Parametro: Sin parametro

    Return: Sin return

    */

    for (int i = 0; i < dimension; i++){
        for (int j = 0; j < dimension; j++){
            Celda* celda = (Celda*)tablero[i][j];
            if (celda->tiene_bomba == 1){
                TryExplotar(i+1,j+1);


            }
        }    
    
    }
    turnos++;
    return;
}


void ColocarBomba(Bomba* b, int fila, int columna){
    /*
    Funcion: Esta funcion void ColocarBomba lo que hace es guardar la tierra de la casilla en la bomba->tierra_debajo y luego coloca la bomba en la casilla del tablero

    Parametro: 
    
    Bomba* b: Esta es la bomba creada en la funcion CrearBomba, tiene las caracteristicas ya listas (Tipo de explosion y cantidad de turnos)
    int fila: La fila donde se va a colocar la bomba
    int columna: columna donde se va a colocar la bomba

    Return: Sin return

    */

    Celda* celda = (Celda*)tablero[fila-1][columna-1];
    
    Tierra* aux = celda->estructura;
    
    b->tierra_debajo = aux;


    celda->estructura = (Bomba*)b;
    celda->tiene_bomba = 1;
    
    return;
}


void MostrarTablero(){

    /*
    Funcion: Void mostrarTablero: Esta funcion muestra el tablero con las vidas, tesoros descubiertos y bombas colocadas

    Parametro: sin parametro

    Return: sin returns

    */
    for (int i = 0; i < dimension; i++) { 
        int cont = 0;
        for (int j = 0; j < dimension; j++){  
            Celda* celda = (Celda*)tablero[i][j];
            if (cont == 0){
                printf(" ");

                if (celda->tiene_bomba == 1){
                    printf("o");

                }else{
                    if (((Tierra*)celda->estructura)->vida == 0 && ((Tierra*)celda->estructura)->es_tesoro){
                        printf("*");
                        if (celda->tesoro_descubierto == 0){
                            contador_tesoros--;
                            celda->tesoro_descubierto = 1;
 
                        }
                        
                    }else{
                        printf("%d", ((Tierra*)celda->estructura)->vida);
                    }
                }

                
            }    
                    
            else{
                printf(" | ");
 
                if (celda->tiene_bomba == 1){
                    printf("o");

                }else{
                    if (((Tierra*)celda->estructura)->vida == 0 && ((Tierra*)celda->estructura)->es_tesoro){
                        printf("*");
                        if (celda->tesoro_descubierto == 0){
                            contador_tesoros--;
                            celda->tesoro_descubierto = 1;
 
                        }
                        
                    }else{
                        printf("%d", ((Tierra*)celda->estructura)->vida);
                    }
                }  


             
            }

            if (cont == dimension-1){
                printf("\n");
            }

            cont++;            
          
        }
    }      
    
    return;
    
}


void MostrarBombas(){

    /*
    Funcion: void MostrarBombas: Esta funcion muestra las bombas activas en el tablero con sus respectivas caracteristicas

    Parametro: sin parametros

    Return: sin returns

    */
    for (int i = 0; i < dimension; i++){
        for (int j = 0; j < dimension; j++){

            Celda* celda = (Celda*)tablero[i][j];
            Bomba* bomb = (Bomba*)celda->estructura;

            if (celda->tiene_bomba == 1){
                printf("\nTurnos para explotar: %d",bomb->contador_turnos);
                printf("\nCoordenada: ");
                printf("(%d, ",i+1);
                printf("%d)", j+1);
                printf("\nForma Explosión: X");
                printf("\nValor tierra debajo: %d\n",(bomb->tierra_debajo)->vida);
                printf("\n");
                
               
            }
            

        }
        
    }
    

    return;
}


void VerTesoros(){

    /*
    Funcion: void verTesoros: Esta funcion muestra un tablero donde los tesoros estan a la vista

    Parametro: sin parametros

    Return: sin returns

    */
    for (int i = 0; i < dimension; i++) { 
        int cont = 0;
        for (int j = 0; j < dimension; j++){  
            Celda* celda = (Celda*)tablero[i][j];
            if (cont == 0){
                printf(" ");

                if (celda->tiene_bomba){
                    if (((Tierra*)celda->estructura)->es_tesoro){
                        printf("*");
                    }
                    

                }else{
                    printf("%d", ((Tierra*)celda->estructura)->vida);
                }
                
            }    
                    
            
            else{
                printf(" | ");

                if (((Tierra*)celda->estructura)->es_tesoro){
                    printf("*");

                }else{
                    printf("%d", ((Tierra*)celda->estructura)->vida);
                }

             
            }

            if (cont == dimension-1){
                printf("\n");
            }

            cont++;            
          
        }
    }    
    return;
}


void BorrarTablero(){

    /*
    Funcion: void BorrarTablero: Esta funcion libera la memoria dinamica del tablero y sus casillas. Estas pueden ser de tipo tierra o de tipo bomba
    
    Parametro: sin parametros

    Return: sin returns

    */
    for (int i = 0; i < dimension; i++) {
        for (int j = 0; j < dimension; j++){     
            if (((Celda*)tablero[i][j])->tiene_bomba == 1){
                BorrarBomba(i+1,j+1);
            }
            free(((Celda*)tablero[i][j])->estructura);
            free(tablero[i][j]);
        }
        free(tablero[i]);
    }
    free(tablero);
    return;
}