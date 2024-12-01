# Grupo 5 Seguros
El objetivo del proyecto es generar una mejora del proceso de gestión de solicitudes de siniestros.

## Descripción del Proyecto
- Carga manual de los formularios requeridos para registrar los siniestros ocurridos en aplicación móvil para Android.
- Público objetivo: Clientes asegurados. 
- Funcionalidades principales:
  - Login
  - Visualización de información de cuenta
  - Recuperación y cambio de contraseña
  - Denuncia de siniestros
  - Visualización de solicitudes
  - Cierre de sesión
  

## Tecnologías Utilizadas
Lista de tecnologías empleadas en el proyecto:
- **Lenguaje:** Kotlin
- **Framework:** Jetpack Compose
- Tecnologías: Retrofit, Inyección de dependencias Hilt.

## Cómo Ejecutar el Proyecto
Pasos para ejecutar el proyecto localmente:
1. Clona el repositorio: `git clone <URL-del-repositorio>`
2. Abre el proyecto en Android Studio.
3. Sincroniza el proyecto con Gradle.
4. Clona el repositorio de la API: https://github.com/HeberTescione1/segurosProjectORT
5. Configura claves API.
6. Ejecuta el backend en VS Code
7. Ejecuta el proyecto en un emulador o dispositivo físico con Android Studio

## Capturas de Pantalla

<p style="display: flex; justify-content: space-between; align-items: center;">
 <img src="/login.webp" alt="Captura 1" width="30%" style="margin-right: 5%;">
 <img src="/detalles_solicitudes.webp" alt="Captura 1" width="30%" style="margin-right: 5%;">
 <img src="/mis_polizas.webp" alt="Captura 1" width="30%" style="margin-right: 5%;">
 <img src="/validaciones.webp" alt="Captura 1" width="30%" style="margin-right: 5%;">
 <img src="/sin_solicitudes.webp" alt="Captura 1" width="30%">
 <img src="/drawer_menu.webp" alt="Captura 1" width="30%" style="margin-right: 5%;">
 </p>


## Arquitectura del Proyecto
- **Patrón:** MVVM, inyección de dependencias con Hilt

