; 1) Definir funciones que devuelvan como resultado:
;   a) El máximo de dos números.
;   b) El máximo de una secuencia.
;   c) El primer átomo de una secuencia.
;   d) El elemento mínimo entre los máximos por fila de una matriz (minimax).

; 2) Definir funciones que determinen:
;   a) La pertenencia de un elemento a una secuencia.
;   b) Si una secuencia tiene un solo componente.
;   c) Si la cantidad de átomos de una secuencia es par. 

; 3) Dada una secuencia con dos subsecuencias, definir funciones para determinar:
;   a) La unión de ambas subsecuencias.
;   b) La intersección de ambas subsecuencias.
;   c) La diferencia de ambas subsecuencias.
;   d) La diferencia simétrica de ambas subsecuencias.

; 4) Definir una función que aplicada sobre un número natural n; obtenga como
; resultado el máximo valor resultante de aplicar cierta función B (predefinida)
; sobre el intervalo natural que finaliza en n (Máximo entre B:1; B:2; ... B:n).

; 5) Dada una matriz de números enteros, definir una función que obtenga la
; sumatoria de los números mayores que 0 de las columnas pares. 

; 6) Dado un número n, generar la siguiente secuencia (sin recursividad):
; <<1>, <1, 2>, <1, 2, 3>, <1, 2, 3, 4>, ... <1, 2, 3, 4, ... n>> 

; 7) Dada una secuencia de pares ordenados donde la primera componente indica el
; equipo que resultó ganador y la segunda indica el perdedor y donde cada par
; ordenado indica un partido jugado (no hay empates) obtener:
;   a) Los equipos invictos.
;   b) Los que siempre perdieron.
;   c) Los que ganaron más veces de las que perdieron.
;   d) Los que perdieron más veces de las que ganaron.
;   e) Los que perdieron y ganaron la misma cantidad de veces. 



;;; 1.a) El maximo de dos numeros.

(defn maximo-de-dos [a b]
  (if (>= a b)
    a
    b))

;;; 1. b) El máximo de una secuencia.

(defn maximo-de-secuencia [numeros]
  (when (seq numeros)
    (reduce maximo-de-dos numeros)))

;;; 1. c) El primer átomo de una secuencia.

(defn primer-atomo [sequencia] 
  (first (filter (complement sequential?) sequencia)))

  
;;; 1. d) El elemento mínimo entre los máximos por fila de una matriz (minimax).
(defn minimax [matriz] 
      (reduce min (map maximo-de-secuencia matriz)))


; 2) Definir funciones que determinen:

;   a) La pertenencia de un elemento a una secuencia.

"Si encuentra un elemento que es igual al buscado, some retorna ese valor (que es truthy)"

(defn pertenece? [elemento secuencia]
  (some #(= elemento %) secuencia))

;   b) Si una secuencia tiene un solo componente.

(defn sec-un-componente? [sec] (= (count sec) 1))

;   c) Si la cantidad de átomos de una secuencia es par.
(defn cant-par-de-atomos? [sec] (even? (count (filter (complement sequential?) sec))))

// filter (complement sequential?) devueleve una secuencia con solo los átomos de la secuencia original, y luego se cuenta esa secuencia para determinar si es par o no.


;;; 3) Dada una secuencia con dos subsecuencias, definir funciones para determinar:

;   a) La unión de ambas subsecuencias.

(defn union [sec1 sec2] (distinct (concat sec1 sec2)))

;   b) La intersección de ambas subsecuencias.  

(defn interseccion [sec1 sec2] (filter #(pertenece? % sec2) sec1))

;   c) La diferencia de ambas subsecuencias.

(defn diferencia [sec1 sec2] (filter #(not (pertenece? % sec2)) sec1))

; sec1 = [1 2 3]
; sec2 = [2 3 5]
; diferencia sec1 sec2 = [1]
; diferencia sec2 sec1 = [1 5]
; concatenar ambas diferencias = [1 1 5]

;  d) La diferencia simétrica de ambas subsecuencias.

sec1 = [1 2 3]
sec2 = [3 4 5]

; diferencia simetrica = [1 2 4 5]

(defn diferencia-simetrica [sec1 sec2] (distinct (concat (diferencia sec1 sec2) (diferencia sec2 sec1))))


;  (distinct [1 2 4 4 5 5]) -> [1 2 4 5]



