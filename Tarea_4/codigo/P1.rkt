#lang scheme

(define(largo lista)
  (if (null? lista)
      0
      (+ 1 (largo(rest lista)))))

(define (chekear cantidad lista)
  (let ((x (largo lista)))
    (if (= x cantidad)
        true
        false)))

(chekear 0 '())