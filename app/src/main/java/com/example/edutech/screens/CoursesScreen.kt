package com.example.edutech.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.edutech.data.courseList

@Composable
fun CoursesScreen(
    onBack: () -> Unit,
    onCourseClick: (Int) -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Button(onClick = { onBack() }) {
            Text("← Volver")
        }

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn {
            items(courseList) { course ->

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                        .clickable {
                            onCourseClick(course.id)
                            // 👉 ENVÍA ID al detalle
                        }
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {

                        Text(course.title, style = MaterialTheme.typography.titleMedium)

                        Text("Instructor: ${course.instructor}")

                        Text("Nivel: ${course.level}")
                    }
                }
            }
        }
    }
}