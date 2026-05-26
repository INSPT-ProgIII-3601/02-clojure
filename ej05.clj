"Definir la función capicua? que reciba un número entero no negativo de hasta 5 
dígitos y devuelva true si el número es capicúa; si no, false. "

(defn capicua? [n] 
    (= (str n) 
        (apply str (reverse 
    (str n)))))
