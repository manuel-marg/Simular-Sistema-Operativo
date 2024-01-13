# Simular-Sistema-Operativo
Gracias a tu excelente trabajo, Ikea ha decidido contratarte de nuevo para elaborar otra simulación. En este caso, planean la compra de un robot que permitiría la detección de errores en el ensamblaje, lo que hará mucho más rápida la siguiente generación escritorios llamados Arauca, para ello, la simulación debe ser de la siguiente manera:

#### 1. Robot (Procesador):
- Su función es recibir los Arauca uno a uno y realizarles pruebas con el fin de determinar si el escritorio está listo para salir al mercado o si requiere alguna mejora.
- La máquina revisa cada uno por un período de 10 segundos. En caso de no poder concluir todavía si el escritorio está completo o debe mejorarse, se encola para esperar nuevamente por una siguiente revisión.
- Por cada revisión, Ikea ha determinado que el escritorio tiene una probabilidad de salir al mercado del 40%, una probabilidad de volver a encolarse por necesitar más tiempo en revisión del 25% y una probabilidad de requerir alguna mejora del 35%. Estos valores son constantes para todos los escritorios durante toda la simulación.

#### 2. Arauca (Proceso):
- Para efectos de la simulación, sólo debe tomar en cuenta que el escritorio tiene un ID entero único asociado y alguno de los tres niveles de prioridad expuestos, cada uno de estos niveles con su propia cola:
  - Nivel 1: prioridad alta, si hay alguno dentro del sistema, debe pasar al robot sobre los de otra prioridad.
  - Nivel 2: prioridad mediana, pueden pasar al robot siempre y cuando no haya ningún escritorio de nivel 1.
  - Nivel 3: prioridad baja, sólo pasan al robot si no hay escritorios de nivel 1 o 2 encolados.
- Para efectos de las reparaciones o mejoras, todos los Arauca (sin importar su prioridad) son colocados en una misma cola y son despachados de ella uno a uno. Por cada vez que se actualicen las colas, existe un 45% de probabilidades de que el primer Arauca en esta cola salga, y sea colocado en la cola de los Arauca listos para la revisión.

#### 3. Administrador (Sistema Operativo):
- Se encarga de actualizar las colas del sistema y dictarle al robot cuál es el siguiente Arauca que debe revisar.
- Cada dos ciclos de revisión (es decir, cada dos escritorios revisados), el administrador agrega un nuevo Arauca a la cola de su nivel correspondiente. Este evento ocurre con una probabilidad del 70% y la prioridad de éste es completamente aleatoria. Se enfatiza que el administrador opera cada vez que el robot acaba de terminar de revisar un Arauca, realiza toda la gestión descrita respecto a las colas y finalmente le indica al robot que puede empezar a trabajar otra vez con el escritorio seleccionado.

La simulación opera de la siguiente manera: comienza a ejecutarse y se debe crear un Arauca. Una vez ahí comienza a operar el robot, después el administrador y así. Se debe mostrar en pantalla en todo momento las colas que mantiene el administrador, con los ID de los escritorios en cada una en el orden en el cual estén, junto con el ID del Arauca que se encuentra en revisión.

