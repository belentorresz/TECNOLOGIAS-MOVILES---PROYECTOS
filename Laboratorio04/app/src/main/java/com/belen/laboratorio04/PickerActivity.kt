package com.belen.laboratorio04

import android.os.Bundle
import android.view.View
import android.widget.TimePicker
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.widget.Button

class PickerActivity : AppCompatActivity() {

    lateinit var timePicker: TimePicker

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContentView(R.layout.activity_picker)

        timePicker = findViewById(R.id.timePicker)
        timePicker.setIs24HourView(true)
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

    fun onClick(view: View) {

        val hora = timePicker.hour
        val minuto = timePicker.minute

        Toast.makeText(
            this,
            "Hora seleccionada $hora:$minuto",
            Toast.LENGTH_SHORT
        ).show()
    }
}