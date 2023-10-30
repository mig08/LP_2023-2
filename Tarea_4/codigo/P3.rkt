#lang scheme

(define(largo lista)
  (if (null? lista)
      0
      (+ 1 (largo(rest lista)))))

(define (chekear cantidad lista)
  (if (null? lista)
      0
      (let ((x (largo (first lista))))
        (if (= x cantidad)
        0
        (let ((dif (- cantidad x)))
          dif)))))
  

(define (obtener_ingrediente lista)
  (let ((ingrediente (first lista)))
    (first ingrediente)))
  

(define (revisar_lista stock lista_final)
  (if (null? stock)
      lista_final
      (let* ((listita (first stock)) 
             (cant (first listita)))
        (if (null? (rest listita))
            (revisar_lista (rest stock) lista_final)
            (let ((valor (chekear cant (rest listita))))
              (if (= valor 0)
                  (revisar_lista (rest stock) lista_final)
                  (let* ((ingrediente (obtener_ingrediente (rest listita)))
                         (lista_ingrediente (cons ingrediente '()))
                         (lista_valor_ingre (cons valor lista_ingrediente))
                         (lista_valor_ingre_f (cons lista_valor_ingre lista_final)))
                    (revisar_lista (rest stock) lista_valor_ingre_f))))))))

(define (armar_lista stock)
  (reverse(revisar_lista stock '())))
      
    


(armar_lista '((5 (cebolla cebolla)) (3 (tomate tomate tomate)) 
(2 (ajo))))
