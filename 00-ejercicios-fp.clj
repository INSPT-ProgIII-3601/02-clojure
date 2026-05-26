; 1) Definir funciones que devuelvan como resultado:
;======================================================================================================
;a) El máximo de dos números.
;v1

(defn maxV1Entre2Num [a b]
  (if (= a b)
    "Son iguales"
    (if (< a b)
      b
      a)))

;======================================================================================================
;v2

(defn maxV2Entre2Num [a b]
  (if (= a b)
    "Son iguales"
    (max a b)))

;======================================================================================================
;b) El máximo de una coleccion 

;v1 Apply desarma una coleccion en muchos argumetos

(defn maxCollV1 [coll]
  (apply max coll))

;======================================================================================================
;v2 Reduce va juntando de a pares, aplica una funcion y a ese resultado le vuelve a aplicar la funcion con el siguiente

(defn maxCollV2 [coll]
  (reduce max coll))

;======================================================================================================
;v3 Sin max

(defn maxCollV3 [coll]
  (reduce (fn [a b] (if (> a b) a b))
          coll))

;======================================================================================================
;c) El primer elemento de una colleccion.

;v1 First devuelve el primer dato que aparece de izq a der. Si esta vacio devuelve nil

(defn primerElemento [coll]  (first coll))

;======================================================================================================
;v2 nth obtiene un elemento de una coll segun su indice. Tercer parametro es para casos donde esta fuera de rango o lista vacia. 
;Rapido para vectores lento para linked list ya que debe recorrer todos los elementos hasta llegar al indicado.

(defn primerElementoV2 [coll] (nth coll 0 "No existe ese indice"))

;======================================================================================================
;V3 esto solo es posible con vectores. 

(defn primerElementoV3 [coll]
  (if (empty? coll)
    "La lista está vacía"
    (coll 0))) ; si aca ponemos nth coll 0 tambien aceptaria listas. 

;======================================================================================================
;d) El elemento mínimo entre los máximos por fila de una matriz (minimax).

;v1 Usando map y recibiendo matrizz

(defn miniMaxV1 [matriz]
  (let [maxFila (map (fn [fila] (apply max fila)) matriz)]
    (apply min maxFila)))

;======================================================================================================
;v2 Prueba, no es escalable, solo acepta 2 filas y te dice el minimax

(defn miniMaxV2 [coll1 coll2]
  (let [max1 (maxCollV1 coll1)
        max2 (maxCollV2 coll2)]
    (min max1 max2)))

;======================================================================================================
; 2) Definir funciones que determinen:

; a) La pertenencia de un elemento a una coleccion.

;v1 Some aplica una funcion hasta que su resultado no sea nil o false. Devuelve lo que la funcion aplicada retorne.
;Aca devolvera true o nil
(defn existeElemento [e coll]
  (some #(= e %) coll))

;======================================================================================================
;v2 Aca devolvera el elemento ya que los Sets al actuar como funciones en Clojure, 
;si ese elemento esta dentro del set, devolvera el elemento, de lo contrario tira nil 

(defn buscarElemento [e coll]
  (some #{e} coll))
;======================================================================================================

;v2 Aca devolvera el elemento ya que los Sets al actuar como funciones en Clojure, 
;si ese elemento esta dentro del set, devolvera el elemento, de lo contrario tira nil 
(defn buscarElemento [e coll]
  (some #{e} coll))

;======================================================================================================

; b) Si una secuencia tiene un solo componente.
;count devuelve longitud de coll
(defn tiene1Comp? [coll]
  (= (count coll) 1))

;======================================================================================================
;   c) Si la cantidad de átomos de una coleccion es par. 

(defn indicePar [coll]
  (let [cantInd (count coll)]
    (if (= (mod cantInd 2) 0)
      "Par"
      "Impar")))


; 3) Dada una secuencia con dos subsecuencias, definir funciones para determinar:
;   a) La unión de ambas subsecuencias.

(require '[clojure.set :as set])
(defn unionV2 [collA collB]
  (set/union (set collA) (set collB)))
;   b) La intersección de ambas subsecuencias.


 ;v1 Los sets en clj actuan como funciones. Filter trae todos los elementos verdaderos. 
;Set al encontrar un valor, devuevle ese valor lo que es tomado como verdadero

(defn interseccionV1 [coll1 coll2]
  (filter (set coll1) coll2))


 ;v2 Require es como el import de java: trae las librerias de clojure. :as es para poner alias asi sabe que cuando se llame a set/ es para llamar a funciones. 
;set/intersection es como usar el . en java para llamar a la funcion. Esta trabaja solo con sets por eso se deben convertir 
;con (dir clojure.set) podemos ver todas las funciones que trae

(require '[clojure.set :as set])
(defn interseccionV2 [A B]
  (set/intersection (set A) (set B)))


;   c) La diferencia de ambas subsecuencias.

(require '[clojure.set :as set])
(defn diferenciaV1 [a b]
  (set/difference (set a) (set b)))

;   d) La diferencia simétrica de ambas subsecuencias. (solo a y solo b sin elemetos de a y b)

(require '[clojure.set :as set])
(defn diferenciaSimetricaV1 [a b]
  (set/union (set/difference (set a) (set b)) (set/difference (set b) (set a))))


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