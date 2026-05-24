" Definir la función invertir que reciba un número entero no negativo y lo devuelva 
espejado.  Ejemplo: 1234 -> 4321, 1200 -> 21, 0 -> 0. "

(defn invertir [n]
    (Integer/parseInt (clojure.string/reverse (str n))))
    