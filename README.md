# Ejercicios de Clojure

Este repositorio contiene ejercicios simples escritos en Clojure.

## Archivos

- `ej01.clj`: define `tercer-angulo`, una funcion que calcula el tercer angulo de un triangulo a partir de los otros dos.
- `ej02.clj`: define `segundos`, una funcion que convierte dias, horas, minutos y segundos a una cantidad total de segundos.

## Uso

Abrir una REPL de Clojure y cargar el archivo que se quiera probar:

```clojure
(load-file "ej01.clj")
(tercer-angulo 60 60)
;; => 60
```

```clojure
(load-file "ej02.clj")
(segundos 1 2 3 4)
;; => 93784
```

## Funciones

### `tercer-angulo`

```clojure
(tercer-angulo a b)
```

Devuelve el angulo restante de un triangulo:

```clojure
(- 180 (+ a b))
```

### `segundos`

```clojure
(segundos dias horas minutos segundos)
```

Devuelve el total de segundos correspondiente a la duracion recibida.

Ejemplo:

```clojure
(segundos 0 1 1 1)
;; => 3661
```

Si alguno de los valores es negativo, imprime un mensaje de error y devuelve `nil`.

## Estado del proyecto

No hay dependencias externas, tests automatizados, namespaces ni configuracion de build. Los archivos estan pensados para cargarse directamente en una REPL.
