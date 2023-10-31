#lang scheme

(define (ingrediente_in_lista ingrediente lista)
  ; ; revisa si la lista de recetas es vacia, luego rescata la primera receta y se usa member para buscar el ingrediente en la receta, en caso de estarlo
  ; ; se construye una lista con el primer valor de receta (nombre de la receta) y se llama a la funcion de nuevo para ver si el ingrediente esta en mas recetas
  ; ;
  ; ; ingrediente : ingrediente que se buscará en las recetas 
  ; ; lista : lista de con las recetas

  (if (null? lista)
      '()
      (let ((receta (first lista)))        
        (if (member ingrediente receta)
            (cons (first receta) (ingrediente_in_lista ingrediente (rest lista)))
            (ingrediente_in_lista ingrediente (rest lista))))))


(define (buscar_recetas ingrediente lista)
  ; ; revisa si el ingrediente que se busca es vacio, luego llama a la funcion ingrediente_in_lista
  ; ;
  ; ; ingrediente : ingrediente que se va a buscar en las recetas
  ; ; lista : lista de listas con las recetas 

  (if (null? ingrediente)
      '()
      (let ((ingr (first ingrediente)))
        (ingrediente_in_lista ingr lista))))
    


