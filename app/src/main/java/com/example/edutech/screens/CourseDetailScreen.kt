package com.example.edutech.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
    // Busca el curso por ID, si no lo encuentra muestra error
    val course = courseList.find { it.id == courseId }

    // Estado para mostrar dialogo de inscripción
    var showDialog by remember { mutableStateOf(false) }

    // Colores de la paleta
    val primaryBlue = Color(0xFF1565C0)
    val accentOrange = Color(0xFFFF6F00)
    val lightGray = Color(0xFFF5F5F5)

    // Si no encuentra el curso
    if (course == null) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Curso no encontrado",
                style = MaterialTheme.typography.headlineSmall,
                color = Color.Gray
            )
        }
        return
    }

    // Dialogo de confirmación de inscripción
    if (showDialog) {
        AlertDialog(
            onDismissRequest = { showDialog = false },
            title = {
                Text(
                    text = "¡Inscripción exitosa! 🎉",
                    fontWeight = FontWeight.Bold,
                    color = primaryBlue
                )
            },
            text = {
                Text(
                    text = "Te has inscrito en \"${course.title}\" correctamente. ¡Mucho éxito en tu aprendizaje!",
                    color = Color.DarkGray
                )
            },
            confirmButton = {
                Button(
                    onClick = { showDialog = false },
                    colors = ButtonDefaults.buttonColors(containerColor = primaryBlue)
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
                    // Botón flecha atrás ←
                    IconButton(onClick = onBack) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Regresar",
                            tint = Color.White
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = primaryBlue
                )
            )
        }
    ) { paddingValues ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .verticalScroll(rememberScrollState())
                .background(lightGray)
        ) {

            // ── Imagen grande del curso (banner con gradiente) ──
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(220.dp)
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(primaryBlue, Color(0xFF0D47A1))
                        )
                    ),
                contentAlignment = Alignment.Center
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Icon(
                        imageVector = Icons.Default.PlayArrow,
                        contentDescription = null,
                        tint = Color.White.copy(alpha = 0.3f),
                        modifier = Modifier.size(80.dp)
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    // Badge de categoría
                    Surface(
                        shape = RoundedCornerShape(20.dp),
                        color = accentOrange
                    ) {
                        Text(
                            text = course.category,
                            color = Color.White,
                            fontSize = 13.sp,
                            fontWeight = FontWeight.SemiBold,
                            modifier = Modifier.padding(horizontal = 16.dp, vertical = 6.dp)
                        )
                    }
                }
            }

            // ── Contenido principal ──
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
                    color = Color(0xFF1A1A2E),
                    lineHeight = 30.sp
                )

                Spacer(modifier = Modifier.height(12.dp))

                // Nivel badge
                Surface(
                    shape = RoundedCornerShape(8.dp),
                    color = when (course.level) {
                        "Básico" -> Color(0xFF4CAF50)
                        "Intermedio" -> Color(0xFFFF9800)
                        "Avanzado" -> Color(0xFFF44336)
                        else -> Color.Gray
                    }
                ) {
                    Text(
                        text = course.level,
                        color = Color.White,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(horizontal = 12.dp, vertical = 4.dp)
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Tarjeta de info (instructor + duración)
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
                        horizontalArrangement = Arrangement.SpaceAround
                    ) {
                        // Instructor
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Icon(
                                imageVector = Icons.Default.Person,
                                contentDescription = null,
                                tint = primaryBlue,
                                modifier = Modifier.size(28.dp)
                            )
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(
                                text = "Instructor",
                                fontSize = 11.sp,
                                color = Color.Gray
                            )
                            Text(
                                text = course.instructor,
                                fontSize = 13.sp,
                                fontWeight = FontWeight.SemiBold,
                                color = Color.DarkGray
                            )
                        }

                        Divider(
                            modifier = Modifier
                                .height(50.dp)
                                .width(1.dp),
                            color = Color.LightGray
                        )

                        // Duración
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Icon(
                                imageVector = Icons.Default.Star,
                                contentDescription = null,
                                tint = accentOrange,
                                modifier = Modifier.size(28.dp)
                            )
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(
                                text = "Duración",
                                fontSize = 11.sp,
                                color = Color.Gray
                            )
                            Text(
                                text = course.duration,
                                fontSize = 13.sp,
                                fontWeight = FontWeight.SemiBold,
                                color = Color.DarkGray
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(20.dp))

                // Descripción del curso
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
                        text = course.description +
                                "\n\nEste curso está diseñado para llevarte desde los conceptos " +
                                "básicos hasta un nivel ${course.level.lowercase()} de dominio. " +
                                "Aprenderás con ejemplos prácticos y proyectos reales que " +
                                "podrás agregar a tu portafolio profesional.",
                        fontSize = 15.sp,
                        color = Color(0xFF424242),
                        lineHeight = 24.sp,
                        modifier = Modifier.padding(16.dp)
                    )
                }

                Spacer(modifier = Modifier.height(28.dp))

                // Botón principal de inscripción
                Button(
                    onClick = { showDialog = true },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp),
                    shape = RoundedCornerShape(16.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = accentOrange
                    ),
                    elevation = ButtonDefaults.buttonElevation(defaultElevation = 6.dp)
                ) {
                    Text(
                        text = "🎓  Inscribirse al Curso",
                        fontSize = 17.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        textAlign = TextAlign.Center
                    )
                }

                Spacer(modifier = Modifier.height(12.dp))

                // Botón secundario
                OutlinedButton(
                    onClick = onBack,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp),
                    shape = RoundedCornerShape(16.dp),
                    colors = ButtonDefaults.outlinedButtonColors(
                        contentColor = primaryBlue
                    )
                ) {
                    Text(
                        text = "← Volver a Cursos",
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Medium
                    )
                }

                Spacer(modifier = Modifier.height(20.dp))
            }
        }
    }
}