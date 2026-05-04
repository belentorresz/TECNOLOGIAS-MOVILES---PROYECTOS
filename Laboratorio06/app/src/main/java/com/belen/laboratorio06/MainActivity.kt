package com.belen.laboratorio06

import android.os.Bundle
import com.belen.laboratorio06.ui.theme.Laboratorio06Theme
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Laboratorio06Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    FormularioUsuario(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun FormularioUsuario(modifier: Modifier = Modifier) {
    var nombre by remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp, vertical = 200.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        OutlinedTextField(
            value = nombre,
            onValueChange = { nuevo ->
                if (nuevo.length <= 8 && !nuevo.contains(" "))
                    nombre = nuevo
            },

            label = { Text("Ingresa tu nombre") },
            supportingText = { Text("Caracteres: ${nombre.length}/8") },
            trailingIcon = {
                if (nombre.isNotEmpty()) {
                    IconButton(onClick = { nombre = "" }) {
                        Icon(Icons.Default.Clear, contentDescription = "Limpiar")
                    }
                }
            },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )
    }
}