#lang scheme

(define (cantidades_simple base lista)
  (if (null? lista)
      '()
      (let ((resultado ((first lista) base)))
        (cons resultado (cantidades_simple base (rest lista))))))


(define (operaciones ope resultado base)
    (if (null? ope)
        (reverse resultado)
        (operaciones (rest ope) (cons ((first ope) base) resultado) base)))
  
(define (cantidades_cola base lista)
  (operaciones lista '() base))  


(cantidades_cola 2 (list (lambda (x) (/ x 2)) (lambda (x) (* x 3)) 
(lambda (x) (- x 2))))

(cantidades_cola 2 (list (lambda (x) (/ (+ x 2) 2)) (lambda (x) (* x 
4)) (lambda (x) (* (/ x 3) 2))))

(cantidades_cola 2 '())


















