#include "Tierra.h"
#include "Tablero.h"
#include "Bomba.h"

void IniciarTablero(int n){
    dimension = n;
    tablero = (void***)malloc(n * sizeof(void**));
    for (int i = 0; i < n; i++){
        tablero[i] = (void**)malloc(n * sizeof(void*));
        for (int j = 0; j < n; j++){
            tablero[i][j] = (void*)malloc(n * sizeof(Bomba*));
            
            Bomba* celda = (Bomba*)tablero[i][j];

            celda->tierra_debajo = (Tierra*)malloc(sizeof(Tierra));
            //Celda* celda = (Celda*)tablero[i][j];
            
            //((Tierra*)tablero[i][j])->vida = (rand() % 3) + 1;
            celda->tierra_debajo->vida = (rand() % 3) + 1;
            //((Tierra*)tablero[i][j])->es_tesoro = ((rand() % 100) < 5);
            celda->tierra_debajo->es_tesoro = ((rand() % 100) < 5);
            //printf("%d",((Tierra*)tablero[i][j])->vida);

        }
    }
    return;  
}  

void PasarTurno(){
    // Su codigo
    return;
}


void ColocarBomba(Bomba* b, int fila, int columna){
    int cont_fila = 0;
    int cont_colum = 0;
    
    for (int i = 0; i < fila-1; i++){
        cont_fila++;
    }
    for (int j = 0; j < columna-1; j++){
        cont_colum++;
    }
    Bomba* celda = (Bomba*)tablero[cont_fila][cont_colum];
    b = celda;
    celda->contador_turnos = 1;
    

    return;
}


void MostrarTablero(){
    for (int i = 0; i < dimension; i++) { 
        int cont = 0;
        for (int j = 0; j < dimension; j++){  
            Bomba* celda = (Bomba*)tablero[i][j];
            if (cont == 0){
                printf(" ");
                //printf("%d", ((Tierra*)tablero[i][j])->vida);
                if (celda->contador_turnos != 0){
                    printf("o");

                }else{
                    printf("%d", celda->tierra_debajo->vida);
                }
                
            }    
                    
            else{
                printf(" | ");
                //printf("%d", ((Tierra*)tablero[i][j])->vida);
                ///printf("%d", celda->vida);
                if (celda->contador_turnos != 0){
                    printf("o");

                }else{
                    printf("%d", celda->tierra_debajo->vida);
                }
                    //printf("%d", celda->tierra_celda.vida);
             
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
    for (int i = 0; i < dimension; i++){
        for (int j = 0; j < dimension; j++){

        }
        
    }
    

    return;
}


void VerTesoros(){
    for (int i = 0; i < dimension; i++) { 
        int cont = 0;
        for (int j = 0; j < dimension; j++){  
            Bomba* celda = (Bomba*)tablero[i][j];
            if (cont == 0){
                printf(" ");
                //printf("%d", ((Tierra*)tablero[i][j])->vida);
                if (celda->tierra_debajo->es_tesoro){
                    printf("*");

                }else{
                    printf("%d", celda->tierra_debajo->vida);
                }
                
            }    
                    
            
            else{
                printf(" | ");
                //printf("%d", ((Tierra*)tablero[i][j])->vida);
                ///printf("%d", celda->vida);
                if (celda->tierra_debajo->es_tesoro){
                    printf("*");

                }else{
                    printf("%d", celda->tierra_debajo->vida);
                }
                    //printf("%d", celda->tierra_celda.vida);
             
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
    for (int i = 0; i < dimension; i++) {
        for (int j = 0; j < dimension; j++){
            Bomba* celda = (Bomba*)tablero[i][j];
            free(celda->tierra_debajo);
            free(tablero[i][j]);
        }
        free(tablero[i]);
    }
    free(tablero);
    return;
}