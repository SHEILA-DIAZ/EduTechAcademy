package com.example.edutech.navigation // Paquete de navegación

import androidx.compose.runtime.Composable // Permite funciones composables
import androidx.navigation.NavType // Tipos de datos para argumentos
import androidx.navigation.compose.* // Librería de navegación
import androidx.navigation.navArgument // Permite recibir parámetros
import com.example.edutech.screens.* // Importa pantallas

@Composable
fun AppNavigation() { // Función principal que controla la navegación

    val navController = rememberNavController()
    //  Crea el controlador que decide a qué pantalla ir

    NavHost(
        navController = navController,
        startDestination = Routes.LOGIN
        //  Primera pantalla: Login
    ) {

        composable(Routes.LOGIN) {
            //  Define la pantalla Login

            LoginScreen(
                onLogin = {
                    navController.navigate(Routes.HOME)
                    //  ENVÍA al usuario de Login → Home
                }
            )
        }

        composable(Routes.HOME) {
            //  Define pantalla Home

            HomeScreen(
                onCoursesClick = {
                    navController.navigate(Routes.COURSES)
                    //  ENVÍA de Home → Cursos
                },
                onProfileClick = {
                    navController.navigate(Routes.PROFILE)
                    //  ENVÍA de Home → Perfil
                }
            )
        }

        composable(Routes.COURSES) {
            // Pantalla lista de cursos

            CoursesScreen(
                onBack = {
                    navController.popBackStack()
                    //  REGRESA a pantalla anterior (Home)
                },
                onCourseClick = { courseId ->
                    navController.navigate(Routes.detailRoute(courseId))
                    //  ENVÍA el ID del curso a Detalle
                }
            )
        }

        composable(
            route = Routes.DETAIL,
            arguments = listOf(
                navArgument("courseId") {
                    type = NavType.IntType
                    //  Define que el parámetro será entero
                }
            )
        ) { backStackEntry ->

            val courseId = backStackEntry.arguments?.getInt("courseId") ?: 0
            // 👉 RECIBE el ID enviado desde Cursos

            CourseDetailScreen(
                courseId = courseId,
                //  ENVÍA ese ID a la pantalla Detalle

                onBack = {
                    navController.popBackStack()
                    //  REGRESA a Cursos
                }
            )
        }

        composable(Routes.PROFILE) {
            //  Pantalla Perfil

            ProfileScreen(
                onBack = {
                    navController.popBackStack()
                    //  REGRESA a Home
                }
            )
        }
    }
}