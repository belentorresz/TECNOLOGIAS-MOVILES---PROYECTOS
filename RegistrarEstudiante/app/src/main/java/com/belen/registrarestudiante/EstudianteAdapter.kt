package com.belen.registrarestudiante

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class EstudianteAdapter(
    private val lista: ArrayList<Estudiante>,
    private val onEditar: (Estudiante) -> Unit,
    private val onEliminar: (Estudiante) -> Unit
) : RecyclerView.Adapter<EstudianteAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val tvNombre: TextView = itemView.findViewById(R.id.tvNombre)
        val tvCarrera: TextView = itemView.findViewById(R.id.tvCarrera)
        val tvCurso: TextView = itemView.findViewById(R.id.tvCurso)

        val btnEditar: Button = itemView.findViewById(R.id.btnEditar)
        val btnEliminar: Button = itemView.findViewById(R.id.btnEliminar)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val vista = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_estudiante, parent, false)

        return ViewHolder(vista)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val estudiante = lista[position]

        holder.tvNombre.text = "Nombre: ${estudiante.nombre}"
        holder.tvCarrera.text = "Carrera: ${estudiante.carrera}"
        holder.tvCurso.text = "Curso: ${estudiante.curso}"

        holder.btnEditar.setOnClickListener {
            onEditar(estudiante)
        }

        holder.btnEliminar.setOnClickListener {
            onEliminar(estudiante)
        }
    }

    override fun getItemCount(): Int {
        return lista.size
    }
}