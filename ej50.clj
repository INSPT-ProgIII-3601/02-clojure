
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

(map a-romano-oficial '(4 87 99 600 3999))
(map (fn [n] (time (a-romano-oficial n))) '(4 87 99 600 3999))
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defn a-romano-gerson [n]
(let [valores-romanos [{:numero 1000, :romano "M"}
 {:numero 900, :romano "CM"}
 {:numero 500, :romano "D"}
 {:numero 400, :romano "CD"}
 {:numero 100, :romano "C"}
 {:numero 90, :romano "XC"}
 {:numero 50, :romano "L"}
 {:numero 40, :romano "XL"}
 {:numero 10, :romano "X"}
 {:numero 9, :romano "IX"}
 {:numero 5, :romano "V"}
 {:numero 4, :romano "IV"}
 {:numero 1, :romano "I"}]]

  (loop [num n num_convertido "" simbolos romanos]
    
    ;si n=0 entonces fin

    ;sino  
    ;si el valor del primer romano es menor o igual que n
        ; recur:  resto el valor a n, escribo esa letra en num_convertidos y vuelvo a dar una vuelta. 
    
        ; recur: volvemos a dar una vuelta sacando el primer valor de valores-romanos 
    
    
    
    )
)  
  
  
  )  

(map a-romano-gerson '(4 87 99 600 3999))
(map (fn [n] (time (a-romano-gerson n))) '(4 87 99 600 3999))

