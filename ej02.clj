;;; Ejercicio 2
;; Definir la funcion segundos que reciba los cuatro valores
;; (dias, horas, minutos y segundos) del tiempo que dura un evento
;; y devuelva ese tiempo expresado solamente en segundos.

(defn dias-a-segundos [dias]
  (* dias 24 60 60))

(defn horas-a-segundos [horas]
  (* horas 60 60))

(defn minutos-a-segundos [minutos]
  (* minutos 60))

(defn segundos [dias horas minutos segundos]
  (if (or (neg? dias) (neg? horas) (neg? minutos) (neg? segundos))
    (println "Alguno de los valores ingresados es invalido (negativo)")
    (+ (dias-a-segundos dias)
       (horas-a-segundos horas)
       (minutos-a-segundos minutos)
       segundos)))
