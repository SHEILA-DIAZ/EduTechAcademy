package com.example.edutech.data //  importante que esté en data

data class Course( //  data class (esto es clave)
    val id: Int,
    val title: String,
    val instructor: String,
    val level: String,
    val category: String,
    val duration: String,
    val description: String,
    val progress: Int = 0
)

val courseList = listOf(
    Course(1, "Kotlin desde Cero", "Ana Torres", "Básico", "Programación", "6 horas", "Aprende Kotlin"),
    Course(2, "Jetpack Compose", "Luis Pérez", "Intermedio", "Programación", "8 horas", "UI moderna"),
    Course(3, "UI/UX", "María Gómez", "Básico", "Diseño", "5 horas", "Diseño apps"),
    Course(4, "Figma", "Carlos Rojas", "Intermedio", "Diseño", "7 horas", "Prototipos"),
    Course(5, "Marketing", "Sofía Vega", "Básico", "Negocios", "4 horas", "Marketing digital"),
    Course(6, "Startup", "Pedro León", "Avanzado", "Negocios", "9 horas", "Emprendimiento")
)