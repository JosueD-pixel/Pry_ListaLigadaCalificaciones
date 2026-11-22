# Sistema de Calificaciones en Tiempo Real

Práctica de **Estructura de Datos** (4C, UTHH). Lista ligada simple ordenada en Java para un profesor que recibe las calificaciones de N estudiantes en orden aleatorio y necesita verlas siempre ordenadas.

**Alumno:** Ángel Josué Domingo Guillén · **Matrícula:** 20251011
**Profesor:** MTI. Luis Alberto Mendoza San Juan

## Requerimientos y métodos

| Requerimiento | Método en `listaLigada` | Complejidad |
| --- | --- | --- |
| Lista siempre ordenada de menor a mayor | `insertarOrdenado(dato)` | O(n) |
| Calificación en cualquier posición | `obtenerCalificacion(pos)` | O(n) |
| Mínima / máxima / mediana | `obtenerMinima()` / `obtenerMaxima()` / `obtenerMediana()` | O(1) / O(n) / O(n) |
| Corregir calificaciones erróneas | `corregir(incorrecta, correcta)` | O(n) |
| Eliminar calificaciones inválidas | `eliminarPorValor(x)` | O(n) |
| Saber si alguien sacó una calificación | `buscar(dato)` | O(n) |
| Total de estudiantes que entregaron | `getTamanio()` | O(1) |

Para corregir no se cambia el dato en su lugar porque se desordenaría la lista: se elimina la calificación incorrecta y se inserta la correcta con `insertarOrdenado()`.

## Estructura

- `nodo.java`: guarda una calificación y la referencia al siguiente nodo
- `listaLigada.java`: lista ordenada con las operaciones del caso de uso
- `SistemaCalificaciones.java`: main que simula la llegada de calificaciones

## Cómo ejecutarlo

En NetBeans: **File → Open Project**, selecciona la carpeta del proyecto y dale **Run (F6)**.
