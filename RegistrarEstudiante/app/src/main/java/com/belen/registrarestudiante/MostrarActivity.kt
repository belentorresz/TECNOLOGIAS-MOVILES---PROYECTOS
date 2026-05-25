package com.belen.registrarestudiante

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*

class MostrarActivity : AppCompatActivity() {

    private lateinit var recycler: RecyclerView

    private lateinit var lista: ArrayList<Estudiante>

    private lateinit var adapter: EstudianteAdapter

    private lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mostrar)

        recycler = findViewById(R.id.recycler)

        recycler.layoutManager = LinearLayoutManager(this)

        lista = ArrayList()

        database = FirebaseDatabase.getInstance().getReference("estudiantes")

        adapter = EstudianteAdapter(

            lista,

            onEditar = { estudiante ->

                val intent = Intent(this, MainActivity::class.java)

                intent.putExtra("id", estudiante.id)
                intent.putExtra("nombre", estudiante.nombre)
                intent.putExtra("carrera", estudiante.carrera)
                intent.putExtra("curso", estudiante.curso)

                startActivity(intent)
            },

            onEliminar = { estudiante ->

                database.child(estudiante.id)
                    .removeValue()

                Toast.makeText(this, "Eliminado", Toast.LENGTH_SHORT).show()
            }
        )

        recycler.adapter = adapter

        leerDatos()
    }

    private fun leerDatos() {

        database.addValueEventListener(object : ValueEventListener {

            override fun onDataChange(snapshot: DataSnapshot) {

                lista.clear()

                for (dato in snapshot.children) {

                    val estudiante =
                        dato.getValue(Estudiante::class.java)

                    if (estudiante != null) {

                        lista.add(estudiante)
                    }
                }

                adapter.notifyDataSetChanged()
            }

            override fun onCancelled(error: DatabaseError) {

            }
        })
    }
}