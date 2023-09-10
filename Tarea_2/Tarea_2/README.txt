Nombre: Martin Ibañez
Rol: 202273597-K
Instrucciones: Para utilizar el programa es necesario que esten en la misma carpeta: Bomba.c, Bomba.h, Tablero.c, Tablero.h, Tierra.h, TreasureFinder.c
Luego compilarlo con el Makefile. 

Se agrego la funcion crear_bomba para crear bombas con sus parametros personalizados
tambien las variables globales: Turnos y contador_tesoros
y el struct "celda": contiene un puntero void para apuntar al struct tierra/bomba y un int tiene_bomba (0 = no, 1 = si)para ver si el puntero void esta apuntando al struct bomba y un int tesoro_descubierto (0 = no y 1 = si)
