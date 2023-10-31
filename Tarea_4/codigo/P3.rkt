#lang scheme

(define(largo lista)
  ; ; Esta funcion es un reemplazo de length
; ;
; ; lista: Esta es la lista que se va a contar el largo

  (if (null? lista)
      0
      (+ 1 (largo(rest lista)))))

(define (chekear cantidad lista)
  ; ; Esta funcion llama a largo y despues saca la diferencia entre cantidad y el largo, en caso de ser iguales retorna 0
; ;
; ; cantidad :cantidad que deberia haber en la lista
; ; lista : lista de cuantos ingredientes de un tipo hay

  (if (null? lista)
      0
      (let ((x (largo (first lista))))
        (if (= x cantidad)
        0
        (let ((dif (- cantidad x)))
          dif)))))
  

(define (obtener_ingrediente lista)
  ; ; Esta funcion obtiene el nombre del ingrediente
; ;
; ; lista : lista donde solo esta el nombre del ingrediente

  (let ((ingrediente (first lista)))
    (first ingrediente)))
  

(define (revisar_lista stock lista_final)
  ; ; Esta funcion revisa todas las listas de stock, si el valor de chekear es 0, llama a la funcion de nuevo, el caso contrario es cuando
  ; ; el valor de chekear es distinto de 0, entonces mete en lista_final el valor de chekear y el ingrediente
  
; ; stock : Lista de listas donde cada lista tiene la cantidad que deberia haber y una lista con la cantidad de ingredientes que hay
; ; lista_final : lista que se retornará con las listas con la cantidad faltante y el nombre del ingrediente

  (if (null? stock)
      lista_final
      (let* ((listita (first stock)) 
             (cant (first listita)))
        (if (null? (rest listita))
            (revisar_lista (rest stock) lista_final)
            (let ((valor (chekear cant (rest listita))))
              (if (<= valor 0)
                  (revisar_lista (rest stock) lista_final)
                  (let* ((ingrediente (obtener_ingrediente (rest listita)))
                         (lista_ingrediente (cons ingrediente '()))
                         (lista_valor_ingre (cons valor lista_ingrediente))
                         (lista_valor_ingre_f (cons lista_valor_ingre lista_final)))
                    (revisar_lista (rest stock) lista_valor_ingre_f))))))))

(define (armar_lista stock)
  ; ; Llama a revisar_lista con los parametros de stock y una lista vacia, luego da vuelta la lista resultante
; ;
; ; stock : Lista de listas donde cada lista tiene la cantidad que deberia haber y una lista con la cantidad de ingredientes que hay


  (reverse(revisar_lista stock '())))
      
    


(armar_lista '((3 (cebolla cebolla)) (3 (tomate tomate tomate)) (2 (ajo))))
