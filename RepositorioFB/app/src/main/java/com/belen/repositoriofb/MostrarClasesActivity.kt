package com.belen.repositoriofb

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.*

class MostrarClasesActivity : AppCompatActivity() {

    private lateinit var listaClases: ListView
    private lateinit var clasesRef: DatabaseReference

    private lateinit var datos: ArrayList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mostrar_clases)

        listaClases = findViewById(R.id.listaClases)

        datos = ArrayList()

        clasesRef = FirebaseDatabase
            .getInstance()
            .getReference("Clases")
            .child("Lecciones")

        mostrarDatos()
    }

    private fun mostrarDatos() {

        clasesRef.addValueEventListener(object : ValueEventListener {

            override fun onDataChange(snapshot: DataSnapshot) {

                datos.clear()

                for (dato in snapshot.children) {

                    val clase = dato.getValue(Clase::class.java)

                    if (clase != null) {

                        val texto =
                            "Sección: ${clase.seccion}\n" +
                                    "Área: ${clase.area}\n" +
                                    "Tema: ${clase.tema}"

                        datos.add(texto)
                    }
                }

                val adapter = ArrayAdapter(
                    this@MostrarClasesActivity,
                    android.R.layout.simple_list_item_1,
                    datos
                )

                listaClases.adapter = adapter
            }

            override fun onCancelled(error: DatabaseError) {

            }
        })
    }
}