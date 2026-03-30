package com.belen.ejercicio3

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResumenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resumen)

        val resumen = findViewById<TextView>(R.id.tvResumen)

        val nombre = intent.getStringExtra("nombre")
        val edad = intent.getStringExtra("edad")
        val profesion = intent.getStringExtra("profesion")

        resumen.text = """
            Nombre: $nombre
            
            Edad: $edad
            
            Profesión: $profesion
        """.trimIndent()
    }
}