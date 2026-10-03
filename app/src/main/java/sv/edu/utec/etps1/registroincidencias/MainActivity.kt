package sv.edu.utec.etps1.registroincidencias

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.LineBreak
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import sv.edu.utec.etps1.registroincidencias.ui.theme.RegistroIncidenciasTheme

data class Evaluacion(
    val asignatura: String,
    val actividad: String,
    val calificacion: String,
    val categoria: String
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge(
            statusBarStyle = SystemBarStyle.light(
                android.graphics.Color.TRANSPARENT,
                android.graphics.Color.TRANSPARENT
            )
        )
        setContent {
            RegistroIncidenciasTheme {
                RegistroIncidenciasApp()
            }
        }
    }
}

@Composable
fun RegistroIncidenciasApp() {
    var asignatura by remember { mutableStateOf("") }
    var actividad by remember { mutableStateOf("") }
    var calificacion by remember { mutableStateOf("") }
    var mensajeError by remember { mutableStateOf("") }

    var categoriaSeleccionada by remember { mutableStateOf("Actividad") }
    val categorias = listOf("Actividad", "Parcial")

    val historial = remember { mutableStateListOf<Evaluacion>() }
    val focusAsignatura = remember { FocusRequester() }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(24.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(40.dp))

        Text(
            text = "Registro Académico",
            style = MaterialTheme.typography.headlineMedium,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "Lleva el control de tus evaluaciones. Agrega la materia, la actividad y la calificación obtenida.",
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.bodyMedium.merge(
                TextStyle(lineBreak = LineBreak.Paragraph.copy(strategy = LineBreak.Strategy.Balanced))
            )
        )

        Spacer(modifier = Modifier.height(24.dp))

        OutlinedTextField(
            value = asignatura,
            onValueChange = { asignatura = it },
            label = { Text("Asignatura") },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                capitalization = KeyboardCapitalization.Sentences,
                imeAction = ImeAction.Next
            ),
            modifier = Modifier
                .fillMaxWidth()
                .focusRequester(focusAsignatura)
        )

        Spacer(modifier = Modifier.height(4.dp))

        OutlinedTextField(
            value = actividad,
            onValueChange = { actividad = it },
            label = { Text("Título de la actividad") },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                capitalization = KeyboardCapitalization.Sentences,
                imeAction = ImeAction.Next
            ),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(4.dp))

        OutlinedTextField(
            value = calificacion,
            onValueChange = { calificacion = it },
            label = { Text("Calificación (0 a 10)") },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Done
            ),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Tipo de evaluación:",
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Start,
            fontWeight = FontWeight.SemiBold
        )
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            categorias.forEach { cat ->
                val isSelected = categoriaSeleccionada == cat
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .clip(RoundedCornerShape(8.dp))
                        .background(if (isSelected) Color(0xFFE0E0E0) else Color.Transparent)
                        .border(
                            width = 1.dp,
                            color = if (isSelected) Color.Transparent else Color.LightGray,
                            shape = RoundedCornerShape(8.dp)
                        )
                        .clickable { categoriaSeleccionada = cat }
                        .padding(vertical = 12.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = cat,
                        color = if (isSelected) Color.DarkGray else Color.Gray,
                        fontSize = 14.sp,
                        fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        if (mensajeError.isNotEmpty()) {
            Text(text = mensajeError, color = Color.Red, style = MaterialTheme.typography.bodySmall)
            Spacer(modifier = Modifier.height(8.dp))
        }

        Button(
            onClick = {
                if (asignatura.isBlank() || actividad.isBlank()) {
                    mensajeError = "La asignatura y la actividad son obligatorias."
                } else {
                    mensajeError = ""
                    val estadoCalificacion = calificacion.ifBlank { "-" }

                    historial.add(0, Evaluacion(asignatura, actividad, estadoCalificacion, categoriaSeleccionada))

                    asignatura = ""
                    actividad = ""
                    calificacion = ""
                    focusAsignatura.requestFocus()
                }
            },
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier.fillMaxWidth().height(54.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF0A0A0A))
        ) {
            Text(text = "Guardar actividad")
        }

        Spacer(modifier = Modifier.height(24.dp))
        HorizontalDivider(thickness = 1.dp, color = Color.LightGray)
        Spacer(modifier = Modifier.height(24.dp))

        if (historial.isEmpty()) {
            Text(text = "Aún no hay actividades registradas.", color = Color.Gray)
        } else {
            historial.forEach { evaluacion ->
                val esPendiente = evaluacion.calificacion == "-"

                Card(
                    modifier = Modifier.fillMaxWidth().padding(bottom = 12.dp),
                    colors = CardDefaults.cardColors(containerColor = Color(0xFFECECEC))
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth().padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Column(modifier = Modifier.weight(1f)) {
                            Text(
                                text = evaluacion.actividad,
                                fontWeight = FontWeight.Bold,
                                fontSize = 18.sp,
                                color = Color(0xFF1C2833)
                            )
                            Text(
                                text = "${evaluacion.asignatura} • ${evaluacion.categoria}",
                                fontSize = 14.sp,
                                color = Color.Gray
                            )
                        }

                        Box(
                            modifier = Modifier
                                .size(48.dp)
                                .background(
                                    color = obtenerColorCalificacion(evaluacion.calificacion),
                                    shape = CircleShape
                                ),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = evaluacion.calificacion,
                                color = if (esPendiente) Color.White else Color(0xFF1C2833),
                                fontWeight = FontWeight.Bold,
                                fontSize = if (esPendiente) 24.sp else 16.sp
                            )
                        }
                    }
                }
            }
        }
        Spacer(modifier = Modifier.height(24.dp))
    }
}

fun obtenerColorCalificacion(calificacionTexto: String): Color {
    if (calificacionTexto == "-") return Color(0xFF9E9E9E)
    val calificacion = calificacionTexto.toFloatOrNull() ?: 0f
    return when {
        calificacion <= 5.9f -> Color(0xFFF44336)
        calificacion <= 6.9f -> Color(0xFFFF9800)
        calificacion <= 7.9f -> Color(0xFFFFEB3B)
        calificacion <= 8.9f -> Color(0xFFCDDC39)
        else -> Color(0xFF4CAF50)
    }
}

@Preview(showBackground = true)
@Composable
fun RegistroIncidenciasPreview() {
    RegistroIncidenciasTheme {
        RegistroIncidenciasApp()
    }
}