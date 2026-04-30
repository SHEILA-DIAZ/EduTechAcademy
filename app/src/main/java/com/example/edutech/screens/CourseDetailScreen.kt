package com.example.edutech.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.edutech.data.courseList

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CourseDetailScreen(
    courseId: Int,
    onBack: () -> Unit
) {
    // Busca el curso por ID
    val course = courseList.find { it.id == courseId }

    // Estado para mostrar dialogo de inscripción
    var showDialog by remember { mutableStateOf(false) }

    // Paleta de colores solicitada
    val blueMedium = Color(0xFF1565C0)
    val blueDark = Color(0xFF0D47A1)
    val accentOrange = Color(0xFFFF6F00)
    val lightGray = Color(0xFFF5F5F5)

    if (course == null) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text(text = "Curso no encontrado", color = Color.Gray)
        }
        return
    }

    // Dialogo de confirmación
    if (showDialog) {
        AlertDialog(
            onDismissRequest = { showDialog = false },
            title = {
                Text(
                    text = "¡Inscripción exitosa! 🎉",
                    fontWeight = FontWeight.Bold,
                    color = blueMedium
                )
            },
            text = {
                Text("Te has inscrito en \"${course.title}\" correctamente. ¡Mucho éxito!")
            },
            confirmButton = {
                Button(
                    onClick = { showDialog = false },
                    colors = ButtonDefaults.buttonColors(containerColor = blueMedium)
                ) {
                    Text("¡Entendido!", color = Color.White)
                }
            }
        )
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Detalle del Curso",
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Volver",
                            tint = Color.White
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = blueMedium
                )
            )
        },
        containerColor = lightGray
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .verticalScroll(rememberScrollState())
        ) {
            // Banner con gradiente y logo 🎓
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(220.dp)
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(blueMedium, blueDark)
                        )
                    ),
                contentAlignment = Alignment.Center
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = "🎓",
                        fontSize = 80.sp,
                        textAlign = TextAlign.Center
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                    Surface(
                        shape = RoundedCornerShape(20.dp),
                        color = accentOrange
                    ) {
                        Text(
                            text = course.category,
                            color = Color.White,
                            fontSize = 13.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(horizontal = 16.dp, vertical = 6.dp)
                        )
                    }
                }
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp)
            ) {
                // Título del curso
                Text(
                    text = course.title,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF1A1A2E)
                )

                Spacer(modifier = Modifier.height(12.dp))

                // Badge de nivel
                val levelColor = when (course.level) {
                    "Básico" -> Color(0xFF4CAF50)
                    "Intermedio" -> Color(0xFFFF9800)
                    "Avanzado" -> Color(0xFFF44336)
                    else -> Color.Gray
                }

                Surface(
                    shape = RoundedCornerShape(8.dp),
                    color = levelColor
                ) {
                    Text(
                        text = course.level,
                        color = Color.White,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(horizontal = 12.dp, vertical = 4.dp)
                    )
                }

                Spacer(modifier = Modifier.height(20.dp))

                // Card de Información (Instructor y Duración)
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White),
                    elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        horizontalArrangement = Arrangement.SpaceAround,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        // Instructor
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Icon(Icons.Default.Person, contentDescription = null, tint = blueMedium)
                            Text("Instructor", fontSize = 11.sp, color = Color.Gray)
                            Text(course.instructor, fontWeight = FontWeight.Bold, fontSize = 13.sp)
                        }

                        VerticalDivider(modifier = Modifier.height(40.dp), thickness = 1.dp, color = Color.LightGray)

                        // Duración
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Icon(Icons.Default.Star, contentDescription = null, tint = accentOrange)
                            Text("Duración", fontSize = 11.sp, color = Color.Gray)
                            Text(course.duration, fontWeight = FontWeight.Bold, fontSize = 13.sp)
                        }
                    }
                }

                Spacer(modifier = Modifier.height(24.dp))

                // Sección Descripción
                Text(
                    text = "Descripción del curso",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF1A1A2E)
                )

                Spacer(modifier = Modifier.height(8.dp))

                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White),
                    elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
                ) {
                    Text(
                        text = course.description + "\n\nEste programa te llevará desde lo más esencial hasta dominar conceptos avanzados de ${course.category.lowercase()}.",
                        modifier = Modifier.padding(16.dp),
                        fontSize = 15.sp,
                        lineHeight = 22.sp
                    )
                }

                Spacer(modifier = Modifier.height(32.dp))

                // Botón Inscribirse
                Button(
                    onClick = { showDialog = true },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp),
                    shape = RoundedCornerShape(16.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = accentOrange)
                ) {
                    Text("Inscribirse al Curso", fontSize = 17.sp, fontWeight = FontWeight.Bold)
                }

                Spacer(modifier = Modifier.height(12.dp))

                // Botón Volver
                OutlinedButton(
                    onClick = onBack,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp),
                    shape = RoundedCornerShape(16.dp),
                    colors = ButtonDefaults.outlinedButtonColors(contentColor = blueMedium)
                ) {
                    Text("← Volver a Cursos", fontWeight = FontWeight.Medium)
                }
            }
        }
    }
}
