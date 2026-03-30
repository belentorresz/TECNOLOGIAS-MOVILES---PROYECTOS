package com.belen.ejercicio3

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class EdadActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edad)

        val edad = findViewById<EditText>(R.id.etEdad)
        val boton = findViewById<Button>(R.id.btnSiguienteEdad)

        val nombre = intent.getStringExtra("nombre")

        boton.setOnClickListener {

            val edadTexto = edad.text.toString()

            if (edadTexto.isEmpty()) {

                Toast.makeText(this,"Ingrese su edad",Toast.LENGTH_SHORT).show()

            } else {

                val edadNumero = edadTexto.toInt()

                if (edadNumero < 0) {

                    Toast.makeText(this,"La edad no puede ser negativa",Toast.LENGTH_SHORT).show()

                } else {

                    val intent = Intent(this, ProfesionActivity::class.java)
                    intent.putExtra("nombre", nombre)
                    intent.putExtra("edad", edadTexto)

                    startActivity(intent)

                }
            }
        }
    }
}
