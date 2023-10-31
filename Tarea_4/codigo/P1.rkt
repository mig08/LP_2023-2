#lang scheme


(define(largo lista)
  ; ; Esta funcion es un reemplazo de length
; ;
; ; lista: Esta es la lista que se va a contar el largo

  (if (null? lista)
      0
      (+ 1 (largo(rest lista)))))

(define (chekear cantidad lista)
  ; ; Esta funcion compara cantidad con el resultado de la funcion largo
; ;
; ; cantidad : Este es el numero que se va a comparar
; ; lista: Lista a la que se sacara el largo

  (let ((x (largo lista)))
    (if (= x cantidad)
        true
        false)))

(chekear 4 '(a b c d))
(chekear 2 '(a a c d e w w q t a v))
(chekear 0 '())