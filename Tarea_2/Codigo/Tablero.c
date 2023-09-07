#include "Tierra.h"
#include "Tablero.h"
#include "Bomba.h"

void IniciarTablero(int n){
    dimension = n;
    tablero = (void***)malloc(n * sizeof(void**));
    for (int i = 0; i < n; i++){
        tablero[i] = (void**)malloc(n * sizeof(void*));
        for (int j = 0; j < n; j++){
            tablero[i][j] = (void*)malloc(n * sizeof(Celda*));
            Celda* celda = (Celda*)tablero[i][j];
            Tierra* tierra = (Tierra*)malloc(sizeof(Tierra));
            celda->estructura = (void*)tierra;
            //Celda* celda = (Celda*)tablero[i][j];
            
            //((Tierra*)tablero[i][j])->vida = (rand() % 3) + 1;
            ((Tierra*)celda->estructura)->vida = (rand() % 3) + 1;
            //((Tierra*)tablero[i][j])->es_tesoro = ((rand() % 100) < 5);
            ((Tierra*)celda->estructura)->es_tesoro = ((rand() % 100) < 5);
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
    Celda* celda = (Celda*)tablero[cont_fila][cont_colum];
    
    Tierra* aux = celda->estructura;
    
    //Tierra* tierra = (Tierra*)malloc(sizeof(Tierra));
    //tierra->vida = 100;
    //tierra->es_tesoro = 1;
    free(((Tierra*)celda->estructura));
    // Asigna memoria para una instancia de Bomba
    Bomba* bomba = (Bomba*)malloc(sizeof(Bomba));
    b = bomba;
    bomba->contador_turnos = 3; // Por ejemplo
    bomba->explotar = NULL; // Debes asignar una función adecuada aquí
    bomba->tierra_debajo = aux;

// ...

    // Luego, asigna bomba a celda
    celda->estructura = (void*)bomba;
    celda->tiene_bomba = 1;
    

    return;
}


void MostrarTablero(){
    for (int i = 0; i < dimension; i++) { 
        int cont = 0;
        for (int j = 0; j < dimension; j++){  
            Celda* celda = (Celda*)tablero[i][j];
            if (cont == 0){
                printf(" ");
                //printf("%d", ((Tierra*)tablero[i][j])->vida);
                if (celda->tiene_bomba == 1){
                    printf("o");

                }else{
                    printf("%d", ((Tierra*)celda->estructura)->vida);
                }
                
            }    
                    
            else{
                printf(" | ");
                //printf("%d", ((Tierra*)tablero[i][j])->vida);
                ///printf("%d", celda->vida);
                if (celda->tiene_bomba == 1){
                    printf("o");

                }else{
                    printf("%d", ((Tierra*)celda->estructura)->vida);
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
            Celda* celda = (Celda*)tablero[i][j];
            if (cont == 0){
                printf(" ");
                //printf("%d", ((Tierra*)tablero[i][j])->vida);
                if (((Tierra*)celda->estructura)->es_tesoro){
                    printf("*");

                }else{
                    printf("%d", ((Tierra*)celda->estructura)->vida);
                }
                
            }    
                    
            
            else{
                printf(" | ");
                //printf("%d", ((Tierra*)tablero[i][j])->vida);
                ///printf("%d", celda->vida);
                if (((Tierra*)celda->estructura)->es_tesoro){
                    printf("*");

                }else{
                    printf("%d", ((Tierra*)celda->estructura)->vida);
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
            Celda* celda = (Celda*)tablero[i][j];
            free(celda->estructura);          
            free(tablero[i][j]);
        }
        free(tablero[i]);
    }
    free(tablero);
    return;
}