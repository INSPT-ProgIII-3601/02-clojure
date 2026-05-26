
(defn a-romano-oficial [n]
(if (or (< n 1) (> n 3999)) nil
(-> (apply str (repeat n "I"))
(clojure.string/replace #"IIIII" "V")
(clojure.string/replace #"IIII" "IV")
(clojure.string/replace #"VV" "X")
(clojure.string/replace #"VIV" "IX")
(clojure.string/replace #"XXXXX" "L")
(clojure.string/replace #"XXXX" "XL")
(clojure.string/replace #"LL" "C")
(clojure.string/replace #"LXL" "XC")
(clojure.string/replace #"CCCCC" "D")
(clojure.string/replace #"CCCC" "CD")
(clojure.string/replace #"DD" "M")
(clojure.string/replace #"DCD" "CM"))))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defn a-romano-gerson [n]
(let [romanos[[1000 "M"]
  [900 "CM"]
  [500 "D"]
  [400 "CD"]
  [100 "C"]
  [90 "XC"]
  [50 "L"]
  [40 "XL"]
  [10 "X"]
  [9 "IX"]
  [5 "V"]
  [4 "IV"]
  [1 "I"]]]

  (loop [num n num_convertido "" simbolos romanos]
    
    ;si 0 = fin

    ;sino  
    ;preg: el valor del primer romano es menor o igual que mi num?
    ;si:recur:  resto el valor a n, escribo esa letra en num_convertidos y vuelvo a dar una vuelta. 
    
    ;no: recur: volvemos a dar una vuelta sacando el primer valor de simbolos 
    
    
    
    )
)  
  
  
  )  

; 50.Definir una función que reciba un número entero y devuelva una cadena con su representación en números romanos.

