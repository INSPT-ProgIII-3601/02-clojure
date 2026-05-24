"Definir la función aprox-pi que reciba la cantidad de términos a considerar entre los 
paréntesis de la expresión  4 · (1 - 1/3 + 1/5 - 1/7 + ... + 1/n)  y devuelva la 
correspondiente aproximación de π. "

(defn aprox-pi [n]
  (* 4 (reduce + 
                (map (fn [i] 
                    (* (if (even? i) 1 -1) 
                        (/ 1 (+ 1(* 2 i))))) 
                    (range n)))))

