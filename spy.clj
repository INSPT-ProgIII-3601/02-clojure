(defn spy
  "Utilidad de depuración: Imprime el valor de una expresión (con o sin un mensaje) sin alterar su resultado.
  Ideal para inspeccionar datos en pipelines o funciones de orden superior.
  No usar en producción."
  ([x] (do (prn x) x))
  ([msg x] (do (print msg) (print ": ") (prn x) x)))

;; Calcula el cuadrado de los números pares, observando el resultado de 'filter'
(map #(* % %)
     (spy "Números pares" (filter even? (range 10))))
;; Salida en consola:
;; Números pares: (0 2 4 6 8)
;; => (0 4 16 36 64)

;; (map #(spy "resultado del cuad" (* % (spy "valor que llego a la f anonima" %)))
;;     (spy "Números pares" (filter even? (spy "rango10" (range 10)))))

;; Suma los números de una lista de forma recursiva, espiando el estado en cada llamada
(defn sum-recursive [numbers]
  (spy "Sumando" numbers) ;; Espía el 'numbers' en cada llamada recursiva
  (if (empty? numbers)
    0
    (+ (first numbers) (spy "res" (sum-recursive (rest numbers)))))
)

(sum-recursive [1 2 3 4])
;; Salida en consola:
;; Sumando: (1 2 3 4)
;; Sumando: (2 3 4)
;; Sumando: (3 4)
;; Sumando: (4)
;; Sumando: ()
;; => 10




