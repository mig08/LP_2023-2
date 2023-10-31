#lang scheme

(define (cantidades_simple base lista)
  ; ; Esta funcion reemplaza los valores de "x" en las funciones lambda de lista, usando recursion simple
; ;
; ; base : valor de numero "x"
; ; lista : Lista con funciones lambda 

  (if (null? lista)
      '()
      (let ((resultado ((first lista) base)))
        (cons resultado (cantidades_simple base (rest lista))))))


(define (operaciones ope resultado base)
  ; ; Descripción de la función
; ;
; ; ope : Lista de operaciones que se van a realizar
; ; resultado : Lista donde se guardaran los resultados
; ; base : Numero "x" que se va a reemplazar en las operaciones 

    (if (null? ope)
        (reverse resultado)
        (operaciones (rest ope) (cons ((first ope) base) resultado) base)))
  
(define (cantidades_cola base lista)
  ; ; Esta funcion llama a operaciones para resolver las funciones de lista
; ;
; ; lista : Lista de funciones lambda a realizar
; ; base : numero "x" que se usará

  (operaciones lista '() base))  


(cantidades_cola 2 (list (lambda (x) (/ x 2)) (lambda (x) (* x 3)) 
(lambda (x) (- x 2))))

(cantidades_cola 2 (list (lambda (x) (/ (+ x 2) 2)) (lambda (x) (* x 
4)) (lambda (x) (* (/ x 3) 2))))

(cantidades_cola 2 '())


















