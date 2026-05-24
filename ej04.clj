"Definir las funciones red, green, blue y alpha que reciban el valor numérico de un
color de 32 bits y devuelvan, respectivamente, los valores de las componentes rojo,
verde, azul y alfa (RGBA: red, green, blue, alpha) del mismo"

(defn red [color]
  (bit-and color 0xFF))
(defn green [color]
    (bit-and (bit-shift-right color 8) 0xFF))
(defn blue [color]
    (bit-and (bit-shift-right color 16) 0xFF))      
(defn alpha [color]
    (bit-and (bit-shift-right color 24) 0xFF))

