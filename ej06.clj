(defn signo-ej06 [x] (* x (if (zero? (rem (dec x) 4)) 1 -1)))

(defn ej06 [n] (float (* 4 (reduce + (map #(/ 1 %) (map signo-ej06 (filter odd? (range (* 2 n)))))))))

