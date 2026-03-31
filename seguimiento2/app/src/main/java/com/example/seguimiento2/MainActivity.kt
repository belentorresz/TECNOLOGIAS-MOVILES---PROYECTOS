package com.example.seguimiento2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnSegunda = findViewById<Button>(R.id.btnSegunda)
        val btnConversion = findViewById<Button>(R.id.btnConversion)

        btnSegunda.setOnClickListener {
            startActivity(Intent(this, SegundaActivity::class.java))
        }

        btnConversion.setOnClickListener {
            startActivity(Intent(this, ConversionActivity::class.java))
        }
        val intent = Intent(this, DrawerActivity::class.java)
        startActivity(intent)
    }
}