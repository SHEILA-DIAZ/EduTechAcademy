# 📱 EduTech Academy

App móvil de cursos online desarrollada con **Kotlin + Jetpack Compose** como proyecto grupal universitario.

---

## 👥 Integrantes

| Nombre | Rol |
|--------|-----|
| Sheila Díaz | Etapa 1 — Login, Home, Cursos, Navegación |
| Naomi Sanchez | Etapa 1 — CourseDetail, Profile + Etapa 2 — Mejoras con Gemini |

---

## 📖 Descripción

**EduTech Academy** es una plataforma de educación online donde los usuarios pueden explorar cursos de tecnología, negocios y diseño, inscribirse en ellos y visualizar su progreso de aprendizaje.

---

## 🚀 Funcionalidades

- 🔐 Login y registro con validación básica
- 🏠 Dashboard con accesos rápidos
- 📚 Lista de cursos con filtros por categoría
- 🔍 Detalle completo de cada curso
- 👤 Perfil de usuario con progreso simulado
- 🎓 Inscripción a cursos con confirmación

---

## 🗂️ Estructura del Proyecto

```
app/src/main/java/com/example/edutech/
│
├── data/
│   └── Course.kt               # Modelo de datos + 6 cursos precargados
│
├── navigation/
│   ├── AppNavigation.kt        # NavHost + NavController
│   └── Routes.kt               # Rutas de navegación
│
├── screens/
│   ├── LoginScreen.kt          # Pantalla de Login/Registro
│   ├── HomeScreen.kt           # Dashboard principal
│   ├── CoursesScreen.kt        # Lista de cursos con filtros
│   ├── CourseDetailScreen.kt   # Detalle del curso + inscripción
│   └── ProfileScreen.kt        # Perfil + Mis Cursos + Progreso
│
├── ui.theme/                   # Paleta de colores y tipografía
└── MainActivity.kt             # Punto de entrada de la app
```

---

## 🖥️ Pantallas

| # | Pantalla | Descripción |
|---|----------|-------------|
| 1 | Login | Ingreso con correo y contraseña |
| 2 | Home | Saludo + accesos rápidos |
| 3 | Cursos | Lista scrollable con filtros por categoría |
| 4 | Detalle | Info completa del curso + botón inscribirse |
| 5 | Perfil | Datos del usuario + cursos inscritos + progreso |

---

## 🛠️ Tecnologías usadas

- **Kotlin** — Lenguaje principal
- **Jetpack Compose** — UI declarativa
- **Material Design 3** — Componentes de diseño
- **Navigation Compose** — NavHost + NavController
- **Android Studio** — IDE de desarrollo
- **Gemini in Android Studio** — Asistente de mejoras UI/UX

---

## ⚙️ Requisitos técnicos

- Android Studio Hedgehog o superior
- SDK mínimo: API 24 (Android 7.0)
- SDK objetivo: API 35
- Emulador: Pixel 6 Pro API 37

---

## 📲 Cómo ejecutar el proyecto

1. Clona el repositorio:
```bash
git clone https://github.com/SHEILA-DIAZ/EduTechAcademy.git
```
2. Abre el proyecto en **Android Studio**
3. Espera que Gradle sincronice
4. Ejecuta en emulador o dispositivo físico ▶️

---

## 📁 Evidencias

Las capturas de pantalla antes/después de las mejoras se encuentran en la carpeta `/capturas` del proyecto.

---

## 📄 Mejoras con Gemini

Ver archivo [`MEJORAS_GEMINI.md`](./MEJORAS_GEMINI.md) para el detalle completo del proceso de mejora con IA.
