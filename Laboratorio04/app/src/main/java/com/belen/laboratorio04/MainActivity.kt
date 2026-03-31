package com.belen.laboratorio04

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.content.Intent
import android.widget.Button

class MainActivity : AppCompatActivity() {
    val presidents = arrayOf(
        "José Luis Bustamante",
        "Zenón Noriega",
        "Manuel Odría",
        "Manuel Prado",
        "Fco Morales Bermúdez",
        "Fernando Belaunde",
        "Alberto Fujimori",
        "Valentín Paniagua",
        "Alejandro Toledo",
        "Alan García",
        "Pedro Pablo Kuczynski",
        "Martín Alberto Vizcarra",
        "Pedro Castillo Terrones",
        "Dina Boluarte Zegarra",
        "Jose Jeri Ore"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val adapter = ArrayAdapter(this,
            android.R.layout.simple_dropdown_item_1line, presidents)
        val textView =
            findViewById<AutoCompleteTextView>(R.id.txtPresidentes)
        textView.threshold = 3
        textView.setAdapter(adapter)

        val btnAuto = findViewById<Button>(R.id.btnAuto)
        val btnTime = findViewById<Button>(R.id.btnTime)
        val btnDate = findViewById<Button>(R.id.btnDate)

        btnAuto.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }

        btnTime.setOnClickListener {
            startActivity(Intent(this, PickerActivity::class.java))
        }

        btnDate.setOnClickListener {
            startActivity(Intent(this, DatePickerActivity::class.java))
        }
    }
}