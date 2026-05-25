package com.belen.registrarestudiante

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class MainActivity : AppCompatActivity() {

    private lateinit var etNombre: EditText
    private lateinit var etCarrera: EditText
    private lateinit var etCurso: EditText

    private lateinit var btnGuardar: Button
    private lateinit var btnMostrar: Button

    private lateinit var database: DatabaseReference

    private var estudianteId = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etNombre = findViewById(R.id.etNombre)
        etCarrera = findViewById(R.id.etCarrera)
        etCurso = findViewById(R.id.etCurso)

        btnGuardar = findViewById(R.id.btnGuardar)
        btnMostrar = findViewById(R.id.btnMostrar)

        database = FirebaseDatabase.getInstance().getReference("estudiantes")

        btnGuardar.setOnClickListener {

            val nombre = etNombre.text.toString()
            val carrera = etCarrera.text.toString()
            val curso = etCurso.text.toString()

            if (estudianteId.isEmpty()) {

                val id = database.push().key!!

                val estudiante = Estudiante(
                    id,
                    nombre,
                    carrera,
                    curso
                )

                database.child(id).setValue(estudiante)

                Toast.makeText(this, "Guardado", Toast.LENGTH_SHORT).show()

            } else {

                val actualizar = mapOf<String, Any>(
                    "nombre" to nombre,
                    "carrera" to carrera,
                    "curso" to curso
                )

                database.child(estudianteId)
                    .updateChildren(actualizar)

                Toast.makeText(this, "Actualizado", Toast.LENGTH_SHORT).show()

                estudianteId = ""
            }

            limpiar()
        }

        btnMostrar.setOnClickListener {

            startActivity(
                Intent(this, MostrarActivity::class.java)
            )
        }

        recibirDatos()
    }

    private fun recibirDatos() {

        estudianteId = intent.getStringExtra("id") ?: ""

        etNombre.setText(
            intent.getStringExtra("nombre") ?: ""
        )

        etCarrera.setText(
            intent.getStringExtra("carrera") ?: ""
        )

        etCurso.setText(
            intent.getStringExtra("curso") ?: ""
        )
    }

    private fun limpiar() {

        etNombre.text.clear()
        etCarrera.text.clear()
        etCurso.text.clear()
    }
}