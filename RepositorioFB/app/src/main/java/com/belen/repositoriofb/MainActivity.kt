package com.belen.repositoriofb

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class MainActivity : AppCompatActivity() {

    private lateinit var txtTema: EditText
    private lateinit var spinAreas: Spinner
    private lateinit var spinSecciones: Spinner
    private lateinit var btnRegistrar: Button
    private lateinit var btnMostrar: Button

    private lateinit var clasesRef: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtTema = findViewById(R.id.editTextText)
        spinAreas = findViewById(R.id.spinarea)
        spinSecciones = findViewById(R.id.spinseccion)
        btnRegistrar = findViewById(R.id.btnregistrar)
        btnMostrar = findViewById(R.id.btnCursos)

        clasesRef = FirebaseDatabase
            .getInstance()
            .getReference("Clases")

        btnRegistrar.setOnClickListener {
            registrarClase()
        }

        btnMostrar.setOnClickListener {

            val intent = Intent(
                this,
                MostrarClasesActivity::class.java
            )

            startActivity(intent)
        }
    }

    private fun registrarClase() {

        val seccion = spinSecciones.selectedItem.toString()

        val area = spinAreas.selectedItem.toString()

        val tema = txtTema.text.toString().trim()

        if (tema.isEmpty()) {

            Toast.makeText(
                this,
                "Ingrese un tema antes de registrar",
                Toast.LENGTH_SHORT
            ).show()

            return
        }

        val id = clasesRef
            .child("Lecciones")
            .push()
            .key ?: return

        val leccion = Clase(
            id,
            seccion,
            area,
            tema
        )

        clasesRef
            .child("Lecciones")
            .child(id)
            .setValue(leccion)
            .addOnSuccessListener {

                Toast.makeText(
                    this,
                    "Clase registrada correctamente",
                    Toast.LENGTH_LONG
                ).show()

                txtTema.text.clear()
            }

            .addOnFailureListener {

                Toast.makeText(
                    this,
                    "Error al registrar",
                    Toast.LENGTH_LONG
                ).show()
            }
    }
}