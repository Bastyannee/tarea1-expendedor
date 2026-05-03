# Tarea 1: Simulación de Máquina Expendedora

**Asignatura:** Desarrollo Orientado a Objetos

## Equipo de Desarrollo
* Tomas Francisco Garrido Fierro
* Maria Jose Norambuena Meza
* Bastián Antonio Pérez Aguayo

---

##Descripción del Proyecto
Esta tarea consiste en la simulación computacional de una máquina expendedora a través de la consola, aplicando estrictamente los pilares de la Programación Orientada a Objetos (Herencia, Polimorfismo, Encapsulamiento y Abstracción). 

El sistema gestiona el flujo de compra controlando el stock de múltiples productos (Bebidas y Dulces), validando la autenticidad y valor del sistema monetario ingresado, y manejando el flujo de vuelto delegando los errores estructurales a través de Excepciones Personalizadas (*Checked Exceptions*).

---

##Decisiones de Arquitectura e Ingeniería

La arquitectura implementa los siguientes patrones y herramientas del lenguaje Java:

1. **Tipos Genéricos (Generics):** La clase `Deposito<T>` fue parametrizada para manejar de forma segura y agnóstica tanto colecciones de `Producto` como colecciones de `Moneda`, evitando el casteo explícito y mejorando el *Type Safety*.
2. **Enumeraciones (Enums):** Se implementó la clase `TipoProducto` como un Enum para centralizar el catálogo, los precios y evitar el uso de "Magic Strings" o variables quemadas en la capa de lógica de negocio.
3. **Manejo de Errores (Checked Exceptions):** Se desacopló la lógica de fallos creando `PagoIncorrectoException`, `PagoInsuficienteException` y `NoHayProductoException`. La máquina expendedora lanza (*throws*) los errores y la interfaz cliente (`Main`) los captura (*catch*).
4. **Interfaces:** Integración de la interfaz nativa `Comparable<Moneda>` en la clase abstracta `Moneda` para definir el orden natural de los objetos basado en su valor, permitiendo la utilización algorítmica de `Collections.sort()`.

---

##Diagrama de Clases (UML)
La siguiente arquitectura refleja el modelo estático de nuestro sistema, omitiendo por simplicidad visual (según rúbrica) las clases `Exception` y `Main`.
```mermaid
classDiagram
    direction TB

    %% Dependencias (Líneas punteadas simples)
    Comprador ..> Expendedor
    Comprador ..> Moneda
    Comprador ..> TipoProducto
    Expendedor ..> TipoProducto
    Expendedor ..> Producto

    %% Composición (Diamante relleno)
    Expendedor *-- Deposito

    %% Herencia (Línea continua con triángulo hueco)
    Producto <|-- Bebida
    Producto <|-- Dulce
    Bebida <|-- CocaCola
    Bebida <|-- Sprite
    Bebida <|-- Fanta
    Dulce <|-- Snickers
    Dulce <|-- Super8

    %% Implementación y Herencia de Monedas
    Comparable~Moneda~ <|.. Moneda
    Moneda <|-- Moneda1000
    Moneda <|-- Moneda500
    Moneda <|-- Moneda100

    class Comparable~Moneda~ {
        <<interface>>
        + compareTo(Moneda)* int
    }

    class Comprador {
        - String producto
        - int vuelto
        + Comprador(Moneda, TipoProducto, Expendedor)
        + cuantoVuelto() int
        + queConsumiste() String
    }

    class Expendedor {
        - Deposito~Producto~ coca
        - Deposito~Producto~ sprite
        - Deposito~Producto~ fanta
        - Deposito~Producto~ snickers
        - Deposito~Producto~ super8
        - Deposito~Moneda~ depVuelto
        + Expendedor(int numProductos)
        + comprarProducto(Moneda, TipoProducto) Producto
        + getVuelto() Moneda
    }

    class Deposito~T~ {
        - ArrayList~T~ items
        + Deposito()
        + add(T item)
        + get() T
    }

    class TipoProducto {
        <<enumeration>>
        COCA_COLA(1000)
        SPRITE(1000)
        FANTA(1000)
        SNICKERS(800)
        SUPER8(500)
        - int precio
        + getPrecio() int
    }

    class Producto {
        <<abstract>>
        - int serie
        + Producto(int serie)
        + consumir()* String
        + getSerie() int
    }

    class Moneda {
        <<abstract>>
        + Moneda()
        + getSerie() int
        + getValor()* int
        + compareTo(Moneda) int
    }
