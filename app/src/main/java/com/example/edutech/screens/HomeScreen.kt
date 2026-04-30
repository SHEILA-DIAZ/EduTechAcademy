package com.example.edutech.screens // Paquete de pantallas

import androidx.compose.foundation.layout.* // Layouts
import androidx.compose.material3.* // Material 3
import androidx.compose.runtime.Composable // Composable
import androidx.compose.ui.Modifier // Modificadores
import androidx.compose.ui.unit.dp // Medidas

@Composable
fun HomeScreen(
    onCoursesClick: () -> Unit, //  Función que envía a Cursos
    onProfileClick: () -> Unit //  Función que envía a Perfil
) {

    Column(
        modifier = Modifier
            .fillMaxSize() // Ocupa toda la pantalla
            .padding(16.dp)
    ) {

        Text(
            text = "Hola ", //  Saludo
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = {
                onCoursesClick()
                //  ENVÍA de Home → Cursos
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Ver Cursos")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                onProfileClick()
                //  ENVÍA de Home → Perfil
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Mi Perfil")
        }
    }
}