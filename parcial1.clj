; Definimos la planilla en el ambiente. Cada vez que se quiera aludir a ella, usar el nombre de la variable
(def planilla-asistencia
  [{:alumno "ALBERTI"   :asistencias ["P" "P" "P" "P" "P" "P" "P" "P" "P" "P" "P" "P"]}
   {:alumno "AZCUENAGA" :asistencias ["P" "A" "P" "P" "P" "P" "T" "P" "P" "P" "A" "P"]}
   {:alumno "BELGRANO"  :asistencias ["P" "A" "P" "P" "A" "P" "P" "A" "A" "A" "A" "A"]}
   {:alumno "CASTELLI"  :asistencias ["P" "P" "T" "P" "P" "P" "P" "P" "P" "P" "P" "P"]}
   {:alumno "LARREA"    :asistencias ["P" "P" "P" "P" "P" "P" "A" "A" "A" "A" "A" "P"]}
   {:alumno "MATHEU"    :asistencias ["P" "A" "A" "P" "T" "P" "P" "A" "P" "P" "T" "P"]}
   {:alumno "MORENO"    :asistencias ["T" "T" "T" "T" "T" "T" "T" "T" "T" "P" "P" "P"]}
   {:alumno "PASO"      :asistencias ["P" "P" "P" "A" "P" "P" "P" "P" "P" "P" "P" "P"]}
   {:alumno "SAAVEDRA"  :asistencias ["P" "T" "A" "P" "P" "T" "P" "P" "P" "A" "P" "P"]}])

;; La función auxiliar sigue igual, ya usa el paradigma funcional anidado
(defn calcular-porcentaje [asistencias]
  (let [total-clases (count asistencias)
        faltas (reduce + (map {"P" 0, "T" 0.5, "A" 1} asistencias))
        presentes (- total-clases faltas)]
    (float (* (/ presentes total-clases) 100))))

;; Función principal resolviendo de adentro hacia afuera:
(defn aptos-final [planilla]
  (filter (fn [mapa-alumno] 
            (>= (first (vals mapa-alumno)) 75))
          (map (fn [{:keys [alumno asistencias]}]
                 {alumno (calcular-porcentaje asistencias)})
               planilla)))

(aptos-final planilla-asistencia)