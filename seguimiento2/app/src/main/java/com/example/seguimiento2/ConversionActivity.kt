package com.example.seguimiento2

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ConversionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_conversion)

        val txtMonto = findViewById<EditText>(R.id.txtMonto)
        val btnSolesDolares = findViewById<Button>(R.id.btnSolesDolares)
        val btnDolaresSoles = findViewById<Button>(R.id.btnDolaresSoles)
        val txtResultado = findViewById<TextView>(R.id.txtResultado)

        val tipoCambio = 3.8

        // Soles a dólares
        btnSolesDolares.setOnClickListener {

            val monto = txtMonto.text.toString().toDoubleOrNull()

            if (monto != null) {
                val dolares = monto / tipoCambio
                txtResultado.text = "USD: $dolares"
            } else {
                txtResultado.text = "Ingrese un monto válido"
            }
        }

        // Dólares a soles
        btnDolaresSoles.setOnClickListener {

            val monto = txtMonto.text.toString().toDoubleOrNull()

            if (monto != null) {
                val soles = monto * tipoCambio
                txtResultado.text = "S/ $soles"
            } else {
                txtResultado.text = "Ingrese un monto válido"
            }
        }
    }
}