# Registro de Incidencias (Registro Académico)
Aplicación Android orientada al registro, reporte y seguimiento de problemas relacionados con equipos, infraestructura o servicios.

## Tecnologías empleadas
* Android Studio
* Kotlin
* Jetpack Compose
* Control de versiones con Git y GitHub

## Estado del proyecto
**Características funcionales:**
* Interfaz inicial interactiva que permite capturar el título de la incidencia y una breve descripción.
* Implementación de estado reactivo utilizando `remember` y `mutableStateOf`.
* Retroalimentación visual inmediata que confirma la preparación del reporte al presionar el botón principal.

**Pendiente de implementación:**
* Validación estricta de los campos de texto.
* Persistencia de los datos capturados (conexión a base de datos local o API remota).

## Registro de avances
* **Semana 6:** Se transformó la interfaz estática en una pantalla con interacción. Ahora los campos capturan texto en tiempo real y la interfaz responde mostrando un mensaje de confirmación temporal usando la memoria del estado de la aplicación.
* **Semana 7:** Se implementó un historial de registros en pantalla, validación de entrada de datos y limpieza automática del formulario tras cada guardado exitoso.

## Instrucciones de ejecución
1. Clona este repositorio en tu entorno local.
2. Abre Android Studio y selecciona la opción "Open" para cargar el directorio del proyecto.
3. Espera a que la sincronización de Gradle finalice por completo antes de ejecutar la aplicación en el emulador o dispositivo físico.

_**Autor:** Daniel Marcelo López Vargas_