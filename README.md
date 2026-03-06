# Hamster UFO

## Introducción
**Hamster UFO ** es un juego inspirado en el *drop*. El jugador controla un pequeño **OVNI con un hámster dentro** que se mueve por la parte inferior de la pantalla.

El objetivo del juego es recoger cristales que caen del cielo para conseguir puntos, mientras se evitan las piedras que también caen y que dañan la nave.
Tematica: un hámster explorador viaja en su nave espacial recolectando cristales mientras esquiva las rocas espaciales.

---

## Desarrollo

### Lógica del juego

La lógica principal del juego se basa en varias mecánicas:

- **Movimiento**  
  El OVNI del jugador se mueve horizontalmente (izquierda y derecha) en la parte inferior de la pantalla mediante el teclado.

- **Generación de objetos**  
  Desde la parte superior de la pantalla aparecen de forma aleatoria dos tipos de objetos:
  - **Cristales** → el jugador debe recogerlos para sumar puntos.
  - **Piedras** → el jugador debe evitarlas porque provocan "daño"

- **Colisiones**  
  El juego detecta cuando el OVNI toca los objetos:
  - Si el OVNI colisiona con un **cristal**, el jugador gana puntos y el cristal desaparece.
  - Si colisiona con una **piedra**, el jugador pierde una vida


---

### Estructura del juego

El juego está organizado en diferentes **clases y pantallas**.

#### Clases principales

- **Player / Nave**  
  Controla el movimiento del jugador y su posición en pantalla.

- **Cristal**  
  Representa los cristales que caen y que el jugador debe recoger.

- **Piedra**  
  Representa los obstáculos que el jugador debe evitar.

- **GameManager / Game**  
  Controla la lógica general del juego: generación de objetos, detección de colisiones, puntuación y estado de la partida.

#### Pantallas

- **Pantalla de inicio**  
  Muestra el título del juego y permite empezar la partida.

- **Pantalla de juego**  
  Es donde ocurre la acción principal donde el jugador mueve el OVNI y debe recoge cristales y evitar las rocas.

- **Pantalla de fin de juego**  
  Aparece cuando el jugador choca con 3 rocas.
