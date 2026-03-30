package com.belen.ejercicio3

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nombre = findViewById<EditText>(R.id.etNombre)
        val boton = findViewById<Button>(R.id.btnSiguiente)

        boton.setOnClickListener {

            if (nombre.text.toString().isEmpty()) {
                Toast.makeText(this,"Ingrese su nombre",Toast.LENGTH_SHORT).show()
            } else {

                val intent = Intent(this, EdadActivity::class.java)
                intent.putExtra("nombre", nombre.text.toString())
                startActivity(intent)

            }
        }
    }
}