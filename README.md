Ruleta VUE APP

Esta aplicación simula una ruleta de casino.

Permite ingresar jugadores, a los cuales se les pueden modificar sus datos, incluyendo cantidad de dinero que poseen, y se pueden eliminar del sistema (CRUD).

Los jugadores parten con una cantidad de $15.000 por defecto al ser creados.

En cada ronda los jugadores apuestan entre un 11% y 19% del total de dinero que poseen. Si tienen $1.000 o menos, van All In. Si no les queda dinero, no podrán apostar.

El modo de apuesta es el siguiente, un jugador puede apostar a Verde, Rojo o Negro con un 1%, 49,5% y 49,5% de probabilidad respectivamente.

Un jugador recupera el doble de lo apostado si acierta su apuesta, cuando ésta sea Rojo o Negro, y recupera 10 veces lo apostado en caso de acertar Verde. En caso de perder la apuesta, no recupera nada.

La ruleta entrega resultados con la misma probabilidad que los jugadores hacen apuestas, es decir, Verde 1%, Rojo 49,5% y Negro 49,5%.

Cada recarga de la página es una ronda de juego transcurrida, con la apuesta de cada jugador y el resultado de la ruleta.

Los jugadores participan de una partida de ruleta automáticamente, cada 3 minutos (a nivel de datos y vista).

Se puede ver la aplicación publicada y funcionando en:

https://fbaunivalle.github.io/ruleta-vue-app/

Para instalación manual que requiera funcionamiento local en sistemas Windows o basados en Unix como Linux se puede sincronizar con git las imágenes Docker frontend y backend que reposan en:

https://hub.docker.com/repository/docker/fbaunivalle/ruleta-app

La etiqueta de la imagen del frontend es v1, la etiqueta de la imagen del backend es apiv1.

Se requiere tener una versión instalada de Docker en su sistema operativo para usar las imágenes. Cada imagen genera un contenedor con todo lo necesario para que el frontend y el backend funcionen sin necesidad de instalar programas adicionales.

Cualquier duda sobre la instalación se puede escribir al correo: fbaunivalle@gmail.com
