;4. Definir las funciones red, green, blue y alpha que reciban el valor numérico de un
;color de 32 bits y devuelvan, respectivamente, los valores de las componentes rojo,
;verde, azul y alfa (RGBA: red, green, blue, alpha) del mismo.
; ROJO 31 - 24     BITS 
; VERDE 23 - 16
; AZUL  15 - 8
; ALPHA 7 - 0


;; 1. ROJO esta en 31 a 24. unsigned-bit-shift-right empuja bits hacia la derecha remplazando con 0 (no toma en cuenta signo) 
;Empujamos 24 lugares (saltamos Verde, Azul y Alfa)


(defn red [color]
  (unsigned-bit-shift-right color 24))

;; 2. VERDE esta en 23 - 16: Empujamos 16 lugares (saltamos Azul y Alfa)
;bit and 255 es una mascaraa  de 11111111 que al aplicarlo con nuestro numero nos devuelve solo los 8
;que nos interesa y el resto lo descarta
; en este caso pasariamos a tener rojo verde y el bit and solo dejaria pasar a verde. 

(defn green [color]
  (bit-and (unsigned-bit-shift-right color 16) 255))

;; 3. AZUL esta en 15 - 8: Empujamos 8 lugares (saltamos solo el Alfa)
(defn blue [color]
  (bit-and (unsigned-bit-shift-right color 8) 255))

;; 4. ALFA primeros 7: No empujamos nada, ya está al final.
(defn alpha [color]
  (bit-and color 255))


(defn validar-hexa [valor]
  (and (number? valor)
       (>= valor 0)
       (<= valor 0xFFFFFFFF)))



;Espera un hexa 0x....
(defn colorRGB [color]
  (if (validar-hexa color)
    (let [rojo (red color)
          verde (green color)
          azul (blue color)
          alph (alpha color)]

      (array-map :rojo  rojo
                 :verde verde
                 :azul  azul
                 :alpha alph))
    "Se esperaba valor Hexadecimal de la forma 0xRRGGVVAA"))




(colorRGB 0xA12Affff)
