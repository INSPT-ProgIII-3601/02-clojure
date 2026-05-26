(defn factorial [n]
  (if (zero? n)
    1                               ; Caso base: si es 0, devuelve 1
    (* n (factorial (dec n)))))     ; Caso recursivo: multiplica n por el factorial de n-1

    ;Problema de este enfoque: La Máquina Virtual de Java (JVM) sobre la que corre Clojure no optimiza este tipo de llamadas automáticamente. Si haces (factorial 10000), cada llamada se acumulará en la memoria, provocando un error de desbordamiento de pila (StackOverflowError).

(defn factorial-tco 
  ;; Usamos sobrecarga de aridad para exponer una API limpia al usuario.
  ;; Si recibe un solo parámetro, llama a la misma función pasándole un "1" como acumulador inicial.
  ([n] (factorial-tco n 1)) 
  
  ;; Si recibe dos parámetros, procesa la lógica recursiva
  ([n acc]
   (if (zero? n)
     acc                            ; Caso base: devolvemos el valor acumulado
     (recur (spy "arg1" (dec n)) (spy "arg2" (* acc n))))))   ; Caso recursivo: recurre con (n-1) y el nuevo acumulador






(defn invertir-lista [lista]
  (loop [restante lista      ; Estado 1: Lo que falta procesar
         resultado '()]      ; Estado 2: La lista donde vamos acumulando
    
    (if (empty? restante)
      resultado              ; Caso base: Si no hay nada más que procesar, devolvemos el resultado
      
      ;; Caso recursivo: 
      ;; Volvemos a saltar al 'loop' actualizando los estados
      (recur (spy "restante" (rest restante))                       ; Nuevo 'restante' = quitamos el primer elemento
             (spy "resultado" (cons (first restante) resultado)))))) ; Nuevo 'resultado' = agregamos ese elemento al principio



(defn invertir-lista
  ;; Aridad 1: La API pública (lo que el usuario llama)
  ([lista] 
   (invertir-lista lista '()))

  ;; Aridad 2: La implementación recursiva interna
  ([restante resultado]
   (if (empty? restante)
     resultado
     (recur (rest restante) 
            (cons (first restante) resultado)))))