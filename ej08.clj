"Definir la función nth-fibo que reciba un número entero no negativo y devuelva el 
correspondiente término de la sucesión de Fibonacci."

(defn nth-fibo [n]
    (if (<= n 1)
        n
        (+ (nth-fibo (- n 1)) (nth-fibo (- n 2)))))


(defn nth-fac [n]
    (if (<= n 1)
        1
        (* n (nth-fac (- n 1)))))