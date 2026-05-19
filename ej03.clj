(defn sig-mul-10-perez [a]
  (int (* 
            10 
            (Math/floor 
                (+ (/ a 10.0) 1)
            )
        )
  )
)

(defn sig-mul-10-copes [n]
    (let [q (quot n 10)
          r (rem n 10)]
    (* 10 (inc 
            (if (and (neg? n) (not (zero? r))) ; ¿negativo no múltiplo de 10?
                (dec q) 
                 q
            )
        )
    )
    )
)

; Buscar la definición de 'mod' (no está en el apunte oficial)
(defn sig-mul-10-baluja [a]
    (+ a (- 10 (mod a 10)))
)