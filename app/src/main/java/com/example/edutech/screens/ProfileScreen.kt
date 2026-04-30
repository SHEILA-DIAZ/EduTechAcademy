package com.example.edutech.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.edutech.data.Course
import com.example.edutech.data.courseList

// Cursos inscritos simulados (con progreso diferente cada uno)
val enrolledCourses = listOf(
    courseList[0].copy(progress = 75),  // Kotlin desde Cero — 75%
    courseList[1].copy(progress = 40),  // Jetpack Compose — 40%
    courseList[4].copy(progress = 90),  // Marketing — 90%
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(
    onBack: () -> Unit
) {
    // Colores de la paleta
    val primaryBlue = Color(0xFF1565C0)
    val secondaryBlue = Color(0xFF1976D2)
    val accentOrange = Color(0xFFFF6F00)
    val lightGray = Color(0xFFF5F5F5)

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Mi Perfil",
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Regresar",
                            tint = Color.White
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = primaryBlue
                )
            )
        },
        containerColor = lightGray
    ) { paddingValues ->

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            verticalArrangement = Arrangement.spacedBy(0.dp)
        ) {

            // ── Header del perfil con gradiente ──
            item {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(
                            Brush.verticalGradient(
                                colors = listOf(primaryBlue, secondaryBlue)
                            )
                        )
                        .padding(28.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {

                        // Avatar circular
                        Box(
                            modifier = Modifier
                                .size(90.dp)
                                .clip(CircleShape)
                                .background(Color.White.copy(alpha = 0.2f)),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                imageVector = Icons.Default.Person,
                                contentDescription = null,
                                tint = Color.White,
                                modifier = Modifier.size(54.dp)
                            )
                        }

                        Spacer(modifier = Modifier.height(14.dp))

                        Text(
                            text = "Estudiante EduTech",
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )

                        Spacer(modifier = Modifier.height(4.dp))

                        Text(
                            text = "estudiante@edutech.com",
                            fontSize = 14.sp,
                            color = Color.White.copy(alpha = 0.8f)
                        )

                        Spacer(modifier = Modifier.height(24.dp))

                        // Estadísticas rápidas en fila
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceEvenly
                        ) {
                            StatItem(value = "${enrolledCourses.size}", label = "Cursos")
                            StatItem(value = "68%", label = "Promedio")
                            StatItem(value = "12h", label = "Horas")
                        }
                    }
                }
            }

            // ── Sección: Mis Cursos ──
            item {
                Spacer(modifier = Modifier.height(24.dp))
                Text(
                    text = "📚 Mis Cursos Inscritos",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF1A1A2E),
                    modifier = Modifier.padding(horizontal = 20.dp)
                )
                Spacer(modifier = Modifier.height(12.dp))
            }

            // Lista de cursos inscritos o estado vacío
            if (enrolledCourses.isEmpty()) {
                item {
                    EmptyState()
                }
            } else {
                items(enrolledCourses) { course ->
                    EnrolledCourseCard(
                        course = course,
                        accentOrange = accentOrange
                    )
                }
            }

            item { Spacer(modifier = Modifier.height(24.dp)) }
        }
    }
}

@Composable
fun StatItem(value: String, label: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = value,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )
        Text(
            text = label,
            fontSize = 12.sp,
            color = Color.White.copy(alpha = 0.75f)
        )
    }
}

@Composable
fun EnrolledCourseCard(
    course: Course,
    accentOrange: Color
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 8.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = course.title,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF1A1A2E),
                    modifier = Modifier.weight(1f)
                )
                
                val levelColor = when (course.level) {
                    "Básico" -> Color(0xFF4CAF50)
                    "Intermedio" -> Color(0xFFFF9800)
                    "Avanzado" -> Color(0xFFF44336)
                    else -> Color.Gray
                }
                
                Surface(
                    shape = RoundedCornerShape(8.dp),
                    color = levelColor.copy(alpha = 0.1f)
                ) {
                    Text(
                        text = course.level,
                        color = levelColor,
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = "👤 ${course.instructor}  •  ⏱ ${course.duration}",
                fontSize = 12.sp,
                color = Color.Gray
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Barra de progreso y porcentaje
            val isCompleted = (course.progress ?: 0) >= 80
            val progressColor = if (isCompleted) Color(0xFF4CAF50) else accentOrange

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Progreso",
                    fontSize = 13.sp,
                    color = Color.DarkGray,
                    fontWeight = FontWeight.Medium
                )
                Text(
                    text = "${course.progress}%",
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Bold,
                    color = progressColor
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            LinearProgressIndicator(
                progress = { (course.progress ?: 0) / 100f },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(8.dp)
                    .clip(RoundedCornerShape(8.dp)),
                color = progressColor,
                trackColor = Color(0xFFE0E0E0)
            )

            if (isCompleted) {
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "🏆 ¡Casi terminas! Sigue así",
                    fontSize = 12.sp,
                    color = Color(0xFF4CAF50),
                    fontWeight = FontWeight.SemiBold
                )
            }
        }
    }
}

@Composable
fun EmptyState() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(32.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "📭", fontSize = 48.sp)
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = "Aún no tienes cursos inscritos",
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.Gray
            )
            Text(
                text = "Explora el catálogo y empieza a aprender",
                fontSize = 13.sp,
                color = Color.LightGray
            )
        }
    }
}
