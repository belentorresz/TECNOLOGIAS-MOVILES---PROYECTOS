package com.belen.ejercicio3

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class ProfesionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profesion)

        val profesion = findViewById<EditText>(R.id.etProfesion)
        val boton = findViewById<Button>(R.id.btnFinal)

        val nombre = intent.getStringExtra("nombre")
        val edad = intent.getStringExtra("edad")

        boton.setOnClickListener {

            if (profesion.text.toString().isEmpty()) {
                Toast.makeText(this,"Ingrese su profesión",Toast.LENGTH_SHORT).show()
            } else {

                val intent = Intent(this, ResumenActivity::class.java)

                intent.putExtra("nombre", nombre)
                intent.putExtra("edad", edad)
                intent.putExtra("profesion", profesion.text.toString())

                startActivity(intent)

            }
        }
    }
}