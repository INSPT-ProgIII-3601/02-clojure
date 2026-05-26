; Librería de funciones reutilizables

; Determina si un elemento pertenece a una secuencia
(defn pertenece? [elemento secuencia]
  (some #(= elemento %) secuencia))

; Calcula la intersección de dos secuencias
; (elementos que están en ambas)
(defn interseccion [sec1 sec2]
  (filter #(pertenece? % sec2) sec1))

; Calcula la diferencia de dos secuencias
; (elementos de sec1 que NO están en sec2)
(defn diferencia [sec1 sec2]
  (filter #(not (pertenece? % sec2)) sec1))

; Calcula la diferencia simétrica de dos secuencias
; (elementos en una pero no en ambas)
(defn diferencia-simetrica [sec1 sec2]
  (distinct (concat (diferencia sec1 sec2) (diferencia sec2 sec1))))

; Calcula la unión de dos secuencias
; (todos los elementos sin duplicados)
(defn union [sec1 sec2]
  (distinct (concat sec1 sec2)))

; Determina el máximo entre dos números
(defn maximo-de-dos [a b]
  (if (>= a b)
    a
    b))

; Determina el máximo de una secuencia
(defn maximo-de-secuencia [numeros]
  (when (seq numeros)
    (reduce maximo-de-dos numeros)))

; Determina el mínimo entre los máximos por fila de una matriz (minimax)
(defn minimax [matriz]
  (reduce min (map maximo-de-secuencia matriz)))
