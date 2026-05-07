; 1) Definir funciones que devuelvan como resultado:
;   a) El máximo de dos números.
;   b) El máximo de una secuencia.
;   c) El primer átomo de una secuencia.
;   d) El elemento mínimo entre los máximos por fila de una matriz (minimax).

a) 
(defn maximo [a b]
  (if (> a b)
    a
    b))


b)
(defn maxSecuencia[a] (last(sort a)))


c)
(defn primeroSecuencia[a] (first a))


d)
(defn minSecuencia[a] (first(sort a)))

(defn minimax [a]
  (minSecuencia (map maxSecuencia a)))