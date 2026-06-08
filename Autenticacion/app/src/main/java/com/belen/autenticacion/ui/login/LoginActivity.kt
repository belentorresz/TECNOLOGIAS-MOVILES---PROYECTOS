package com.belen.autenticacion.ui.login

import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.belen.autenticacion.R
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    private lateinit var email: EditText
    private lateinit var password: EditText
    private lateinit var loading: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        auth = FirebaseAuth.getInstance()

        email = findViewById(R.id.etEmail)
        password = findViewById(R.id.etPassword)
        loading = findViewById(R.id.loading)

        findViewById<Button>(R.id.btnRegister)
            .setOnClickListener {
                registerUser()
            }
    }

    private fun registerUser() {

        val correo = email.text.toString().trim()
        val clave = password.text.toString().trim()

        if (!Patterns.EMAIL_ADDRESS.matcher(correo).matches()) {
            email.error = "Correo inválido"
            return
        }

        if (clave.length < 6) {
            password.error = "La contraseña debe tener mínimo 6 caracteres"
            return
        }

        loading.visibility = View.VISIBLE

        auth.createUserWithEmailAndPassword(
            correo,
            clave
        ).addOnCompleteListener { task ->

            loading.visibility = View.GONE

            if (task.isSuccessful) {

                Toast.makeText(
                    this,
                    "Registro exitoso",
                    Toast.LENGTH_SHORT
                ).show()

                email.setText("")
                password.setText("")

            } else {

                Toast.makeText(
                    this,
                    task.exception?.message,
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }
}