% codigo de cerradura usado
cerradura(1, 4, 5, 1, 0).

% caso para cuando el promedio es igual a 0
evaluar_promedio(Promedio, 'Contrasena descubierta'):-
    Promedio =:= 0.

% caso para cuando el promedio es menor a 1 pero distinto de 0
evaluar_promedio(Promedio, 'Cerca'):-
    Promedio < 1,
    Promedio =\= 0.

% caso para resto de valores de promedio
evaluar_promedio(_, 'Lejos').

% primero se recupera los valores de cerradura, luego se crea variables
% de las diferencias de cada uno. Para terminar se define el promedio y se llama
% a evaluar_promedio
verificar(X1, X2, X3, X4, X5, R):-
    cerradura(C1, C2, C3, C4, C5),
    DiffAbs1 is abs(X1 - C1),
    DiffAbs2 is abs(X2 - C2),
    DiffAbs3 is abs(X3 - C3),
    DiffAbs4 is abs(X4 - C4),
    DiffAbs5 is abs(X5 - C5),
    PromedioDelta is (DiffAbs1 + DiffAbs2 + DiffAbs3 + DiffAbs4 + DiffAbs5) / 5,
    evaluar_promedio(PromedioDelta, R),!.




