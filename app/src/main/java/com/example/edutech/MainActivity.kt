package com.example.edutech // Paquete principal

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.edutech.navigation.AppNavigation // 👉 Importa navegación
import com.example.edutech.ui.theme.EduTechAcademyTheme // Tema

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge() //  Ajusta la app a toda la pantalla

        setContent {
            EduTechAcademyTheme {

                AppNavigation()
                //  AQUÍ INICIA TODA LA APP
                //  NavController controla TODAS las pantallas

            }
        }
    }
}