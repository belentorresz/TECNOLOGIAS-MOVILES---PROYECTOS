package com.belen.laboratorio04

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.DatePicker
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class DatePickerActivity : AppCompatActivity() {

    lateinit var datePicker: DatePicker

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContentView(R.layout.activity_date_picker)

        datePicker = findViewById(R.id.datePicker)
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

        val dia = datePicker.dayOfMonth
        val mes = datePicker.month + 1
        val año = datePicker.year

        Toast.makeText(
            this,
            "Fecha seleccionada $dia/$mes/$año",
            Toast.LENGTH_SHORT
        ).show()
    }

}