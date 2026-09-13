# Registro de Incidencias (Registro Académico)
Aplicación Android orientada al registro, reporte y seguimiento de problemas relacionados con equipos, infraestructura o servicios.

## Tecnologías empleadas
* Android Studio
* Kotlin
* Jetpack Compose
* Control de versiones con Git y GitHub

## Estado del proyecto
**Características funcionales:**
* Interfaz inicial interactiva con campos de entrada (`OutlinedTextField`) para capturar la asignatura, el título de la actividad y la calificación.
* Implementación de estado reactivo utilizando `remember`, `mutableStateOf` y `mutableStateListOf` para almacenar y mostrar un historial de registros en tarjetas dinámicas.
* Validación de datos obligatorios y limpieza automática del formulario tras cada guardado exitoso con redirección de enfoque.

**Pendiente de implementación:**
* Persistencia de los datos capturados (conexión a base de datos local o API remota).

## Registro de avances
* **Semana 1:** Creación del proyecto base en Android Studio con plantilla Empty Activity para Jetpack Compose, configuración inicial del entorno, SDK y primera ejecución exitosa de la aplicación en el emulador.
* **Semana 2:** Diseño y estructuración de la interfaz móvil inicial mediante la incorporación de componentes básicos de Jetpack Compose (`Column`, `Text`, `OutlinedTextField`, `Button` y `Card`) aplicando un orden visual vertical y espaciado con `Modifier`.
* **Semana 5:** Configuración formal del control de versiones mediante Git y GitHub, establecimiento de la estructura base del repositorio remoto y documentación inicial del proyecto a través del archivo `README`.
* **Semana 6:** Se transformó la interfaz estática en una pantalla con interacción. Ahora los campos capturan texto en tiempo real y la interfaz responde mostrando un mensaje de confirmación temporal usando la memoria del estado de la aplicación (`remember` y `mutableStateOf`).
* **Semana 7:** Se implementó un historial de registros en pantalla mediante una lista reactiva (`mutableStateListOf`), validación de entrada de datos obligatorios y limpieza automática de los campos de texto del formulario tras cada guardado exitoso.

## Instrucciones de ejecución
1. Clona este repositorio en tu entorno local.
2. Abre Android Studio y selecciona la opción "Open" para cargar el directorio del proyecto.
3. Espera a que la sincronización de Gradle finalice por completo antes de ejecutar la aplicación en el emulador o dispositivo físico.

_**Autor:** Daniel Marcelo López Vargas_