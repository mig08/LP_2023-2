#lang scheme

(define (buscar_nodo utensilio arbol)
  ; ; primero revisa si arbol es vacio, en caso de serlo es porque no encontro el utensilio. Luego revisa si el nodo actual es igual a utensilio, si lo es devuelve una lista del valor
  ; ; mas el camino de vuelta. Si es que no es igual, llama a la funcion por la izquierda y despues por la derecha. Si encontro por el lado izquierdo añade a una lista el camino, en el caso
  ; ; del derecho hace una lista con el lado derecho
; ;
; ; utensilio : utensilio que se buscará
; ; arbol : arbol a recorrer
  
  (cond ((null? arbol) #f)  
        ((eqv? utensilio (first arbol)) (list utensilio))  
        (else
         (let ((izq (buscar_nodo utensilio (cadr arbol)))  
               (der (buscar_nodo utensilio (caddr arbol))))  
           (if izq
               (cons (first arbol) izq)
               der)))))  

(define (buscar_utensilio utensilio arbol)
  ; ; Esta funcion revisa si utensilio es vacio, si es vacio retorna "no esta". En caso de no serlo se saca utensilio de la lista y llama a buscar_nodo, si es que buscar_nodo retorna #f entonces se imprime "no esta"
  ; ; en caso contrario se retorna la lista del resultado de buscar_nodo sin el primer valor
; ;
; ; utensilio : una lista donde que contiene lo que se quiere buscar
; ; arbol : arbol que se recorrerá
  (if (null? utensilio)
      "no esta"
      (let* ((ute (first utensilio))
             (resultado (buscar_nodo ute arbol)))
        (if resultado
            (reverse(rest (reverse resultado))) 
            "no está"))))
  

(buscar_utensilio '(vaso) '(cocina
             (arriba (alacena (gabinete () (vaso () ())) (vaso () ())) (estante (tenedor () ()) (batidor () ())))
                                           (abajo (taburete (vaso () ()) ()) (cajon (batidor () ()) (tenedor () ())))))

(buscar_utensilio '(vaso) '())
