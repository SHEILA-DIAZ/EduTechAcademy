package com.example.edutech.screens // Paquete de pantallas

import androidx.compose.foundation.layout.* // Layouts
import androidx.compose.material3.* // Material 3
import androidx.compose.runtime.* // Estados
import androidx.compose.ui.Modifier // Modificadores
import androidx.compose.ui.unit.dp // Medidas

@Composable
fun LoginScreen(
    onLogin: () -> Unit // 👉 Función que envía al usuario hacia Home
) {

    var email by remember { mutableStateOf("") }
    // 👉 Guarda el correo ingresado

    var password by remember { mutableStateOf("") }
    // 👉 Guarda la contraseña

    Column(
        modifier = Modifier
            .fillMaxSize() // Ocupa toda la pantalla
            .padding(16.dp),
        verticalArrangement = Arrangement.Center // Centra contenido
    ) {

        Text("EduTech Academy", style = MaterialTheme.typography.headlineMedium)

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            // 👉 Guarda lo que escribe el usuario
            label = { Text("Correo") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            // 👉 Guarda contraseña
            label = { Text("Contraseña") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                if (email.isNotEmpty() && password.isNotEmpty()) {
                    onLogin()
                    // 👉 ENVÍA a Home usando NavController
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Ingresar")
        }
    }
}