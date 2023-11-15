% codigo de cerradura usado
cerradura(1, 4, 5, 1, 0).

% caso para cuando son iguales, en caso de serlo se retorna 1
evaluar_igualdad(X, C, 1):-
    X = C.

% caso para cuando son distintos, en caso de serlo se retorna 0
evaluar_igualdad(X, C, 0):-
    X \= C.

% si Cant_aciertos es 5, se retorna 'Contraseña descubierta'
evaluar_coincidencias(5, 'Contrasena descubierta').

% se retorna la cantidad de aciertos
evaluar_coincidencias(Aciertos, Aciertos).

%se recupera los valores de cerradura y los compara con evaluar_igualdad
% luego se define Cant_aciertos como la suma de los aciertos y se evalua
% en evaluar_coincidencias
verificar(X1, X2, X3, X4, X5, R):-
    cerradura(C1, C2, C3, C4, C5),
    evaluar_igualdad(X1, C1, A1),
    evaluar_igualdad(X2, C2, A2),
    evaluar_igualdad(X3, C3, A3),
    evaluar_igualdad(X4, C4, A4),
    evaluar_igualdad(X5, C5, A5),
    Cant_aciertos is A1 + A2 + A3 + A4 + A5,
    evaluar_coincidencias(Cant_aciertos, R),!.
