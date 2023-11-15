cifrado([0,0], a).
cifrado([0,1], g).
cifrado([1,0], c).
cifrado([1,1], t).

% caso de lista vacia para la recursion
descifrar([], []).

% primero revisa los primeros dos numero de la lista y los relaciona
% con una letra, luego con recursion repute los pasos
descifrar([X1, X2 | Resto], [Letra | Mensaje]):-
    cifrado([X1, X2], Letra),
    descifrar(Resto, Mensaje).
