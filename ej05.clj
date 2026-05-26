;5. Definir la función capicua? que reciba un número entero no negativo de hasta 5
;dígitos y devuelva true si el número es capicúa; si no, false.

; Reverse Devuelve la SECUENCIA DE CARACTERES, "123" reverse-> (/3 /2 /1). str solo haria "(/3 /2 /1)"
;por eso apply aplica str a cada elemente de reverse, ya que es una secuencia, quedando asi "321"
(defn numInvertido [num]
  (Integer/parseInt  (apply str (reverse (str num)))))

(defn capicua? [num]

  (if (pos? num)
    (= num (numInvertido num))
    "Se esperaba un numero postivo"))(capicua? 123321)
