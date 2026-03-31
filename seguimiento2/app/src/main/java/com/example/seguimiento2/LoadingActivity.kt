package com.example.seguimiento2

import android.content.Intent
import android.os.Bundle
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class LoadingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loading)

        val progressBar = findViewById<ProgressBar>(R.id.progressBar)
        val txtMensaje = findViewById<TextView>(R.id.txtMensaje)

        Thread {
            for (i in 0..100 step 10) {
                Thread.sleep(200)

                runOnUiThread {
                    progressBar.progress = i
                }
            }

            runOnUiThread {
                txtMensaje.text = "Carga completa"
            }

            Thread.sleep(500)

            val destino = intent.getStringExtra("destino")

            val intent = when (destino) {
                "inicio" -> Intent(this, MainActivity::class.java)
                "segunda" -> Intent(this, SegundaActivity::class.java)
                "conversion" -> Intent(this, ConversionActivity::class.java)
                else -> Intent(this, MainActivity::class.java)
            }

            startActivity(intent)
            finish()

        }.start()
    }
}