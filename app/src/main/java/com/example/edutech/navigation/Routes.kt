package com.example.edutech.navigation // Paquete donde se guardan las rutas de navegación

object Routes { // Objeto que contiene todas las rutas de la app

    const val LOGIN = "login" // Ruta para ir a la pantalla Login

    const val HOME = "home" // Ruta para ir a la pantalla Home

    const val COURSES = "courses" // Ruta para ir a la pantalla Cursos

    const val DETAIL = "detail/{courseId}" // Ruta para Detalle; recibe el ID del curso

    const val PROFILE = "profile" // Ruta para ir a Perfil

    fun detailRoute(courseId: Int): String { // Función que prepara la ruta con el ID del curso
        return "detail/$courseId" // Envía el courseId hacia la pantalla Detalle
    }
}